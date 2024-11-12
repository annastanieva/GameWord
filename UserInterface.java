import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public char getUserInput() {
        displayMessage("Введіть літеру:");
        String input = scanner.nextLine();
        return input.length() > 0 ? input.charAt(0) : '\0';
    }

    public void displayProgress(String progress) {
        System.out.println("Поточний прогрес: " + progress);
    }
}
