package apple;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConceptFinderTest {
    private ConceptsFinder subject = new ConceptsFinder();

    @Test
    public void search_matches_caseInsensitive() {
        String input = "Where can I find good sushi";

        List<String> actual = subject.search(input);

        assertThat(actual).containsExactly("Sushi");
    }

    @Test
    public void search_matches_ignoresPunctuation() {
        String input = "I, for one, would like some food - thai food! :) ;)";

        List<String> actual = subject.search(input);

        assertThat(actual).containsExactly("Thai");
    }

    @Test
    public void search_no_matches_returnsEmptyList() {
        String input = "Find me a place that does tapas";

        List<String> actual = subject.search(input);

        assertThat(actual).isEmpty();
    }

    @Test
    public void search_whenInputIsEmpty_returnsEmptyList() {
        String input = "";

        List<String> actual = subject.search(input);

        assertThat(actual).isEmpty();
    }

    @Test
    public void search_whenInputIsBlank_returnsEmptyList() {
        String input = "        ";

        List<String> actual = subject.search(input);

        assertThat(actual).isEmpty();
    }

    @Test
    public void search_matches_twoConcepts() {
        String input = "Which restaurants do West Indian food";

        List<String> actual = subject.search(input);

        assertThat(actual).containsExactly("West Indian", "Indian");
    }

    @Test
    public void search_matches_withAnyNumberOfWhitespaces() {
        String input = "Which restaurants        do East    Asian food";

        List<String> actual = subject.search(input);

        assertThat(actual).containsExactly("East Asian");
    }

    @Test
    public void search_matches_conceptsFromDifferentNodes() {
        String input = "Which restaurants do West Indian East Asian or East European food";

        List<String> actual = subject.search(input);

        assertThat(actual).containsExactly("West Indian", "Indian", "East Asian", "East European");
    }

    @Test
    public void search_performanceTest() {
        String input = "Which restaurants do West Indian East Asian or East European food";

        List<String> actual = subject.search(input);

        assertThat(actual).containsExactly("West Indian", "Indian", "East Asian", "East European");
    }
}