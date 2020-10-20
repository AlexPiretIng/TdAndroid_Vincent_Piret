package com.example.td5;

import android.content.Context;
import android.view.LayoutInflater;
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
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContat.get(position);

        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getPrenom());

        TextView lastNameTextView = holder.lastNameTextView;
        lastNameTextView.setText(contact.getNom());
    }

    @Override
    public int getItemCount() {
        return mContat.size();
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
