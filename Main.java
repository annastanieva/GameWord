public class Main {
    public static void main(String[] args) {
        WordGenerator wordGenerator = new GUI();
        UserInterface userInterface = new ConsoleUserInterface();
        Game gameEngine = new Game(wordGenerator, userInterface);
        gameEngine.startGame();
    }
}