package com.example.tppokedex.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Models.DetailsPoke;
import com.example.tppokedex.Models.PokemonType;
import com.example.tppokedex.R;

import java.util.ArrayList;
import java.util.List;

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


        String id = this.getArguments().getString("poke");
        pokeDetail(id);
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        return view;

    }

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

                    name = (TextView)getView().findViewById(R.id.name);
                    img = (ImageView)getView().findViewById(R.id.myPoke_img);
                    number = (TextView)getView().findViewById(R.id.index);
                    height = (TextView)getView().findViewById(R.id.taille);
                    weight = (TextView)getView().findViewById(R.id.weight);
                    List<PokemonType> list = detailsPoke.getType();

                    name.setText(detailsPoke.getName());
                    height.setText(detailsPoke.getHeight() + " m");
                    number.setText(detailsPoke.getId());
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


}