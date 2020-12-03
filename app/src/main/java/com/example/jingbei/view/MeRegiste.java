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

public class MeRegiste extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText password_confrim;
    private EditText age;
    private EditText phone_number;
    private EditText address;
    private RadioButton male;
    private RadioButton female;
    private RadioGroup sex_group;
    private String SexName;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shj_me_registe);
        username=(EditText) findViewById(R.id.fukang_me_registe_username);
        password=(EditText)findViewById(R.id.fukang_me_registe_password);
        password_confrim=(EditText)findViewById(R.id.fukang_me_registe_password_confirm);
        age=(EditText)findViewById(R.id.fukang_me_registe_age);
        phone_number=(EditText)findViewById(R.id.fukang_me_registe_phone_number);
        address=(EditText)findViewById(R.id.fukang_me_registe_adddress);
        male=(RadioButton)findViewById(R.id.fukang_me_registe_male);
        female=(RadioButton)findViewById(R.id.fukang_me_registe_female);
        sex_group=(RadioGroup)findViewById(R.id.fukang_me_registe_sex_group);
        sex_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(male.getId()==checkedId){
                    SexName=male.getText().toString();
                }else if (female.getId()==checkedId){
                    SexName=female.getText().toString();
                }
            }
        });
        info=(TextView)findViewById(R.id.fukang_me_registe_info);
    }
    public void MeRegisteSubmit(View view){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(this);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        String username_add=username.getText().toString();
        if(password.getText().toString().equals(password_confrim.getText().toString())) {
            String password_add = password.getText().toString();
            String age_add=age.getText().toString();
            String phone_number_add=phone_number.getText().toString();
            String address_add=address.getText().toString();
            String SexName_add=SexName;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("username", username_add);
                contentValues.put("password", password_add);
                contentValues.put("age", age_add);
                contentValues.put("sex", SexName_add);
                contentValues.put("phonenumber", phone_number_add);
                contentValues.put("address", address_add);
                sqLiteDatabase.insert("user", "", contentValues);
                sqLiteDatabase.setTransactionSuccessful();
            }catch (Exception e){

            }finally {
                sqLiteDatabase.endTransaction();
                sqLiteDatabase.close();
            }
            info.setText("恭喜您，注册成功！");
        }else if(password.getText().toString()!=password_confrim.getText().toString()){
            info.setText("两次输入密码不一致！");
        }else if(password.getText().toString()==null||password_confrim.getText().toString()==null){
            info.setText("请输入注册信息！");
        }

    }
    public void MeRegisteReturn(View view){
        Intent intent=new Intent(this,MeSignup.class);
        startActivity(intent);
    }
}
