package com.sg.gametrackerwebservice.controller;

import com.sg.gametrackerwebservice.dao.GameDao;
import com.sg.gametrackerwebservice.model.Game;
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
    GameDao games;
    
    @GetMapping("game/{id}")
    public Game getGame(@PathVariable Integer id) {
        return games.getGameById(id);
    }
    
    @GetMapping("games")
    public List<Game> getAllGames() {
        return games.getAllGames();
    }
    
    @PostMapping("game")
    public Game addGame(@RequestBody Game game) {
        return games.addGame(game);
    }
    
    @PutMapping("game")
    public void updateGame(@RequestBody Game game) {
        games.updateGame(game);
    }
    
    @DeleteMapping("game/{id}")
    public void deleteGame(@PathVariable Integer id) {
        games.deleteGameById(id);
    }
    
}
