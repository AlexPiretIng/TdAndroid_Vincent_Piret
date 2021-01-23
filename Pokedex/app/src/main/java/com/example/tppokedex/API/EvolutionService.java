package com.example.tppokedex.API;

import com.example.tppokedex.Models.EvolutionPokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EvolutionService {

    String ENDPOINT = "https://pokeapi.glitch.me/v1/";
    
    @GET("pokemon/{slug}")
    Call<EvolutionPokemon> getEvolutions(@Path("slug") String slug);

}
