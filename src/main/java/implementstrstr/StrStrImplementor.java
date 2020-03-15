package implementstrstr;

public class StrStrImplementor {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        outer: for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (!(haystack.charAt(i + j) == needle.charAt(j))) {
                    continue outer;
                }
            }
            return i;
        }

        return -1;
    }
}
