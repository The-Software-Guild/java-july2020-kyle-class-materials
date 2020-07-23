package com.sg.gametrackerwebservice.controller;

import java.time.LocalDateTime;

/**
 *
 * @author Kyle David Rudy
 */
public class Error {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
