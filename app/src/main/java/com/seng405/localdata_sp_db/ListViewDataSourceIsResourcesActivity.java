package com.seng405.localdata_sp_db;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.seng405.localdata_sp_db.databinding.ActivityListViewBinding;
import com.seng405.localdata_sp_db.databinding.ActivityListViewDataSourceIsResourcesBinding;

import java.util.ArrayList;

public class ListViewDataSourceIsResourcesActivity extends Activity {

    ActivityListViewDataSourceIsResourcesBinding activityListViewDataSourceIsResourcesBinding;

    private ListView simpleListView;
    private ArrayAdapter<String> simpleListAdapter;
    private ArrayList<String> simpleListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityListViewDataSourceIsResourcesBinding = ActivityListViewDataSourceIsResourcesBinding.inflate(getLayoutInflater());
        View view = activityListViewDataSourceIsResourcesBinding.getRoot();
        setContentView(view);

        simpleListView = activityListViewDataSourceIsResourcesBinding.simpleListView;

        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.planets_array);


        simpleListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planets);

        simpleListView.setAdapter(simpleListAdapter);

    }
}