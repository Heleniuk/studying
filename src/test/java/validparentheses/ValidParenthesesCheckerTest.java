package validparentheses;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidParenthesesCheckerTest {
    private ValidParenthesesChecker subject = new ValidParenthesesChecker();

    @Test
    public void isValid_whenInputIsAnEmptyString_returnsTrue() {
        assertThat(subject.isValid("")).isTrue();
    }

    @Test
    public void isValid_whenInputLengthIsAnOddNumber_returnsFalse() {
        assertThat(subject.isValid("{(}")).isFalse();
    }

    @Test
    public void isValid_whenInputIsValid_withSuperposition_returnsTrue() {
        assertThat(subject.isValid("{[{()}]}")).isTrue();
    }

    @Test
    public void isValid_whenInputIsValid_returnsTrue() {
        assertThat(subject.isValid("{}()[]")).isTrue();
    }

    @Test
    public void isValid_whenInputIsInvalid_returnsFalse() {
        assertThat(subject.isValid("([)]")).isFalse();
    }
}