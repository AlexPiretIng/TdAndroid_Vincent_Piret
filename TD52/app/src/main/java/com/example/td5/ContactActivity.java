package com.example.td5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView)findViewById(R.id.rvContacts);

        contacts.add(new Contact("Jean","Pierre", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Jeanne","D'arc", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Pierre","Menez", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Arthur","Rimbaut", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Richard","Coeur de lion", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Zinedine","Zidane", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));
        contacts.add(new Contact("Yannick","Noah", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.tf1.fr%2Fdossier%2Fjean-pierre-pernaut&psig=AOvVaw2A8RMyzHcTWBNCKXyZ8hBl&ust=1603283776975000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKCO3dKXw-wCFQAAAAAdAAAAABAD"));

        ContactAdapter adapter = new ContactAdapter(contacts);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}