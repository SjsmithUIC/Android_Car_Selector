package com.example.hailtotheblue.sidneysmith_cs478_project2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.view.ContextMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    String[] CarNames={"Audi", "BMW", "Range Rover", "Charger", "Camaro", "Subaru WRX", "Jetta", "Camry"};

    int[] CarImages={R.drawable.audi1, R.drawable.bmw1, R.drawable.range_rover1, R.drawable.charger1,
                     R.drawable.camero1, R.drawable.subaru_wrx1, R.drawable.jetta1, R.drawable.camry1};

    int[] BigCarImages = {R.drawable.audi, R.drawable.bmw, R.drawable.range_rover, R.drawable.charger,
                          R.drawable.camero, R.drawable.subaru_wrx, R.drawable.jetta, R.drawable.camry};

    String[] CarURL = {"https://www.audiusa.com/models/audi-a8/2019",
                       "https://www.bmwusa.com/vehicles/3-series.html",
                       "https://www.landroverusa.com/vehicles/range-rover-evoque/index.html",
                       "https://www.dodge.com/charger.html",
                       "https://www.chevrolet.com/performance/camaro-sports-car",
                       "https://www.subaru.com/vehicles/wrx/index.html",
                       "https://www.vw.com/models/jetta/section/masthead/",
                       "https://www.toyota.com/camry/"};


    Dealers audiDealers = new Dealers();
    Dealers bmwDealers = new Dealers();
    Dealers rangeRoverDealers = new Dealers();
    Dealers dogeDealers = new Dealers();
    Dealers chevyDealers = new Dealers();
    Dealers subaruDealers = new Dealers();
    Dealers volkswagenDealers = new Dealers();
    Dealers toyotaDealers = new Dealers();

    Dealers[] AllDealers = {audiDealers, bmwDealers, rangeRoverDealers, dogeDealers, chevyDealers,
                            subaruDealers, volkswagenDealers, toyotaDealers};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridview);
        GridAdapter addp = new GridAdapter(this, GetCars());
        gridView.setAdapter(addp);

        registerForContextMenu(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ShowCar.class);

                intent.putExtra("car", BigCarImages[position]);
                intent.putExtra("CarUrl", CarURL[position]);
                startActivity(intent);
            }
        });

        PopulateDealers();
    }

    private void PopulateDealers() {
        audiDealers.add("Fletcher Jones Audi", "1523 W North Ave, Chicago, IL 60642");
        audiDealers.add("Audi Morton Grove", "7000 Golf Rd, Morton Grove, IL 60053");
        audiDealers.add("Audi Westmont", "276 E Ogden Ave, Westmont, IL 60559");

        bmwDealers.add("Perillo BMW","1035 N Clark St, Chicago, IL 60610");
        bmwDealers.add("Elmhurst BMW", "466 W Lake St, Elmhurst, IL 60126");
        bmwDealers.add("Patrick BMW", "700 E Golf Rd, Schaumburg, IL 60173");

        rangeRoverDealers.add("Land Rover Chicago", "1924 N Paulina St, Chicago, IL 60622");
        rangeRoverDealers.add("Land Rover Hinsdale", "300 E Ogden Ave, Hinsdale, IL 60521");
        rangeRoverDealers.add("Land Rover Orland Park", "8031 W 159th St, Tinley Park, IL 60477");

        dogeDealers.add("Midway Dodge", "4747 S Pulaski Rd, Chicago, IL 60632");
        dogeDealers.add("South Chicago Dodge Chrysler Jeep", "7340 S Western Ave, Chicago, IL 60636");
        dogeDealers.add("Napleton's Northwestern Chrysler Jeep Dodge Ram", "5950 N Western Ave, Chicago, IL 60659");

        chevyDealers.add("Rogers Chevrolet", "2720 S Michigan Ave, Chicago, IL 60616");
        chevyDealers.add("Kingdom Chevy", "6603 S Western Ave, Chicago, IL 60636");
        chevyDealers.add("Mike Anderson Chevrolet of Chicago", "5333 W Irving Park Rd, Chicago, IL 60641");

        subaruDealers.add("Berman Subaru of Chicago", "4330 W Irving Park Rd, Chicago, IL 60641");
        subaruDealers.add("Evanston Subaru in Skokie", "3340 Oakton St, Skokie, IL 60076");
        subaruDealers.add("The Autobarn Subaru of Countryside", "6191 Joliet Rd, Countryside, IL 60525");

        volkswagenDealers.add("Volkswagen of Downtown Chicago", "1111 N Clark St, Chicago, IL 60610");
        volkswagenDealers.add("The Autobarn City Volkswagen", "5330 W Irving Park Rd, Chicago, IL 60641");
        volkswagenDealers.add("Fletcher Jones Volkswagen", "1111 N Clark St, Chicago, IL 60610");

        toyotaDealers.add("Grossinger City Toyota", "1561 N Fremont St, Chicago, IL 60642");
        toyotaDealers.add("Chicago Northside Toyota", "6042 N Western Ave, Chicago, IL 60659");
        toyotaDealers.add("Toyota On Western", "6941 S Western Ave, Chicago, IL 60636");
    }

    private ArrayList<Cars> GetCars(){
        ArrayList<Cars> C = new ArrayList<Cars>();

        for (int i = 0; i < CarNames.length; i++) {
            C.add(new Cars(CarNames[i], CarImages[i]));
        }

        return C;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId() == (R.id.LargePicture)){

            Intent intent = new Intent(MainActivity.this,ShowCar.class);

            intent.putExtra("car", BigCarImages[info.position]);
            intent.putExtra("CarUrl", CarURL[info.position]);
            startActivity(intent);

            return true;
        }

        else if(item.getItemId() == (R.id.Website)){

            Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(CarURL[info.position]));
            startActivity(BrowserIntent);

            return true;
        }

        else if(item.getItemId() == (R.id.Dealers)){

            Intent DealerIntent = new Intent(MainActivity.this, ShowDealers.class);

            DealerIntent.putExtra("Dealers", AllDealers[info.position]);
            startActivity(DealerIntent);

            return true;
        }

        return super.onContextItemSelected(item);
    }
}
