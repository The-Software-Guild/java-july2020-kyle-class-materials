package com.sg.gametrackerwebservice.service;

import com.sg.gametrackerwebservice.dao.GameDao;
import com.sg.gametrackerwebservice.dao.GameDaoPersistanceException;
import com.sg.gametrackerwebservice.model.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kyle David Rudy
 */
@Service
public class GameService {

    @Autowired
    GameDao dao;

    public Game getGameById(int id) throws GameDaoPersistanceException, GameDoesNotExistException {
        Game g = dao.getGameById(id);
        if (g == null) {
            throw new GameDoesNotExistException("Game with id " + id + " does not exist");
        }
        return g;
    }

    public List<Game> getAllGames() throws GameDaoPersistanceException {
        return dao.getAllGames();
    }

    public Game addGame(Game game) throws GameDaoPersistanceException, GameDataInvalidException {
        if(game.getName() == null || game.getName().isBlank()) {
            throw new GameDataInvalidException("Name can not be blank");
        }
        return dao.addGame(game);
    }

    public void updateGame(Game game) throws GameDaoPersistanceException, GameDoesNotExistException {
        Game g = dao.getGameById(game.getId());
        if (g == null) {
            throw new GameDoesNotExistException("Game with id " + game.getId() + " does not exist");
        }
        dao.updateGame(game);
    }

    public void deleteGameById(int id) throws GameDaoPersistanceException, GameDoesNotExistException {
        Game g = dao.getGameById(id);
        if (g == null) {
            throw new GameDoesNotExistException("Game with id " + id + " does not exist");
        }
        dao.deleteGameById(id);
    }

}
