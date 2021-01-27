package com.example.tppokedex.Models;

import java.util.List;

public class PokemonSpecies {

    int base_happiness;

    public int getBase_happiness() {
        return base_happiness;
    }

    public void setBase_happiness(int base_happiness) {
        this.base_happiness = base_happiness;
    }

    private List<FlavorTextEntries> flavor_text_entries;
    private List<FlavorTextEntry> flavorTextEntries;
    private List<Varietie> varieties;

    public List<FlavorTextEntries> getFlavor_text_entries() {
        return flavor_text_entries;
    }

    public void setFlavor_text_entries(List<FlavorTextEntries> flavor_text_entries) {
        this.flavor_text_entries = flavor_text_entries;
    }

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<Varietie> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<Varietie> varieties) {
        this.varieties = varieties;
    }
}
