package com.example.pokedextp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.pokedextp.api.PokeAPI;
import com.example.pokedextp.models.Pokemon;
import com.example.pokedextp.models.PokemonRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "Pokedex";

    private RecyclerView rvPoke;
    private PokedexAdapter mPokedexAdapter;

    Retrofit retrofit;

    public static Context context;

    private int offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        context = getApplicationContext();

       retrofit = new Retrofit.Builder()
                            .baseUrl(PokeAPI.URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

       offset = 0;

        obtenirPokemon(offset);

        rvPoke = (RecyclerView)findViewById(R.id.rvPokemon);
        mPokedexAdapter = new PokedexAdapter();
        rvPoke.setAdapter(mPokedexAdapter);
        rvPoke.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        rvPoke.setLayoutManager(layoutManager);
    }

    private void obtenirPokemon(int offset) {
        PokeAPI service = retrofit.create(PokeAPI.class);
        Call<PokemonRequest> pokemonRequestCall = service.getPokemon(151, 0);

        pokemonRequestCall.enqueue(new Callback<PokemonRequest>() {
            @Override
            public void onResponse(Call<PokemonRequest> call, Response<PokemonRequest> response) {
                if (response.isSuccessful()){
                    PokemonRequest pokemonRequest = response.body();
                    ArrayList<Pokemon> listPokemon = pokemonRequest.getResults();
                    mPokedexAdapter.addPoke(listPokemon);
                }else {
                    Log.e(TAG,"on Response" + response.body());
                }
            }

            @Override
            public void onFailure(Call<PokemonRequest> call, Throwable t) {

            }
        });
    }
}