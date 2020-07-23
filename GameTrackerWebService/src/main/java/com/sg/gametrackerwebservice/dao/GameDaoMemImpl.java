package com.sg.gametrackerwebservice.dao;

import com.sg.gametrackerwebservice.model.Game;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kyle David Rudy
 */
@Repository
@Profile("mem")
public class GameDaoMemImpl implements GameDao {
    
    List<Game> games = new ArrayList<>();

    @Override
    public Game getGameById(int id) {
        for(Game g : games) {
            if(g.getId() == id) {
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
        int id = games.stream().mapToInt(g -> g.getId()).max().orElse(0) + 1;
        game.setId(id);
        games.add(game);
        return game;
    }

    @Override
    public void updateGame(Game game) {
        int index = -1;
        for(int i = 0;i<games.size();i++) {
            if(games.get(i).getId() == game.getId()) {
                index = i;
            }
        }
        if(index != -1) {
            games.remove(index);
            games.add(index, game);
        }
    }

    @Override
    public void deleteGameById(int id) {
        int index = -1;
        for(int i = 0;i<games.size();i++) {
            if(games.get(i).getId() == id) {
                index = i;
            }
        }
        if(index != -1) {
            games.remove(index);
        }
    }

}
