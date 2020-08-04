package com.sg.complexgametrackerdb.dto;

import java.util.Objects;

/**
 *
 * @author Kyle David Rudy
 */
public class Publisher {
    private int id;
    private String publisher;
    private String country;

    public Publisher() {
    }

    public Publisher(int id, String publisher, String country) {
        this.id = id;
        this.publisher = publisher;
        this.country = country;
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
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.publisher);
        hash = 59 * hash + Objects.hashCode(this.country);
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
