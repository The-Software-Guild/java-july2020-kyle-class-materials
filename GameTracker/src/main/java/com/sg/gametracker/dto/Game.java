package com.sg.gametracker.dto;

import java.util.Objects;

/**
 *
 * @author Kyle David Rudy
 */
public class Game {
    private String name;
    private String genre;
    private String publisher;
    private int releaseYear;
    
    public Game(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.genre);
        hash = 73 * hash + Objects.hashCode(this.publisher);
        hash = 73 * hash + this.releaseYear;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.releaseYear != other.releaseYear) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        return true;
    }
    
    
}
