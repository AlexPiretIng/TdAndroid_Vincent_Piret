package com.example.tppokedex.Models;

import java.util.List;

public class TextEntrie {
    List<Language> lang;
    private String text;

    public List<Language> getLang() {
        return lang;
    }

    public void setLang(List<Language> lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
