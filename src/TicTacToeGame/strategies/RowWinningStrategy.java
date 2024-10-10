package TicTacToeGame.strategies;

import TicTacToeGame.models.Move;
import TicTacToeGame.models.Player;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Move move, Player player) {
        return false;
    }
}
