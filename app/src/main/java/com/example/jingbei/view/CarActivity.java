package com.example.jingbei.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingbei.bean.CarGoods;
import com.example.jingbei.bean.Goods;
import com.example.jingbei.bean.Orders;
import com.example.jingbei.dao.GoodsDao;
import com.example.jingbei.dao.OrdersDao;
import com.example.jingbei.dao.ShoppingCarDao;
import com.example.taoshui.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarActivity extends AppCompatActivity {
    ShoppingCarDao shoppingCarDao=new ShoppingCarDao(this);
    OrdersDao ordersDao=new OrdersDao(this);

    private  TextView quantity_tv,sum_tv;
    private CheckBox checkBox ,checkBox1;
    private LinearLayout linearLayout;
    private Button update,account;
    int count=0;//选中商品的个数
    List selectlist=new ArrayList();// 保存所有的checkbox
    List buttonlist=new ArrayList();//保存所有的删除按钮
    GoodsDao goodsDao=new GoodsDao(this);
    double sumprice=0;//定义总价钱
    List arrayList=new ArrayList();//存储所有商品
    List resultList=new ArrayList();//最后结算商品集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zyk_shoppingcar);


        //goodsDao.addGoods();
        ListView listView = (ListView) findViewById(R.id.hubo_shoppingcar_listview);
        checkBox=(CheckBox)findViewById(R.id.test_ck);
        checkBox1=(CheckBox)findViewById(R.id.shoppingcar_ck1);//全选按钮
        sum_tv=(TextView)findViewById(R.id.hubo_shoppingcar_textview_sum) ;

        update=(Button)findViewById(R.id.hubo_shoppingcar_btn1);

        update.setText("编辑");
        init();//初始化操作


        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.zyk_shoppingcar_listitem, new String[]{"id","img","title","price","id","id","id","number"}, new int[]{R.id.test_ck,R.id.test_img,R.id.test_title,R.id.test_price,R.id.test_btn1,R.id.hubo_button_minus,R.id.hubo_button_plus,R.id.hubo_textview_number});
        //自定义适配器的显示方式
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, final Object data, final String textRepresentation) {
                if (view.getId()==R.id.test_img){
                    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(CarActivity.this).build();
                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.init(config);
                    imageLoader.displayImage(data.toString(), (ImageView) view);
                    return true;
                }else if(view.getId()==R.id.test_ck){
                    //自定义checkbox的显示方式
                    final CheckBox ck=(CheckBox)view;
                    selectlist.add(view);
                    view.setVisibility(View.INVISIBLE);
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //选中传值

                            if(ck.isChecked()) {
                                //数量
                                count++;
                                account = (Button) findViewById(R.id.hubo_shoppingcar_goodsprice);
                                String sum = String.valueOf(count);
                                account.setText("合计：结算" + "(" + sum + ")");
                               //总价
                                int id=Integer.parseInt(data.toString());
                                Goods goods=goodsDao.queryById(id);
                                double price=goods.getPrice();
                                sumprice=sumprice+price;
                                sum_tv.setText(String.valueOf(sumprice));
                                //将该行商品添加到结算集合中
                                int index=Integer.parseInt(data.toString());//获取改行id
                                int index1=index-1;
                                Map goodsMap=(Map) arrayList.get(index1);
                                resultList.add(goodsMap);
                            }else {
                                count--;
                                account = (Button) findViewById(R.id.hubo_shoppingcar_goodsprice);
                                String sum = String.valueOf(count);
                                account.setText("合计：结算" + "(" + sum + ")");

                                int id=Integer.parseInt(data.toString());
                                Goods goods=goodsDao.queryById(id);
                                double price=goods.getPrice();
                                sumprice=sumprice-price;
                                sum_tv.setText(String.valueOf(sumprice));
                                //从结算商品集合里面删除
                                int index=Integer.parseInt(data.toString());
                                int index1=index-1;
                                shoppingCarDao.deleteCarGoods(index1);
                                Map goodsMap=(Map) arrayList.get(index1);
                                if(resultList.contains(goodsMap)){
                                    resultList.remove(goodsMap);
                                }
                            }
                        }
                    });
                }else if(view.getId()==R.id.test_btn1){//删除
                    final Button button=(Button)view;
                    buttonlist.add(button);
                    button.setVisibility(View.INVISIBLE);
                    button.setText("删除");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id=Integer.parseInt(data.toString());
                          if(id >= 1){
                                int index=id-1;
                                if(index >= 0 && arrayList.size() >=1){
                                    arrayList.remove(index);
                                    shoppingCarDao.deleteCarGoods(id  + GoodsDetail.id - 1);
                                    Log.e("shoppingCarDao","index = " + index + " id =" + id +"  id  + GoodsDetail.id = " + (id  + GoodsDetail.id));
                                }

                            }else {
                                arrayList.remove(id);
                                shoppingCarDao.deleteCarGoods(id);
                            }
                           button.setVisibility(View.VISIBLE);
                            simpleAdapter.notifyDataSetChanged();//刷新
                }
            });
                    return  true;
                    //加法操作
                }else if(view.getId()==R.id.hubo_button_plus){
                    Button btn1=(Button)view;
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id=Integer.parseInt(data.toString());
                            int index=id-1;
                            Map map=(Map) arrayList.get(index);
                            int number=Integer.parseInt(map.get("number").toString());
                            int number1=number+1;
                            String finalNumber=String.valueOf(number1);

                            map.put("number",finalNumber);
                            simpleAdapter.notifyDataSetChanged();
                        }
                    });
                  return true;
                  //减法操作
                }else if(view.getId()==R.id.hubo_button_minus){
                    Button btn1=(Button)view;
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id=Integer.parseInt(data.toString());
                            int index=id-1;
                            Map map=(Map) arrayList.get(index);
                            int number=Integer.parseInt(map.get("number").toString());
                            int number1=number-1;
                            if(number1>=0) {
                                String finalNumber = String.valueOf(number1);
                                map.put("number",finalNumber);
                            }else {
                                Toast.makeText(CarActivity.this,"数量不能小于0",Toast.LENGTH_SHORT).show();
                            }

                            simpleAdapter.notifyDataSetChanged();
                        }
                    });
                    return true;
                }

                return false;
            }
        });
        listView.setAdapter(simpleAdapter);
    }
    //初始化操作
    public void init(){


       List carList=new ArrayList();//返回购物车商品集合
        carList=shoppingCarDao.queryCarGoods();
        for (int i=0;i<carList.size();i++){
            CarGoods carGoods=(CarGoods) carList.get(i);
            HashMap map=new HashMap();
            map.put("id",i+1);
            map.put("number",carGoods.getNumber());
            map.put("img",carGoods.getPhoto());
            map.put("title",carGoods.getTitle());
            map.put("price",carGoods.getPrice());
            arrayList.add(map);
        }

    }
    //编辑完成操作
    public void change(View view){
        String str=update.getText().toString();
        for(int i=0;i<selectlist.size();i++){
            CheckBox checkBox=(CheckBox)selectlist.get(i);
            Button button=(Button)buttonlist.get(i);
            if(str.equals("编辑")){
                update.setText("完成");
                checkBox.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }else if(str.equals("完成")){
                update.setText("编辑");
                checkBox.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
            }

        }
    }
    //全选操作
    public void selectAll(View view){
        String str=checkBox1.getText().toString();
        if(str.equals("全选")){
            checkBox1.setText("反选");
            count=selectlist.size();
            account = (Button) findViewById(R.id.hubo_shoppingcar_goodsprice);
            String sum = String.valueOf(count);
            account.setText("结算" + "(" + sum + ")");

            //遍历所有列表项，全选计算总价格
             for(int i=0;i<arrayList.size();i++){
                 Map map=(Map) arrayList.get(i);
                 double price=(Double) map.get("price");
                sumprice=sumprice+price;
                String sumprice1=String.valueOf(sumprice);
                 sum_tv.setText("合计：结算" + "(" + sumprice1 + ")");
             }
        }else if(str.equals("反选")){
            checkBox1.setText("全选");
            count=0;
            account = (Button) findViewById(R.id.hubo_shoppingcar_goodsprice);
            String sum = String.valueOf(count);
            account.setText("结算" + "(" + sum + ")");
            sumprice=0;
            sum_tv.setText("合计：结算" + "(0)");
          /*  //遍历所有列表项，全选计算总价格
            for(int i=0;i<arrayList.size();i++){
                Map map=(Map) arrayList.get(i);
                double price=(Double) map.get("price");
                sumprice=sumprice-price;
                String sumprice1=String.valueOf(sumprice);
                sum_tv.setText("合计：结算" + "(" + sumprice1 + ")");
            }*/
        }
        for(int i=0;i<selectlist.size();i++){
            CheckBox checkBox=(CheckBox)selectlist.get(i);
            if(!checkBox1.isChecked()){
                checkBox.setChecked(false);
            }else if(checkBox1.isChecked()){
                checkBox.setChecked(true);
            }

        }
    }
    //结算
    public void getFinal(View view){
        //结算把商品集合中的商品添加到订单数据库中
    for (int i=0;i<resultList.size();i++){
    Map map=(Map) resultList.get(i);
    String title=map.get("title").toString();
    String photo=map.get("img").toString();
    double price=(Double) map.get("price");
    Orders orders=new Orders(photo,price,title);
    ordersDao.inertIntoOrders(orders);
}
        Intent intent=new Intent(CarActivity.this,OrderActivity.class);
        startActivity(intent);
    }

    public void shoppingcar_back(View view){
        finish();
    }
}



