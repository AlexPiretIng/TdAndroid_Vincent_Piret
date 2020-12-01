package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.LinearLayout;
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
    LinearLayoutManager layoutManager;
    private static final String TAG = "Repo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String login = "";
        Intent intent = getIntent();

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
        githubService.searchRepos("picasso").enqueue(new Callback<Repos>() {
            @Override
            public void onResponse(Call<Repos> call, Response<Repos> response) {
                afficherRepos(response.body());
            }

            @Override
            public void onFailure(Call<Repos> call, Throwable t) {

            }
        });

        //RecyclerView rvRepos = (RecyclerView) findViewById(R.id.rvRepo);

    }
    public void afficherRepos(Repos repos) {
        //Toast.makeText(this,"nombre de dépots : "+repos.size(), Toast.LENGTH_SHORT).show();
        RecyclerView rvRepos = (RecyclerView) findViewById(R.id.rvRepo);
        RepoAdapter adapter = new RepoAdapter(repos,this);
        rvRepos.setAdapter(adapter);
        rvRepos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this,"nombre de dépots : "+repos.size(), Toast.LENGTH_SHORT).show();
    }
}