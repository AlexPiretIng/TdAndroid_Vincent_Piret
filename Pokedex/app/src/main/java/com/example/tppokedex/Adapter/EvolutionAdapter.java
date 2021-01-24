package com.example.tppokedex.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.bumptech.glide.Glide;
import com.example.tppokedex.Models.Pokemon;
import com.example.tppokedex.R;

import java.util.ArrayList;
import java.util.List;


public class EvolutionAdapter extends Adapter<EvolutionAdapter.ViewHolder> {

    private List<Pokemon> evolution;

    public EvolutionAdapter(List<Pokemon> evolution) {
        this.evolution = evolution;
    }
    public EvolutionAdapter() {
        this.evolution = new ArrayList<>();
    }

    @NonNull
    @Override
    public EvolutionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View evolutionView = inflater.inflate(R.layout.item_evolution, parent, false);
        return new ViewHolder(evolutionView);
    }

    @Override
    public void onBindViewHolder(@NonNull EvolutionAdapter.ViewHolder holder, int position) {
        Pokemon pokemon = evolution.get(position);

        // Add avatar
        ImageView evolutionAvatar = holder.evolutionAvatar;
    }

    public void updateList(List<Pokemon> newEvolution) {
        this.evolution = newEvolution;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.evolution.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView evolutionAvatar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Get item from the view
            evolutionAvatar = itemView.findViewById(R.id.item_evolution_avatar);
        }
    }
}