package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

//Game service that handles the logic
@Service
public class GameService {

    private static AtomicLong gameLong = new AtomicLong();//to create incrementing game ID
    private Map<Long,Game> gameList = new HashMap();//holds the list of games

    //adds new game to list
    public void addGame(Game game){
        if(!gameList.containsValue(game))
            gameList.put(game.gameID, game);
    }

    //main game logic
    public void checkMove(Long gameID, int option){
        Game game = gameList.get(gameID);

        //if game already won or board is full then do nothing
        if(game.state.equals("win"))
            return;
        if(game.state.equals("draw"))
            return;

        //if it's player 1 turn then change symbol to X. If player 2 turn then 0
        if(game.p1Turn)
            game.move="X";
        else
            game.move="0";

        //insert move in board then check for win or full board
        insertMove(gameID,option);
        checkWin(game);
        checkFull(game);
        //switch to next player turn
        game.p1Turn=!game.p1Turn;
    }

    //changes board based on option chosen
    public void insertMove(long gameID, int index){
        Game game = gameList.get(gameID);
        switch (index){
            case 0:
                game.board[0][0]=game.move;
                break;
            case 1:
                game.board[0][1]=game.move;
                break;
            case 2:
                game.board[0][2]=game.move;
                break;
            case 3:
                game.board[1][0]=game.move;
                break;
            case 4:
                game.board[1][1]=game.move;
                break;
            case 5:
                game.board[1][2]=game.move;
                break;
            case 6:
                game.board[2][0]=game.move;
                break;
            case 7:
                game.board[2][1]=game.move;
                break;
            case 8:
                game.board[2][2]=game.move;
                break;
            default:
                break;
        }
    }

    //check if board is full
    public boolean checkFull(Game game){
        if(!Arrays.asList(game.board).contains("_"))
            return true;
        return false;
    }


    public void checkWin(Game game){
        //handles all possible winning positions (there might be more efficient way: check later)
        if((game.board[0][0]==game.move) && (game.board[0][1]==game.move) && (game.board[0][2]==game.move)) //top row
            game.state="win";
        else if((game.board[1][0]==game.move) && (game.board[1][1]==game.move) && (game.board[1][2]==game.move))//middle row
            game.state="win";
        else if((game.board[2][0]==game.move) && (game.board[2][1]==game.move) && (game.board[2][2]==game.move))//last row
            game.state="win";
        else if((game.board[0][0]==game.move) && (game.board[1][0]==game.move) && (game.board[2][0]==game.move))//left column
            game.state="win";
        else if((game.board[0][1]==game.move) && (game.board[1][1]==game.move) && (game.board[1][2]==game.move))//middle column
            game.state="win";
        else if((game.board[0][2]==game.move) && (game.board[1][2]==game.move) && (game.board[2][2]==game.move))//right column
            game.state="win";
        else if((game.board[0][0]==game.move) && (game.board[1][1]==game.move) && (game.board[2][2]==game.move))//left diagonal
            game.state="win";
        else if((game.board[0][2]==game.move) && (game.board[1][1]==game.move) && (game.board[2][0]==game.move))//right diagonal
            game.state="win";
    }

    //creates ID for game and increment count
    public static long createID()
    {
        return gameLong.getAndIncrement();
    }

    //print board for debugging
    public String printBoard(Game game) {
        String answer="";
        for (String[] row: game.board){
            for (String value : row){
                answer+="| "+value+" | ";
            }
            answer+="\n";
        }
        return answer;
    }


    public Map<Long, Game> getGameList() {
        return gameList;
    }
}
