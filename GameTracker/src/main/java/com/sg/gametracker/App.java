package com.sg.gametracker;

import com.sg.gametracker.controller.GameController;
import com.sg.gametracker.dao.GameDao;
import com.sg.gametracker.dao.GameDaoFileImpl;
import com.sg.gametracker.dao.GameDaoMemImpl;
import com.sg.gametracker.service.GameService;
import com.sg.gametracker.view.GameView;
import com.sg.gametracker.view.UserIO;
import com.sg.gametracker.view.UserIOConsoleImpl;

/**
 *
 * @author Kyle David Rudy
 */
public class App {
    public static void main(String[] args) {
        
        UserIO io = new UserIOConsoleImpl();
        GameView view = new GameView(io);
        GameDao dao = new GameDaoMemImpl();
        GameService service = new GameService(dao);
        GameController controller = new GameController(service, view);
        
        controller.run();
    }
}
