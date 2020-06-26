package com.sg.gametracker.dto;

/**
 *
 * @author Kyle David Rudy
 */
public class Game {
    private String name;
    private String genre;
    private String publisher;
    private int releaseYear;
    
    public Game() {
        
    }
    
    public Game(String name, String genre, String publisher, int releaseYear) {
        this.name = name;
        this.genre = genre;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    
}
