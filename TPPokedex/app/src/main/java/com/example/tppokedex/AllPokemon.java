package com.example.tppokedex;

import java.util.ArrayList;

public class AllPokemon {

    private ArrayList<Pokemon> listPoke;

    public ArrayList<Pokemon> getResults() {
        return listPoke;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.listPoke = results;
    }
}
