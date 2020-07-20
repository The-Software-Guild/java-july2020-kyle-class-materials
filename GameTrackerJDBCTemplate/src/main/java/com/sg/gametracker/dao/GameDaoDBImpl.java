package com.sg.gametracker.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sg.gametracker.dto.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kyle David Rudy
 */
@Component
@Profile("db")
public class GameDaoDBImpl implements GameDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Game getGameByName(String name) throws GameDaoPersistanceException {
        try {
            return jdbc.queryForObject("SELECT * FROM game WHERE name = ?", new GameMapper(), name);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() throws GameDaoPersistanceException {
        return jdbc.query("SELECT * FROM game", new GameMapper());
    }

    @Override
    public Game addGame(Game game) throws GameDaoPersistanceException {
        jdbc.update("INSERT INTO game(name, genre, publisher, releaseYear) VALUES(?,?,?,?)",
                game.getName(),
                game.getGenre(),
                game.getPublisher(),
                game.getReleaseYear());
        
        return game;
    }

    @Override
    public void updateGame(Game game) throws GameDaoPersistanceException {
        jdbc.update("UPDATE game SET genre = ?, publisher = ?, releaseYear = ? WHERE name = ?",
                game.getGenre(),
                game.getPublisher(),
                game.getReleaseYear(),
                game.getName());
    }

    @Override
    public void deleteGameByName(String name) throws GameDaoPersistanceException {
        jdbc.update("DELETE FROM game WHERE name = ?", name);
    }

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game g = new Game(rs.getString("name"));
            g.setGenre(rs.getString("genre"));
            g.setPublisher(rs.getString("publisher"));
            g.setReleaseYear(rs.getInt("releaseYear"));

            return g;
        }

    }

}
