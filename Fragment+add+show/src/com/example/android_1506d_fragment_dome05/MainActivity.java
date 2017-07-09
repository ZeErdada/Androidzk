package com.example.android_1506d_fragment_dome05;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

	
	private RadioGroup radioGroup;
	private Fragment01 fragment01;
	private Fragment02 fragment02;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //获得资源ID
        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        
        fragment01=new Fragment01();
        fragment02=new Fragment02();
        //将所有的Fragment加载进来
        
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment02).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment01).commit();
        
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
     			@Override
     			public void onCheckedChanged(RadioGroup group, int checkedId) {
     				// TODO Auto-generated method stub
     				
     				switch (checkedId) {
					case R.id.but1:
						getSupportFragmentManager().beginTransaction().show(fragment01).hide(fragment02).commit();
						break;
					case R.id.but2:
						getSupportFragmentManager().beginTransaction().show(fragment02).hide(fragment01).commit();
						
						Log.i("TAG", "222");
						break;

					default:
						break;
					}
     				
     				
     			}
     		});
        
        
    }


    
}
