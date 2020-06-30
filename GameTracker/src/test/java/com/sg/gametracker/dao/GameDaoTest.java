/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametracker.dao;

import com.sg.gametracker.dto.Game;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kyle David Rudy
 */
public class GameDaoTest {
    
    GameDao dao;
    
    public GameDaoTest() {
        dao = new GameDaoFileImpl();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws GameDaoPersistanceException {
        List<Game> games = dao.getAllGames();
        for(Game g : games) {
            dao.deleteGameByName(g.getName());
        }
    }
    
    @AfterEach
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
