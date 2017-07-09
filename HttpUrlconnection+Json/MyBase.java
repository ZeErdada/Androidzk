package com.example.admin.myzhoukao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/7/7.
 */

public class MyBase extends BaseAdapter {
    private Context context;
    private List<NewsBean.NewslistEntity.NewsEntity> list=new ArrayList<NewsBean.NewslistEntity.NewsEntity>();

    public MyBase(Context context, List<NewsBean.NewslistEntity.NewsEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = View.inflate(context,R.layout.activity_main,null);
            holder = new ViewHolder();
            holder.mytext= (TextView) view.findViewById(R.id.mytext);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        holder.mytext.setText(list.get(i).getTitle()+"\n"+list.get(i).getDetail());
        return view;
    }
    class ViewHolder{
        TextView mytext;
    }
}
