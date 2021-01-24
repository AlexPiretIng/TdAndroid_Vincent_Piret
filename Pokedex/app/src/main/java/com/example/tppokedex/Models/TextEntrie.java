package com.example.tppokedex.Models;

import java.util.List;

public class TextEntrie {
    List<Language> language;
    private String flavor_text;

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }
}
