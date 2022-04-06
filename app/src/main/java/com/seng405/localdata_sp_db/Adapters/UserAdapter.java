package com.seng405.localdata_sp_db.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.seng405.localdata_sp_db.Activities.DisplayPersonActivity;
import com.seng405.localdata_sp_db.Activities.UserDetailActivity;
import com.seng405.localdata_sp_db.Entity.Person;
import com.seng405.localdata_sp_db.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<Person> personItemList;


    public UserAdapter( ArrayList<Person> personItemList) {
        this.personItemList = personItemList;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Person person = personItemList.get(position);
        holder.user_title_txt.setText(person.getName());
        holder.user_phone_number_txt.setText(person.getPhoneNumber());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayPersonActivity.class);
                intent.putExtra("person",person);
                v.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return personItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView user_title_txt;
        private TextView user_phone_number_txt;


        public ViewHolder(View v) {
            super(v);

            user_title_txt = v.findViewById(R.id.user_title_txt);
            user_phone_number_txt = v.findViewById(R.id.user_phone_number_txt);

        }
    }
}
