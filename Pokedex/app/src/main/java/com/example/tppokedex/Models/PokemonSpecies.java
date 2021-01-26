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

    private List<TextEntrie> flavor_text_entries;
    private List<Name> names;
    private List<Varietie> varieties;

    public List<TextEntrie> getFlavor_text_entries() {
        return flavor_text_entries;
    }

    public void setFlavor_text_entries(List<TextEntrie> flavor_text_entries) {
        this.flavor_text_entries = flavor_text_entries;
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
