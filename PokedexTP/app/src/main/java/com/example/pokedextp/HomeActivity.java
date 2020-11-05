package com.example.pokedextp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        rvPoke = (RecyclerView)findViewById(R.id.rvPokemon);
        mPokedexAdapter = new PokedexAdapter();
        rvPoke.setAdapter(mPokedexAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        rvPoke.setLayoutManager(layoutManager);

       retrofit = new Retrofit.Builder()
                            .baseUrl(PokeAPI.URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        obtenirPokemon();
    }

    private void obtenirPokemon() {
        PokeAPI service = retrofit.create(PokeAPI.class);
        Call<PokemonRequest> pokemonRequestCall = service.getPokemonNameAndPic();

        pokemonRequestCall.enqueue(new Callback<PokemonRequest>() {
            @Override
            public void onResponse(Call<PokemonRequest> call, Response<PokemonRequest> response) {
                if (response.isSuccessful()){
                    PokemonRequest pokemonRequest = response.body();
                    ArrayList<Pokemon> listPokemon = pokemonRequest.getResults();

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