package com.bw.two;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private int i = 3;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 0:
                        iv.setImageBitmap((Bitmap) msg.obj);
                        AnimationSet animationSet = new AnimationSet(true);
                        AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f, 0.0f);
                        ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                        animationSet.addAnimation(alphaAnimation);
                        animationSet.addAnimation(scaleAnimation);
                        animationSet.setDuration(3000);
                        iv.setAnimation(animationSet);
                    case 1:
                        if (i>0){
                            i--;
                        }else {
                            startActivity(new Intent(MainActivity.this,Main2Activity.class));
                        }
                        break;
                    default:
                        break;
                }
            }
        };
        String path = "http://pic48.nipic.com/file/20140912/7487939_223919315000_2.jpg";
        requestNetThread(path);
    }

    private void requestNetThread(final String path) {
        new Thread() {
            @Override
            public void run() {
                requestNet(path);
               while (i>0){
                   try {
                       sleep(1000);
                       Message message = new Message();
                       message.what=1;
                       handler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void requestNet(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            int code = conn.getResponseCode();
            if (code == 200) {
                Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream());
                Message message = new Message();
                message.obj = bitmap;
                message.what = 0;
                handler.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
