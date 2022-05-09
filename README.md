# Tic-Tac-Toe

This is a tic tac toe game to get started with backend with Java and Spring Boot.

It is played through requests sent to the local server through postman:

There are 3 operations available:

_Create a new game through POST (http://localhost:8080/game/newGame)

_Load a game state through GET (http://localhost:8080/game/getState?id=)

_Do a move in a game through PUT (http://localhost:8080/game/getState/move?id=ID&option=Option)

With each move, the symbol switches from 0 to X. The game can no longer be modified if the board is full or if there is a winner.
