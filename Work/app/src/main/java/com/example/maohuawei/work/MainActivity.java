package com.example.maohuawei.work;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView list_view;
    private String data;
    private List<RootBean.NewslistEntity.NewsEntity> list;
    private MyBaseAdapter adapter;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            list_view.setAdapter(adapter);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = (ListView) findViewById(R.id.list_view);

        final Gson gson = new Gson();

        list = new ArrayList<>();


        new Thread(new Runnable() {
            @Override
            public void run() {
                data = getData();

                Log.e(TAG, "run: " + data);

                RootBean rootBean = gson.fromJson(data, RootBean.class);

                RootBean.NewslistEntity newslist = rootBean.getNewslist();

                List<RootBean.NewslistEntity.NewsEntity> news = newslist.getNews();

                list.addAll(news);

                adapter = new MyBaseAdapter(MainActivity.this, list);

                handler.sendEmptyMessage(1);


            }
        }).start();


    }

    private String getData() {
        try {
            URL url = new URL("http://huixinguiyu.cn/Assets/js/newsnew.js");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(1024 * 8);

            connection.setReadTimeout(1024 * 8);

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();


            if (responseCode == 200) {

                InputStream inputStream = connection.getInputStream();

                int len = 0;
                //缓冲区  一次读取1024*8
                byte[] buf = new byte[1024 * 8];

                ByteArrayOutputStream  baos = new ByteArrayOutputStream();

                while ((len = inputStream.read(buf)) != -1) {

                    baos.write(buf, 0, len);

                }

                baos.close();
                return baos.toString();


            } else {
                Log.e(TAG, "onCreate: Error" + responseCode);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
