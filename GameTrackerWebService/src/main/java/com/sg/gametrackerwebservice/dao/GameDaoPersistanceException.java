package com.sg.gametrackerwebservice.dao;

/**
 *
 * @author Kyle David Rudy
 */
public class GameDaoPersistanceException extends Exception {

    public GameDaoPersistanceException(String message) {
        super(message);
    }

    public GameDaoPersistanceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
