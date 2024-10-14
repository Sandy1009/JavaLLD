package TicTacToeGame.strategies;

import TicTacToeGame.models.Board;
import TicTacToeGame.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    private Map<Character, Integer> leftDiagonal = new HashMap<>();
    private Map<Character, Integer> rightDiagonal = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        if(row == col) {
            if(!leftDiagonal.containsKey(symbol)) {
                leftDiagonal.put(symbol, 0);
            }
            leftDiagonal.put(symbol, leftDiagonal.get(symbol)+1);

            if(leftDiagonal.get(symbol) == board.getDimension()) {
                return true;
            }
        }

        if(row+col == board.getDimension()-1) {
            if(!rightDiagonal.containsKey(symbol)) {
                rightDiagonal.put(symbol, 0);
            }
            rightDiagonal.put(symbol, rightDiagonal.get(symbol)+1);

            if(rightDiagonal.get(symbol) == board.getDimension()) {
                return true;
            }
        }

        return false;
    }
}
