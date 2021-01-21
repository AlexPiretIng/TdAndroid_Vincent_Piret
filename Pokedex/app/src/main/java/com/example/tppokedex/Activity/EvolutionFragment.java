package com.example.tppokedex.Activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tppokedex.R;

import java.util.HashMap;
import java.util.Map;

public class EvolutionFragment extends Fragment {

    private TextView name;
    Map<String, String> mapType;
    private ImageView back;
    private TextView number;

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

        name = (TextView)view.findViewById(R.id.name_evolve);
        back =(ImageView)view.findViewById(R.id.header_evolve);
        number = (TextView)view.findViewById(R.id.index_evolve);

        makeMapType();
        name.setText(id);
        back.setBackgroundColor(Color.parseColor(mapType.get(type)));
        number.setText(index);

        return view;

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