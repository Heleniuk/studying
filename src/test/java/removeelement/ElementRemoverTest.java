package removeelement;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

public class ElementRemoverTest {
    private ElementRemover subject = new ElementRemover();

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void removeElement_twoElements() {
        int[] input = {4,5};
        int[] expected = {4};

        int actual = subject.removeElement(input, 5);

        softly.assertThat(actual).isEqualTo(expected.length);
        for (int i = 0; i < expected.length; i++) {
            softly.assertThat(input[i]).isEqualTo(expected[i]);
        }
    }

    @Test
    public void removeElement_twoElementsReverseOrder() {
        int[] input = {4,5};
        int[] expected = {5};

        int actual = subject.removeElement(input, 4);

        softly.assertThat(actual).isEqualTo(expected.length);
        for (int i = 0; i < expected.length; i++) {
            softly.assertThat(input[i]).isEqualTo(expected[i]);
        }
    }

    @Test
    public void removeElement_sunnyDay() {
        int[] input = {0,1,2,2,3,0,4,2};
        int[] expected = {0,1,3,0,4};

        int actual = subject.removeElement(input, 2);

        softly.assertThat(actual).isEqualTo(expected.length);
        softly.assertThat(Arrays.copyOf(input, 5))
                .containsExactlyInAnyOrder(0, 1, 3, 0 ,4);
    }

    @Test
    public void removeElement_allElementsAreRemoved() {
        int[] input = {2,2,2,2,2,2,2,2};

        int actual = subject.removeElement(input, 2);

        softly.assertThat(actual).isEqualTo(0);
    }

    @Test
    public void removeElement_noElementsAreRemoved() {
        int[] input = {1,1,1,1,1,1,1,1};
        int[] expected = {1,1,1,1,1,1,1,1};

        int actual = subject.removeElement(input, 2);

        softly.assertThat(actual).isEqualTo(8);
        softly.assertThat(input).isEqualTo(expected);
    }

    @Test
    public void removeElement_whenInputIsNull_returnsZero() {
        int actual = subject.removeElement(null, 2);

        softly.assertThat(actual).isEqualTo(0);
    }

    @Test
    public void removeElement_whenInputIsEmpty_returnsZero() {
        int actual = subject.removeElement(new int[]{}, 2);

        softly.assertThat(actual).isEqualTo(0);
    }
}