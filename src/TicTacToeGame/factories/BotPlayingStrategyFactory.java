package TicTacToeGame.factories;

import TicTacToeGame.models.BotDifficultyLevel;
import TicTacToeGame.strategies.BotPlayingStrategy;
import TicTacToeGame.strategies.EasyBotPlayingStrategy;
import TicTacToeGame.strategies.HardBotPlayingStrategy;
import TicTacToeGame.strategies.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStratedy(BotDifficultyLevel botDifficultyLevel) {
            return switch (botDifficultyLevel) {
                case BotDifficultyLevel.EASY -> new EasyBotPlayingStrategy();
                case BotDifficultyLevel.MEDIUM -> new MediumBotPlayingStrategy();
                case BotDifficultyLevel.HARD -> new HardBotPlayingStrategy();
            };
    }

}
