package com.computercastles.movieslist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("assessment.php")
    Call<List<Movie>> getMovies();
}
