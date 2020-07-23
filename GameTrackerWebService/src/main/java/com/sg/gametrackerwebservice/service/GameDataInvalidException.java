package com.sg.gametrackerwebservice.service;

/**
 *
 * @author Kyle David Rudy
 */
public class GameDataInvalidException  extends Exception {

    public GameDataInvalidException(String message) {
        super(message);
    }

    public GameDataInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

}
