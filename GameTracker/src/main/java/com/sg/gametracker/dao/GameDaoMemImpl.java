package com.sg.gametracker.dao;

import com.sg.gametracker.dto.Game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public class GameDaoMemImpl implements GameDao {
    
    List<Game> games = new ArrayList<>();

    @Override
    public Game getGameByName(String name) {
        for(Game g : games) {
            if(name.equals(g.getName())) {
                return g;
            }
        }
        return null;
    }

    @Override
    public List<Game> getAllGames() {
        return games;
    }

    @Override
    public Game addGame(Game game) {
        games.add(game);
        return game;
    }

    @Override
    public void updateGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGameByName(String name) {
        int index = -1;
        for(int i = 0;i<games.size();i++) {
            if(games.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if(index != -1) {
            games.remove(index);
        }
    }

}
