package com.example.tppokedex.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tppokedex.Models.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAll();

    @Query("SELECT * FROM pokemon WHERE id = :id")
    List<Pokemon> getPokemon(int id);

    @Insert
    void insertAll(List<Pokemon> pokemons);

    @Insert
    void insertOne(Pokemon pokemon);

    @Delete
    void delete(Pokemon pokemon);

    @Update
    int updateGeneration(Pokemon pokemon);
}
