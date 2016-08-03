package com.example.mayur.adgapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AboutUsAdapter extends ArrayAdapter {

    List list=new ArrayList();

    public AboutUsAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler{

        TextView title;
        TextView msg;
        ImageView imageView;

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View customView =view;
        DataHandler handler;
        if(view==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            customView= layoutInflater.inflate(R.layout.home_row_layout,viewGroup,false);
            handler=new DataHandler();

            handler.imageView= (ImageView) customView.findViewById(R.id.event_row_image);
            handler.title= (TextView) customView.findViewById(R.id.event_row_title);
            handler.msg= (TextView) customView.findViewById(R.id.event_row_msg);
            customView.setTag(handler);

        }

        else{
            handler= (DataHandler) customView.getTag();
        }

        AboutUsModel model;
        model=(AboutUsModel) this.getItem(i);
        handler.title.setText(model.getTitle());
        handler.msg.setText(model.getMsg());
        handler.imageView.setImageResource(model.getImg());


        return customView;

    }
}
