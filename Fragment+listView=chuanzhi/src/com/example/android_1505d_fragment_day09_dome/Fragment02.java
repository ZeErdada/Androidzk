package com.example.android_1505d_fragment_day09_dome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment02 extends Fragment{
	
	private View view;
	private TextView textView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		view=inflater.inflate(R.layout.fragment02, container, false);
		textView=(TextView) view.findViewById(R.id.textview);
		
		return view;
	}
	//接受Fragment01传过来的值
	public void setTextArs(String string){
		
		textView.setText(string);
		
		
	}
	

}
