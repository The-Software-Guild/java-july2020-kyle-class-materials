/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.advancedgametrackerjdbctemplate.dao;

import com.sg.advancedgametrackerjdbctemplate.dto.Game;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public interface GameDao {
    Game getGameById(int id);
    List<Game> getAllGames();
    Game addGame(Game game);
    void updateGame(Game game);
    void deleteGameById(int id);
}
