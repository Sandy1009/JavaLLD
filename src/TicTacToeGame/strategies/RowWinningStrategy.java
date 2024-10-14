package TicTacToeGame.strategies;

import TicTacToeGame.models.Board;
import TicTacToeGame.models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    private Map<Integer, Map<Character, Integer>> countsMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        if(!countsMap.containsKey(row)) {
            countsMap.put(row, new HashMap<>());
        }

        Map<Character, Integer> rowCounts = countsMap.get(row);

        if(!rowCounts.containsKey(symbol)) {
            rowCounts.put(symbol, 0);
        }

        rowCounts.put(symbol, rowCounts.get(symbol)+1);

        if(rowCounts.get(symbol) == board.getDimension()) {
            return true;
        }

        return false;
    }
}
