package apple.loader;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PreprocessorTest {
    private Preprocessor subject = new Preprocessor();
    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void prepare_removesSpecialCharacters() {
        punctuationCharacters().forEach(punctuation -> {
            String input = String.format("I would like%s some thai food", punctuation);

            String[] actual = subject.prepare(input);

            softly.assertThat(actual).containsExactly("I", "would", "like", "some", "thai", "food");
        });
    }

    private static List<String> punctuationCharacters() {
        return Arrays.asList(",", ";", ":", "-", "!", ".", "(", ")", "[", "]", "?");
    }

    @Test
    public void prepare_splitsByAnyNumberOfWhitespaces() {
        String input = "Which restaurants        do East    Asian food";

        String[] actual = subject.prepare(input);

        assertThat(actual).containsExactly("Which", "restaurants", "do", "East", "Asian", "food");
    }

    @Test
    public void prepare_whenInputIsNull_throwsException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input string is not supposed to be null");
        subject.prepare(null);
    }
}