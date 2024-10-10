package TicTacToeGame;

import TicTacToeGame.controllers.GameController;
import TicTacToeGame.exceptions.DuplicateSymbolFoundException;
import TicTacToeGame.exceptions.MoreThanOneBotException;
import TicTacToeGame.exceptions.PlayersCountDimensionMismatchException;
import TicTacToeGame.models.*;
import TicTacToeGame.strategies.ColumnWinningStrategy;
import TicTacToeGame.strategies.DiagonalWinningStrategy;
import TicTacToeGame.strategies.RowWinningStrategy;
import TicTacToeGame.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeApplication {

    public static void main(String[] args) throws PlayersCountDimensionMismatchException, MoreThanOneBotException, DuplicateSymbolFoundException {

        int dimension = 3;
        List<Player> players = new ArrayList<>();

        players.add(new Player(1, "Sandy", PlayerType.HUMAN, '#'));
        players.add(new Bot(2, "GPT", PlayerType.BOT, '&', BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategyList = new ArrayList<>();
        winningStrategyList.add(new RowWinningStrategy());
        winningStrategyList.add(new ColumnWinningStrategy());
        winningStrategyList.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.startGame(dimension, players, winningStrategyList);
        gameController.print(game);

    }

}
