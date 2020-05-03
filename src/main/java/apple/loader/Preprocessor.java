package apple.loader;

import static apple.REGEX.NON_ALPHABETIC;
import static apple.REGEX.WHITESPACES;

public class Preprocessor {
    public String[] prepare(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string is not supposed to be null");
        }
        input = input.replaceAll(NON_ALPHABETIC, " ");
        return input.split(WHITESPACES);
    }
}
