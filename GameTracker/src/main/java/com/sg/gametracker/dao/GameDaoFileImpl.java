package com.sg.gametracker.dao;

import com.sg.gametracker.dto.Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kyle David Rudy
 */
public class GameDaoFileImpl implements GameDao {

    private final String FILENAME = "games.txt";
    private final String DELIMITER = "::";

    List<Game> games = new ArrayList<>();

    //<name>::<genre>::<publisher>::<releaseYear>
    
    @Override
    public Game getGameByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Game> getAllGames() throws GameDaoPersistanceException {
        loadFile();
        return games;
    }

    @Override
    public Game addGame(Game game) throws GameDaoPersistanceException {
        try {
            loadFile();
        } catch(GameDaoPersistanceException ex) {
            //write file will create the file
        }
        games.add(game);
        writeFile();
        
        return game;
    }

    @Override
    public void updateGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGameByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadFile() throws GameDaoPersistanceException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(FILENAME));
        } catch (FileNotFoundException ex) {
            throw new GameDaoPersistanceException("Error loading file");
        }

        games = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String parts[] = line.split(DELIMITER);
            if (parts.length == 4) {
                Game g = new Game();
                g.setName(parts[0]);
                g.setGenre(parts[1]);
                g.setPublisher(parts[2]);
                g.setReleaseYear(Integer.parseInt(parts[3]));

                games.add(g);
            }
        }

        sc.close();
    }

    private void writeFile() throws GameDaoPersistanceException {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File(FILENAME)));
        } catch (IOException ex) {
            throw new GameDaoPersistanceException("Error writing to file");
        }

        for (Game g : games) {
            pw.append(g.getName() + DELIMITER
                    + g.getGenre() + DELIMITER
                    + g.getPublisher() + DELIMITER
                    + g.getReleaseYear() + "\n");
        }
        
        pw.flush();
        pw.close();
    }

}
