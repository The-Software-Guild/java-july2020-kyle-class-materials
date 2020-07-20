package com.sg.gametracker.view;

import com.sg.gametracker.dto.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kyle David Rudy
 */
@Component
public class GameView {
    
    UserIO io;

    @Autowired
    public GameView(UserIO io) {
        this.io = io;
    }
    
    public void welcomeBanner() {
        io.print("Welcome to Kyle's Game Tracker");
    }
    
    public int displayMenuGetOption() {
        io.print("1 - List All Games");
        io.print("2 - View Game");
        io.print("3 - Add Game");
        io.print("4 - Update Game");
        io.print("5 - Delete Game");
        io.print("6 - Exit");
        
        return io.readInt("Select an option:", 1, 6);
    }
    
    public void exitTracker() {
        io.print("Thank you for using the Game Tracker");
    }
    
    public Game getGameInfo() {
        io.print("Enter Game Info");
        String name = io.readString("Enter name:");
        String genre = io.readString("Enter genre:");
        String publisher = io.readString("Enter publisher:");
        int releaseYear = io.readInt("Enter release year:");
        
        return new Game(name, genre, publisher, releaseYear);
    }
    
    public void actionSuccess(String action) {
        io.print(String.format("Game %s successfully", action));
    }
    
    public void actionFailure(String action) {
        io.print(String.format("Game %s not successful", action));
    }
    
    public void viewAllGames(List<Game> games) {
        io.print("Listing all games");
        for(Game g : games) {
            io.print(String.format("%s - %s - %s - %d", g.getName(), g.getGenre(), 
                    g.getPublisher(), g.getReleaseYear()));
        }
    }
    
    public String enterGameName(String banner) {
        io.print(banner);
        return io.readString("Enter the name of the game:");
    }
    
    public void displayError(String error) {
        io.print("ERROR: " +  error);
    }
}














