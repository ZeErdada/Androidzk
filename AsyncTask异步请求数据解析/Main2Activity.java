package com.bw.shinelon.rikao8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private ImageView iv;
    private TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv = (ImageView) findViewById(R.id.M2_image);
        tv1 = (TextView) findViewById(R.id.M2_title);
        tv2 = (TextView) findViewById(R.id.M2_subtitle);
        tv3 = (TextView) findViewById(R.id.M2_fromname);
        tv4 = (TextView) findViewById(R.id.M2_showtime);
        Bean.DataBean dataBean = (Bean.DataBean) getIntent().getSerializableExtra("DataBean");

        ImageloderUtils.setImageView(dataBean.getIMAGEURL(),this,iv);
        tv1.setText(dataBean.getTITLE());
        tv2.setText(dataBean.getSUBTITLE());
        tv3.setText(dataBean.getFROMNAME());
        tv4.setText(dataBean.getSHOWTIME());
    }
}
