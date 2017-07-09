package com.example.customerdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etName;
	private EditText etPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		findViewById(R.id.btnRegister).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//显示对话框
				showDialog();
				
			}
		});
		
		
	}
	
	/**
	 * 显示一个对话框
	 */
	private void showDialog(){
		//把你定义的布局文件。充成一个View
		View view = View.inflate(this, R.layout.item, null);
		etName = (EditText) view.findViewById(R.id.etName);
		etPwd = (EditText) view.findViewById(R.id.etPwd);
		
		//创建一个构建对话框的一个Builder类实例
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//这个指定的是你自己定义的View
		builder.setView(view);
		//设置dialog按钮
		builder.setNegativeButton("取消", null);
		
		builder.setPositiveButton("注册", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				//保存数据sharedperfrences
				Toast.makeText(MainActivity.this, "注册中", 0).show();
			
				//打印到控制台
				System.out.println("用户名 : "+etName.getText().toString()+" " +
						"密码 : "+etPwd.getText().toString());
			}
		});
		
		
		//创建一个对话框
		AlertDialog dialog = builder.create();
		//显示对话框
		dialog.show();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
