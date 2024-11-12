public class Game {
    private String wordToGuess;
    private StringBuilder progress;
    private int attempts;
    private WordGenerator wordGenerator;
    private UserInterface userInterface;

    public Game() {
        this.wordGenerator = new WordGenerator();
        this.userInterface = new UserInterface();
    }

    public void startGame() {
        wordToGuess = wordGenerator.getRandomWord();
        progress = new StringBuilder("_".repeat(wordToGuess.length()));
        attempts = 7;
        userInterface.displayMessage("Гра почалась! Відгадай слово.\n" +
                "Правила:\n" +
                "1. У вас 7 спроб вгадати слово.\n" +
                "2. За одну спробу можна ввести тільки одну літеру.\n" +
                "3. Спроб меншає, якщо ви не вгадали літеру.\n" +
                "Категорія: Тварини");
        playGame();

    }

    private void playGame() {
        while (!isGameOver()) {
            userInterface.displayProgress(progress.toString());
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
