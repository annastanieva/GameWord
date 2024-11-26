package generator;

import java.util.Random;

public class GUI implements WordGenerator {
    private String[] words = {
            "собака", "кіт", "восьминіг", "носоріг", "кінь", "орел", "білка",
            "сова", "дельфін", "кашалот", "пінгвін", "скорпіон", "ігуана", "лемур",
            "тигр", "слон", "жирафа", "вовк", "лисиця", "лев", "зебра", "мураха",
            "комар", "кролик", "шакал", "ведмідь", "крокодил", "гепард", "єнот",
            "панда", "бегемот", "змія", "кабан", "лисиця", "черепаха", "оса",
            "шершень", "буйвол", "бобер", "страус", "пелікан", "куниця",
            "козел", "баран"
    };

    private Random random;

    public GUI() {
        random = new Random();
    }

    @Override
    public String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}
