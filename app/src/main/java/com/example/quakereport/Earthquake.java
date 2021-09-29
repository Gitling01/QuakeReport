package com.example.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private String mDate;

    //constructor
    public Earthquake(double magnitude, String location, String date) {

        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mDate = date;
    }

    //get
    public double getMagnitude()
    {
        return mMagnitude;
    }

    public String getLocation()
    {
        return mLocation;
    }

   public String getDate(){ return mDate; }


    //set
    public void setMagnitude(double mag)
    {
        this.mMagnitude = mag;

    }

    public void setLocation(String location)
    {
      this.mLocation = location;
    }

    public void setDate(String date)
    {
        this.mDate = date;
    }

}
