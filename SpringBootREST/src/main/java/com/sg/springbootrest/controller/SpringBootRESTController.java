package com.sg.springbootrest.controller;

import com.sg.springbootrest.dto.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kyle David Rudy
 */
@RestController
@RequestMapping("api")
public class SpringBootRESTController {

    
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello " + name;
    }
    
    @PostMapping("/hello")
    public String sayHelloPost() {
        return "Hello Post";
    }
    
    @GetMapping("/cat")
    @ResponseStatus(HttpStatus.FOUND)
    public Cat getCat() {
        return new Cat("Tinny", "B&W", 4);
    }
    
    @GetMapping("/cat2")
    public ResponseEntity<Cat> getCat2() {
        Cat c = new Cat("Smokey", "Gray", 8);
        return new ResponseEntity(c, HttpStatus.I_AM_A_TEAPOT);
    }
    
    @PostMapping("/cat")
    public String postCat(@RequestBody Cat cat) {
        
        return  cat.getName() + " is a " + cat.getColor() + " kitty";
    }
    
    @PostMapping("/stuff")
    public Cat queryParameterCat(Cat cat) {
        return cat;
    }
    
}
