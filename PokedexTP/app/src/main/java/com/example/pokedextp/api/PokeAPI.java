package com.example.pokedextp.api;

import com.example.pokedextp.models.PokemonRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeAPI {

    public static final String URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon/")
    Call<PokemonRequest> getPokemon(@Query("limit") int limit, @Query("offset") int offset);


}
