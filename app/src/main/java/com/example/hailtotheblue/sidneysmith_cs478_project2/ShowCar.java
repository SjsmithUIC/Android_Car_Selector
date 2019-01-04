package com.example.hailtotheblue.sidneysmith_cs478_project2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ShowCar extends AppCompatActivity {

    Intent caller;
    int CarPic;
    ImageView CarImg;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_car);

        CarImg = findViewById(R.id.CarBack);

        caller = getIntent();
        CarPic = caller.getIntExtra("car",0);
        URL = caller.getStringExtra("CarUrl");

        CarImg.setImageResource(CarPic);

        CarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                startActivity(BrowserIntent);
            }
        });
    }
}
