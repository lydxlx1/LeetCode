import java.util.Stack;

/**
 * LeetCode 1047 - Remove All Adjacent Duplicates In String
 *
 * Brute-force
 */
public class _1047 {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder builder = new StringBuilder("");
        for (char ch : stack) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
