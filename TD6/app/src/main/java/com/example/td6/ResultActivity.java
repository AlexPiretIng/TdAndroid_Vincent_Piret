package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity {

    RecyclerView rvRepo;
    private RepoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String login = "";
        Intent intent = getIntent();
        rvRepo = (RecyclerView)findViewById(R.id.rvRepo);
        adapter = new RepoAdapter();
        rvRepo.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        rvRepo.setLayoutManager(layoutManager);

        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
        }

        GithubService githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);

        githubService.listRepos("adrienbusin").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                afficherRepos(response.body());
            }
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

        githubService.searchRepos(login).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
               
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }

    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this,"nombre de dépots : "+repos.size(), Toast.LENGTH_SHORT).show();
    }
}