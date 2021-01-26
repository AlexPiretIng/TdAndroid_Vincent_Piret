package com.example.tppokedex.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Dao.PokeDatabase;
import com.example.tppokedex.Models.AllPokemon;
import com.example.tppokedex.Models.Pokemon;
import com.example.tppokedex.R;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadingScreen extends AppCompatActivity {

    private ArrayList<Pokemon> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        //AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        obtenirPokemon(151,0);
    }

    private void obtenirPokemon(int limit, int offset) {
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
                    list = pokemons.getResults();
                    insert(list);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("gen1", list);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<AllPokemon> call, Throwable t) {

            }
        });
    }

    private void insert(ArrayList<Pokemon> pokemons){
        PokeDatabase database = PokeDatabase.getInstance(this);
        for (int i = 0; i<pokemons.size(); i++){
            database.pokemonDao().insertOne(pokemons.get(i));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}