package com.sg.gametrackerwebservice.service;

/**
 *
 * @author Kyle David Rudy
 */
public class GameDoesNotExistException extends Exception {

    public GameDoesNotExistException(String message) {
        super(message);
    }

    public GameDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
