package com.sg.gametrackerjpa.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Kyle David Rudy
 */
@Entity
public class Publisher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    @Column(nullable = false)
    private String publisher;
    
    @Column
    private String country;

    public Publisher(int id, String publisher, String country) {
        this.id = id;
        this.publisher = publisher;
        this.country = country;
    }

    public Publisher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.publisher);
        hash = 89 * hash + Objects.hashCode(this.country);
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
        final Publisher other = (Publisher) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }
    
    
}
