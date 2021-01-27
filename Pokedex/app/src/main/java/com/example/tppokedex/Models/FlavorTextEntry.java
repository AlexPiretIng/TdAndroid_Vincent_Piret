package com.example.tppokedex.Models;

public class FlavorTextEntry {

    private String flavor_text;
    private Language language;

    public String getFlavorText() {
        return flavor_text;
    }

    public void setFlavorText(String flavorText) {
        this.flavor_text = flavorText;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
