package com.example.jingbei.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import    java.text.SimpleDateFormat;

import com.example.jingbei.bean.Orders;
import com.example.jingbei.dao.OrdersDao;
import com.example.jingbei.dbUtil.MyDbOpenHelper;
import com.example.taoshui.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ArrayList orders;//订单数据
    private HashMap orderDetail;//订单明细，<orderID,ArrayList>
    private ImageLoader imageLoader;
    OrdersDao ordersDao=new OrdersDao(this);
    List orderList=new ArrayList();//订单数据
    private  Button deleteButton;//删除按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zyk_shopping_order);
       orderList=this.init();
        prepareData();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();

        imageLoader= ImageLoader.getInstance();
        imageLoader.init(config);
        expandableListView=(ExpandableListView)findViewById(R.id.hubo_shoppingorder_expandablelistview);
        expandableListView.setAdapter(new MyAdapter());


    }
    //初始化订单集合
    public List init(){
        //查询订单数据
        Orders orders=null;
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(this);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.query("orders",new String[]{"id","title","photo","price"},null,null,null,null,null);
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                orders=new Orders(photo,price,title);
                orderList.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.close();
        }

        return  orderList;
    }

    //初始化数据
    private void prepareData(){
        orders=new ArrayList();
        HashMap hashMap=new HashMap();
       orderDetail=new HashMap();
        hashMap.put("id","1");
        hashMap.put("order","订单1");
        hashMap.put("money","77826");
        hashMap.put("date","2019-12-10");
        orders.add(hashMap);


        ArrayList arrayList=new ArrayList();
     for(int i=0;i<orderList.size();i++){
         HashMap map=new HashMap();
         Orders orders=(Orders) orderList.get(i);
         map.put("id",String.valueOf(i+1));
         map.put("img",orders.getPhoto());
         map.put("title",orders.getTitle());
         map.put("price",String.valueOf(orders.getPrice()));
         arrayList.add(map);
     }
        orderDetail.put("1",arrayList);
    }
    //实现 自定义的适配器
    private class MyAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            //返回第一级数据的数目
            return orders.size();
        }

        @Override
        public int getChildrenCount(int i) {
            //返回第二级数据的数目
            HashMap hashMap=(HashMap) orders.get(i);
            String orderId=hashMap.get("id").toString();
            ArrayList arrayList=(ArrayList) orderDetail.get(orderId);
            return arrayList.size();
        }

        @Override
        public Object getGroup(int i) {
            //得到第一级别中一行的数据
            return orders.get(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            //得到第二级别中一行的数据
            HashMap hashMap=(HashMap) orders.get(i);
            String orderId=hashMap.get("id").toString();
            ArrayList arrayList=(ArrayList) orderDetail.get(orderId);
            return arrayList.get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            //提供 第一级记录的界面
            if(view!=null){
                return view;
            }
            View view1=getLayoutInflater().inflate(R.layout.zyk_shoppingorderlistitemsecond,null);
            HashMap hashMap=(HashMap) getGroup(i);
            //设置界面上的数据
            TextView textView=(TextView)view1.findViewById(R.id.hubo_shoppingorderlistitemsecond_textview_ordername);
            textView.setText(hashMap.get("order").toString());
            textView=(TextView) view1.findViewById(R.id.hubo_shoppingorderlistitemsecond_textview_price);
            textView.setText(hashMap.get("money").toString());
            SimpleDateFormat    sDateFormat    =   new    SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
            String    date    =    sDateFormat.format(new    java.util.Date());
            textView=(TextView) view1.findViewById(R.id.hubo_shoppingorderlistitemsecond_textview_systemtime);
            textView.setText((date).toString());
            deleteButton=(Button)view1.findViewById(R.id.hubo_shoppingorderlistitemfirst_button_delete);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orders.remove(0);
                    notifyDataSetChanged();
                }
            });


            return view1;
            }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            ////提供 第二级记录的界面
            if(view!=null){
                return view;
            }
            HashMap hashMap=(HashMap) getChild(i,i1);
            View view1=getLayoutInflater().inflate(R.layout.zyk_shoppingorderlistitemfirst,null);
            TextView textView=(TextView) view1.findViewById(R.id.hubo_shoppingorderlistitemfirst_textview_price);
            textView.setText(hashMap.get("price").toString());
            textView=(TextView) view1.findViewById(R.id.hubo_shoppingorderlistitemfirst_textview_goodsname);
            textView.setText(hashMap.get("title").toString());
            ImageView imageView=(ImageView)view1.findViewById(R.id.hubo_shoppingorderlistitemfirst_imageview_iv1);
            imageLoader.displayImage(hashMap.get("img").toString(),imageView);
            return view1;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }

    }
    public void shoppingorder_back(View view){
       finish();
    }




}

