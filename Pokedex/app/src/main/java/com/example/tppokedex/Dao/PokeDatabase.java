package com.example.tppokedex.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tppokedex.Models.Pokemon;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class PokeDatabase extends RoomDatabase {
    public abstract PokemonDao pokemonDao();

    public static synchronized PokeDatabase getInstance(Context context) {
        PokeDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                PokeDatabase.class, "pokemon").allowMainThreadQueries().build();
        return db;
    }
}
