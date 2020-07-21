package com.sg.advancedgametrackerjdbctemplate.dao;

import com.sg.advancedgametrackerjdbctemplate.dao.PlatformDaoDBImpl.PlatformMapper;
import com.sg.advancedgametrackerjdbctemplate.dao.PublisherDaoDBImpl.PublisherMapper;
import com.sg.advancedgametrackerjdbctemplate.dto.Game;
import com.sg.advancedgametrackerjdbctemplate.dto.Platform;
import com.sg.advancedgametrackerjdbctemplate.dto.Publisher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kyle David Rudy
 */
@Repository
public class GameDaoDBImpl implements GameDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public Game getGameById(int id) {
        try {
            Game g = jdbc.queryForObject("SELECT * FROM game WHERE id = ?", new GameMapper(), id);
            
            g.setPublisher(getPublisherForGame(id));
            g.setPlatforms(getPlatformsForGame(id));
            
            return g;
        } catch(DataAccessException ex) {
            return null;
        }
        
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = jdbc.query("SELECT * FROM game", new GameMapper());
        for(Game g : games) {
            g.setPublisher(getPublisherForGame(g.getId()));
            g.setPlatforms(getPlatformsForGame(g.getId()));
        }
        return games;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbc.update("INSERT INTO game(name, releaseYear, genre, publisherId) VALUES(?,?,?,?)",
                game.getName(),
                game.getReleaseYear(),
                game.getGenre(),
                game.getPublisher() == null ? null : game.getPublisher().getId());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setId(newId);
        
        associateGameToPlatforms(game);
        
        return game;
    }

    private void associateGameToPlatforms(Game game) throws DataAccessException {
        for(Platform p : game.getPlatforms()) {
            jdbc.update("INSERT INTO game_platform(gameId, platformId) VALUES(?,?)",
                    game.getId(),
                    p.getId());
        }
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
        jdbc.update("UPDATE game SET name = ?, releaseYear = ?, genre = ?, publisherId = ? WHERE Id = ?",
                game.getName(),
                game.getReleaseYear(),
                game.getGenre(),
                game.getPublisher() == null ? null : game.getPublisher().getId(),
                game.getId());
        
        jdbc.update("DELETE FROM game_platform WHERE gameId = ?", game.getId());
        associateGameToPlatforms(game);
        
    }

    @Override
    @Transactional
    public void deleteGameById(int id) {
        jdbc.update("DELETE FROM game_platform WHERE gameId = ?", id);
        jdbc.update("DELETE FROM game WHERE id = ?", id);
    }
    
    
    private Publisher getPublisherForGame(int id) {
        try {
            return jdbc.queryForObject("SELECT p.* FROM publisher p "
                    + "JOIN game g ON p.id = g.publisherId "
                    + "WHERE g.id = ?", new PublisherMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }
    
    private List<Platform> getPlatformsForGame(int id) {
        return jdbc.query("SELECT p.* FROM platform p "
                + "JOIN game_platform gp ON p.id = gp.platformId "
                + "WHERE gp.gameId = ?", new PlatformMapper(), id);
    }
    
    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game g = new Game();
            g.setId(rs.getInt("id"));
            g.setName(rs.getString("name"));
            g.setGenre(rs.getString("genre"));
            g.setReleaseYear(rs.getInt("releaseYear"));
            return g;
        }
        
    }
    
}
