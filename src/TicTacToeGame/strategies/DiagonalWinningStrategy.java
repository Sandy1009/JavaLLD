package TicTacToeGame.strategies;

import TicTacToeGame.models.Move;
import TicTacToeGame.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Move move, Player player) {
        return false;
    }
}
