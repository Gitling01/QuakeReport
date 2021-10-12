package com.example.quakereport;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import android.graphics.drawable.GradientDrawable;

import androidx.core.content.ContextCompat;

public class EarthquakeAdapter extends BaseAdapter {
//context, data source and a string separator for the getView method
    private Context mContext;
    private ArrayList<Earthquake> mEarthquakes;
    private static final String LOCATION_SEPARATOR = " of ";

    //constructor
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes){
        this.mContext = context;
        this.mEarthquakes = earthquakes;
    }

    @Override
    public int getCount() {
//returns the number of items in the array
        return mEarthquakes.size();
    }

    @Override
    public Object getItem(int position) {
        //retrieves the item at the given position in the array
        return mEarthquakes.get(position);
    }

    @Override
    public long getItemId(int position) {
//*Bookmark
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflates the layout for each list row

        View listItemView = convertView;
        if (listItemView == null){
    listItemView = LayoutInflater.from(mContext).inflate(R.layout.single_earthquake_line, parent, false);
        }

        //gets the current item to be displayed
        Earthquake currentEarthquake = (Earthquake) getItem(position);

        //creates objects for the specific views for the items (textview...etc)
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location_text_view);
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset_text_view);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);

        //sets the specific views with the information in the array & formats date and time


       Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
       String formattedDate = formatDate(dateObject);
       String formattedTime = formatTime(dateObject);
        dateTextView.setText(formattedDate);
        timeTextView.setText(formattedTime);

       String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
       magnitudeTextView.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String currentLocation = currentEarthquake.getLocation();
        String locationOffset;
        String primaryLocation;

        if (currentLocation.contains(LOCATION_SEPARATOR)){

            int splitIndex = currentLocation.indexOf(LOCATION_SEPARATOR);
            locationOffset = currentLocation.substring(0,splitIndex) + LOCATION_SEPARATOR;
            primaryLocation = currentLocation.substring(splitIndex+LOCATION_SEPARATOR.length());
        }
        else{
            ///*FLAG* temporarily hardcoded "near the" below, because of issues with getString()
            locationOffset = "Near the";
            primaryLocation = currentLocation;
        }

        locationOffsetTextView.setText(locationOffset);
        primaryLocationTextView.setText(primaryLocation);

        //returns the view for the current row
        return listItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double originalMagnitude){
        DecimalFormat formatMagnitude = new DecimalFormat("0.0");
        return formatMagnitude.format(originalMagnitude);
    }

    /**
     * FLAG - PLACEHOLDER CODE WHICH IS ONLY SHOWING SOME CASES AND SETTING EVERYTHING ABOVE 4
     * TO THE "TEN PLUS" COLOR
     */
    private int getMagnitudeColor(double originalMagnitude){

        int magnitudeColor;

        if(originalMagnitude > 0 && originalMagnitude < 2) {
            magnitudeColor = ContextCompat.getColor(mContext, R.color.magnitude1);
        }
        else if (originalMagnitude >= 2 && originalMagnitude < 3) {
           magnitudeColor = ContextCompat.getColor(mContext, R.color.magnitude2);
        }
         else if (originalMagnitude >= 3 && originalMagnitude < 4) {
             magnitudeColor = ContextCompat.getColor(mContext, R.color.magnitude3);
         }
         else {
             magnitudeColor = ContextCompat.getColor(mContext, R.color.magnitude10plus);
         }
         return magnitudeColor;
    }

    /**
     * END OF FLAGGED SECTION
     */

}
