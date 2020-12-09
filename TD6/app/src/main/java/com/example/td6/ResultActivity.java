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


        githubService.searchRepos("picasso").enqueue(new Callback<Repos>() {
            @Override
            public void onResponse(Call<Repos> call, Response<Repos> response) {
                afficherReposit(response.body());
                Log.e(TAG, response.toString());
            }

            @Override
            public void onFailure(Call<Repos> call, Throwable t) {
            }
        });

        RecyclerView rvRepos = (RecyclerView) findViewById(R.id.rvRepo);
    }
    public void afficherReposit(Repos repos) {
        RecyclerView rvRepos = (RecyclerView) findViewById(R.id.rvRepo);
        RepoAdapter adapter = new RepoAdapter(repos,ResultActivity.this);
        rvRepos.setAdapter(adapter);
        rvRepos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this,"nombre de dépots : "+ repos.size(), Toast.LENGTH_SHORT).show();
    }
}