package com.example.android_1505d_fragment_day09_dome;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment01 extends Fragment{
	
	private View view;
	private ListView listView;
	private List<String> list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		view=inflater.inflate(R.layout.fragment01, container, false);
		
		//获取资源ID
		listView=(ListView) view.findViewById(R.id.listview);
		
		return view;
	}
	//进行一些逻辑的操作
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		list=new ArrayList<String>();
		//添加数据
		getdate();
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, list);
		//listview进行展示数据
		listView.setAdapter(adapter);
		//对listview的Item添加监听
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//通过当前的Activity的到管理者在的到Id
				Fragment02 fragment02=(Fragment02) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment02);
				//将listview的值传到fragment当中
				fragment02.setTextArs(list.get(position));
			}
		});
		
	}
	public void getdate() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			list.add("小米"+i);
		}
		
		
	}

}
