public class Game {
    private String wordToGuess;
    private StringBuilder progress;
    private int attempts;
    private final WordGenerator wordGenerator;
    private final UserInterface userInterface;

    public Game(WordGenerator wordGenerator, UserInterface userInterface) {
        this.wordGenerator = wordGenerator;
        this.userInterface = userInterface;
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
            char letter = userInterface.getUserInput();
            checkLetter(letter);
        }
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
        if (isGameOver()) {
            endGame();
        }
    }

    public boolean isGameOver() {
        return attempts == 0 || progress.toString().equals(wordToGuess);
    }

    private void endGame() {
        if (progress.toString().equals(wordToGuess)) {
            userInterface.displayMessage("Вітаю! Ви виграли ;)");
        } else {
            userInterface.displayMessage("Гра завершена. Ви програли:( Тварина яку ви не вгадали це: " + wordToGuess);
        }
    }
}

