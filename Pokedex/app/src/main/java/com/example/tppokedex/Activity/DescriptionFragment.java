package com.example.tppokedex.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.L;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tppokedex.API.EvolutionService;
import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Models.DetailsPoke;
import com.example.tppokedex.Models.EvolutionPokemon;
import com.example.tppokedex.Models.FlavorTextEntries;
import com.example.tppokedex.Models.PokemonType;
import com.example.tppokedex.Models.Type;
import com.example.tppokedex.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DescriptionFragment extends Fragment {

    private TextView name;
    private ImageView img;
    private TextView number;
    private TextView height;
    private TextView weight;
    private TextView type1;
    private TextView type2;
    private ImageView back;
    Map<String, String> mapType;
    private String first_type;
    private String second_type;
    private TextView desc;
    private String newId;
    private BottomNavigationView bottom;

    public DescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        makeMapType();

        View view = inflater.inflate(R.layout.fragment_description, container, false);
        String id = this.getArguments().getString("id");
        //pokeDetail(id);
        String type = this.getArguments().getString("type");
        String index = this.getArguments().getString("number");
        String second_type = this.getArguments().getString("type2");
        String poids = this.getArguments().getString("weight");
        String taille = this.getArguments().getString("height");

        poids = poids + " kg";
        taille = taille + " m";

        name = (TextView)view.findViewById(R.id.name);
        back =(ImageView)view.findViewById(R.id.header);
        type1 = (TextView)view.findViewById(R.id.type1);
        type2 = (TextView)view.findViewById(R.id.type2);
        number = (TextView)view.findViewById(R.id.index);
        img = (ImageView)view.findViewById(R.id.myPoke_img);
        weight = (TextView)view.findViewById(R.id.weight);
        height = (TextView)view.findViewById(R.id.taille);
        desc = (TextView)view.findViewById(R.id.description);

        if (String.valueOf(index).length() == 1){
            newId = "#00" + index;
        }else if (String.valueOf(index).length() == 2){
            newId = "#0" + index;
        }else if (String.valueOf(index).length() == 3){
            newId = "#" + index;
        }else{
            newId = "#" + index;
        }

        name.setText(id);
        back.setBackgroundColor(Color.parseColor(mapType.get(type)));
        Glide.with(this)
                .load("https://pokeres.bastionbot.org/images/pokemon/" + index +".png")
                .centerCrop()
                .into(img);

        type1.setText(type);

        weight.setText(poids);
        height.setText(taille);

        if (second_type != null){
            type2.setText(second_type);
        }

        test1(Integer.parseInt(index));
        number.setText(newId);
        return view;

    }

    public void test1(int id){
        PokemonService pokemonService = new Retrofit.Builder()
                .baseUrl(PokemonService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService.class);

        pokemonService.getFlav(id).enqueue(new Callback<FlavorTextEntries>() {
            @Override
            public void onResponse(Call<FlavorTextEntries> call, Response<FlavorTextEntries> response) {
                for(int i = 0 ; i < response.body().getFlavorTextEntries().size() ; i++){
                    if(response.body().getFlavorTextEntries().get(i).getLanguage().getName().equals("de"))
                        desc = (TextView)getView().findViewById(R.id.description);
                        desc.setText(response.body().getFlavorTextEntries().get(i).getFlavorText());
                }
            }

            @Override
            public void onFailure(Call<FlavorTextEntries> call, Throwable t) {

            }
        });
    }

    private void pokeDetail(String id) {
        PokemonService pokemonService = new Retrofit.Builder()
                .baseUrl(PokemonService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService.class);

        pokemonService.getPokemonById(id).enqueue(new Callback<DetailsPoke>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<DetailsPoke> call, Response<DetailsPoke> response) {
                if (response.isSuccessful()){
                    DetailsPoke detailsPoke = response.body();
                    Log.d("check", detailsPoke.getName());
                    Log.d("check", String.valueOf(detailsPoke.getId()));

                    name = (TextView)getView().findViewById(R.id.name);
                    img = (ImageView)getView().findViewById(R.id.myPoke_img);
                    number = (TextView)getView().findViewById(R.id.index);
                    height = (TextView)getView().findViewById(R.id.taille);
                    weight = (TextView)getView().findViewById(R.id.weight);
                    type1 = (TextView)getView().findViewById(R.id.type1);
                    type2 = (TextView)getView().findViewById(R.id.type2);
                    back = (ImageView)getView().findViewById(R.id.header);
                    bottom = (BottomNavigationView)getView().findViewById(R.id.bottom_navigation);

                    if (detailsPoke.getType().size() == 1){
                        first_type = detailsPoke.getType().get(0).getType().getName();
                        type1.setText(first_type);
                    }
                    if (detailsPoke.getType().size() > 1){
                        first_type = detailsPoke.getType().get(0).getType().getName();
                        second_type = detailsPoke.getType().get(1).getType().getName();
                        type1.setText(first_type);
                        type2.setText(second_type);
                    }


                    back.setBackgroundColor(Color.parseColor(mapType.get(first_type)));
                    //bottom.setBackgroundColor(Color.parseColor(mapType.get(first_type)));

                    String id = detailsPoke.getId();
                    String newId;

                    if (String.valueOf(id).length() == 1){
                        newId = "#00" + id;
                    }else if (String.valueOf(id).length() == 2){
                        newId = "#0" + id;
                    }else if (String.valueOf(id).length() == 3){
                        newId = "#" + id;
                    }else{
                        newId = "#" + id;
                    }
                    number.setText(newId);
                    name.setText(detailsPoke.getName());
                    height.setText(detailsPoke.getHeight() + " m");
                    weight.setText(detailsPoke.getWeight() + " kg");
                    Glide.with(getView())
                            .load("https://pokeres.bastionbot.org/images/pokemon/" + detailsPoke.getId() +".png")
                            .centerCrop()
                            .into(img);
                }
            }

            @Override
            public void onFailure(Call<DetailsPoke> call, Throwable t) {

            }
        });
    }

    public void test(int id){
        EvolutionService evolutionService = new Retrofit.Builder()
                .baseUrl(EvolutionService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EvolutionService.class);

        evolutionService.listEvolutions(id).enqueue(new Callback<List<EvolutionPokemon>>() {
            @Override
            public void onResponse(Call<List<EvolutionPokemon>> call, Response<List<EvolutionPokemon>> response) {
                String description = response.body().get(0).getDescription();
                Log.d("desc" ,description);
            }

            @Override
            public void onFailure(Call<List<EvolutionPokemon>> call, Throwable t) {

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