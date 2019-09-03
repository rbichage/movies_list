package com.computercastles.movieslist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Movie {

    /**
     *  a Pojo class to model Movie
     *
     *
     * **/

    @SerializedName("movieID")
    @Expose
    private Integer movieID;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("genre")
    @Expose
    private String genre;

    public Movie(Integer movieID, String title, String genre) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
