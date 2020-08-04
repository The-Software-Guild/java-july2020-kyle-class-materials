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
public class PublisherDaoDBTest {

    @Autowired
    PlatformDao platforms;

    @Autowired
    GameDao games;

    @Autowired
    PublisherDao publishers;

    @Autowired
    JdbcTemplate jdbc;

    public PublisherDaoDBTest() {
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
     * Test of getPublisherById method, of class PublisherDaoDB.
     */
    @Test
    public void testGetPublisherById() {
    }

    /**
     * Test of getAllPublishers method, of class PublisherDaoDB.
     */
    @Test
    public void testGetAllPublishers() {
    }

    /**
     * Test of addPublisher method, of class PublisherDaoDB.
     */
    @Test
    public void testAddPublisher() {
    }

    /**
     * Test of updatePublisher method, of class PublisherDaoDB.
     */
    @Test
    public void testUpdatePublisher() {
    }

    /**
     * Test of deletePublisherById method, of class PublisherDaoDB.
     */
    @Test
    public void testDeletePublisherById() {
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
        
        Publisher fromDao = publishers.getPublisherById(p.getId());
        
        assertEquals(fromDao, p);
        
        publishers.deletePublisherById(p.getId());
        
        fromDao = publishers.getPublisherById(p.getId());
        
        assertNull(fromDao);
        
    }

}
