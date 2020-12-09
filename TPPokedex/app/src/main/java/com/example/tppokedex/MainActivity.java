package com.example.tppokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tppokedex.API.PokemonService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private PokedexAdapter mPokedexAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.rvPokemon);
        mPokedexAdapter = new PokedexAdapter();
        mRecyclerView.setAdapter(mPokedexAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(layoutManager);

        obtenirPokemon(20,0);
    }

    public void obtenirPokemon(int limit, int offset){
        PokemonService pokedex = new Retrofit.Builder()
                .baseUrl(PokemonService.ENDPOINT_POKEMON)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService.class);

        pokedex.getAllPokemon(limit,offset).enqueue(new Callback<AllPokemon>() {
            @Override
            public void onResponse(Call<AllPokemon> call, Response<AllPokemon> response) {
                AllPokemon pokemonRequest = response.body();
                ArrayList<Pokemon> listPokemon = pokemonRequest.getResults();
                mPokedexAdapter.addPoke(listPokemon);
            }

            @Override
            public void onFailure(Call<AllPokemon> call, Throwable t) {

            }
        });
    }
}