package com.example.jingbei.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jingbei.dbUtil.MyDbOpenHelper;
import com.example.jingbei.bean.CarGoods;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCarDao {
    private Context context;
    public ShoppingCarDao(Context context){
        this.context=context;
    }
    /**
     * 添加到购物车
     */
    public void  inertIntoCar(CarGoods carGoods){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("title",carGoods.getTitle());
            contentValues.put("photo",carGoods.getPhoto());
            contentValues.put("number",carGoods.getNumber());
            contentValues.put("price",String.valueOf(carGoods.getPrice()));
            sqLiteDatabase.insert("shoppingcar","",contentValues);
            contentValues.clear();
            sqLiteDatabase.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
    }
    /**
     * 查询购物车所有商品
     */
    public List queryCarGoods(){
        List carList=new ArrayList();//保存购物车中所有的商品
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.query("shoppingcar",new String[]{"id","title","photo","number","price"},null,null,null,null,null);
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                String number=cursor.getString(cursor.getColumnIndex("number"));

                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                CarGoods carGoods=new CarGoods(title,photo,number,price);
                carList.add(carGoods);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.close();
        }
        return carList;
    }
    /**
     * 按id删除
     */
    public void deleteCarGoods(int id){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try{
            sqLiteDatabase.delete("shoppingcar","id=?",new String[]{String.valueOf(id)});
            sqLiteDatabase.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
    }
}
