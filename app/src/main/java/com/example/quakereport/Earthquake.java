package com.example.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    /** Constructs a new Earthquake object.
     * @param magnitude is the magnitude of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (1/1/70)
     *  that the earthquake occurred
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds) {

        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
    }

    /** Returns the magnitude of the earthquake */


    public double getMagnitude()
    {
        return mMagnitude;
    }

    /** Returns the city where the earthquake happened */


    public String getLocation()
    {
        return mLocation;
    }

    /** Returns the time of the earthquake */

   public long getTimeInMilliseconds()
   {
       return mTimeInMilliseconds;
   }


    //setter methods follow

    public void setMagnitude(double mag)
    {
        this.mMagnitude = mag;

    }


    public void setLocation(String location)
    {
      this.mLocation = location;
    }


  //  public void setDate(long timeInMilliseconds) { this.mTimeInMilliseconds = timeInMilliseconds; }

}
