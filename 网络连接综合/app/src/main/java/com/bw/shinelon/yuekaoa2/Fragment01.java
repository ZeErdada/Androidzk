package com.bw.shinelon.yuekaoa2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.shinelon.yuekaoa2.xListView.XListView;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Fragment01 extends Fragment {

    private XListView xListView;
    private String path = "http://baobab.kaiyanapp.com/api/v4/discovery/hot?start=0&num=20&udid=f4cbbcd2e9444b09a73bf9f3de46c0ec6392c2ba&vc=183&vn=3.5.1&deviceModel=Redmi%20Note%204&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23";
    private List<Bean.ItemListBeanX.DataBeanX.ItemListBean.DataBean> datalist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.fragment01, container, false);
        xListView = (XListView) view.findViewById(R.id.Xilst);
        getData();
        datalist = new ArrayList<>();

        MyBaseAdapter adapter = new MyBaseAdapter();
        xListView.setAdapter(adapter);
        return view;
    }

    private void getData() {
        new Thread() {
            @Override
            public void run() {
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
                    if (conn.getResponseCode() == 200) {
                        InputStream is = conn.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = is.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        final String s = baos.toString();
                        Gson gson = new Gson();
                        Bean bean = gson.fromJson(s, Bean.class);
                        List<Bean.ItemListBeanX> itemList = bean.getItemList();
                        for (int i = 0; i < itemList.size(); i++) {
                            List<Bean.ItemListBeanX.DataBeanX.ItemListBean> itemList1 = itemList.get(i).getData().getItemList();
                            for (int j = 0; j < itemList1.size(); j++) {
                                Bean.ItemListBeanX.DataBeanX.ItemListBean.DataBean data = itemList1.get(j).getData();
                                datalist.add(data);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
class MyBaseAdapter extends BaseAdapter{

    @Override
    public int getCount() {
        return datalist.size();
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
        if (convertView == null){
            holder = new ViewHolder();
           convertView = View.inflate(getActivity(),R.layout.list_item,null);
            holder.iv = (ImageView) convertView.findViewById(R.id.List_iv1);
            holder.list_tv1 = (TextView) convertView.findViewById(R.id.List_tv1);
            holder.List_tv2 = (TextView) convertView.findViewById(R.id.List_tv2);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(getActivity()).load(datalist.get(position).getImage()).into(holder.iv);
        holder.list_tv1.setText(datalist.get(position).getTitle());
        holder.List_tv2.setText(datalist.get(position).getDescription());
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView list_tv1,List_tv2;
    }
}

}
