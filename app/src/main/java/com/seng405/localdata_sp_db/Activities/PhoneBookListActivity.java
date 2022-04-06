package com.seng405.localdata_sp_db.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.seng405.localdata_sp_db.Adapters.UserAdapter;
import com.seng405.localdata_sp_db.DB.DB;
import com.seng405.localdata_sp_db.Entity.Person;
import com.seng405.localdata_sp_db.databinding.ActivityListViewBinding;
import com.seng405.localdata_sp_db.databinding.ActivityPhoneBookListBinding;

import java.util.ArrayList;

public class PhoneBookListActivity extends AppCompatActivity {

    ActivityPhoneBookListBinding activityPhoneBookListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityPhoneBookListBinding = ActivityPhoneBookListBinding.inflate(getLayoutInflater());
        View view = activityPhoneBookListBinding.getRoot();
        setContentView(view);


        ArrayList<Person> personArrayList = DB.getInstance(this).getPersonList();


        UserAdapter adapter = new UserAdapter(personArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        activityPhoneBookListBinding.userList.setLayoutManager(mLayoutManager);
        activityPhoneBookListBinding.userList.setAdapter(adapter);


        activityPhoneBookListBinding.addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PhoneBookListActivity.this,AddPersonActivity.class));
            }
        });


    }
}