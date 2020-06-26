package com.sg.gametracker.controller;

import com.sg.gametracker.dao.GameDao;
import com.sg.gametracker.dao.GameDaoPersistanceException;
import com.sg.gametracker.dto.Game;
import com.sg.gametracker.view.GameView;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public class GameController {

    GameDao dao;
    GameView view;

    public GameController(GameDao dao, GameView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        view.welcomeBanner();

        while (true) {
            int choice = view.displayMenuGetOption();
            try {
                switch (choice) {
                    case 1: //List All
                        List<Game> games = dao.getAllGames();
                        view.viewAllGames(games);
                        break;
                    case 2: //View Game
                        break;
                    case 3: //Add Game
                        Game newGame = view.getGameInfo();
                        dao.addGame(newGame);
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
            } catch (GameDaoPersistanceException ex) {
                view.displayError(ex.getMessage());
            }
        }
    }

    public void deleteGame() {
        String name = view.enterGameName("Delete Game");
        Game g = dao.getGameByName(name);
        if (g != null) {
            dao.deleteGameByName(name);
            view.actionSuccess("deleted");
        } else {
            view.actionFailure("deleted");
        }
    }

}
