package com.example.jingbei.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingbei.dbUtil.MyDbOpenHelper;
import com.example.taoshui.R;

public class MeSignup extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private TextView Info;
    private String username_db;
    private String password_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shj_me_signup);
        username=(EditText) findViewById(R.id.fukang_me_signup_username);
        password=(EditText) findViewById(R.id.fukang_me_signup_password);
        Info=(TextView)findViewById(R.id.fukang_me_signup_info);
    }

    public void MeSignupReturn(View view){
        finish();
    }

    public void MeSignup (View view){
        String get_username=username.getText().toString();
        String get_password=password.getText().toString();
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(this);
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
            Intent intent=new Intent(this,MeLogin.class);
            String content_name=username_db;
            String content_passwd=password_db;
            if(content_name!=null&&content_passwd!=null){
                intent.putExtra("transform_username",content_name);
                intent.putExtra("transform_passwd",content_passwd);
            }
            startActivity(intent);
        }else{
            Toast.makeText(MeSignup.this,"密码错误",Toast.LENGTH_SHORT).show();
        }
    }
}
