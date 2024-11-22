import java.util.Random;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private Scanner scanner;

    public ConsoleUserInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public char getUserInput() {
        displayMessage("Введіть літеру:");
        String input = scanner.nextLine();
        return input.length() > 0 ? input.charAt(0) : '\0';
    }

    @Override
    public void displayProgress(String progress) {
        System.out.println("Поточний прогрес: " + progress);
    }
}
