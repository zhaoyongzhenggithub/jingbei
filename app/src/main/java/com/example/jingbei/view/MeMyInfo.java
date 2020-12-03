package com.example.jingbei.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jingbei.dbUtil.MyDbOpenHelper;
import com.example.taoshui.R;


public class MeMyInfo extends AppCompatActivity {
    private Context context;
    private TextView Info_username;
    private TextView Info_password;
    private TextView Info_sex;
    private TextView Info_age;
    private TextView Info_phonenumber;
    private TextView Info_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shj_my_info);
        Info_username=(TextView) findViewById(R.id.fukang_my_info_username);
        Info_password=(TextView) findViewById(R.id.fukang_my_info_password);
        Info_sex=(TextView) findViewById(R.id.fukang_my_info_sex);
        Info_age=(TextView) findViewById(R.id.fukang_my_info_age);
        Info_phonenumber=(TextView) findViewById(R.id.fukang_my_info_phone_number);
        Info_address=(TextView) findViewById(R.id.fukang_my_info_address);
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(this);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getReadableDatabase();
        try{

            Cursor cursor=sqLiteDatabase.query("user",new String[]{"username","password","sex","age","phonenumber","address"},null,null,null,null,null);

            while(cursor.moveToNext()){
                int index0=cursor.getColumnIndex("username");
                String Info_cursor_username=cursor.getString(index0);
                int index=cursor.getColumnIndex("password");
                String Info_cursor_password=cursor.getString(index);
                int index1=cursor.getColumnIndex("sex");
                String Info_cursor_sex=cursor.getString(index1);
                int index2=cursor.getColumnIndex("age");
                String Info_cursor_age=cursor.getString(index2);
                int index3=cursor.getColumnIndex("phonenumber");
                String Info_cursor_phonenumber=cursor.getString(index3);
                int index4=cursor.getColumnIndex("address");
                String Info_cursor_address=cursor.getString(index4);
                Info_username.setText(Info_cursor_username);
                Info_password.setText(Info_cursor_password);
                Info_sex.setText(Info_cursor_sex);
                Info_age.setText(Info_cursor_age);
                Info_phonenumber.setText(Info_cursor_phonenumber);
                Info_address.setText(Info_cursor_address);
            }
            cursor.close();
        }catch(Exception e){
        }finally{
            sqLiteDatabase.close();
        }
    }
    public void MeMyInfoReturn(View view){ ;
        finish();
    }
    public void MeMyInfoChangeInfo(View view){
        Intent intent=new Intent(this,MeChangeInfo.class);
        startActivity(intent);
    }
}
