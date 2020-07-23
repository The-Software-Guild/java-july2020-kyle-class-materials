package com.sg.gametrackerwebservice.controller;

import com.sg.gametrackerwebservice.dao.GameDao;
import com.sg.gametrackerwebservice.dao.GameDaoPersistanceException;
import com.sg.gametrackerwebservice.model.Game;
import com.sg.gametrackerwebservice.service.GameDataInvalidException;
import com.sg.gametrackerwebservice.service.GameDoesNotExistException;
import com.sg.gametrackerwebservice.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kyle David Rudy
 */
@RestController
@RequestMapping("api")
public class GameController {
    
    @Autowired
    GameService service;
    
    @GetMapping("game/{id}")
    public Game getGame(@PathVariable Integer id) throws GameDaoPersistanceException, GameDoesNotExistException {
        return service.getGameById(id);
    }
    
    @GetMapping("games")
    public List<Game> getAllGames() throws GameDaoPersistanceException {
        return service.getAllGames();
    }
    
    @PostMapping("game")
    public Game addGame(@RequestBody Game game) throws GameDaoPersistanceException, GameDataInvalidException {
        return service.addGame(game);
    }
    
    @PutMapping("game")
    public void updateGame(@RequestBody Game game) throws GameDaoPersistanceException, GameDoesNotExistException {
        service.updateGame(game);
    }
    
    @DeleteMapping("game/{id}")
    public void deleteGame(@PathVariable Integer id) throws GameDaoPersistanceException, GameDoesNotExistException {
        service.deleteGameById(id);
    }
    
}
