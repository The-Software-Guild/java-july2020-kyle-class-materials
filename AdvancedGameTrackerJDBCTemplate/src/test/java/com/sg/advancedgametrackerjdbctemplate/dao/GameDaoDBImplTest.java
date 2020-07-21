/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.advancedgametrackerjdbctemplate.dao;

import com.sg.advancedgametrackerjdbctemplate.TestApplicationConfiguration;
import com.sg.advancedgametrackerjdbctemplate.dto.Game;
import com.sg.advancedgametrackerjdbctemplate.dto.Platform;
import com.sg.advancedgametrackerjdbctemplate.dto.Publisher;
import java.util.ArrayList;
import java.util.List;
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
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDaoDBImplTest {
    
    @Autowired
    PublisherDao publishers;
    
    @Autowired
    GameDao games;
    
    @Autowired
    PlatformDao platforms;
    
    @Autowired
    JdbcTemplate jdbc;
    
    public GameDaoDBImplTest() {
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
     * Test of getGameById method, of class GameDaoDBImpl.
     */
    @Test
    public void testAddGetGameById() {
        Platform pl = new Platform(0, "TestPlat");
        pl = platforms.addPlatform(pl);
        Platform pl2 = new Platform(0, "TestPlatAgain");
        pl2 = platforms.addPlatform(pl2);
        
        List<Platform> plList = new ArrayList<>();
        plList.add(pl);
        plList.add(pl2);
        
        Publisher p = new Publisher(0, "TestPub", "TestCountry");
        p = publishers.addPublisher(p);
        
        Game g = new Game(0, "TestName", 1980, "TestGenre", p, plList);
        g = games.addGame(g);
        
        Game fromDao = games.getGameById(g.getId());
        
        assertEquals(fromDao, g);
    }

    /**
     * Test of getAllGames method, of class GameDaoDBImpl.
     */
    @Test
    public void testGetAllGames() {
    }

    /**
     * Test of updateGame method, of class GameDaoDBImpl.
     */
    @Test
    public void testUpdateGame() {
        Platform pl = new Platform(0, "TestPlat");
        pl = platforms.addPlatform(pl);
        Platform pl2 = new Platform(0, "TestPlatAgain");
        pl2 = platforms.addPlatform(pl2);
        
        List<Platform> plList = new ArrayList<>();
        plList.add(pl);
        plList.add(pl2);
        
        Publisher p = new Publisher(0, "TestPub", "TestCountry");
        p = publishers.addPublisher(p);
        
        Game g = new Game(0, "TestName", 1980, "TestGenre", p, plList);
        g = games.addGame(g);
        
        g.setName("UpdatedTestname");
        
        List<Platform> updateList = new ArrayList<>();
        updateList.add(pl2);
        Platform uPl = new Platform(0, "UpdatePlat");
        uPl = platforms.addPlatform(uPl);
        updateList.add(uPl);
        
        g.setPlatforms(updateList);
        
        games.updateGame(g);
        
        Game fromDao = games.getGameById(g.getId());
        assertEquals(fromDao, g);
    }

    /**
     * Test of deleteGameById method, of class GameDaoDBImpl.
     */
    @Test
    public void testDeleteGameById() {
    }
    
}
