package com.sg.complexgametrackerdb.dao;

import com.sg.complexgametrackerdb.dao.GamePlatformDaoDB.GamePlatformMapper;
import com.sg.complexgametrackerdb.dao.PlatformDaoDB.PlatformMapper;
import com.sg.complexgametrackerdb.dao.PublisherDaoDB.PublisherMapper;
import com.sg.complexgametrackerdb.dto.Game;
import com.sg.complexgametrackerdb.dto.GamePlatform;
import com.sg.complexgametrackerdb.dto.Platform;
import com.sg.complexgametrackerdb.dto.Publisher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class GameDaoDB implements GameDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Game getGameById(int id) {
        try {
            Game g = jdbc.queryForObject("SELECT * FROM game WHERE Id = ?", new GameMapper(), id);

            g.setPublisher(getPublisherForGame(g));
            g.setGamePlatforms(getGamePlatformsForGame(g));
//            g.setPlatforms(getPlatformsForGame(g));

            return g;
        } catch (DataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Game> getAllGames() {
        List<Game> gameList = jdbc.query("SELECT * FROM game", new GameMapper());
        for(Game g : gameList) {
            g.setPublisher(getPublisherForGame(g));
            g.setGamePlatforms(getGamePlatformsForGame(g));
//            g.setPlatforms(getPlatformsForGame(g));
        }
        return gameList;
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
        
        associateGamePlatformsToGame(game);
        
        return game;
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
        jdbc.update("UPDATE game SET name = ?, releaseYear = ?, genre = ?, publisherId = ? "
                + "WHERE id = ?",
                game.getName(),
                game.getReleaseYear(),
                game.getGenre(),
                game.getPublisher() == null ? null : game.getPublisher().getId(),
                game.getId());
        
        jdbc.update("DELETE FROM game_platform WHERE gameId = ?", game.getId());
        associateGamePlatformsToGame(game);
    }

    @Override
    @Transactional
    public void deleteGameById(int id) {
        jdbc.update("DELETE FROM game_platform WHERE gameId = ?", id);
        jdbc.update("DELETE FROM game WHERE id = ?", id);
    }

    private Publisher getPublisherForGame(Game game) {
        try {
            return jdbc.queryForObject("SELECT p.* FROM publisher p "
                    + "JOIN game g ON p.id = g.publisherId "
                    + "WHERE g.id = ?", new PublisherMapper(), game.getId());
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private List<GamePlatform> getGamePlatformsForGame(Game game) {
        List<GamePlatform> gamePlatforms = new ArrayList<>();
        
        List<Integer> platformIds = jdbc.queryForList("SELECT platformId FROM game_platform WHERE gameId = ?", Integer.class, game.getId());
        for(int platformId : platformIds) {
            GamePlatform gp = jdbc.queryForObject("SELECT * FROM game_platform WHERE gameId = ? AND platformId = ?",
                    new GamePlatformMapper(), game.getId(), platformId);
            Platform p = jdbc.queryForObject("SELCT * FROM platform WHERE id = ?", new PlatformMapper(), platformId);
            gp.setPlatform(p);
            gamePlatforms.add(gp);
        }
        return gamePlatforms;
    }
    
//    private List<Platform> getPlatformsForGame(Game game) {
//        return jdbc.query("SELECT p.* FROM platform p "
//                + "JOIN game_platform gp ON p.id = gp.platformId "
//                + "WHERE gp.gameId = ?", new PlatformMapper(), game.getId());
//    }
    
    private void associateGamePlatformsToGame(Game g) {
        for(GamePlatform gp : g.getGamePlatforms()) {
            jdbc.update("INSERT INTO game_platform(gameId, platformId, price) VALUES(?,?,?)",
                    g.getId(),
                    gp.getPlatform().getId(),
                    gp.getPrice());
        }
    }

    @Override
    public List<Game> getAllGamesForPlatform(Platform platform) {
        List<Game> gameList = jdbc.query("SELECT g.* FROM game g "
                + "JOIN game_platform gp ON gp.gameId = g.id "
                + "WHERE gp.platformId = ?", new GameMapper(), platform.getId());
        for(Game g : gameList) {
            g.setPublisher(getPublisherForGame(g));
            g.setGamePlatforms(getGamePlatformsForGame(g));
//            g.setPlatforms(getPlatformsForGame(g));
        }
        
        return gameList;
    }

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game g = new Game();
            g.setId(rs.getInt("id"));
            g.setName(rs.getString("name"));
            g.setReleaseYear(rs.getInt("releaseYear"));
            g.setGenre(rs.getString("genre"));
            return g;
        }

    }

}
