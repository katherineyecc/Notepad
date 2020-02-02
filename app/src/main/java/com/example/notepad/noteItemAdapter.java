package com.example.notepad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class noteItemAdapter extends BaseAdapter {

    private LinkedList<noteItem> mData;
    private Context mContext;

    public noteItemAdapter(LinkedList<noteItem> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.note_item_list, parent, false);
        TextView note_id = (TextView) convertView.findViewById(R.id.note_id);
        TextView note_title = (TextView) convertView.findViewById(R.id.note_title);
        note_id.setText(mData.get(position).getID());
        note_title.setText(mData.get(position).getTitle());
        return convertView;
    }
}
