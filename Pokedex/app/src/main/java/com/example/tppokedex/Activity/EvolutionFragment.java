package com.example.tppokedex.Activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tppokedex.API.EvolutionService;
import com.example.tppokedex.API.PokemonService;
import com.example.tppokedex.Models.EvolutionPokemon;
import com.example.tppokedex.Models.FlavorTextEntries;
import com.example.tppokedex.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EvolutionFragment extends Fragment {

    private TextView name;
    Map<String, String> mapType;
    private ImageView back;
    private TextView number;
    private ImageView img;
    String ev;
    private List<FlavorTextEntries> names;

    public EvolutionFragment() {
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
        View view = inflater.inflate(R.layout.fragment_evolution, container, false);
        String id = this.getArguments().getString("id");
        String type = this.getArguments().getString("type");
        String index = this.getArguments().getString("number");
        String newId;

        name = (TextView)view.findViewById(R.id.name_evolve);
        back =(ImageView)view.findViewById(R.id.header_evolve);
        number = (TextView)view.findViewById(R.id.index_evolve);

        makeMapType();
        img = (ImageView)view.findViewById(R.id.myPoke_img_evolve);

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

        name.setText(id);
        back.setBackgroundColor(Color.parseColor(mapType.get(type)));
        number.setText(newId);
        //test(Integer.parseInt(index));
        Log.d("id_poke", id);
        return view;

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
                List<String> st = response.body().get(0).getFamily().getEvolutionLine();
                getEvolve(st);
            }

            @Override
            public void onFailure(Call<List<EvolutionPokemon>> call, Throwable t) {

            }
        });
    }

    public void getEvolve(List<String> evolve){
        Toast.makeText(getContext(),"taille " + evolve.size(),Toast.LENGTH_LONG).show();
        for (int i = 0;i < evolve.size();i++){
            Log.d("test", evolve.get(i));
        }
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