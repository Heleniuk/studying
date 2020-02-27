package romantointeger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanToIntegerConverterTest {
    private RomanToIntegerConverter subject = new RomanToIntegerConverter();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void convert_whenARomanNumberIsDirectlyMapped_returnsIt() {
        int actual = subject.convert("I");
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void convert_whenALowerLetterFollowsAHigherOne_addsIt() {
        int actual = subject.convert("XXVII");
        int expected = 27;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void convert_whenALowerLetterPrecedesAHigherOne_subtractsIt() {
        int actual = subject.convert("IX");
        int expected = 9;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void convert_mixedCase() {
        int actual = subject.convert("MCMXCIV");
        int expected = 1994;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void convert_whenRomanNumberIsInvalid_throwsException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input does not belong to Roman numbers");
        subject.convert("MCMXCIM");
    }

    @Test
    public void convert_whenOneOfTheSymbolsIsInvalid_throwsException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Symbol A does not belong to Roman numbers");
        subject.convert("MCMACIV");
    }
}