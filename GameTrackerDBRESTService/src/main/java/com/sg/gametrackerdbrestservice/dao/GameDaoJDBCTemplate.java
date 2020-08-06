package com.sg.gametrackerdbrestservice.dao;

import com.sg.gametrackerdbrestservice.dto.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kyle David Rudy
 */
@Repository
public class GameDaoJDBCTemplate implements GameDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Game getGameById(int id) throws GameDaoPersistanceException {
        try {
            return jdbc.queryForObject("SELECT * FROM game WHERE id = ?", new GameMapper(), id);
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

//        jdbc.update("INSERT INTO game(name, genre, publisher, releaseYear) VALUES(?,?,?,?)",
//                game.getName(),
//                game.getGenre(),
//                game.getPublisher(),
//                game.getReleaseYear());
//        
//        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
//        game.setId(newId);
//        
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbc.update((Connection conn) -> {
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO game(name, genre, publisher, releaseYear) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, game.getName());
            statement.setString(2, game.getGenre());
            statement.setString(3, game.getPublisher());
            statement.setInt(4, game.getReleaseYear());

            return statement;

        }, holder);
        
        game.setId(holder.getKey().intValue());
        

        return game;
    }

    @Override
    public void updateGame(Game game) throws GameDaoPersistanceException {
        jdbc.update("UPDATE game SET name = ?, genre = ?, publisher = ?, releaseYear = ? WHERE id = ?",
                game.getName(),
                game.getGenre(),
                game.getPublisher(),
                game.getReleaseYear(),
                game.getId());
    }

    @Override
    public void deleteGameById(int id) throws GameDaoPersistanceException {
        jdbc.update("DELETE FROM game WHERE id = ?", id);
    }

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game game = new Game(rs.getString("name"));
            game.setId(rs.getInt("id"));
            game.setGenre(rs.getString("genre"));
            game.setPublisher(rs.getString("publisher"));
            game.setReleaseYear(rs.getInt("releaseYear"));
            return game;
        }

    }

}
