/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.complexgametrackerdb.dao;

import com.sg.complexgametrackerdb.dto.Game;
import com.sg.complexgametrackerdb.dto.GamePlatform;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public interface GamePlatformDao {
    GamePlatform getGamePlatformByGameAndPlatformId(int gameId, int platformId);
    List<GamePlatform> getAllGamePlatforms();
    GamePlatform addGamePlatform(Game game, GamePlatform gamePlatform);
    void updateGamePlatform(Game game, GamePlatform gamePlatform);
    void deleteGamePlatformByGameAndPlatformId(int gameId, int platformId);
}
