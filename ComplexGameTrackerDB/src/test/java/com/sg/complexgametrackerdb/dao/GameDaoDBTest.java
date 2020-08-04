/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.complexgametrackerdb.dao;

import com.sg.complexgametrackerdb.TestConfiguration;
import com.sg.complexgametrackerdb.dto.Game;
import com.sg.complexgametrackerdb.dto.Platform;
import com.sg.complexgametrackerdb.dto.Publisher;
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
public class GameDaoDBTest {

    @Autowired
    PlatformDao platforms;

    @Autowired
    GameDao games;

    @Autowired
    PublisherDao publishers;

    @Autowired
    JdbcTemplate jdbc;

    public GameDaoDBTest() {
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
     * Test of getGameById method, of class GameDaoDB.
     */
    @Test
    public void testGetGameById() {
    }

    /**
     * Test of getAllGames method, of class GameDaoDB.
     */
    @Test
    public void testGetAllGames() {
    }

    /**
     * Test of addGame method, of class GameDaoDB.
     */
    @Test
    public void testAddGame() {
    }

    /**
     * Test of updateGame method, of class GameDaoDB.
     */
    @Test
    public void testUpdateGame() {
        Publisher p = new Publisher();
        p.setPublisher("Test Pub");
        p.setCountry("Test Country");
        p = publishers.addPublisher(p);
        
        Platform plat = new Platform();
        plat.setPlatform("Test Plat");
        plat = platforms.addPlatform(plat);
        
        Game g = new Game();
        g.setName("Test Game");
        g.setGenre("Test genre");
        g.setReleaseYear(1980);
        g.setPublisher(p);
        g.setPlatforms(platforms.getAllPlatforms());
        g = games.addGame(g);
        
        Game fromDao = games.getGameById(g.getId());
        
        assertEquals(fromDao, g);
        
        g.setName("Test Game 2");
        
        Platform plat2 = new Platform();
        plat2.setPlatform("Test Plat Again");
        plat2 = platforms.addPlatform(plat2);
        
        g.setPlatforms(platforms.getAllPlatforms());
        
        games.updateGame(g);
        
        fromDao = games.getGameById(g.getId());
        
        assertEquals(fromDao, g);
    }

    /**
     * Test of deleteGameById method, of class GameDaoDB.
     */
    @Test
    public void testDeleteGameById() {
    }

}
