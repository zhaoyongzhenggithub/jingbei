package com.example.jingbei.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.taoshui.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Weather extends AppCompatActivity {
    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private String getCity = "济南";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shj_me_weather);

        textView=(TextView)findViewById(R.id.weather_title);
        textView1=(TextView)findViewById(R.id.weather_text1);
        textView2=(TextView)findViewById(R.id.weather_text2);
        textView3=(TextView)findViewById(R.id.weather_text3);
        textView4=(TextView)findViewById(R.id.weather_text4);
        new Thread(new MyHttpRequest()).start();
    }
    public void searchCity(View view){
       getCity=textView4.getText().toString();
        new Thread(new MyHttpRequest()).start();
    }
    private class MyHttpRequest implements Runnable{

        @Override
        public void run() {
            try {
                URL url = new URL("http://v.juhe.cn/weather/index?format=2&key=04b5c0331e7b74d627ef59735c0e8de3&cityname=" + URLEncoder.encode(getCity, "UTF-8"));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(100000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.connect();
                if(connection.getResponseCode()!=HttpURLConnection.HTTP_BAD_REQUEST){
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String temp="";
                    final StringBuilder response=new StringBuilder();
                    while((temp=bufferedReader.readLine())!=null){
                        response.append(temp);
                    }
                    JSONObject jsonObject=new JSONObject(response.toString());
                    final String result=jsonObject.getString("result");
                    final String resultCode=jsonObject.getString("resultcode");
                    JSONObject jsonObject1=new JSONObject(result);
                    String today=jsonObject1.getString("today");
                    String sk=jsonObject1.getString("sk");
                    JSONObject jsonObject2=new JSONObject(today);
                    final String city=jsonObject2.getString("city");
                    final String temperature=jsonObject2.getString("temperature");
                    final String weather_con=jsonObject2.getString("weather");
                    JSONObject sk1=new JSONObject(sk);
                    final String wind=sk1.getString("wind_direction");
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(city);
                        }
                    });
                    textView1.post(new Runnable() {
                        @Override
                        public void run() {
                            textView1.setText("今日温度："+temperature);
                        }
                    });
                    textView2.post(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText("今日天气状况："+weather_con);
                        }
                    });
                    textView3.post(new Runnable() {
                        @Override
                        public void run() {
                            textView3.setText("风向："+wind);
                        }
                    });
                    Log.d(MyHttpRequest.class.toString(),response.toString());
                    bufferedReader.close();
                }
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
