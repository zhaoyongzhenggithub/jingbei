package com.example.jingbei.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.taoshui.R;

public class MeNotLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shj_me_not_login);
    }
    public void MeNotLogin (View view){
        Intent intent=new Intent(this,MeSignup.class);
        startActivity(intent);
    }
    public void MeNotLoginRegister(View view){
        Intent intent=new Intent(this,MeRegiste.class);
        startActivity(intent);
    }
    public void MeNotLoginTest(View view){
        Intent intent=new Intent(this,TestActivity.class);
        startActivity(intent);
    }
    //
    public void buttom_menotlogin_Mainactivity(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void button_menotlogin_Weather(View view){
        Intent intent=new Intent(this,Weather.class);
        startActivity(intent);
    }
    public void buttom_menotlogin_Caractivity(View view){
        Intent intent=new Intent(this,CarActivity.class);
        startActivity(intent);
    }

}
