package com.example.tppokedex.API;

import com.example.tppokedex.models.AllPokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonService {

    public static final String URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon/")
    Call<AllPokemon> getPokemon(@Query("limit") int limit, @Query("offset") int offset);

}
