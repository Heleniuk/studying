package implementstrstr;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrStrImplementorTest {
    private StrStrImplementor subject = new StrStrImplementor();

    @Test
    public void strStr_sunnyDay() {
        int actual = subject.strStr("mississippi", "issippi");
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void strStr_whenInputIsAnEmptyString() {
        int actual = subject.strStr("", "");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void strStr_whenInputIsNull() {
        int actual = subject.strStr(null, "");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void strStr_whenNeedleIsLongerThanHaystack() {
        int actual = subject.strStr("o", "ololo");
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void strStr_whenNeedleIsNotPresentInHaystack() {
        int actual = subject.strStr("abcabc", "ac");
        assertThat(actual).isEqualTo(-1);
    }
}