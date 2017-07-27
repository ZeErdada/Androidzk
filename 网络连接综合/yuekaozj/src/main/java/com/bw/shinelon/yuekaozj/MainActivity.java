package com.bw.shinelon.yuekaozj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout frame;
    private RadioButton rg_btn1;
    private RadioButton rg_btn2;
    private RadioButton rg_btn3;
    private RadioButton rg_btn4;
    private RadioGroup RG;
    private LinearLayout activity_main;
    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private Fragment04 fragment04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        fragment04 = new Fragment04();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment04).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment03).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment02).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment01).commit();
        getSupportFragmentManager().beginTransaction().show(fragment01).hide(fragment02).hide(fragment03).hide(fragment04).commit();

        RG.setOnCheckedChangeListener(this);
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        rg_btn1 = (RadioButton) findViewById(R.id.rg_btn1);
        rg_btn2 = (RadioButton) findViewById(R.id.rg_btn2);
        rg_btn3 = (RadioButton) findViewById(R.id.rg_btn3);
        rg_btn4 = (RadioButton) findViewById(R.id.rg_btn4);
        RG = (RadioGroup) findViewById(R.id.RG);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rg_btn1:
                getSupportFragmentManager().beginTransaction().show(fragment01).hide(fragment02).hide(fragment03).hide(fragment04).commit();
                break;
            case R.id.rg_btn2:
                getSupportFragmentManager().beginTransaction().show(fragment02).hide(fragment01).hide(fragment03).hide(fragment04).commit();
                break;
            case R.id.rg_btn3:
                getSupportFragmentManager().beginTransaction().show(fragment03).hide(fragment01).hide(fragment02).hide(fragment04).commit();
                break;
            case R.id.rg_btn4:
                getSupportFragmentManager().beginTransaction().show(fragment04).hide(fragment01).hide(fragment02).hide(fragment03).commit();
                break;
        }
    }
}