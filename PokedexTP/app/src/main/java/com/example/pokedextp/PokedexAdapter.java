package com.example.pokedextp;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokedextp.models.Pokemon;

import java.util.ArrayList;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.ViewHolder> {

    private ArrayList<Pokemon> list;
    private Context context;

    public PokedexAdapter() {
        this.list = new ArrayList<>();
        context = context;
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

        Glide.with(HomeActivity.context)
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image_pokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_pokemon = (ImageView)itemView.findViewById(R.id.image_pokemon);
        }
    }
}
