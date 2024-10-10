package TicTacToeGame.strategies;

import TicTacToeGame.models.Move;
import TicTacToeGame.models.Player;

public interface WinningStrategy {

    boolean checkWinner(Move move, Player player);

}
