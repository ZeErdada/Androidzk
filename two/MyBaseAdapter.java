package com.bw.two;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static android.view.View.inflate;

/**
 * Created by Shinelon on 2017/7/6.
 */

public class MyBaseAdapter extends BaseAdapter{
    private Context context;
    private List<Bean> list;

    public MyBaseAdapter(Context context, List<Bean> list) {
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
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.item,null);
           holder.tv1 = (TextView) convertView.findViewById(R.id.tvv1);
           holder.tv2 = (TextView) convertView.findViewById(R.id.tvv2);
           convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv1.setText(list.get(position).getDataSize()+"");
        holder.tv2.setText(list.get(position).getApk().get(position).toString());
        return convertView;
    }
    class ViewHolder{
        TextView tv1,tv2;
    }
}
