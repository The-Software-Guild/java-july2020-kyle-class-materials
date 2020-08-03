/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametracker.service;

import com.sg.gametracker.TestConfiguration;
import com.sg.gametracker.dao.GameDaoMock;
import com.sg.gametracker.dto.Game;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Kyle David Rudy
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("mock")
public class GameServiceTest {

    @Autowired
    GameService service;

    public GameServiceTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getGameByName method, of class GameService.
     */
    @Test
    public void testGetGameByName() throws Exception {
        try {
            service.getGameByName("Valid");
        } catch (GameDoesNotExistException ex) {
            fail();
        }

        try {
            service.getGameByName("null");
            fail();
        } catch (GameDoesNotExistException ex) {

        }

    }

    /**
     * Test of addGame method, of class GameService.
     */
    @Test
    public void testAddGame() throws Exception {
        try {
            service.addGame(new Game("Good Game", "Good", "Good", 1980));
        } catch (InvalidDataException ex) {
            fail();
        }

        try {
            service.addGame(new Game(null, "Null", "Null", 1980));
            fail("Should fail on null");
        } catch (InvalidDataException ex) {

        }

        try {
            service.addGame(new Game("", "Empty", "Empty", 1980));
            fail("Should fail on empty string");
        } catch (InvalidDataException ex) {

        }

        try {
            service.addGame(new Game("    ", "Spaces", "Spaces", 1980));
            fail("Should fail on only blank space");
        } catch (InvalidDataException ex) {

        }
    }

    /**
     * Test of updateGame method, of class GameService.
     */
    @Test
    public void testUpdateGame() throws Exception {
    }

    /**
     * Test of deleteGameByName method, of class GameService.
     */
    @Test
    public void testDeleteGameByName() throws Exception {
    }

}
