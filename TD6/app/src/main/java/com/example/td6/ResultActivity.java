package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    Retrofit mRetrofit;
    private static final String TAG = "Repo";
    List<Repo> mRepoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String login = "";
        Intent intent = getIntent();

        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
        }

        rvRepo = (RecyclerView)findViewById(R.id.rvRepo);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvRepo.setLayoutManager(layoutManager);
        RepoAdapter adapter = new RepoAdapter(mRepoList, this);
        rvRepo.setAdapter(adapter);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService githubService = mRetrofit.create(GithubService.class);

        githubService.listRepos("adrienbusin").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                //afficherRepos(response.body());
            }
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

       githubService.searchRepos("7WondersDuel").enqueue(new Callback<List<Repo>>() {
           @Override
           public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
               if (response.isSuccessful()){

               }
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