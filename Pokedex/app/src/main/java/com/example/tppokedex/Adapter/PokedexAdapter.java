package com.example.tppokedex.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tppokedex.Activity.DetailActivity;
import com.example.tppokedex.R;
import com.example.tppokedex.Models.Pokemon;

import java.util.ArrayList;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.ViewHolder> {

    private ArrayList<Pokemon> list = new ArrayList<>();
    private Pokemon p;
    private Context mContext;

    public PokedexAdapter(Context context) {
        this.list = new ArrayList<>();
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon pokemon = list.get(position);

        Glide.with(mContext)
                .load("https://pokeres.bastionbot.org/images/pokemon/" + pokemon.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.image_pokemon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addPoke(ArrayList<Pokemon> listPokemon) {
        list.addAll(listPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView image_pokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_pokemon = (ImageView) itemView.findViewById(R.id.image_pokemon);
            image_pokemon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.image_pokemon:
                    Intent i = new Intent(v.getContext(),DetailActivity.class);
                    v.getContext().startActivity(i);
            }
        }
    }
}
