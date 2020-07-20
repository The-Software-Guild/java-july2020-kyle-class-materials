package com.sg.gametracker.app;

import com.sg.gametracker.controller.GameController;
import com.sg.gametracker.dao.GameDao;
import com.sg.gametracker.dao.GameDaoFileImpl;
import com.sg.gametracker.dao.GameDaoMemImpl;
import com.sg.gametracker.service.GameService;
import com.sg.gametracker.view.GameView;
import com.sg.gametracker.view.UserIO;
import com.sg.gametracker.view.UserIOConsoleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */

public class App {

    public static void main(String[] args) {

//        UserIO io = new UserIOConsoleImpl();
//        GameView view = new GameView(io);
//        GameDao dao = new GameDaoMemImpl();
//        GameService service = new GameService(dao);
//        GameController controller = new GameController(service, view);
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        GameController controller = ctx.getBean("controller", GameController.class);
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.getEnvironment().setActiveProfiles("db");
        appContext.scan("com.sg.gametracker");
        appContext.refresh();

        GameController controller = appContext.getBean("gameController", GameController.class);
        controller.run();
    }
}
