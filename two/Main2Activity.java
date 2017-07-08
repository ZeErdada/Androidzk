package com.bw.two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<Bean> list;
    private JSONObject jb;
    private List<Bean.ApkBean> alist;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = (ListView) findViewById(R.id.lv);
        String path = "http://huixinguiyu.cn/Assets/js/Data.js";
        list = HttpUrlconnUtils.HttpGet(path);
        listView.setAdapter(new MyBaseAdapter(this, list));
    }


}
