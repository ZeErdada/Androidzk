package com.example.maohuawei.work;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {

    private Context context;
    private List<RootBean.NewslistEntity.NewsEntity> list;

    public MyBaseAdapter(Context context, List<RootBean.NewslistEntity.NewsEntity> list) {
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

        ViewHolder holder = null;

        if (view == null) {

            holder = new ViewHolder();

            view = view.inflate(context, R.layout.item, null);

            holder.image_view_item = view.findViewById(R.id.image_view_item);

            holder.tv_title_item = view.findViewById(R.id.tv_title_item);

            holder.tv_content = view.findViewById(R.id.tv_content);

            holder.tv_number = view.findViewById(R.id.tv_number);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }


        holder.tv_title_item.setText(list.get(i).getTitle());

        holder.tv_content.setText(list.get(i).getDetail());

        holder.tv_number.setText(list.get(i).getComment());

        ImageLoaderUtils.setImageView(list.get(i).getImage(), context, holder.image_view_item);

        return view;
    }

    static class ViewHolder {
        TextView tv_title_item, tv_content, tv_number;
        ImageView image_view_item;

    }
}
