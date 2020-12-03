package com.example.jingbei.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

import java.util.List;

public class GoodsDetail extends AppCompatActivity {
    ShoppingCarDao shoppingCarDao=new ShoppingCarDao(this);
    GoodsDao goodsDao=new GoodsDao(this);
private TextView textView;//数量显示
    private  TextView textView1,textView2,textView3;
    private  ImageView imageView;
    OrdersDao ordersDao=new OrdersDao(this);
    static int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.wse_detail_layout);
        textView=(TextView)findViewById(R.id.dzp_detail_tv1);
        textView1=(TextView)findViewById(R.id.dzp_detail_tv3);
        textView2=(TextView)findViewById(R.id.dzp_detail_tv4);
        imageView=(ImageView)findViewById(R.id.dzp_detail_iv1);
        textView.setText("2");
        textView3=(TextView)findViewById(R.id.dzp_detail_tv5);

        Intent intent=getIntent();
        String img=intent.getStringExtra("img");
        String tilte=intent.getStringExtra("title");
        double price=intent.getDoubleExtra("price",100);
        //通过title名称查询商品
       List titleList= goodsDao.queryByName(tilte);
        Goods goods=(Goods) titleList.get(0);
        String introduce=goods.getIntroduce();//获取商品介绍
        textView1.setText(tilte);
        String price1=String.valueOf(price);
        textView2.setText("价格："+price1);
        textView3.setText("商品简介："+introduce);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(GoodsDetail.this).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        imageLoader.displayImage(img,imageView);

    }
    public void Subduction(View view){
        String str=textView.getText().toString();
        int sum=Integer.parseInt(str);
       int sum1=sum-1;
        if(sum1==0){
            Toast.makeText(this,"没货了",Toast.LENGTH_LONG).show();
            textView.setText("0");
        }else if(sum1>0){

            textView.setText(String.valueOf(sum1));
        }else {
            textView.setText("0");
        }
    }
    public void Addition(View view){
        String str=textView.getText().toString();
        int sum=Integer.parseInt(str);
        int sum1=sum+1;
        textView.setText(String.valueOf(sum1));
    }
    //返回按钮
    public void detail_back(View view){
        finish();
    }
    //跳转到购物车
   public void insertShoppingCar(View view){
       Intent intent=getIntent();
       String img=intent.getStringExtra("img");
       String tilte=intent.getStringExtra("title");
       double price=intent.getDoubleExtra("price",100);
       String number=textView.getText().toString();//获取数量
       CarGoods carGoods=new CarGoods(tilte,img,number,price);
       shoppingCarDao.inertIntoCar(carGoods);
Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
       id ++;
       System.out.println(" id ==== " + id);
      /* Intent intent1=new Intent(GoodsDetail.this,CarActivity.class);
       intent1.putExtra("img",img);
       intent1.putExtra("title",tilte);
       intent1.putExtra("price",price);
       intent1.putExtra("number",number);
       startActivity(intent1);*/
   }
   //立即购买
    public void buyNow(View view){

        Intent intent=getIntent();
        String img=intent.getStringExtra("img");
        String tilte=intent.getStringExtra("title");
        double price=intent.getDoubleExtra("price",100);
        Orders orders=new Orders(img,price,tilte);
        ordersDao.inertIntoOrders(orders);
        Toast.makeText(GoodsDetail.this,"购买成功",Toast.LENGTH_SHORT).show();
    }



}
