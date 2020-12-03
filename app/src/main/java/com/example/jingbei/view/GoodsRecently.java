package com.example.jingbei.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.jingbei.bean.Recently;
import com.example.jingbei.dao.GoodsDao;
import com.example.jingbei.dao.RecentlyDao;
import com.example.taoshui.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsRecently extends AppCompatActivity {

    private LinearLayout linearLayout;
    private Button update;
    List buttonlist=new ArrayList();//保存所有的删除按钮
    GoodsDao goodsDao=new GoodsDao(this);
    List recentList=new ArrayList();//足迹集合
RecentlyDao recentlyDao=new RecentlyDao(this);
List arrayList=new ArrayList();//加载所有足迹
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zyk_shopping_goodsrecently);
        //goodsDao.addGoods();
        Button delete_all = (Button) findViewById(R.id.delete_all);
        ListView listView = (ListView) findViewById(R.id.hubo_shoppinggoodsrecently_listview);
        update=(Button)findViewById(R.id.hubo_shoppinggoodsrecently_button_change);
        update.setText("编辑");

        recentList=recentlyDao.queryOrders();

          for(int i=0;i<recentList.size();i++){
              Recently recently=(Recently) recentList.get(i);
              Map hashMap=new HashMap();
              hashMap.put("id",String.valueOf(i+1));
              hashMap.put("img",recently.getPhoto());
              hashMap.put("title",recently.getTitle());
              hashMap.put("price",String.valueOf(recently.getPrice()));
              arrayList.add(hashMap);
          }



        simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.zyk_goodsrecently_listitem, new String[]{"id","img","title","price","id"}, new int[]{R.id.hubo_shoppinggoodsrecentlylistitem_button_delete,R.id.hubo_shoppinggoodsrecentlylistitem_imageview_iv1,R.id.hubo_shoppinggoodsrecentlylistitem_textview_goodsname,R.id.hubo_shoppinggoodsrecentlylistitem_textview_price});
        //自定义适配器的显示方式
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, final Object data, String textRepresentation) {
                if (view.getId()==R.id.hubo_shoppinggoodsrecentlylistitem_imageview_iv1){
                    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(GoodsRecently.this).build();
                    ImageLoader imageLoader = ImageLoader.getInstance();
                    imageLoader.init(config);
                    imageLoader.displayImage(data.toString(), (ImageView) view);
                    return true;
                }else if(view.getId()==R.id.hubo_shoppinggoodsrecentlylistitem_button_delete){
                    Button button=(Button)view;
                    buttonlist.add(button);
                    button.setVisibility(View.INVISIBLE);
                    button.setText("删除");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id=Integer.parseInt(data.toString());
                            int index=id-1;
                            arrayList.remove(index);
                            simpleAdapter.notifyDataSetChanged();
                        }
                    });return true;
                }
                return false;
            }
        });
        listView.setAdapter(simpleAdapter);
    }
    public void goodsrecentlychange(View view) {
        String str = update.getText().toString();
        for (int i = 0; i < buttonlist.size(); i++) {
            Button button = (Button) buttonlist.get(i);
            if (str.equals("编辑")) {
                update.setText("完成");
                button.setVisibility(View.VISIBLE);
            } else if (str.equals("完成")) {
                update.setText("编辑");
                button.setVisibility(View.INVISIBLE);
            }
        }
    }
    public void shoppinggoodsrecently_back(View view){
        Intent intent=new Intent(GoodsRecently.this,MeNotLogin.class);
        startActivity(intent);
    }


    public void delete_all_info(View view){
        arrayList.clear();
        recentlyDao.deleteAll();
        simpleAdapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(),"清空完成",Toast.LENGTH_SHORT).show();
        System.out.println("我被输出了");
    }


}
