package com.sg.complexgametrackerdb.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Kyle David Rudy
 */
public class GamePlatform {
    private Platform platform;
    private BigDecimal price;

    public GamePlatform(Platform platform, BigDecimal price) {
        this.platform = platform;
        this.price = price;
    }

    public GamePlatform() {
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.platform);
        hash = 79 * hash + Objects.hashCode(this.price);
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
        final GamePlatform other = (GamePlatform) obj;
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
    
    
}
