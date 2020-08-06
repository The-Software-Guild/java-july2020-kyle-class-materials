package com.sg.gametrackerdbrestservice.controller;

import com.sg.gametrackerdbrestservice.dao.GameDaoPersistanceException;
import com.sg.gametrackerdbrestservice.service.GameDoesNotExistException;
import com.sg.gametrackerdbrestservice.service.InvalidDataException;
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
    public final ResponseEntity<Error> handleGameDNEException(GameDoesNotExistException ex,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidDataException.class)
    public final ResponseEntity<Error> handleInvalidDataException(InvalidDataException ex,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
