/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gametrackerjpa.repositories;

import com.sg.gametrackerjpa.model.Game;
import com.sg.gametrackerjpa.model.Platform;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kyle David Rudy
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{
    List<Game> findByGenre(String genre);
    List<Game> findByGenreAndReleaseYear(String genre, int releaseYear);
    List<Game> findByPlatformsContains(Platform platform);
    Game findByName(String name);
    
    @Query("select g from Game g where g.genre like '%?1'")
    List<Game> findByGenreEndsWith(String suffix);
}
