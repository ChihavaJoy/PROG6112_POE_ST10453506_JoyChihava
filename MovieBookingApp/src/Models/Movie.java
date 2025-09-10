/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.ArrayList;
/**
 *
 * @author lab_services_student
 */
public class Movie {
    
    private String movieId;
    private String title;
    private int duration; // in minutes
    private String genre;

    // Constructor
    public Movie(String movieId, String title, int duration, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    // Getters
    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // toString for reports
    @Override
    public String toString() {
        return "Movie ID: " + movieId +
               ", Title: " + title +
               ", Duration: " + duration + " mins" +
               ", Genre: " + genre;
    }
    
    
    
}
