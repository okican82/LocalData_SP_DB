package com.seng405.localdata_sp_db;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.seng405.localdata_sp_db.databinding.ActivityListViewBinding;

import java.util.ArrayList;

public class ListViewActivity extends Activity {

    private ListView simpleListView;
    private ArrayAdapter<String> simpleListAdapter;
    private ArrayList<String> simpleListArrayList;

    ActivityListViewBinding activityListViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityListViewBinding = ActivityListViewBinding.inflate(getLayoutInflater());
        View view = activityListViewBinding.getRoot();
        setContentView(view);

        simpleListView = activityListViewBinding.simpleListView;

        simpleListArrayList = new ArrayList<String>();

        simpleListArrayList.add("Mercury");
        simpleListArrayList.add("Venus");
        simpleListArrayList.add("Earth");
        simpleListArrayList.add("Mars");

        simpleListAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, simpleListArrayList);

        simpleListView.setAdapter(simpleListAdapter);





    }
}