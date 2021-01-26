package com.example.tppokedex.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tppokedex.Models.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAll();

    @Query("SELECT * FROM pokemon WHERE id = :id")
    List<Pokemon> getPokemon(int id);

    @Query("SELECT count(*) FROM pokemon")
    int getNumber();

    @Query("SELECT * FROM pokemon WHERE id>=0 AND id<=151")
    List<Pokemon> getGen1();

    @Query("SELECT * FROM pokemon WHERE id>=151 AND id<=251")
    List<Pokemon> getGen2();

    @Query("SELECT * FROM pokemon WHERE id>=251 AND id<386")
    List<Pokemon> getGen3();

    @Query("SELECT * FROM pokemon WHERE id>=386 AND id<493")
    List<Pokemon> getGen4();

    @Query("SELECT * FROM pokemon WHERE id>=493 AND id<649")
    List<Pokemon> getGen5();

    @Query("SELECT * FROM pokemon WHERE id>=649 AND id<721 ")
    List<Pokemon> getGen6();

    @Query("SELECT * FROM pokemon WHERE id>=721 AND id<809 ")
    List<Pokemon> getGen7();

    @Query("SELECT * FROM pokemon WHERE id>=809 AND id<898 ")
    List<Pokemon> getGen8();

    @Insert
    void insertAll(List<Pokemon> pokemon);

    @Insert
    void insertOne(Pokemon pokemon);

    @Delete
    void delete(Pokemon pokemon);

    @Update
    int updateGeneration(Pokemon pokemon);
}
