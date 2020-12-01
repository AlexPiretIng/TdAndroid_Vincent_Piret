package com.example.td6;

import java.util.List;

public class Repos {
    private int total_count;
    private int incomplete_results;
    private List<Repo> items;


    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(int incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<Repo> getItems() {
        return items;
    }

    public void setItems(List<Repo> items) {
        this.items = items;
    }
}
