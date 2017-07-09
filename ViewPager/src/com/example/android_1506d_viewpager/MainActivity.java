package com.example.android_1506d_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	private ViewPager viewPager;
	private List<Integer> list;
	private RadioGroup radioGroup;
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			//接受handler发送的消息
			if(msg.what==0){
				int i=0;
				//接受Viewpager显示图片的位置
				i=viewPager.getCurrentItem();
				viewPager.setCurrentItem(i+1);
			}
		};
	};
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        	
        //获取资源ID
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        
        list=new ArrayList<Integer>();
        
        //存放图片数据
        list.add(R.drawable.c);
        list.add(R.drawable.d);
        list.add(R.drawable.e);
        //将Activity  数据源 交给adapter
        ViewPagerAdapter adapter=new ViewPagerAdapter(list, this);
        
        viewPager.setAdapter(adapter);
        //没过2秒自动向Handler发送一条消息 切换图片
        new Thread(){
        	public void run() {
        		
        		while (true) {
					try {
						sleep(2000);
						handler.sendEmptyMessage(0);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
        		
        	};
        }.start();
        
        
        
        
        //将显示图片的位置设置到 中间  可以往左滑
        viewPager.setCurrentItem(list.size()*10000);
    
        //监听选中的页数的
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			//选择的页数
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				//通过图片的位置选中Button
				switch (arg0%list.size()) {
				case 0:
					radioGroup.check(R.id.but1);
					
					break;
				case 1:
					radioGroup.check(R.id.but2);			
					break;
				case 2:
					radioGroup.check(R.id.but3);
					break;

				default:
					break;
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        
    }
    
}
