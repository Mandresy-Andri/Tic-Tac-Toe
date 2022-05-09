package com.example.demo;

import static com.example.demo.GameService.createID;

//Game resource
public class Game {

    String state; //might use enums but need more research
    Long gameID;
    String[][] board;
    Boolean p1Turn;
    String move;//X or 0 depending on whose turn is it


    public Game(){
        this.state="ongoing";
        gameID=createID();
        board = new String[][]{{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
        p1Turn=true;
        move="X";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public Boolean getP1Turn() {
        return p1Turn;
    }

    public void setP1Turn(Boolean p1Turn) {
        this.p1Turn = p1Turn;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
