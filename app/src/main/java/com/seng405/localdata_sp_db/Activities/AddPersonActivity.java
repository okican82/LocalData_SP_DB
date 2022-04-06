package com.seng405.localdata_sp_db.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Person;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.seng405.localdata_sp_db.DB.DB;
import com.seng405.localdata_sp_db.R;
import com.seng405.localdata_sp_db.databinding.ActivityAddPersonBinding;

public class AddPersonActivity extends Activity {

    ActivityAddPersonBinding activityAddPersonBinding;
    private boolean noError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityAddPersonBinding = ActivityAddPersonBinding.inflate(getLayoutInflater());
        View view = activityAddPersonBinding.getRoot();
        setContentView(view);

        noError = true;

        activityAddPersonBinding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataToPhoneBook();
            }
        });


    }

    private void saveDataToPhoneBook() {
        //name_txt
        //surname_txt
        //phoneNumber_txt
        //company_txt
        //email_txt

        validateTextFields(activityAddPersonBinding.nameTxt);
        validateTextFields(activityAddPersonBinding.surnameTxt);
        validateTextFields(activityAddPersonBinding.phoneNumberTxt);
        validateTextFields(activityAddPersonBinding.companyTxt);
        validateTextFields(activityAddPersonBinding.emailTxt);



        if(noError)
        {

            com.seng405.localdata_sp_db.Entity.Person person = new com.seng405.localdata_sp_db.Entity.Person(
                    activityAddPersonBinding.nameTxt.getText().toString(),
                    activityAddPersonBinding.surnameTxt.getText().toString(),
                    0,
                    activityAddPersonBinding.phoneNumberTxt.getText().toString(),
                    activityAddPersonBinding.companyTxt.getText().toString(),
                    activityAddPersonBinding.emailTxt.getText().toString()
            );
            addUserToDB(person);
        }

    }

    private void validateTextFields(@NonNull EditText editText)
    {
        if(TextUtils.isEmpty(editText.getText().toString()))
        {
            noError = false;
            editText.setError(getResources().getString(R.string.error_message));
        }
    }

    private void addUserToDB(@NonNull com.seng405.localdata_sp_db.Entity.Person person)
    {
        DB db = DB.getInstance(this);
        db.addNewPerson(person.getName(),person.getSurname(),person.getPhoneNumber(),person.getCompany(),person.getEmail());
        finish();

    }
}