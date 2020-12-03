package com.example.jingbei.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jingbei.bean.Recently;
import com.example.jingbei.dbUtil.MyDbOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class RecentlyDao {
    private Context context;
    public RecentlyDao(Context context){
        this.context=context;
    }
    //添加足迹
    public void  inertIntoRecently(Recently recently){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("title",recently.getTitle());
            contentValues.put("photo",recently.getPhoto());
            contentValues.put("price",String.valueOf(recently.getPrice()));
            sqLiteDatabase.insert("recently","",contentValues);
            contentValues.clear();
            sqLiteDatabase.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
    }
    //查看足迹
    public List queryOrders(){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase1=myDbOpenHelper.getWritableDatabase();
        List recentlyList=new ArrayList();//保存订单中所有的商品
        try{
            Cursor cursor=sqLiteDatabase1.query("recently",new String[]{"id","title","photo","price"},null,null,null,null,null);
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                Recently recently=new Recently(photo,price,title);
                recentlyList.add(recently);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase1.close();
        }
        return recentlyList;
    }

    //删除操作
    public void deleteAll(){
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(context);
        SQLiteDatabase sqLiteDatabase1=myDbOpenHelper.getWritableDatabase();;
        //参数(表名，删除条件，条件值)
        sqLiteDatabase1.delete("recently",null,null);
        sqLiteDatabase1.close();
    }

}
