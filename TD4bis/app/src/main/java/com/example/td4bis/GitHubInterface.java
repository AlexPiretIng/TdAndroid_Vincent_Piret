package com.example.td4bis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubInterface {

    public static final String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("/search/repositories")
    Call<List<Repo>> searchRepos(@Query("q") String query);

    GitHubInterface githubService = new Retrofit.Builder()
            .baseUrl(GitHubInterface.ENDPOINT)
            //convertie le json automatiquement
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubInterface.class);
}