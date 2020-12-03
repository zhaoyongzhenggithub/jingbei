package com.example.jingbei.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jingbei.dbUtil.MyDbOpenHelper;

public class UserDao {
    private Context context;
    private TextView Info_username;
    private TextView Info_password;
    private TextView Info_sex;
    private TextView Info_age;
    private TextView Info_phonenumber;
    private TextView Info_address;
    private EditText username;
    private EditText password;
    private TextView Info;
    private String username_db;
    private String password_db;
    public void Insert(){

        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
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
    public void FukangMeSignup (View view){
        String get_username=username.getText().toString();
        String get_password=password.getText().toString();
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getReadableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.query("user",new String[]{"username","password"},"username=?",new String[]{get_username},null,null,null);
            while(cursor.moveToNext()){
                int index0=cursor.getColumnIndex("username");
                username_db=cursor.getString(index0);
                int index=cursor.getColumnIndex("password");
                password_db=cursor.getString(index);
            }
            cursor.close();
        }catch(Exception e){
        }finally{
            sqLiteDatabase.close();
        }
        //传输用户名到另一个页面
        if(get_username.equals(username_db)&&get_password.equals(password_db)){

            String content_name=username_db;
            String content_passwd=password_db;
            if(content_name!=null&&content_passwd!=null){
        }
        }else{
            Info.append("密码错误！");
        }
    }
}
