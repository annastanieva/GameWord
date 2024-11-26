package player;

import java.util.HashSet;
import java.util.Random;

public class ComputerPlayer {
    private final Random random = new Random();
    private final HashSet<Character> guessedLetters = new HashSet<>();
    private final String alphabet = "абвгґдежзийклмнопрстуфхцчшщьюя";

    public char getNextGuess() {
        char guess;
        do {
            guess = alphabet.charAt(random.nextInt(alphabet.length()));
        } while (guessedLetters.contains(guess));
        guessedLetters.add(guess);
        return guess;
    }

    public void reset() {
        guessedLetters.clear();
    }
}

