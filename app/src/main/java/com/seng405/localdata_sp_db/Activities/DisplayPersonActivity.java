package com.seng405.localdata_sp_db.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.seng405.localdata_sp_db.DB.DB;
import com.seng405.localdata_sp_db.Entity.Person;
import com.seng405.localdata_sp_db.R;
import com.seng405.localdata_sp_db.databinding.ActivityDisplayPersonBinding;
import com.seng405.localdata_sp_db.databinding.ActivityPhoneBookListBinding;

public class DisplayPersonActivity extends Activity {

    ActivityDisplayPersonBinding activityDisplayPersonBinding;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDisplayPersonBinding = ActivityDisplayPersonBinding.inflate(getLayoutInflater());
        View view = activityDisplayPersonBinding.getRoot();
        setContentView(view);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            person = getIntent().getExtras().getParcelable("person");

            activityDisplayPersonBinding.nameTxt.setText(person.getName());
            activityDisplayPersonBinding.surnameTxt.setText(person.getSurname());
            activityDisplayPersonBinding.phoneNumberTxt.setText(person.getPhoneNumber());
            activityDisplayPersonBinding.companyTxt.setText(person.getCompany());
            activityDisplayPersonBinding.emailTxt.setText(person.getEmail());



            activityDisplayPersonBinding.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteUser();
                }
            });

            activityDisplayPersonBinding.saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateUser();
                }
            });

        }
    }

    private void updateUser() {

        DB db = DB.getInstance(this);

        db.updatePerson(
                activityDisplayPersonBinding.nameTxt.getText().toString(),
                activityDisplayPersonBinding.surnameTxt.getText().toString(),
                person.getUserId(),
                activityDisplayPersonBinding.phoneNumberTxt.getText().toString(),
                activityDisplayPersonBinding.companyTxt.getText().toString(),
                activityDisplayPersonBinding.emailTxt.getText().toString()
        );

        finish();
    }

    private void deleteUser() {
        DB db = DB.getInstance(this);
        db.deletePerson(person.getUserId());

        finish();


    }
}