package com.bw.shinelon.day07;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

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
            //1.创建httpClient对象
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            //2.创建请求对象,把网址封装到请求对象,请求网络的方式
            HttpGet httpGet = new HttpGet("http://huixinguiyu.cn/Assets/js/newsnew.js");
            //3.使用客户端对象发送请求,获取服务器的响应
            //从response对象中拿到服务器给我们返回的信息
            HttpResponse response = defaultHttpClient.execute(httpGet);
            StatusLine line = response.getStatusLine();
            //获取状态码
            int code = line.getStatusCode();
            //4.判断请求网络是否成功

            if (code == 200) {
                //5.服务器通过流写给客户端的数据,把它成一个实体
                HttpEntity entity = response.getEntity();
                //获取输入流
                InputStream is = entity.getContent();
                int len = 0;
                //缓冲区  一次读取1024*8
                byte[] buf = new byte[1024 * 8];

                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                while ((len = is.read(buf)) != -1) {

                    baos.write(buf, 0, len);

                }

                baos.close();
                return baos.toString();


            } else {
                Log.e(TAG, "onCreate: Error" + code);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
