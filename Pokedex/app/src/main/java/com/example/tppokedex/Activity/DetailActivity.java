package com.example.tppokedex.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Models.AllPokemon;
import com.example.tppokedex.Models.DetailsPoke;
import com.example.tppokedex.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  DetailActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(listener);

        Bundle pokeIntent = getIntent().getExtras();
        String pokeName = pokeIntent.getString("pokemon");
        Log.d("poke", pokeName);


        Bundle bundle = new Bundle();
        bundle.putString("poke", pokeName);
        DescriptionFragment descriptionFragment = new DescriptionFragment();
        descriptionFragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_content, descriptionFragment);
        transaction.commit();

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, new DescriptionFragment()).commit();
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

    private void pokeDetail(String id) {
        PokemonService pokemonService = new Retrofit.Builder()
                .baseUrl(PokemonService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService.class);

        pokemonService.getPokemonById(id).enqueue(new Callback<DetailsPoke>() {
            @Override
            public void onResponse(Call<DetailsPoke> call, Response<DetailsPoke> response) {
                if (response.isSuccessful()){
                    DetailsPoke detailsPoke = response.body();
                    Log.d("check", detailsPoke.getName());
                    Log.d("check", String.valueOf(detailsPoke.getId()));
                }
            }

            @Override
            public void onFailure(Call<DetailsPoke> call, Throwable t) {

            }
        });
    }
}