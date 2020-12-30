package com.example.tppokedex.API;

import com.example.tppokedex.Models.AllPokemon;
import com.example.tppokedex.Models.DetailsPoke;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonService {

    public static final String URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon/")
    Call<AllPokemon> getPokemon(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{pokemonID}")
    Call<DetailsPoke>getPokemonById(@Path("pokemonID") String id);
}
