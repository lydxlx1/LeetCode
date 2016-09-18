import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 402 - Remove K Digits
 *
 * Greey + Monotone Stack
 */
public class _402 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        List<Character> stack = new ArrayList<>();
        k = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(i) < stack.get(stack.size() - 1) && num.length() - i + stack.size() - 1 >= k)
                stack.remove(stack.size() - 1);
            stack.add(num.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) builder.append(stack.get(i));
        String ans = builder.toString().replaceFirst("^0+", ""); // remove leading zeros
        return ans.length() == 0 ? "0" : ans; // if that is number is 0, we should print 0
    }
}