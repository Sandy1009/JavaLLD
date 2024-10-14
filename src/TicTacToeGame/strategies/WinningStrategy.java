package TicTacToeGame.strategies;

import TicTacToeGame.models.Board;
import TicTacToeGame.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Move move, Board board);

}
