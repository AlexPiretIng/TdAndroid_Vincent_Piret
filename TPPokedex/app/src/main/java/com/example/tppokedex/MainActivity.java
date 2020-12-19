package com.example.tppokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.models.AllPokemon;
import com.example.tppokedex.models.Pokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Pokedex";

    private RecyclerView rvPoke;
    private PokedexAdapter mPokedexAdapter;

    Retrofit retrofit;

    public static Context context;

    private int offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        retrofit = new Retrofit.Builder()
                .baseUrl(PokemonService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        offset = 0;

        obtenirPokemon();

        rvPoke = (RecyclerView)findViewById(R.id.rvPokemon);
        mPokedexAdapter = new PokedexAdapter();
        rvPoke.setAdapter(mPokedexAdapter);
        rvPoke.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        rvPoke.setLayoutManager(layoutManager);
    }

    private void obtenirPokemon() {
        PokemonService pokemonService = new Retrofit.Builder()
                .baseUrl(PokemonService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService.class);

        pokemonService.getPokemon(9,0).enqueue(new Callback<AllPokemon>() {
            @Override
            public void onResponse(Call<AllPokemon> call, Response<AllPokemon> response) {
                if (response.isSuccessful()){
                    AllPokemon pokemons = response.body();
                    ArrayList<Pokemon> listPoke = pokemons.getResults();
                    mPokedexAdapter.addPoke(listPoke);
                }
            }

            @Override
            public void onFailure(Call<AllPokemon> call, Throwable t) {

            }
        });
    }
}