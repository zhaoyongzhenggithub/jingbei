package com.example.jingbei.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.example.jingbei.bean.Goods;
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

public class GoodsSearch extends AppCompatActivity {
    GoodsDao goodsDao = new GoodsDao(this);
    private EditText editText;
    private ImageView imageView;
    private ListView listView;
RecentlyDao recentlyDao=new RecentlyDao(this);//我的足迹
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.wse_search_layout);
        //goodsDao.addGoods();
        /*
        获取首页传递过来的参数
         */
        editText = (EditText) findViewById(R.id.dzp_search_et);
        imageView = (ImageView) findViewById(R.id.dzp_search_iv);
        listView = (ListView) findViewById(R.id.dzp_search_lv);
        Intent intent=getIntent();
        String content=intent.getStringExtra("key");
        editText.setText(content);

        //listview监听事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map goodsmap=(Map) parent.getItemAtPosition(position);
                String img=(String) goodsmap.get("img");
                String title=(String) goodsmap.get("title");
                double price=(Double) goodsmap.get("price");

                Intent intent=new Intent(GoodsSearch.this,GoodsDetail.class);
                intent.putExtra("img",img);
                intent.putExtra("title",title);
                intent.putExtra("price",price);
                startActivity(intent);

                //添加该商品到足迹
                Recently recently=new Recently(img,price,title);
                recentlyDao.inertIntoRecently(recently);
            }
        });
    }
    //设置监听事件
    public void showGoods(View view) {
        String str = editText.getText().toString();//获取输入框内的数据
        List list = goodsDao.queryByName(str);//根据名字得到符合条件的集合
        final List goodsList = new ArrayList();//适配器所加载的数组，由map组成

        //初始化goodsList数组
        if(list.size()>0) {
            listView.setBackgroundResource(R.drawable.white);
            for (int i = 0; i < list.size(); i++) {
                Map map = new HashMap();
                Goods goods = (Goods) list.get(i);
                map.put("img", goods.getPhoto());
                map.put("title", goods.getTitle());
                map.put("price", goods.getPrice());
                goodsList.add(map);
            }
            SimpleAdapter simpleAdapter = new SimpleAdapter(this, goodsList, R.layout.wse_search_list_layout, new String[]{"img", "title", "price"}, new int[]{R.id.img, R.id.title, R.id.price});
            //适配器干扰imageview显示方式
            simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                public boolean setViewValue(View v, Object o, String s) {
                    if (v.getId() == R.id.img) {
                        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(GoodsSearch.this).build();
                        ImageLoader imageLoader = ImageLoader.getInstance();
                        imageLoader.init(config);
                        imageLoader.displayImage(o.toString(), (ImageView) v);
                        return true;
                    }
                    return false;
                }
            });
            listView.setAdapter(simpleAdapter);

        }else{
            //查询没有返回值
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,new String[]{"",""});
            listView.setAdapter(arrayAdapter);
            listView.setBackgroundResource(R.drawable.goodsnull);

        }

    }
    //返回按钮
    public void search_back(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}