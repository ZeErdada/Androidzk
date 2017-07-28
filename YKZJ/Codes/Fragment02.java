package com.bw.shinelon.yuekaozj;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.shinelon.yuekaozj.xListView.XListView;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.inflate;

public class Fragment02 extends Fragment implements XListView.IXListViewListener {
	private XListView Xlistv;
	private String path = "http://v.juhe.cn/toutiao/index?type=top&key=e76b62dbe5ce78645516fe866dc7058b";
	private List<Bean.ResultBean.DataBean> list;
	private List<XlistBean> beanList;
	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			//刷新listView
			adapter.notifyDataSetChanged();
			//隐藏头和尾
			closeXlistView();
		}
	};
	private MyBaseAdapter adapter;
	private final static int FristType = 1;
	private  final static int TwoType = 2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View view = inflater.inflate(R.layout.fragment02, container, false);

		initView(view);
		MyTask myTask = new MyTask();
		myTask.execute();
		//开启下拉刷新
		Xlistv.setPullRefreshEnable(true);
		//开启加载更多可用
		Xlistv.setPullLoadEnable(true);

		//设置XlistView的上拉加载,下拉刷新的接口
		Xlistv.setXListViewListener(this);
		return view;
	}

	private void inData() {
		beanList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			XlistBean xbean = new XlistBean();
			if (i%2 == 0){
				xbean.setType(FristType);
				xbean.setThumbnail_pic_s(list.get(i).getThumbnail_pic_s());
				xbean.setTitle(list.get(i).getTitle());
			}else {
				xbean.setType(TwoType);
				xbean.setThumbnail_pic_s(list.get(i).getThumbnail_pic_s());
				xbean.setTitle(list.get(i).getTitle());
			}
			beanList.add(xbean);
		}
	}

	@Override
	public void onRefresh() {
		handler.sendEmptyMessage(0);
	}

	@Override
	public void onLoadMore() {
		handler.sendEmptyMessage(0);
	}

	class MyTask extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			try {
				//建立地址对象
				URL url = new URL(path);
				//得到对象
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				//设置请求方式
				conn.setRequestMethod("GET");
				//设置响应时间
				conn.setConnectTimeout(3000);
				//读取超时时间
				conn.setReadTimeout(3000);
				//同步请求
				System.out.println("asdadsadad"+conn.getResponseCode());
				if (conn.getResponseCode() == 200) {
					InputStream is = conn.getInputStream();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = is.read(buffer)) != -1) {
						baos.write(buffer, 0, len);
					}
					final String s = baos.toString();
					System.out.println("asdadsadad"+s);
					return s;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String s) {
			super.onPostExecute(s);
			System.out.println("nishishishis" + s);
			list = new ArrayList<>();
			Gson gson = new Gson();
			Bean bean = gson.fromJson(s, Bean.class);
			List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
			list.addAll(data);
			inData();
			adapter = new MyBaseAdapter();
			Xlistv.setAdapter(adapter);
		}
	}

	private void initView(View view) {
		Xlistv = (XListView) view.findViewById(R.id.Xlist2);
	}

	class MyBaseAdapter extends BaseAdapter {
		@Override
		public int getViewTypeCount() {
			return 3;
		}

		@Override
		public int getItemViewType(int position) {
			return beanList.get(position).getType();
		}

		@Override
		public int getCount() {
			return beanList.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder1 holder1 = null;
			ViewHolder2 holder2 = null;
			int type = getItemViewType(position);
			if (convertView == null){
				switch (type){
					case FristType:
						holder1 = new ViewHolder1();
						convertView = View.inflate(getActivity(),R.layout.item,null);
						holder1.iv = (ImageView) convertView.findViewById(R.id.holder1_iv1);
						holder1.tv = (TextView) convertView.findViewById(R.id.holder1_tv1);
						convertView.setTag(holder1);
						break;
					case TwoType:
						holder2 = new ViewHolder2();
						convertView = View.inflate(getActivity(),R.layout.item2,null);
						holder2.iv = (ImageView) convertView.findViewById(R.id.holder2_iv1);
						holder2.tv = (TextView) convertView.findViewById(R.id.holder2_tv1);
						convertView.setTag(holder2);
						break;
					default:
						break;
				}

			}else {
				switch (type){
					case FristType:
						holder1 = (ViewHolder1) convertView.getTag();
						break;
					case TwoType:
						holder2 = (ViewHolder2) convertView.getTag();
						break;
					default:
						break;
				}
			}
			switch (type){
				case FristType:
					Glide.with(getActivity()).load(beanList.get(position).getThumbnail_pic_s()).into(holder1.iv);
					holder1.tv.setText(beanList.get(position).getTitle());
					break;
				case TwoType:
					Glide.with(getActivity()).load(beanList.get(position).getThumbnail_pic_s()).into(holder2.iv);
					holder2.tv.setText(beanList.get(position).getTitle());
					break;
				default:
					break;
			}
			return convertView;
		}

		class ViewHolder1 {
			ImageView iv;
			TextView tv;
		}
		class ViewHolder2 {
			ImageView iv;
			TextView tv;
		}

	}

	//刷新给关闭的逻辑代码
	private void closeXlistView() {
		//停止加载更多
		Xlistv.stopLoadMore();
		//停止刷新
		Xlistv.stopRefresh();
		//更新时间
		Xlistv.setRefreshTime("2017/7/27");
	}
	

}
