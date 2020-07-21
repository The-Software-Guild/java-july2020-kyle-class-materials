package com.sg.advancedgametrackerjdbctemplate.dao;

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
public class PublisherDaoDBImpl implements PublisherDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Publisher getPublisherById(int id) {
        try {
            return jdbc.queryForObject("SELECT * FROM publisher WHERE id = ?", new PublisherMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbc.query("SELECT * FROM publisher", new PublisherMapper());
    }

    @Override
    @Transactional
    public Publisher addPublisher(Publisher publisher) {
        jdbc.update("INSERT INTO publisher(publisher, country) VALUES(?,?)",
                publisher.getPublisher(),
                publisher.getCountry());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        publisher.setId(newId);
        return publisher;
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePublisherById(int id) {
//        jdbc.update("DELETE gp.* FROM game_platform gp "
//                + "JOIN game g ON gp.gameId = g.id "
//                + "WHERE g.publisherId = ?", id);
//        jdbc.update("DELETE FROM game WHERE publisherId = ?", id);
        jdbc.update("UPDATE game SET publisherId = null WHERE publisherId = ?", id);
        jdbc.update("DELETE FROM publisher WHERE Id = ?", id);
    }

    public static final class PublisherMapper implements RowMapper<Publisher> {

        @Override
        public Publisher mapRow(ResultSet rs, int i) throws SQLException {
            Publisher p = new Publisher();
            p.setId(rs.getInt("id"));
            p.setPublisher(rs.getString("publisher"));
            p.setCountry(rs.getString("country"));
            return p;
        }

    }

}
