package com.sg.gametracker;

import com.sg.gametracker.controller.GameController;
import com.sg.gametracker.dao.GameDao;
import com.sg.gametracker.dao.GameDaoFileImpl;
import com.sg.gametracker.dao.GameDaoMemImpl;
import com.sg.gametracker.service.GameService;
import com.sg.gametracker.view.GameView;
import com.sg.gametracker.view.UserIO;
import com.sg.gametracker.view.UserIOConsoleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */
@SpringBootApplication
public class App implements CommandLineRunner {
    
    @Autowired
    GameController controller;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.run();
    }
}
