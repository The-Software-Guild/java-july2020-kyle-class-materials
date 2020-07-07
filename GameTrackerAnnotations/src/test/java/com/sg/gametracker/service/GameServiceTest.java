/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametracker.service;

import com.sg.gametracker.dao.GameDaoMock;
import com.sg.gametracker.dto.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */
public class GameServiceTest {

    GameService service;

    public GameServiceTest() {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.getEnvironment().setActiveProfiles("mock");
        appContext.scan("com.sg.gametracker");
        appContext.refresh();
        
        service = appContext.getBean("gameService", GameService.class);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
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
