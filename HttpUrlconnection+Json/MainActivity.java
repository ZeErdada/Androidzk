package com.example.admin.myzhoukao;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    String path = "http://huixinguiyu.cn/Assets/js/newsnew.js";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1){
                mylist.setAdapter(adapter);
            }
        }
    };
    private String s;
    private List<NewsBean.NewslistEntity.NewsEntity> list=new ArrayList<>();
    private ListView mylist;
    private MyBase adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = (ListView) findViewById(R.id.mylist);
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    if(connection.getResponseCode() == 200){
                        InputStream is = connection.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int len = 0;
                        byte[] buffer = new byte[1024];
                        while((len = is.read(buffer)) != -1){
                            baos.write(buffer,0,len);
                            s = baos.toString();
                        }

                        Gson gson = new Gson();
                        NewsBean newsBean = gson.fromJson(s, NewsBean.class);
                        list=newsBean.getNewslist().getNews();
                        adapter = new MyBase();
                        handler.sendEmptyMessage(1);

                    }
                    } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
    class MyBase extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHodler holder ;
            if(view == null){
                holder = new ViewHodler();
                view = View.inflate(MainActivity.this,R.layout.item,null);
                holder.mytext= (TextView) view.findViewById(R.id.mytext);
                view.setTag(holder);
            }else{
                holder= (ViewHodler) view.getTag();
            }
            holder.mytext.setText(list.get(i).getTitle()+"\n"+list.get(i).getDetail());
            return view;
        }
    }
    class ViewHodler{
        TextView mytext;
    }

}
