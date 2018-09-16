import java.util.Stack;

/**
 * LeetCode 907 - Sum of Subarray Minimums
 *
 * Linear solution using stack
 *
 * First, let's consider an easy version where all elements in A are distinct.
 * Then, for each element A[i], we can compute two values, left[i] and right[i], where
 *
 * - left[i] is the smallest index such that A[j] > A[i], for all left[i] <= j <= i,
 * - right[i] is the largest index such that A[j] > A[i], for all i <= j <= right[i].
 *
 * These can be easily solved by using stacks: scanning from left to right to compute left[.] and scanning from right to left to compute right[.].
 * Then, the answer is clearly sum( A[i] * (i - left[i] + 1) * (right[i] - i + 1) ).
 *
 * But how about the case where A can contain duplicates? Say we might then encounter the following tricky case:
 *
 * 1 10 2 10 10 2 10 10 10 2 10 1
 * For all the 2's in the middle, how should we compute their left and right bounds?
 * Doing ">" for both stacks will miss the subarrays containing more than one 2's.
 * Doing ">=" for both stacks will over-count.
 *
 * The interesting part is if we do exactly one ">" and one ">=", then each subarray will be UNIQUELY charged to either the leftmost or the rightmost 2 that it contains,
 * depending on where we put the equal sign. Hence, we are counting exactly.
 */
public class _907_1 {

    public int sumSubarrayMins(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int mod = 1000000007;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (A.length - 1) : stack.peek() - 1;
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += 1L * A[i] * (i - left[i] + 1) * (right[i] - i + 1);
            ans %= mod;
        }
        return (int) ans;
    }
}

