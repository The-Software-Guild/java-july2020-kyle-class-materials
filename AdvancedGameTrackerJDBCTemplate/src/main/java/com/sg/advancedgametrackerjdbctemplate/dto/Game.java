package com.sg.advancedgametrackerjdbctemplate.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Kyle David Rudy
 */
public class Game {
    private int id;
    private String name;
    private int releaseYear;
    private String genre;
    private Publisher publisher;
    private List<Platform> platforms;

    public Game() {
    }

    public Game(int id, String name, int releaseYear, String genre, Publisher publisher, List<Platform> platforms) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.publisher = publisher;
        this.platforms = platforms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + this.releaseYear;
        hash = 11 * hash + Objects.hashCode(this.genre);
        hash = 11 * hash + Objects.hashCode(this.publisher);
        hash = 11 * hash + Objects.hashCode(this.platforms);
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
        if (this.id != other.id) {
            return false;
        }
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
        if (!Objects.equals(this.platforms, other.platforms)) {
            return false;
        }
        return true;
    }
    
    
    
}
