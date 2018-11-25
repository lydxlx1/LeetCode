import java.util.Stack;

/**
 * LeetCode 946 - Validate Stack Sequences
 *
 * Stack
 */
public class _946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0;
        for (; i < pushed.length; i++) {
            s.push(pushed[i]);
            while (j < popped.length && !s.isEmpty() && popped[j] == s.peek()) {
                s.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}

