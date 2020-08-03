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
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kyle David Rudy
 */
@Repository
@Profile("jdbc")
public class GameDaoJDBC implements GameDao {

    @Override
    public Game getGameByName(String name) throws GameDaoPersistanceException {
        try ( Connection conn = getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM game WHERE id = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.getFetchSize() == 1) {
                rs.next();
                Game game = new Game(rs.getString("name"));
                game.setGenre(rs.getString("genre"));
                game.setPublisher(rs.getString("publisher"));
                game.setReleaseYear(rs.getInt("releaseYear"));
                return game;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new GameDaoPersistanceException(ex.getMessage());
        }
    }

    @Override
    public List<Game> getAllGames() throws GameDaoPersistanceException {
        try ( Connection conn = getDataSource().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM game");

            List<Game> games = new ArrayList<>();
            while (rs.next()) {
                Game game = new Game(rs.getString("name"));
                game.setGenre(rs.getString("genre"));
                game.setPublisher(rs.getString("publisher"));
                game.setReleaseYear(rs.getInt("releaseYear"));
                games.add(game);
            }
            return games;

        } catch (SQLException ex) {
            throw new GameDaoPersistanceException(ex.getMessage());
        }
    }

    @Override
    public Game addGame(Game game) throws GameDaoPersistanceException {
        try ( Connection conn = getDataSource().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO game(name, genre, publisher, releaseYear) VALUES(?,?,?,?)");
            ps.setString(1, game.getName());
            ps.setString(2, game.getGenre());
            ps.setString(3, game.getPublisher());
            ps.setInt(4, game.getReleaseYear());
            ps.executeUpdate();
            
            return game;
        } catch (SQLException ex) {
            throw new GameDaoPersistanceException(ex.getMessage());
        }
    }

    @Override
    public void updateGame(Game game) throws GameDaoPersistanceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGameByName(String name) throws GameDaoPersistanceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static DataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("gamedb");
        ds.setUser("root");
        ds.setPassword("rootroot");

        ds.setServerTimezone("UTC");
        ds.setUseSSL(false);
        ds.setAllowPublicKeyRetrieval(true);

        return ds;
    }

}
