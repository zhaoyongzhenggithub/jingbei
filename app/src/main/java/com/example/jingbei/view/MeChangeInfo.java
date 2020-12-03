package com.example.jingbei.view;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.jingbei.dbUtil.MyDbOpenHelper;
import com.example.taoshui.R;


public class MeChangeInfo extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText age;
    private EditText phonenumber;
    private EditText address;
    private RadioButton male;
    private RadioButton female;
    private RadioGroup sex_group;
    private String SexName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shj_me_change_info);
        username=(EditText) findViewById(R.id.fukang_me_change_info_username);
        password=(EditText) findViewById(R.id.fukang_me_change_info_password);
        age=(EditText) findViewById(R.id.fukang_me_change_info_age);
        phonenumber=(EditText) findViewById(R.id.fukang_me_change_info_phonenumber);
        address=(EditText) findViewById(R.id.fukang_me_change_info_address);
        male=(RadioButton) findViewById(R.id.fukang_me_change_info_male);
        female=(RadioButton) findViewById(R.id.fukang_me_change_info_female);
        sex_group=(RadioGroup)findViewById(R.id.fukang_me_change_info_sex_group);
        sex_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(male.getId()==checkedId){
                    SexName=male.getText().toString();
                }else if(female.getId()==checkedId){
                    SexName=female.getText().toString();
                }
            }
        });}
    public void MeChangeInfo(View view){
        TextView output=(TextView) findViewById(R.id.fukang_me_change_info_output);
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(this);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("password",password.getText().toString());
            contentValues.put("age",age.getText().toString());
            contentValues.put("phonenumber",phonenumber.getText().toString());
            contentValues.put("address",address.getText().toString());
            contentValues.put("sex",SexName);
            sqLiteDatabase.update("user",contentValues,"username=?",new String[]{username.getText().toString()});
            sqLiteDatabase.setTransactionSuccessful();
        }catch(Exception e){

        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
        output.setText("修改信息成功！");
    }
    public void MeChangeInfoReturn(View view){
        Intent intent=new Intent(this,MeMyInfo.class);
        startActivity(intent);
    }
}
