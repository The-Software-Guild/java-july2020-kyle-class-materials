package com.sg.complexgametrackerdb.dto;

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
    private List<GamePlatform> gamePlatforms;

    public Game() {
    }

    public Game(int id, String name, int releaseYear, String genre, Publisher publisher, List<GamePlatform> gamePlatforms) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.publisher = publisher;
        this.gamePlatforms = gamePlatforms;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<GamePlatform> getGamePlatforms() {
        return gamePlatforms;
    }

    public void setGamePlatforms(List<GamePlatform> gamePlatforms) {
        this.gamePlatforms = gamePlatforms;
    }



    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + this.releaseYear;
        hash = 43 * hash + Objects.hashCode(this.genre);
        hash = 43 * hash + Objects.hashCode(this.publisher);
        hash = 43 * hash + Objects.hashCode(this.gamePlatforms);
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
        if (!Objects.equals(this.gamePlatforms, other.gamePlatforms)) {
            return false;
        }
        return true;
    }

}
