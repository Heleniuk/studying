package longestcommonprefix;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LongestCommonPrefixFinderTest {
    private LongestCommonPrefixFinder subject = new LongestCommonPrefixFinder();

    @Test
    public void longestCommonPrefix_whenInputIsEmpty_returnsEmptyString() {
        String actual = subject.longestCommonPrefix(new String[]{});
        assertThat(actual).isEqualTo("");
    }

    @Test
    public void longestCommonPrefix_whenThereIsNoCommonPrefix_returnsEmptyString() {
        String actual = subject.longestCommonPrefix(new String[]{"abs", "def"});
        assertThat(actual).isEqualTo("");
    }

    @Test
    public void longestCommonPrefix_whenThereIsCommonPrefix_returnsIt() {
        String actual = subject.longestCommonPrefix(new String[]{"abcs", "abcdef", "abc"});
        assertThat(actual).isEqualTo("abc");
    }
}