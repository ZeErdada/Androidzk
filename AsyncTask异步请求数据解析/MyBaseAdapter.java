package com.bw.shinelon.rikao8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 创建时间： 2017/7/13
 * 创建人：Android 1506D 王野
 * 类作用：
 */

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.DataBean> list;

    public MyBaseAdapter(Context context, List<Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

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
        if (convertView==null){
            convertView = View.inflate(context,R.layout.item,null);
            holder = new ViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.tv1 = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv2 = (TextView) convertView.findViewById(R.id.tv_fromname);
            holder.tv3 = (TextView) convertView.findViewById(R.id.tv_showtime);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
            holder.tv1.setText(list.get(position).getTITLE());
            holder.tv2.setText(list.get(position).getFROMNAME());
            holder.tv3.setText(list.get(position).getSHOWTIME());
            ImageloderUtils.setImageView(list.get(position).getIMAGEURL(),context,holder.iv);
        return convertView;
    }
    static class ViewHolder{
            TextView tv1,tv2,tv3;
            ImageView iv;
    }
}
