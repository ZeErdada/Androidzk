package com.bw.shinelon.yuekaoa2;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private RadioButton tv1;
    private RadioButton tv2;
    private RadioButton tv3;
    private RadioGroup RG;
    private Banner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();



        banner = (Banner) findViewById(R.id.banner);
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.abc);
        list.add(R.drawable.abc1);
        list.add(R.drawable.abc2);
        list.add(R.drawable.abc3);

        banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment03).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment02).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment01).commit();
        getSupportFragmentManager().beginTransaction().show(fragment01).hide(fragment02).hide(fragment03).commit();


    }

    private void initView() {

        tv1 = (RadioButton) findViewById(R.id.tv1);
        tv2 = (RadioButton) findViewById(R.id.tv2);
        tv3 = (RadioButton) findViewById(R.id.tv3);
        RG = (RadioGroup) findViewById(R.id.RG);
        RG.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tv1:
                getSupportFragmentManager().beginTransaction().show(fragment01).hide(fragment02).hide(fragment03).commit();
                break;
            case R.id.tv2:
                getSupportFragmentManager().beginTransaction().show(fragment02).hide(fragment01).hide(fragment03).commit();
                break;
            case R.id.tv3:
                getSupportFragmentManager().beginTransaction().show(fragment03).hide(fragment01).hide(fragment02).commit();
                break;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束轮播
        banner.stopAutoPlay();
    }
}
