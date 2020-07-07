package com.sg.gametracker.service;

import com.sg.gametracker.dao.GameDao;
import com.sg.gametracker.dao.GameDaoPersistanceException;
import com.sg.gametracker.dto.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kyle David Rudy
 */
@Service
public class GameService {
    
    GameDao dao;

    @Autowired
    public GameService(GameDao dao) {
        this.dao = dao;
    }
    
    public List<Game> getAllGames() throws GameDaoPersistanceException {
        return dao.getAllGames();
    }
    
    public Game getGameByName(String name) throws GameDaoPersistanceException, GameDoesNotExistException {
        checkIfGameExists(name);
        return dao.getGameByName(name);
    }
    
    public Game addGame(Game game) throws GameDaoPersistanceException, InvalidDataException {
        checkName(game);
        return dao.addGame(game);
    }
    
    public void updateGame(Game game) throws GameDaoPersistanceException, InvalidDataException {
        checkName(game);
        dao.updateGame(game);
    }
    
    public void deleteGameByName(String name) throws GameDaoPersistanceException, GameDoesNotExistException {
        checkIfGameExists(name);
        dao.deleteGameByName(name);
    }
    
    private void checkName(Game game) throws InvalidDataException {
        if(game.getName() == null || game.getName().isBlank()) {
            throw new InvalidDataException("Name must not be blank");
        }
    }
    
    private void checkIfGameExists(String name) throws GameDoesNotExistException, GameDaoPersistanceException {
        if(dao.getGameByName(name) == null) {
            throw new GameDoesNotExistException("Game does not exist");
        }
    }
}
