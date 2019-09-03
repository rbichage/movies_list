package com.computercastles.movieslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 *
 * An adapter is a bridge between layout and your  code(data).
 *
 * An adapter inflates layout from your code
 *
 * In this  case our data is a list of  movies from https://admin.coverappke.com/api/post/assessment.php
 *
 * **/
public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.ViewHolder> {
    private List<Movie> movieList;
    private Context context;

    public MoviesListAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false));

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie= movieList.get(position);

        if (movie != null){
            holder.movieTitle.setText(movie.getTitle());
            holder.movieGenre.setText(movie.getGenre());

        }

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle, movieGenre;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = itemView.findViewById(R.id.movie_title);
            movieGenre = itemView.findViewById(R.id.movie_genre);
        }
    }
}
