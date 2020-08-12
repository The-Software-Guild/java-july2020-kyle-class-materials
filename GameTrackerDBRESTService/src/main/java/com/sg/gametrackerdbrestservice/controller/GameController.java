package com.sg.gametrackerdbrestservice.controller;

import com.sg.gametrackerdbrestservice.dao.GameDaoPersistanceException;
import com.sg.gametrackerdbrestservice.dto.Game;
import com.sg.gametrackerdbrestservice.service.GameDoesNotExistException;
import com.sg.gametrackerdbrestservice.service.GameService;
import com.sg.gametrackerdbrestservice.service.InvalidDataException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kyle David Rudy
 */
@CrossOrigin
@RestController
public class GameController {

    @Autowired
    GameService service;
    
    @GetMapping("/games")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Game> getAllGames() throws GameDaoPersistanceException {
        return service.getAllGames();
    }
    
    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable Integer id) throws GameDaoPersistanceException, GameDoesNotExistException {
        return service.getGameById(id);
    }
    
    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game) throws GameDaoPersistanceException, InvalidDataException {
        return service.addGame(game);
    }
    
    @PutMapping("/game")
    public void updateGame(@RequestBody Game game) throws GameDaoPersistanceException, InvalidDataException {
        service.updateGame(game);
    }
    
    @DeleteMapping("/game/{id}")
    public void deleteGameById(@PathVariable Integer id) throws GameDaoPersistanceException, GameDoesNotExistException {
        service.deleteGameById(id);
    }
    
}
