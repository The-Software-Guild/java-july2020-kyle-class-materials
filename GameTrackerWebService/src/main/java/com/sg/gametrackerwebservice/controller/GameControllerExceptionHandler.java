package com.sg.gametrackerwebservice.controller;

import com.sg.gametrackerwebservice.service.GameDataInvalidException;
import com.sg.gametrackerwebservice.service.GameDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Kyle David Rudy
 */
@ControllerAdvice
@RestController
public class GameControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GameDoesNotExistException.class)
    public final ResponseEntity<Error> handleGameDNE(GameDoesNotExistException ex, WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(GameDataInvalidException.class)
    public final ResponseEntity<Error> handleInvalidData(GameDataInvalidException ex, WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
}
