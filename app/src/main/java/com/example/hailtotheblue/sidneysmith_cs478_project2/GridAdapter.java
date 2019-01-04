package com.example.hailtotheblue.sidneysmith_cs478_project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter{

    Context currContext;
    ArrayList<Cars> currCars;

    public GridAdapter(Context Curr, ArrayList<Cars> cars) {
        this.currContext = Curr;
        this.currCars = cars;
    }

    @Override
    public int getCount() {
        return currCars.size();
    }

    @Override
    public Object getItem(int position) {
        return currCars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) currContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.single_cell, parent, false);
        }

        ImageView img = (ImageView) convertView.findViewById(R.id.Image1);
        TextView text = (TextView) convertView.findViewById(R.id.Text1);

        img.setImageResource(currCars.get(position).getCarImg());
        text.setText(currCars.get(position).getCarName());

        return convertView;
    }
}
