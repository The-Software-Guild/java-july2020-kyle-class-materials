package com.sg.complexgametrackerdb.dao;

import com.sg.complexgametrackerdb.dto.Platform;
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
public class PlatformDaoDB implements PlatformDao {

    @Autowired
    JdbcTemplate jdbc;
    
    
    @Override
    public Platform getPlatformById(int id) {
        try {
            return jdbc.queryForObject("SELECT * FROM platform WHERE id = ?", new PlatformMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Platform> getAllPlatforms() {
        return jdbc.query("SELECT * FROM platform", new PlatformMapper());
    }

    @Override
    @Transactional
    public Platform addPlatform(Platform platform) {
        jdbc.update("INSERT INTO platform(platform) VALUES(?)",
                platform.getPlatform());
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        platform.setId(newId);
        
        return platform;
    }

    @Override
    public void updatePlatform(Platform platform) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void deletePlatformById(int id) {
        jdbc.update("DELETE FROM game_platform WHERE platformId = ?", id);
        jdbc.update("DELETE FROM platform WHERE id = ?", id);
    }
    
    public final static class PlatformMapper implements RowMapper<Platform> {

        @Override
        public Platform mapRow(ResultSet rs, int i) throws SQLException {
            Platform p = new Platform();
            p.setId(rs.getInt("id"));
            p.setPlatform(rs.getString("platform"));
            return p;
        }
        
    }

}
