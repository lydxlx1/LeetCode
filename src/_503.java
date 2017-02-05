import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * LeetCode 503 - Next Greater Element II
 * <p>
 * O(n) Solution using a monotone stack
 */
public class _503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] a = new int[n * 2], ans = new int[n * 2];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) a[i] = a[i + n] = nums[i];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) ans[stack.pop()] = a[i];
            stack.push(i);
        }
        return IntStream.of(ans).limit(n).toArray();
    }
}

