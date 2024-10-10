package TicTacToeGame.models;

import TicTacToeGame.factories.BotPlayingStrategyFactory;
import TicTacToeGame.strategies.BotPlayingStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, PlayerType playerType, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, playerType, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStratedy(this.botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
