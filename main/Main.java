package main;

import generator.WordGenerator;
import generator.GUI;
import ui.ConsoleUserInterface;
import core.Game;


public class Main {
    public static void main(String[] args) {
        WordGenerator wordGenerator = new GUI();
        ConsoleUserInterface userInterface = new ConsoleUserInterface();
        Game gameEngine = new Game(wordGenerator, userInterface);
        gameEngine.startGame();
    }
}

