package com.sg.complexgametrackerdb.dto;

import java.util.Objects;

/**
 *
 * @author Kyle David Rudy
 */
public class Platform {
    private int id;
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
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.platform);
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
