package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//make requests to: http://localhost:8080/game
@RestController
@RequestMapping("game")
public class RequestController {

    @Autowired
    GameService service;

    //handles get requests to getState endpoint
   @GetMapping("getState")
   public Game getState(@RequestParam(name = "id") Long id){
       return service.getGameList().get(id);
   }

    //handles post requests to newGame endpoint
    @PostMapping("newGame")
    @ResponseStatus(code= HttpStatus.CREATED)
    public String newGame(){
        //create new game and return game ID to player (so player can send request to this game ID)
        Game game1=new Game();
        service.addGame(game1);
        return "New game created with ID: "+game1.gameID;
    }

    //handles post requests to newGame endpoint
    @PutMapping("move")
    public void move(@RequestParam(name="id") long gameID, @RequestParam(name="option")int option){
        //get the game with gameID, check if move is okay, edit game, print board
        service.checkMove(gameID,option);
    }
}
