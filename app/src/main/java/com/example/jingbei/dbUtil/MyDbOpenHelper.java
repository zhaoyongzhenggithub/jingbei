package com.example.jingbei.dbUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDbOpenHelper extends SQLiteOpenHelper {
      private static final String DB_NAME="Jingbei.db";
      private static final int DB_VERSION=1;
   public MyDbOpenHelper(Context context){

       super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建用户表
       sqLiteDatabase.execSQL("create table user(id integer primary key autoincrement,username text,password text,age text,sex text,phonenumber text,address text)");
        //创建商品列表
        sqLiteDatabase.execSQL("create table goods(goodsid integer primary key autoincrement,title text,introduce text,price text,photo text,type text)");
       //创建购物车表
        sqLiteDatabase.execSQL("create table shoppingcar(id integer primary key autoincrement,title text,photo text,number text,price text)");
        //创建订单表
        sqLiteDatabase.execSQL("create table orders(id integer primary key autoincrement,title text,photo text,price text)");
        //创建足迹表
        sqLiteDatabase.execSQL("create table recently(id integer primary key autoincrement,title text,photo text,price text)");
   }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table goods");
        sqLiteDatabase.execSQL("drop table orders");
        onCreate(sqLiteDatabase);
    }
}
