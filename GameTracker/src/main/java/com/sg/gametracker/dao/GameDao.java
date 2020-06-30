/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametracker.dao;

import com.sg.gametracker.dto.Game;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public interface GameDao {

    Game getGameByName(String name) throws GameDaoPersistanceException;

    List<Game> getAllGames() throws GameDaoPersistanceException;

    Game addGame(Game game) throws GameDaoPersistanceException;

    void updateGame(Game game) throws GameDaoPersistanceException;

    void deleteGameByName(String name) throws GameDaoPersistanceException;
}
