package com.example.hailtotheblue.sidneysmith_cs478_project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowDealers extends AppCompatActivity {

    ListView DList;
    Dealers Deal;
    Intent caller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dealers);
        DList = findViewById(R.id.DealerList);

        caller = this.getIntent();
        Deal = (Dealers) caller.getSerializableExtra("Dealers");



        DealerListAddapter LAddap = new DealerListAddapter(this, Deal);
        DList.setAdapter(LAddap);
    }
}
