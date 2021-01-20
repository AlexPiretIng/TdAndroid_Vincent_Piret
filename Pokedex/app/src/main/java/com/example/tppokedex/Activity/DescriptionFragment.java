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
import com.example.tppokedex.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionFragment extends Fragment {

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

        String text = this.getArguments().getString("poke");
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        TextView name = view.findViewById(R.id.name);
        name.setText(text);
/*        Glide.with(this)
                .load("https://pokeres.bastionbot.org/images/pokemon/1.png")
                .centerCrop()
                .into(poke_img);*/

        return view;

    }


}