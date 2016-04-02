/**
 * LeetCode 214 - Shortest Palindrome
 *
 * O(n) KMP
 *
 * As stated in [1], the problem can also be naturally solved using KMP algorithm.
 * 
 * [1]: https://leetcode.com/discuss/36807/c-8-ms-kmp-based-o-n-time-%26-o-n-memory-solution
 */
public class _214_1 {
    public String shortestPalindrome(String s) {
        String concat = new StringBuilder(s).append('.').append(new StringBuffer(s).reverse()).toString();
        int[] next = new int[concat.length()];
        for (int i = 0, ptr = -1; i < next.length; ptr = next[i], i++) {
            while (ptr > -1 && concat.charAt(ptr + 1) != concat.charAt(i)) ptr = next[ptr];
            next[i] = i > 0 && concat.charAt(ptr + 1) == concat.charAt(i) ? ptr + 1 : -1;
        }
        return new StringBuilder(s.substring(next[next.length - 1] + 1, s.length())).reverse().append(s).toString();
    }
}