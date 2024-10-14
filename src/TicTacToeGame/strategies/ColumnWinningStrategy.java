package TicTacToeGame.strategies;

import TicTacToeGame.models.Board;
import TicTacToeGame.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {

    private Map<Integer, Map<Character, Integer>> countsMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        if(!countsMap.containsKey(col)) {
            countsMap.put(col, new HashMap<>());
        }

        Map<Character, Integer> colMap = countsMap.get(col);

        if(!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0);
        }

        colMap.put(symbol, colMap.get(symbol)+1);

        if(colMap.get(symbol) == board.getDimension()) {
            return true;
        }

        return false;
    }
}
