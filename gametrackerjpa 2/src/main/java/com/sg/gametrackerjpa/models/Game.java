package com.sg.gametrackerjpa.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Kyle David Rudy
 */
@Entity
public class Game {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    @Column
    private String name;
    
    @Column
    private String genre;
    
    @Column(name = "releaseyear")
    private int releaseYear;
    
    @ManyToOne
    @JoinColumn(name = "publisherid")
    private Publisher publisher;
    
    @ManyToMany
    @JoinTable(name = "game_platform",
            joinColumns = {@JoinColumn(name = "gameid")},
            inverseJoinColumns = {@JoinColumn(name = "platformid")})
    private List<Platform> platforms;

    public Game(int id, String name, String genre, int releaseYear, Publisher publisher, List<Platform> platforms) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.publisher = publisher;
        this.platforms = platforms;
    }

    public Game() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.genre);
        hash = 89 * hash + this.releaseYear;
        hash = 89 * hash + Objects.hashCode(this.publisher);
        hash = 89 * hash + Objects.hashCode(this.platforms);
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
