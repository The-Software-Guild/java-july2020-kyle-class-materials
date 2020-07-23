package com.sg.gametrackerwebservice.dao;

import com.sg.gametrackerwebservice.model.Game;
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
@Profile("db")
public class GameDaoDbImpl implements GameDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Game getGameById(int id) {
        try {
            return jdbc.queryForObject("SELECT * FROM game WHERE id = ?", new GameMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        return jdbc.query("SELECT * FROM game", new GameMapper());
    }

    @Override
    public Game addGame(Game game) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbc.update((Connection conn) -> {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO game(name, genre, releaseYear) values(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getName());
            ps.setString(2, game.getGenre());
            ps.setInt(3, game.getReleaseYear());
            return ps;
        }, holder);

        game.setId(holder.getKey().intValue());
        return game;
    }

    @Override
    public void updateGame(Game game) {
        jdbc.update("UPDATE game SET name = ?, genre = ?, releaseYear = ? WHERE id = ?",
                game.getName(),
                game.getGenre(),
                game.getReleaseYear(),
                game.getId());
    }

    @Override
    public void deleteGameById(int id) {
        jdbc.update("DELETE FROM game WHERE id = ?", id);
    }

    private final static class GameMapper implements RowMapper<Game> {

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
