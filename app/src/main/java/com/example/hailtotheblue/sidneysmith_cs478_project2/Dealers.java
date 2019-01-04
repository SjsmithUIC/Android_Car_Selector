package com.example.hailtotheblue.sidneysmith_cs478_project2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Dealers implements Serializable {

    public class Dealer implements Serializable{
        String name;
        String location;

        public Dealer(String n, String l) {
            this.name = n;
            this.location = l;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    ArrayList<Dealer> AllDealers = new ArrayList<Dealer>();

    public void Dealers(){
    }

    public void add(String n, String L) {
        Dealer D = new Dealer(n,L);
        AllDealers.add(D);
    }

    public ArrayList<Dealer> getAllDealers() {
        return AllDealers;
    }
}
