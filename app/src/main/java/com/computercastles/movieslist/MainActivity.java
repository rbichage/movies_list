package com.computercastles.movieslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;
private List<Movie> movies = new ArrayList<>();
private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//     initialize recyclerView(displays items)
//        set layout manager as grid, grids items

        recyclerView = findViewById(R.id.movies_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,  2));


//      initialize okhttp client, for logging requests
//        In future requests make this a singleton class

        OkHttpClient client  = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

//        build retrofit object

        retrofit = new Retrofit.Builder()
                .baseUrl("https://admin.coverappke.com/api/post/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // implementing the api interface. Contains the api endpoints
        Api api = retrofit.create(Api.class);

//        retrofit call

        api.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    movies = response.body();   //parse items to adapter if the response is successful. TODO:  handle nulls

                    MoviesListAdapter moviesListAdapter = new MoviesListAdapter(movies, getApplicationContext());
                    recyclerView.setAdapter(moviesListAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                    // connectivity issue
            }
        });



    }
}
