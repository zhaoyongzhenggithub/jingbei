package com.example.jingbei.view;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingbei.bean.Orders;
import com.example.jingbei.dao.ShoppingCarDao;
import com.example.jingbei.dbUtil.MyDbOpenHelper;
import com.example.taoshui.R;

public class TestActivity extends AppCompatActivity {
    private TextView test_view;
ShoppingCarDao shoppingCarDao=new ShoppingCarDao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);
        test_view = (TextView) findViewById(R.id.test_page);

        }

    public void TestButton(View view) {
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(this);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("title","aa");
            contentValues.put("photo","ss");
            contentValues.put("number","2");
            contentValues.put("price","22");
            sqLiteDatabase.insert("shoppingcar","",contentValues);
            sqLiteDatabase.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
    }

    public void Query(View view) {
        String title="qwerweqr";
        Orders orders=null;
        MyDbOpenHelper myDbOpenHelper=new MyDbOpenHelper(this);
        SQLiteDatabase sqLiteDatabase=myDbOpenHelper.getWritableDatabase();
        try{
            Cursor cursor=sqLiteDatabase.query("orders",new String[]{"id","title","photo","price"},null,null,null,null,null);
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                title=cursor.getString(cursor.getColumnIndex("title"));
                String photo=cursor.getString(cursor.getColumnIndex("photo"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                 orders=new Orders(photo,price,title);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqLiteDatabase.close();
        }
        Toast.makeText(this,orders.getTitle(),Toast.LENGTH_SHORT).show();
    }
}