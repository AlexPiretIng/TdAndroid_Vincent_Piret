package com.example.tppokedex.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Adapter.PokedexAdapter;
import com.example.tppokedex.Dao.PokeDatabase;
import com.example.tppokedex.R;
import com.example.tppokedex.Models.AllPokemon;
import com.example.tppokedex.Models.Pokemon;

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
    private ImageButton gen1;
    private ImageButton gen2;
    private ImageButton gen3;
    private ImageButton gen4;
    private ImageButton gen5;
    private ImageButton gen6;
    private ImageButton gen7;
    private ImageButton gen8;
    private PokeDatabase db;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        gen1 = (ImageButton)findViewById(R.id.gen1);
        gen2 = (ImageButton)findViewById(R.id.gen2);
        gen3 = (ImageButton)findViewById(R.id.gen3);
        gen4 = (ImageButton)findViewById(R.id.gen4);
        gen5 = (ImageButton)findViewById(R.id.gen5);
        gen6 = (ImageButton)findViewById(R.id.gen6);
        gen7 = (ImageButton)findViewById(R.id.gen7);
        gen8 = (ImageButton)findViewById(R.id.gen8);
        toolbar.setTitle("Première génération");

        db = Room.databaseBuilder(getApplicationContext(),
                PokeDatabase.class, "pokemon").allowMainThreadQueries().build();


        list = (ArrayList<Pokemon>)getIntent().getSerializableExtra("gen1");



        rvPoke = (RecyclerView)findViewById(R.id.rvPokemon);
        mPokedexAdapter = new PokedexAdapter( this);
        rvPoke.setAdapter(mPokedexAdapter);
        rvPoke.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        rvPoke.setLayoutManager(layoutManager);
        mPokedexAdapter.addPoke(list);

        gen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtenirPokemon(151,0);
                list = new ArrayList<Pokemon>(db.pokemonDao().getGen1());
                afficherGenPokemon(list);
                toolbar.setTitle("Première génération");
            }
        });
        gen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenirPokemon(251,151);
                //afficherGenPokemon(list);
                toolbar.setTitle("Deuxième génération");
            }
        });
        gen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenirPokemon(386,251);
                //afficherGenPokemon(list);
                toolbar.setTitle("Troisième génération");
            }
        });
        gen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenirPokemon(494,386);
                afficherGenPokemon(list);
                toolbar.setTitle("Quatrième génération");
            }
        });
        gen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenirPokemon(649,494);
                afficherGenPokemon(list);
                toolbar.setTitle("Cinquième génération");
            }
        });
        gen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenirPokemon(721,649);
                afficherGenPokemon(list);
                toolbar.setTitle("Sixième génération");
            }
        });
        gen7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenirPokemon(809,721);
                afficherGenPokemon(list);
                toolbar.setTitle("Septième génération");
            }
        });
        gen8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenirPokemon(898,809);
                afficherGenPokemon(list);
                toolbar.setTitle("Huitième génération");
            }
        });

    }

    private void obtenirPokemon(int limit, int offset) {
        PokemonService pokemonService = new Retrofit.Builder()
                .baseUrl(PokemonService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService.class);

        pokemonService.getPokemon(limit,offset).enqueue(new Callback<AllPokemon>() {
            @Override
            public void onResponse(Call<AllPokemon> call, Response<AllPokemon> response) {
                if (response.isSuccessful()){
                    AllPokemon pokemons = response.body();
                    list = pokemons.getResults();
                    rvPoke = (RecyclerView)findViewById(R.id.rvPokemon);
                    mPokedexAdapter = new PokedexAdapter( getApplicationContext());
                    rvPoke.setAdapter(mPokedexAdapter);
                    rvPoke.setHasFixedSize(true);
                    GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
                    rvPoke.setLayoutManager(layoutManager);
                    mPokedexAdapter.addPoke(list);
                    insert(list);
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

    private void afficherGenPokemon(ArrayList<Pokemon> listPoke){
        rvPoke = (RecyclerView)findViewById(R.id.rvPokemon);
        mPokedexAdapter = new PokedexAdapter( getApplicationContext());
        rvPoke.setAdapter(mPokedexAdapter);
        rvPoke.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        rvPoke.setLayoutManager(layoutManager);
        mPokedexAdapter.addPoke(listPoke);
    }
}