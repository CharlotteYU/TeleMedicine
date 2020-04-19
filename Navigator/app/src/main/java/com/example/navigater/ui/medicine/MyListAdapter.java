package com.example.navigater.ui.medicine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.navigater.R;

public class MyListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    MyListAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        //public ImageView imageView;
        public TextView tvTitle,tvTime, tvContent;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            //holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tvContent = (TextView)convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("Here is title");
        holder.tvTime.setText("2020-04-18");
        holder.tvContent.setText("Here is diagnosis");
        return null;
    }
}
