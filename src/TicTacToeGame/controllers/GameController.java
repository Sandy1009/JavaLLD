package TicTacToeGame.controllers;

import TicTacToeGame.exceptions.DuplicateSymbolFoundException;
import TicTacToeGame.exceptions.MoreThanOneBotException;
import TicTacToeGame.exceptions.PlayersCountDimensionMismatchException;
import TicTacToeGame.models.Game;
import TicTacToeGame.models.Player;
import TicTacToeGame.strategies.WinningStrategy;

import java.util.List;

public class GameController {

    /*
    Steps involved are:
    -  start/create the game -> enter all the details required
    -  makeMove() -> user will enter the location
    -  displayBoard()
    -  checkStatus() -> check if someone has won or not

    -  undo()
    -  getWinner() -> display the name if someone has won
     */

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategyList) throws PlayersCountDimensionMismatchException, MoreThanOneBotException, DuplicateSymbolFoundException {
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategyList(winningStrategyList)
                .build();
    }

    public void print(Game game) {
        game.print();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }


}
