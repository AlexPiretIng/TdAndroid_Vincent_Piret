package com.example.tppokedex.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Adapter.PokedexAdapter;
import com.example.tppokedex.R;
import com.example.tppokedex.Models.AllPokemon;
import com.example.tppokedex.Models.Pokemon;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPoke;
    private PokedexAdapter mPokedexAdapter;
    private ArrayList<Pokemon> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Première génération");

        list = (ArrayList<Pokemon>)getIntent().getSerializableExtra("gen1");

        rvPoke = (RecyclerView)findViewById(R.id.rvPokemon);
        mPokedexAdapter = new PokedexAdapter( this);
        rvPoke.setAdapter(mPokedexAdapter);
        rvPoke.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        rvPoke.setLayoutManager(layoutManager);
        mPokedexAdapter.addPoke(list);
    }

/*    private void obtenirPokemon(int limit, int offset) {
        PokemonService pokemonService = new Retrofit.Builder()
                .baseUrl(PokemonService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService.class);

        pokemonService.getPokemon(limit, offset).enqueue(new Callback<AllPokemon>() {
            @Override
            public void onResponse(Call<AllPokemon> call, Response<AllPokemon> response) {
                if (response.isSuccessful()){
                    AllPokemon pokemons = response.body();
                }
            }

            @Override
            public void onFailure(Call<AllPokemon> call, Throwable t) {

            }
        });
    }*/
}