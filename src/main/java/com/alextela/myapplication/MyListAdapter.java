package com.alextela.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> list1;
    private final ArrayList<String> list2;

    public MyListAdapter(Activity context, ArrayList<String> list1, ArrayList<String> list2) {
        super(context, R.layout.mylist, list1);

        this.context = context;
        this.list1 = list1;
        this.list2 = list2;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null,true);
        TextView textView = (TextView)rowView.findViewById(R.id.textView);
        TextView textView2 = (TextView)rowView.findViewById(R.id.textView2);

        textView.setText(list1.get(position));
        textView2.setText(list2.get(position));

        return rowView;
    }
}
