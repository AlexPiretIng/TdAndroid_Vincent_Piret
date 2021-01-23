package com.example.tppokedex.Models;

import java.util.List;

public class PokemonSpecies {

    private List<TextEntrie> flavorTextEntries;
    private List<Name> names;
    private List<Varietie> varieties;

    public List<TextEntrie> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<TextEntrie> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<Varietie> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<Varietie> varieties) {
        this.varieties = varieties;
    }
}
