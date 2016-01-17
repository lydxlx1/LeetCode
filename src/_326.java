/**
 * LeetCode 326 - Power of Three
 *
 * O(log log n)
 *
 * See below for an interesting discussion about this topic.
 * https://leetcode.com/discuss/78698/let-us-discuss-when-is-unbounded-and-can-be-arbitrarily-large
 */
public class _326 {
    public boolean isPowerOfThree(int n) {
        long a = 3;
        for (; a < n; a *= a);
        return n > 0 && a % n == 0;
    }
}