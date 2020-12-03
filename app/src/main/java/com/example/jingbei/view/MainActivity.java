package com.example.jingbei.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.jingbei.dao.GoodsDao;
import com.example.taoshui.R;

public class MainActivity extends AppCompatActivity {
    GoodsDao goodsDao=new GoodsDao(this);

    private GridView gridView;
    private List datalist;
    private SimpleAdapter simpleAdapter;
    private EditText editText;
  private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wse_main_layout);
        editText=(EditText)findViewById(R.id.dzp_main_layout_et);
       linearLayout=(LinearLayout)findViewById(R.id.dzp_main_layout_linear);
       goodsDao.addGoods();//初始化数据库
        gridView=(GridView)findViewById(R.id.gridview);
        String[] from={"img","text1"};
        int[] to={R.id.img,R.id.text1};
        //初始化数据
        firstLoad();

        //设置适配器
        simpleAdapter=new SimpleAdapter(this,datalist,R.layout.wse_gridview_layout,from,to);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map map=(Map) parent.getItemAtPosition(position);
                String type=(String) map.get("text1");
                Intent intent=new Intent(MainActivity.this,GoodsInfoList.class);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }
/*
初始化操作
 */
public void firstLoad(){
    //图标
    int[] pict={R.drawable.nike,R.drawable.adidas,R.drawable.peak,R.drawable.lining,R.drawable.pixie,R.drawable.tuoxie};
    //图标下加载的文字
    String[] name={"耐克","阿迪达斯","匹克","李宁","皮鞋","拖鞋"};
        datalist=new ArrayList();
        for(int i=0;i<pict.length;i++){
            Map map=new HashMap();
            map.put("img",pict[i]);
            map.put("text1",name[i]);
            datalist.add(map);
        }
    }

    /*
    查询跳转操作
     */
    public void beginQuery(View view){
        Intent intent=new Intent(this,GoodsSearch.class);
        String content=editText.getText().toString();
        if(content!=null) {
            intent.putExtra("key", content);
            startActivity(intent);
        }
    }
    public void button_mainlayout_Weather(View view){
        Intent intent=new Intent(this,Weather.class);
        startActivity(intent);
    }
    public void buttom_mainlayout_Caractivity(View view){
        Intent intent=new Intent(this,CarActivity.class);
        startActivity(intent);
    }
    public void button_mainlayout_MeNotLogin(View view){
        /*Intent intent=new Intent(this,MeNotLogin.class);
        startActivity(intent);*/
       String username_db="111";
        String password_db="111";
        if("111".equals(username_db)&&"111".equals(password_db)){
            Intent intent=new Intent(this,MeLogin.class);
            String content_name=username_db;
            String content_passwd=password_db;
            if(content_name!=null&&content_passwd!=null){
                intent.putExtra("transform_username",content_name);
                intent.putExtra("transform_passwd",content_passwd);
            }
            startActivity(intent);
        }
    }
}
