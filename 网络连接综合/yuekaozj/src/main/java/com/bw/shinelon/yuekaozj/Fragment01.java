package com.bw.shinelon.yuekaozj;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.shinelon.yuekaozj.xListView.XListView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Fragment01 extends Fragment implements XListView.IXListViewListener {

    private Banner banner;
    private XListView Xlistv;
    private String path = "http://v.juhe.cn/toutiao/index?type=top&key=e76b62dbe5ce78645516fe866dc7058b";
    private List<Bean.ResultBean.DataBean> list;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.fragment01, container, false);


        MyTask myTask = new MyTask();
        myTask.execute();
        initView(view);

        //开启下拉刷新
        Xlistv.setPullRefreshEnable(true);
        //开启加载更多可用
        Xlistv.setPullLoadEnable(true);

        //设置XlistView的上拉加载,下拉刷新的接口
        Xlistv.setXListViewListener(this);

        return view;
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
         protected void onPreExecute() {
             boolean nc = NetWorkUtils.isNetworkConnected(getActivity());
             if (nc){
                 Toast.makeText(getActivity(),"网络已连接！",Toast.LENGTH_SHORT).show();
             }else {
                 new  AlertDialog.Builder(getActivity())
                         .setTitle("提示" )
                         .setMessage("无网络连接是否继续访问？" )
                         .setPositiveButton("是", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 dialog.dismiss();
                             }
                         })
                         .setNegativeButton("否", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 // 跳转到系统的网络设置界面
                                 Intent intent = null;
                                 // 先判断当前系统版本
                                 if(android.os.Build.VERSION.SDK_INT > 10){  // 3.0以上
                                     intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                                 }else{
                                     intent = new Intent();
                                     intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                                 }
                                 getActivity().startActivity(intent);
                             }
                         }).show();
             }
         }

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
            List<String> images = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String s02 = list.get(i).getThumbnail_pic_s02();
                images.add(s02);
            }

            banner.setImages(images).setImageLoader(new GlideImageLoader()).start();

            adapter = new MyBaseAdapter();
            Xlistv.setAdapter(adapter);
        }
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        Xlistv = (XListView) view.findViewById(R.id.Xlistv);
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播
        banner.stopAutoPlay();
    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
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
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.list_item, null);
                holder.iv = (ImageView) convertView.findViewById(R.id.xlist_image);
                holder.tv1 = (TextView) convertView.findViewById(R.id.xlist_tv1);
                holder.tv2 = (TextView) convertView.findViewById(R.id.xlist_tv2);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Glide.with(getActivity()).load(list.get(position).getThumbnail_pic_s()).into(holder.iv);
            holder.tv1.setText(list.get(position).getAuthor_name());
            holder.tv2.setText(list.get(position).getTitle());
            return convertView;
        }

        class ViewHolder {
            ImageView iv;
            TextView tv1, tv2;
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
