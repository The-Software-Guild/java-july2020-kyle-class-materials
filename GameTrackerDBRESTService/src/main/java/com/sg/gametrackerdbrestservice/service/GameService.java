package com.sg.gametrackerdbrestservice.service;

import com.sg.gametrackerdbrestservice.dao.GameDao;
import com.sg.gametrackerdbrestservice.dao.GameDaoPersistanceException;
import com.sg.gametrackerdbrestservice.dto.Game;
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
    
    public Game getGameById(int id) throws GameDaoPersistanceException, GameDoesNotExistException {
        checkIfGameExists(id);
        return dao.getGameById(id);
    }
    
    public Game addGame(Game game) throws GameDaoPersistanceException, InvalidDataException {
        checkName(game);
        return dao.addGame(game);
    }
    
    public void updateGame(Game game) throws GameDaoPersistanceException, InvalidDataException {
        checkName(game);
        dao.updateGame(game);
    }
    
    public void deleteGameById(int id) throws GameDaoPersistanceException, GameDoesNotExistException {
        checkIfGameExists(id);
        dao.deleteGameById(id);
    }
    
    private void checkName(Game game) throws InvalidDataException {
        if(game.getName() == null || game.getName().isBlank()) {
            throw new InvalidDataException("Name must not be blank");
        }
    }
    
    private void checkIfGameExists(int id) throws GameDoesNotExistException, GameDaoPersistanceException {
        if(dao.getGameById(id) == null) {
            throw new GameDoesNotExistException("Game does not exist");
        }
    }
}
