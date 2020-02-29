package validparentheses;

import com.google.common.collect.ImmutableMap;

import java.util.LinkedList;
import java.util.Map;

import static java.lang.String.valueOf;

public class ValidParenthesesChecker {
    private static final Map<String, String> PARENTHESES =
            ImmutableMap.of("{", "}",
                    "[", "]",
                    "(", ")");

    public boolean isValid(String input) {
        int length = input.length();
        if (length == 0) {
            return true;
        }
        if (length % 2 == 1) {
            return false;
        }

        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            String current = valueOf(input.charAt(i));
            if (isLeft(current)) {
                stack.push(current);
            } else {
                if (isAMatchingPair(stack.peekFirst(), current)) {
                    stack.pollFirst();
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(String current) {
        return PARENTHESES.keySet().contains(current);
    }

    private boolean isAMatchingPair(String left, String right) {
        String expectedRight = PARENTHESES.get(left);
        return expectedRight != null && expectedRight.equals(right);
    }
}
