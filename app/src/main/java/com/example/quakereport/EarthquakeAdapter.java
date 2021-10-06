package com.example.quakereport;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends BaseAdapter {
//context and data source
    private Context mContext;
    private ArrayList<Earthquake> mEarthquakes;

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
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);

        //sets the specific views with the information in the array & formats date and time


       Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
       String formattedDate = formatDate(dateObject);
       String formattedTime = formatTime(dateObject);

        magnitudeTextView.setText(String.valueOf(currentEarthquake.getMagnitude()) );
        locationTextView.setText(currentEarthquake.getLocation());
        dateTextView.setText(formattedDate);
        timeTextView.setText(formattedTime);

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

}
