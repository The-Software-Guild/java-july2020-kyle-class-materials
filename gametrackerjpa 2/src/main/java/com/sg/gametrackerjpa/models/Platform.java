package com.sg.gametrackerjpa.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Kyle David Rudy
 */
@Entity
public class Platform {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    @Column(nullable = false)
    private String platform;

    public Platform() {
    }

    public Platform(int id, String platform) {
        this.id = id;
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.platform);
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
        final Platform other = (Platform) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        return true;
    }
    
    
}
