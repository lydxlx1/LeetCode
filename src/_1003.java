import java.util.Stack;

/**
 * LeetCode 1003 - Check If Word Is Valid After Substitutions
 *
 * Greedy
 */
public class _1003 {

    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == 'a') {
                stack.push(ch);
            } else if (ch == 'b') {
                if (stack.isEmpty() || stack.peek() != 'a') {
                    return false;
                }
                stack.push('b');
            } else {
                if (stack.isEmpty() || stack.peek() != 'b') {
                    return false;
                }
                stack.pop();
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

