package com.example.td5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final List<Contact> mContat;

    public ContactAdapter(List<Contact> mContat) {
        this.mContat = mContat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView firstNameTextView;
        public TextView lastNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstNameTextView = (TextView)itemView.findViewById(R.id.firstname);
            lastNameTextView = (TextView)itemView.findViewById(R.id.lastname);
        }
    }
}
