package com.mobile.geoapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LocationAdapter extends BaseAdapter {
    private List<String> data;
    private Activity owner;

    public LocationAdapter(List<String> data, Activity owner) {
        this.data = data;
        this.owner = owner;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView holder;

        if (convertView == null) {
            LayoutInflater inflater = owner.getLayoutInflater();
            convertView = inflater.inflate(R.layout.location_row, null);
            holder = (TextView) convertView.findViewById(R.id.locationName);
            convertView.setTag(holder);
        } else {
            holder = (TextView) convertView.getTag();
        }

        holder.setText(data.get(position));

        return convertView;
    }
}
