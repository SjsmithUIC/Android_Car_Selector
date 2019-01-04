package com.example.hailtotheblue.sidneysmith_cs478_project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class DealerListAddapter extends BaseAdapter {

    Dealers De;
    Context Curr;

    public DealerListAddapter(Context C, Dealers D)
    {
        this.De = D;
        this.Curr = C;
    }

    @Override
    public int getCount() {
        return De.getAllDealers().size();
    }

    @Override
    public Object getItem(int position) {
        return De.getAllDealers().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) Curr.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.single_row, parent, false);
        }

        TextView Name = (TextView) convertView.findViewById(R.id.dealerName);
        TextView Loc = (TextView) convertView.findViewById(R.id.dealearLocation);

        Name.setText("Name: " + (De.getAllDealers().get(position).getName()));
        Loc.setText("Location: " + (De.getAllDealers().get(position).getLocation()));

        return convertView;
    }
}
