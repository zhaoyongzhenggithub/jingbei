package com.example.jingbei.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jingbei.dbUtil.MyDbOpenHelper;
import com.example.jingbei.bean.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
    private  Context context;
    public OrdersDao(Context context){

        this.context=context;
    }
    //插入到订单表中
    public void  inertIntoOrders(Orders orders){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("title",orders.getTitle());
            contentValues.put("photo",orders.getPhoto());
            contentValues.put("price",String.valueOf(orders.getPrice()));
            sqLiteDatabase.insert("orders","",contentValues);
            contentValues.clear();
            sqLiteDatabase.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
    }
    //查询数据库中所有数据
    public List queryOrders(){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase1=myDbOpenHelper.getWritableDatabase();
        List orderList=new ArrayList();//保存订单中所有的商品
        try{
            Cursor cursor=sqLiteDatabase1.query("orders",new String[]{"id","title","photo","price"},null,null,null,null,null);
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
              Orders orders=new Orders(photo,price,title);
                orderList.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase1.close();
        }
        return orderList;
    }

}
