package com.example.hailtotheblue.sidneysmith_cs478_project2;

public class Cars {
    private String CarName;
    private int CarImg;

    public Cars(String name, int img)
    {
        this.CarName = name;
        this.CarImg = img;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public int getCarImg() {
        return CarImg;
    }

    public void setCarImg(int carImg) {
        CarImg = carImg;
    }
}
