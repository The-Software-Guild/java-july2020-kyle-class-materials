package com.sg.complexgametrackerdb.dao;

import com.sg.complexgametrackerdb.dao.PlatformDaoDB.PlatformMapper;
import com.sg.complexgametrackerdb.dto.Game;
import com.sg.complexgametrackerdb.dto.GamePlatform;
import com.sg.complexgametrackerdb.dto.Platform;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kyle David Rudy
 */
@Repository
public class GamePlatformDaoDB implements GamePlatformDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public GamePlatform getGamePlatformByGameAndPlatformId(int gameId, int platformId) {
        try {
            GamePlatform gp = jdbc.queryForObject("SELECT * FROM game_platform WHERE gameId = ? AND platformId = ?", 
                    new GamePlatformMapper(), gameId, platformId);

            gp.setPlatform(getPlatformForGamePlatform(platformId));

            return gp;
        } catch(DataAccessException ex) {
            return null;
        }
    }
    
    private Platform getPlatformForGamePlatform(int platformId) {
        return jdbc.queryForObject("SELECT * FROM platform WHERE id = ?", new PlatformMapper(), platformId);
    }

    @Override
    public List<GamePlatform> getAllGamePlatforms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GamePlatform addGamePlatform(Game game, GamePlatform gamePlatform) {
        jdbc.update("INSERT INTO game_platform(gameId, platformId, price) VALUES(?,?,?)",
                game.getId(),
                gamePlatform.getPlatform().getId(),
                gamePlatform.getPrice());
        
        return gamePlatform;
    }

    @Override
    public void updateGamePlatform(Game game, GamePlatform gamePlatform) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGamePlatformByGameAndPlatformId(int gameId, int platformId) {
        jdbc.update("DELETE FROM game_platform WHERE gameId = ? AND platformId = ?", gameId, platformId);
    }
    
    public static final class GamePlatformMapper implements RowMapper<GamePlatform> {

        @Override
        public GamePlatform mapRow(ResultSet rs, int i) throws SQLException {
            GamePlatform gp = new GamePlatform();
            gp.setPrice(rs.getBigDecimal("price"));
            return gp;
        }
        
    }

}
