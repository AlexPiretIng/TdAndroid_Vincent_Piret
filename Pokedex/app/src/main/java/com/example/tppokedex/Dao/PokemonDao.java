package com.example.tppokedex.Dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.tppokedex.Models.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAll();
}
