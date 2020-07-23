/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametrackerwebservice.dao;

import com.sg.gametrackerwebservice.model.Game;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public interface GameDao {
    Game getGameById(int id) throws GameDaoPersistanceException;
    List<Game> getAllGames() throws GameDaoPersistanceException;
    Game addGame(Game game) throws GameDaoPersistanceException;
    void updateGame(Game game) throws GameDaoPersistanceException;
    void deleteGameById(int id) throws GameDaoPersistanceException;
}
