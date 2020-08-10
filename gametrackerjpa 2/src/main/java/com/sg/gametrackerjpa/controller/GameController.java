package com.sg.gametrackerjpa.controller;

import com.sg.gametrackerjpa.models.Game;
import com.sg.gametrackerjpa.repositories.GameRepository;
import com.sg.gametrackerjpa.repositories.PlatformRepository;
import com.sg.gametrackerjpa.repositories.PublisherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kyle David Rudy
 */
@RestController
public class GameController {

    @Autowired
    GameRepository games;
    
    @Autowired
    PlatformRepository platforms;
    
    @Autowired
    PublisherRepository publishers;
    
    @GetMapping("games")
    public List<Game> getAllGames() {
        return games.findAll();
    }
    
    @GetMapping("game/{id}")
    public Game getGameById(@PathVariable Integer id) {
        return games.findById(id).orElse(null);
    }
    
    @GetMapping("games/genre/{genre}")
    public List<Game> getGamesByGenre(@PathVariable String genre) {
        return games.findByGenre(genre);
    }
    
}
