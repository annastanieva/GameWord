package core;

import player.ComputerPlayer;
import generator.WordGenerator;
import ui.UserInterface;

public class Game {
    private String wordToGuess;
    private StringBuilder progress;
    private int attempts;
    private final WordGenerator wordGenerator;
    private final UserInterface userInterface;

    private boolean isComputerMode = false;
    private ComputerPlayer computerPlayer;

    public Game(WordGenerator wordGenerator, UserInterface userInterface) {
        this.wordGenerator = wordGenerator;
        this.userInterface = userInterface;
    }

    public void enableComputerMode(ComputerPlayer computerPlayer) {
        this.isComputerMode = true;
        this.computerPlayer = computerPlayer;
    }

    public void startGame() {
        wordToGuess = wordGenerator.getRandomWord();
        progress = new StringBuilder("_".repeat(wordToGuess.length()));
        attempts = 7;

        userInterface.displayMessage("""
                Гра почалась! Відгадай слово.
                Правила:
                1. У вас 7 спроб вгадати слово.
                2. За одну спробу можна ввести тільки одну літеру.
                3. Спроб меншає, якщо ви не вгадали літеру.
                Категорія: Тварини
                """);
        playGame();
    }

    private void playGame() {
        while (!isGameOver()) {
            userInterface.displayProgress(progress.toString());
            userInterface.displayMessage("Залишилось спроб: " + attempts);

            char letter;
            if (isComputerMode) {
                letter = computerPlayer.getNextGuess();
                userInterface.displayMessage("Комп'ютер вгадав літеру: " + letter);
            } else {
                letter = userInterface.getUserInput();
            }

            checkLetter(letter);
        }
        endGame();
    }

    public void checkLetter(char letter) {
        boolean correct = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                progress.setCharAt(i, letter);
                correct = true;
            }
        }

        if (!correct) {
            attempts--;
        }
    }

    public boolean isGameOver() {
        return attempts == 0 || progress.toString().equals(wordToGuess);
    }

    private void endGame() {
        if (progress.toString().equals(wordToGuess)) {
            userInterface.displayMessage("Вітаю! Ви виграли ;)");
        } else {
            userInterface.displayMessage("Гра завершена. Ви програли :( Тварина, яку ви не вгадали: " + wordToGuess);
        }
    }

    public String getProgress() {
        return progress.toString();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public boolean getIsGameOver() {
        return isGameOver();
    }
}



