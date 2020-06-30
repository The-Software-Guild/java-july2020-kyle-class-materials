package com.sg.gametracker.dao;

import com.sg.gametracker.dto.Game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public class GameDaoMock implements GameDao {

    @Override
    public Game getGameByName(String name) throws GameDaoPersistanceException {
        if("null".equals(name)) {
            return null;
        } else {
            return new Game(name, "test", "test", 1980);
        }
    }

    @Override
    public List<Game> getAllGames() throws GameDaoPersistanceException {
        return new ArrayList<>();
    }

    @Override
    public Game addGame(Game game) throws GameDaoPersistanceException {
        return game;
    }

    @Override
    public void updateGame(Game game) throws GameDaoPersistanceException {
        //do nothing;
    }

    @Override
    public void deleteGameByName(String name) throws GameDaoPersistanceException {
        //do nothing
    }

}
