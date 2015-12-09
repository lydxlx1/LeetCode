import java.util.Stack;

/**
 * LeetCode 316 - Remove Duplicate Letters
 *
 * An O(n) solution using stack
 *
 * Inspired by https://leetcode.com/discuss/73824/, this problem can be solved in truly O(n) time via a stack.
 **/
public class _316_1 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inAnswer = new boolean[128];
        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) cnt[ch]++;
        for (char ch : s.toCharArray()) {
            if (!inAnswer[ch]) {
                while(!stack.isEmpty() && ch < stack.peek() && cnt[stack.peek()] > 0) inAnswer[stack.pop()] = false;
                stack.push(ch);
                inAnswer[ch] = true;
            }
            cnt[ch]--;
        }
        StringBuilder builder = new StringBuilder();
        for (char ch : stack) builder.append(ch);
        return builder.toString();
    }
}