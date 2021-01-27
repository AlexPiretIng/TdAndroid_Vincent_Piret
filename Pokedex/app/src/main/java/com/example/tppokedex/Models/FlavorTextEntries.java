package com.example.tppokedex.Models;

import java.util.List;

public class FlavorTextEntries {

    private List<FlavorTextEntry> flavor_text_entries;
    private List<Name> names;

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavor_text_entries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavor_text_entries = flavorTextEntries;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }
}
