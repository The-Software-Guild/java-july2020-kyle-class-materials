package com.sg.gametracker.controller;

import com.sg.gametracker.dao.GameDao;
import com.sg.gametracker.dao.GameDaoPersistanceException;
import com.sg.gametracker.dto.Game;
import com.sg.gametracker.service.GameDoesNotExistException;
import com.sg.gametracker.service.GameService;
import com.sg.gametracker.service.InvalidDataException;
import com.sg.gametracker.view.GameView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kyle David Rudy
 */
@Component
public class GameController {

    GameService service;
    GameView view;

    @Autowired
    public GameController(GameService service, GameView view) {        
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.welcomeBanner();

        while (true) {
            int choice = view.displayMenuGetOption();
            try {
                switch (choice) {
                    case 1: //List All
                        List<Game> games = service.getAllGames();
                        view.viewAllGames(games);
                        break;
                    case 2: //View Game
                        break;
                    case 3: //Add Game
                        Game newGame = view.getGameInfo();
                        service.addGame(newGame);
                        view.actionSuccess("added");
                        break;
                    case 4: //Update Game
                        break;
                    case 5: //Delete Game
                        deleteGame();
                        break;
                    case 6: //Exit
                        view.exitTracker();
                        System.exit(0);
                }
            } catch (GameDaoPersistanceException | GameDoesNotExistException | InvalidDataException ex) {
                view.displayError(ex.getMessage());
            }
        }
    }

    public void deleteGame() throws GameDaoPersistanceException, GameDoesNotExistException {
        String name = view.enterGameName("Delete Game");
        Game g = service.getGameByName(name);
        if (g != null) {
            service.deleteGameByName(name);
            view.actionSuccess("deleted");
        } else {
            view.actionFailure("deleted");
        }
    }

}
