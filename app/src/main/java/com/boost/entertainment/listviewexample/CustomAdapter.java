package com.boost.entertainment.listviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by waqas on 23/09/2016.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    private int resourceId ;
    private int textViewResourceId ;
    public CustomAdapter(Context context, int resource, int nameTextViewResourceId, List<String> names) {
        super(context, resource, nameTextViewResourceId, names);
        resourceId = resource ;
        textViewResourceId = nameTextViewResourceId ;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String name = getItem(position);

        Log.i("tag",name);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(resourceId , parent , false);

            TextView nameTextView = (TextView) convertView.findViewById(textViewResourceId);
            nameTextView.setText(name);


        }
        return convertView;
    }
}
