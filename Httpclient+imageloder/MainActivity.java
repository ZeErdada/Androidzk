package com.bw.shinelon.rikao8;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "" ;
    private ListView lv;
    private List<Bean.DataBean> list;
    private String data;
    private MyBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);

        list = new ArrayList<>();

        MyTask myTask = new MyTask();
        myTask.execute();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取intent对象
                Intent intent = new Intent();
                //得到bundle对象
                Bundle bundle = new Bundle();
                //利用Seriazable接口方法将bean对象加入bundle中
                bundle.putSerializable("DataBean",list.get(position));
                //设置跳转
                intent.setClass(MainActivity.this,Main2Activity.class);
                //intent加载bundle
                intent.putExtras(bundle);
                //跳转
                startActivity(intent);
            }
        });

    }
    private class MyTask extends AsyncTask<Void,Void,MyBaseAdapter>{

        @Override
        protected MyBaseAdapter doInBackground(Void... params) {
            final Gson gson = new Gson();
            //接收数据
            data = getData();
            //开始解析
            Bean bean = gson.fromJson(data, Bean.class);
            //得到对象
            List<Bean.DataBean> dataBeanList = bean.getData();
            //添加集合
            list.addAll(dataBeanList);
            //得到适配器对象
            adapter = new MyBaseAdapter(MainActivity.this, list);
            //返回适配器在主线程中加载
            return adapter;
        }

        @Override
        protected void onPostExecute(MyBaseAdapter adapter) {
            lv.setAdapter(adapter);
        }
    }
    private String getData() {
        try {
            //1.创建httpClient对象
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            //2.创建请求对象,把网址封装到请求对象,请求网络的方式
            HttpGet httpGet = new HttpGet("http://www.93.gov.cn/93app/data.do?channelId=0&startNum=0");
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
