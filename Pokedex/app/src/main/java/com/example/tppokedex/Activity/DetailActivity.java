package com.example.tppokedex.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.tppokedex.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class  DetailActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(listener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new DescriptionFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment seletedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_description:
                            seletedFragment = new DescriptionFragment();
                            break;
                        case R.id.nav_evolve:
                            seletedFragment = new EvolutionFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, seletedFragment).commit();
                    return true;
                }
            };
}