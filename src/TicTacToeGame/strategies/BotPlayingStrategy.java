package TicTacToeGame.strategies;

import TicTacToeGame.models.Board;
import TicTacToeGame.models.Cell;

public interface BotPlayingStrategy {

     Cell makeMove(Board board);

}
