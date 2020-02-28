package longestcommonprefix;

public class LongestCommonPrefixFinder {

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        String result = findShortest(strings);

        for (int i = result.length(); i > 0; i--) {
            for (String string : strings) {
                if (!string.startsWith(result)) {
                    result = result.substring(0, i - 1);
                    break;
                }
            }
        }
        return result;
    }

    private String findShortest(String[] strings) {
        int minLength = strings[0].length();
        String result = strings[0];
        for (String string : strings) {
            if (string.length() < minLength) {
                minLength = string.length();
                result = string;
            }
        }
        return result;
    }
}
