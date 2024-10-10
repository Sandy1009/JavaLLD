package TicTacToeGame.models;

import TicTacToeGame.exceptions.DuplicateSymbolFoundException;
import TicTacToeGame.exceptions.MoreThanOneBotException;
import TicTacToeGame.exceptions.PlayersCountDimensionMismatchException;
import TicTacToeGame.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private  List<Player> players;
    private Board board;
    private int nextPlayerIndex;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategyList;
    private Player winner;

    public Game(List<Player> players, int dimension, List<WinningStrategy> winningStrategyList) {
        this.players = players;
        this.board = new Board(dimension);
        this.winningStrategyList = winningStrategyList;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameStatus = GameStatus.INPROGRESS;
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public void print() {
        board.printBoard();
    }

    public static class GameBuilder {
        private  List<Player> players;
        private int dimension;
        private List<WinningStrategy> winningStrategyList;

        private GameBuilder() {
            this.players = new ArrayList<>();
            this.dimension = 0;
            this.winningStrategyList = new ArrayList<>();
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        public Game build() throws PlayersCountDimensionMismatchException, MoreThanOneBotException, DuplicateSymbolFoundException {
            validateUniqueSymbolsForPlayers();
            validateBotCount();
            validateNumberOfPlayers();
            return new Game(players, dimension, winningStrategyList);
        }

        private void validateNumberOfPlayers() throws PlayersCountDimensionMismatchException {
            if(players != null && players.size() != dimension-1) {
                throw new PlayersCountDimensionMismatchException();
            }
        }

        private void validateBotCount() throws MoreThanOneBotException {
            int botCount = 0;

            for(Player player : players) {
                if(PlayerType.BOT.equals(player.getPlayerType())) {
                    botCount++;
                }
            }

            if(botCount > 1) {
                throw new MoreThanOneBotException();
            }
        }

        private void validateUniqueSymbolsForPlayers() throws DuplicateSymbolFoundException {
            Set<Character> set = new HashSet<>();

            for(Player player : players) {
                if(set.contains(player.getSymbol())) {
                    throw new DuplicateSymbolFoundException();
                }
                set.add(player.getSymbol());
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
