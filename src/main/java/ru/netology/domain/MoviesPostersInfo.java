package ru.netology.domain;



public class MoviesPostersInfo {
    int id;
    String movieName;
    int moviePicture;
    String movieGenre;

    public MoviesPostersInfo(int id, String movieName, int moviePicture, String movieGenre) {
        this.id = id;
        this.movieName = movieName;
        this.moviePicture = moviePicture;
        this.movieGenre = movieGenre;
    }

    public int getId() { return id; }
}
