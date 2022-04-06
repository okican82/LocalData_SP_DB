package com.seng405.localdata_sp_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.view.View;

import com.seng405.localdata_sp_db.databinding.ActivityListViewBinding;
import com.seng405.localdata_sp_db.databinding.ActivitySharedPreferencesBinding;

import java.util.HashSet;
import java.util.Set;

public class SharedPreferencesActivity extends Activity {

    ActivitySharedPreferencesBinding activitySharedPreferencesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activitySharedPreferencesBinding = ActivitySharedPreferencesBinding.inflate(getLayoutInflater());
        View view = activitySharedPreferencesBinding.getRoot();
        setContentView(view);

        activitySharedPreferencesBinding.setDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData(activitySharedPreferencesBinding.inputEditText.getText().toString());
            }
        });

        activitySharedPreferencesBinding.getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDataToTextView();
            }
        });
    }

    private void displayDataToTextView() {
        String data = getData();
        activitySharedPreferencesBinding.ResultTextView.setText(data);

    }

    private void setData(String data) {
        String CONST_DATA = "LANGUAGE";
        SharedPreferences preferences = this.getSharedPreferences(CONST_DATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONST_DATA,String.valueOf(data));
        editor.apply();

    }

    private String getData() {
        String result = "";

        String CONST_DATA = "LANGUAGE";
        SharedPreferences preferences = this.getSharedPreferences(CONST_DATA, Context.MODE_PRIVATE);

        result = preferences.getString(CONST_DATA, "");

        return result;
    }



}