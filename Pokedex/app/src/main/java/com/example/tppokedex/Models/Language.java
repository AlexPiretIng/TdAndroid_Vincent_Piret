package com.example.tppokedex.Models;

import java.util.List;

public class Language {
    private String name;
    List<Name> names;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }
}
