package com.example.jingbei.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.taoshui.R;

public class MeLogin extends AppCompatActivity {
    private String SignUpName;
    private String SignUpPasswd;
    private TextView displayname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shj_me_login);
        Intent intent=getIntent();
        SignUpName=intent.getStringExtra("transform_username");
        SignUpPasswd=intent.getStringExtra("transform_passwd");
        //SignUpPasswd=intent.getStringExtra("transform_passwd");
        displayname=(TextView)findViewById(R.id.fukang_me_login_displayname);
        displayname.append(SignUpName);
    }
    public void MeLogOut(View view){
        Intent intent=new Intent(this,MeNotLogin.class);
        startActivity(intent);
    }
    public void LoginWatchMyInfo(View view){
        Intent intent=new Intent(this,MeMyInfo.class);
        startActivity(intent);
    }
    public void WatchWeather(View view){
        Intent intent=new Intent(this,Weather.class);
        startActivity(intent);
    }
    //我的订单部分，等待其他成员写好接口

    public void LoginMyOrder(View view){
        Intent intent=new Intent(this,OrderActivity.class);
        startActivity(intent);
    }

    //我的足迹部分，等待其他成员写好接口

    public void LoginMyFooter(View view){
        Intent intent=new Intent(this,GoodsRecently.class);
        startActivity(intent);
    }

//最下面页面跳转
    public void buttom_melogin_Mainactivity(View view){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("LogID",SignUpName);
        intent.putExtra("Passwd",SignUpPasswd);
        startActivity(intent);

    }
    public void button_melogin_Weather(View view){
        Intent intent=new Intent(this,Weather.class);
        startActivity(intent);

    }
    public void buttom_melogin_Caractivity(View view){
        Intent intent=new Intent(this,CarActivity.class);
        startActivity(intent);

    }

}
