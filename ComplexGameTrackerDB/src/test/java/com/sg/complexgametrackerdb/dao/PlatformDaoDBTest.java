/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.complexgametrackerdb.dao;

import com.sg.complexgametrackerdb.TestConfiguration;
import com.sg.complexgametrackerdb.dto.Game;
import com.sg.complexgametrackerdb.dto.Platform;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Kyle David Rudy
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class PlatformDaoDBTest {
    
    @Autowired
    PlatformDao platforms;
    
    @Autowired
    GameDao games;
    
    @Autowired
    PublisherDao publishers;
    
    @Autowired
    JdbcTemplate jdbc;
    
    public PlatformDaoDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jdbc.update("DELETE FROM game_platform");
        jdbc.update("DELETE FROM platform");
        jdbc.update("DELETE FROM game");
        jdbc.update("DELETE FROM publisher");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPlatformById method, of class PlatformDaoDB.
     */
    @Test
    public void testGetPlatformById() {
    }

    /**
     * Test of getAllPlatforms method, of class PlatformDaoDB.
     */
    @Test
    public void testGetAllPlatforms() {
    }

    /**
     * Test of addPlatform method, of class PlatformDaoDB.
     */
    @Test
    public void testAddPlatform() {
    }

    /**
     * Test of updatePlatform method, of class PlatformDaoDB.
     */
    @Test
    public void testUpdatePlatform() {
    }

    /**
     * Test of deletePlatformById method, of class PlatformDaoDB.
     */
    @Test
    public void testDeletePlatformById() {
        Platform p = new Platform();
        p.setPlatform("Test Platform");
        platforms.addPlatform(p);
        
        Game g = new Game();
        g.setName("Test Name");
        g.setGenre("test genre");
        g.setReleaseYear(1980);
//        g.setPlatforms(platforms.getAllPlatforms());
        
        games.addGame(g);
        
        Platform fromDao = platforms.getPlatformById(p.getId());
        
        assertEquals(fromDao, p);
        
        platforms.deletePlatformById(p.getId());
        
        fromDao = platforms.getPlatformById(p.getId());
        
        assertNull(fromDao);
    }
    
}
