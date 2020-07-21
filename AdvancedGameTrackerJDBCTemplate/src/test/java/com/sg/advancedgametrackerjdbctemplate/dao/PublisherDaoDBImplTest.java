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
public class PublisherDaoDBImplTest {
    
    @Autowired
    PublisherDao publishers;
    
    @Autowired
    GameDao games;
    
    @Autowired
    PlatformDao platforms;
    
    @Autowired
    JdbcTemplate jdbc;
    
    public PublisherDaoDBImplTest() {
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
     * Test of getPublisherById method, of class PublisherDaoDBImpl.
     */
    @Test
    public void testAddGetPublisherById() {
        
        Publisher p = new Publisher(0, "TestPublisher", "TestCountry");
        p = publishers.addPublisher(p);
        
        Publisher fromDao = publishers.getPublisherById(p.getId());
        
        assertEquals(p, fromDao);
        
    }

    /**
     * Test of getAllPublishers method, of class PublisherDaoDBImpl.
     */
    @Test
    public void testGetAllPublishers() {
    }

    /**
     * Test of updatePublisher method, of class PublisherDaoDBImpl.
     */
    @Test
    public void testUpdatePublisher() {
    }

    /**
     * Test of deletePublisherById method, of class PublisherDaoDBImpl.
     */
    @Test
    public void testDeletePublisherById() {
        Platform pl = new Platform(0, "TestPlat");
        pl = platforms.addPlatform(pl);
        
        List<Platform> plList = new ArrayList<>();
        plList.add(pl);
        
        Publisher p = new Publisher(0, "TestPub", "TestCountry");
        p = publishers.addPublisher(p);
        
        Game g = new Game(0, "TestName", 1980, "TestGenre", p, plList);
        g = games.addGame(g);
        
        publishers.deletePublisherById(p.getId());
        
        Publisher fromDao = publishers.getPublisherById(p.getId());
        
        assertNull(fromDao);
    }
    
}
