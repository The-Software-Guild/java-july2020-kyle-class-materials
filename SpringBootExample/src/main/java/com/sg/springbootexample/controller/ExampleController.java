package com.sg.springbootexample.controller;


import com.sg.springbootexample.model.Game;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kyle David Rudy
 */
@RestController
public class ExampleController {

    
    @GetMapping("hi")
    public String sayHi(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "hi " + name;
    }
    
    @GetMapping("game")
    public Game getGame() {
        return new Game(1, "Mario", "Platformer", 1983);
    }
    
    @PostMapping("game")
    public ResponseEntity sendGame(@RequestBody Game game) {
        if(game.getName().isBlank()) {
            return new ResponseEntity(new Error("Name is blank"), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return ResponseEntity.ok(game);
    }
    
    @PostMapping("hi")
    public String postHi() {
        return "hi2";
    }
    
    @DeleteMapping("hi")
    public String words() {
        return "words";
    }
}
