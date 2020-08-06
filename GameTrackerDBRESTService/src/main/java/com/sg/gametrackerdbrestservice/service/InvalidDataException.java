package com.sg.gametrackerdbrestservice.service;

/**
 *
 * @author Kyle David Rudy
 */
public class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

}
