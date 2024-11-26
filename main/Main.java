package main;

import core.Game;
import generator.GUI;
import generator.WordGenerator;
import ui.ConsoleUserInterface;
import player.ComputerPlayer;
import ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordGenerator wordGenerator = new GUI();
        UserInterface userInterface;
        ComputerPlayer computerPlayer = null;

        System.out.println("Оберіть режим гри:");
        System.out.println("1. Людина грає");
        System.out.println("2. Комп'ютер грає");

        int choice = scanner.nextInt();

        if (choice == 1) {
            userInterface = new ConsoleUserInterface();
        } else if (choice == 2) {
            userInterface = new ConsoleUserInterface();
            computerPlayer = new ComputerPlayer();
        } else {
            System.out.println("Такого варіанту вибори не має. Будь ласка перевірте свій вибір");
            return;
        }

        if (choice == 1) {
            Game gameEngine = new Game(wordGenerator, userInterface);
            gameEngine.startGame();
        } else {
            int wins = 0;
            int games = 10;

            for (int i = 0; i < games; i++) {
                Game gameEngine = new Game(wordGenerator, userInterface);
                gameEngine.enableComputerMode(computerPlayer);
                computerPlayer.reset();
                gameEngine.startGame();

                if (gameEngine.getIsGameOver() && gameEngine.getProgress().equals(gameEngine.getWordToGuess())) {
                    wins++;
                }
            }

            userInterface.displayMessage("Комп'ютер виграв " + wins + " з " + games + " ігор.");
        }
    }
}


