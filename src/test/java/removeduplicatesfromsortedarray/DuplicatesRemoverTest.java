package removeduplicatesfromsortedarray;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

public class DuplicatesRemoverTest {
    private DuplicatesRemover subject = new DuplicatesRemover();

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void removeDuplicates_sunnyDay() {
        int[] input = {0,0,1,1,1,2,2,3,3,4};
        int expected = 5;

        int actual = subject.removeDuplicates(input);

        softly.assertThat(actual).isEqualTo(expected);
        for (int i = 0; i < expected; i++) {
            softly.assertThat(input[i]).isEqualTo(i);
        }
    }

    @Test
    public void removeDuplicates_noDuplicates() {
        int[] input = {1,2};
        int expected = 2;

        int actual = subject.removeDuplicates(input);

        softly.assertThat(actual).isEqualTo(expected);
        for (int i = 0; i < expected; i++) {
            softly.assertThat(input[i]).isEqualTo(i + 1);
        }
    }

    @Test
    public void removeDuplicates_whenInputIsEmpty_returnsZero() {
        int[] input = {};
        int expected = 0;

        int actual = subject.removeDuplicates(input);

        softly.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void removeDuplicates_whenInputIsNull_returnsZero() {
        int expected = 0;

        int actual = subject.removeDuplicates(null);

        softly.assertThat(actual).isEqualTo(expected);
    }
}