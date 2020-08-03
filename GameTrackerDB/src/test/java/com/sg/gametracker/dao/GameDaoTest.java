/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametracker.dao;

import com.sg.gametracker.App;
import com.sg.gametracker.TestConfiguration;
import com.sg.gametracker.dto.Game;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Kyle David Rudy
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("jdbctemplate")
public class GameDaoTest {
    
    @Autowired
    GameDao dao;
    
    @Autowired
    JdbcTemplate jdbc;
    
    public GameDaoTest() {

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws GameDaoPersistanceException {
//        List<Game> games = dao.getAllGames();
//        for(Game g : games) {
//            dao.deleteGameByName(g.getName());
//        }
        jdbc.update("DELETE FROM game");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGameByName method, of class GameDaoMemImpl.
     */
    @Test
    public void testAddAndGetGameByName() throws GameDaoPersistanceException {
        Game g = new Game("Test", "TestGenre", "TestPublisher", 1980);
        dao.addGame(g);
        
        Game fromDao = dao.getGameByName(g.getName());
        
        assertEquals(g, fromDao);
                
    }

    /**
     * Test of getAllGames method, of class GameDaoMemImpl.
     */
    @Test
    public void testGetAllGames() throws GameDaoPersistanceException {
        //retrieve multiple games from system and verify all are in retrieved list
        Game g = new Game("Test", "TestGenre", "TestPub", 1980);
        Game g2 = new Game("Test2", "TestGenre2", "TestPub2", 1981);
        
        dao.addGame(g);
        dao.addGame(g2);
        
        List<Game> gameList = dao.getAllGames();
        
        assertEquals(2, gameList.size());
        assertTrue(gameList.contains(g));
        assertTrue(gameList.contains(g2));
        
    }

    /**
     * Test of updateGame method, of class GameDaoMemImpl.
     */
    @Test
    public void testUpdateGame() throws GameDaoPersistanceException {
        //change game in system. retrieve and verify changes
        Game g = new Game("Test", "TestGenre", "TestPublisher", 1980);
        dao.addGame(g);
        
        Game fromDao = dao.getGameByName(g.getName());
        
        assertEquals(g, fromDao);
        
        g.setGenre("TestGenreChange");
        
        dao.updateGame(g);
        
        assertNotEquals(g, fromDao);
        
        fromDao = dao.getGameByName(g.getName());
        
        assertEquals(g, fromDao);
        
    }

    /**
     * Test of deleteGameByName method, of class GameDaoMemImpl.
     */
    @Test
    public void testDeleteGameByName() throws GameDaoPersistanceException {
        //remove game from system. verify it doesn't exist any longer
        Game g = new Game("Test", "TestGenre", "TestPublisher", 1980);
        dao.addGame(g);
        
        Game fromDao = dao.getGameByName(g.getName());
        
        assertEquals(g, fromDao);
        
        dao.deleteGameByName(g.getName());
        
        assertNull(dao.getGameByName(g.getName()));
        
    }
    
}
