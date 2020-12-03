package com.example.jingbei.view;

import android.util.Log;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;



public class GetNet {
    public static void requestByGet() throws Exception {
        URL url = new URL("http://blog.csdn.net/checkiming");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(6000);
        connection.setReadTimeout(6000);
        //之后再调用getInputStream()方法就可以获取到服务器返回的输入流了,剩下的任务就是对输入流进行读取,如下所示:
        InputStream in = connection.getInputStream();
        //最后可以调用disconnect()这个方法将这个HTTP连接关闭掉,如下显示
        connection.disconnect();

    }
}
