package com.example.tppokedex.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Models.AllPokemon;
import com.example.tppokedex.Models.DetailsPoke;
import com.example.tppokedex.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  DetailActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    final Fragment fragment1 = new DescriptionFragment();
    final Fragment fragment2 = new EvolutionFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
    private String first_type;
    private String second_type;
    Map<String, String> mapType;
    private TextView number;
    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(listener);

        Bundle pokeIntent = getIntent().getExtras();
        String pokeName = pokeIntent.getString("pokemon");

        pokeDetail(pokeName);

        makeMapType();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment seletedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_description:
                            fm.beginTransaction().hide(active).show(fragment1).commit();
                            active=fragment1;
                            return true;
                        case R.id.nav_evolve:
                            fm.beginTransaction().hide(active).show(fragment2).commit();
                            active=fragment2;
                            return true;
                    }
                    return false;
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

                    first_type = detailsPoke.getType().get(0).getType().getName();
                    if (detailsPoke.getType().size() == 1){
                        first_type = detailsPoke.getType().get(0).getType().getName();
                    }
                    if (detailsPoke.getType().size() > 1){
                        first_type = detailsPoke.getType().get(0).getType().getName();
                        second_type = detailsPoke.getType().get(1).getType().getName();
                    }

                    bottomNav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
                    bottomNav.setBackgroundColor(Color.parseColor(mapType.get(first_type)));
                    String id = detailsPoke.getId();
                    if (String.valueOf(id).length() == 1){
                        newId = "#00" + id;
                    }else if (String.valueOf(id).length() == 2){
                        newId = "#0" + id;
                    }else if (String.valueOf(id).length() == 3){
                        newId = "#" + id;
                    }else{
                        newId = "#" + id;
                    }

                    Bundle bundle = new Bundle();
                    bundle.putString("id", detailsPoke.getName());
                    bundle.putString("type", first_type);
                    bundle.putString("type2", second_type);
                    bundle.putString("number", detailsPoke.getId());

                    fragment1.setArguments(bundle);
                    fragment2.setArguments(bundle);
                    fm.beginTransaction().add(R.id.fragment_content, fragment1).commit();
                    fm.beginTransaction().add(R.id.fragment_content, fragment2, "2").hide(fragment2).commit();
                }
            }

            @Override
            public void onFailure(Call<DetailsPoke> call, Throwable t) {

            }
        });
    }
    private void makeMapType() {
        mapType = new HashMap<String, String>();

        mapType.put("bug", "#A8B820");
        mapType.put("dragon", "#7038F8");
        mapType.put("ice", "#98D8D8");
        mapType.put("fire", "#F08030");
        mapType.put("water", "#6890F0");
        mapType.put("grass", "#78C850");
        mapType.put("fighting", "#C03028");
        mapType.put("flying", "#A890F0");
        mapType.put("ghost", "#705898");
        mapType.put("ground", "#E0C068");
        mapType.put("rock", "#B8A038");
        mapType.put("psychic", "#F85888");
        mapType.put("poison", "#A040A0");
        mapType.put("normal", "#A8A878");
        mapType.put("electric", "#F8D030");
    }
}