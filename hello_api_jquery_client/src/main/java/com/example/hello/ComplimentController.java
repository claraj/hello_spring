package com.example.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by clara on 4/5/18.
 */

@RestController
public class ComplimentController {
    
    private Compliment[] compliments = {
            new Compliment("You look nice today"),
            new Compliment("Your code is awesome!"),
            new Compliment("I'm so happy to see you!"),
            new Compliment("I hope you have a great day!"),
            new Compliment("Super fun to code with you!")
    };
    
    private Random rnd = new Random();
    
    
    @RequestMapping("/random")
    ResponseEntity<Compliment> randomCompliment() {
      Compliment randomCompliment = compliments[rnd.nextInt(compliments.length)];
      return new ResponseEntity<>(randomCompliment, HttpStatus.OK);
    }
    
}
