package com.example.tppokedex.Dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tppokedex.Models.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class PokeDatabase extends RoomDatabase {
    public abstract PokemonDao pokemonDao();
}
