/**
 * LeetCode 214 - Shortest Palindrome
 *
 * O(n) Rabin-Karp rolling hash
 *
 * This problem is indeed computing the longest palindromic prefix of a string s.
 * A naive approach would be computing all the prefixes of s and its reverse, and
 * then finding the longest pair of prefixes that are equal.
 *
 * Unfortunately, this method requires quadratic time and space since
 * the length sum of all prefixes is 1+2+...+|s| = Theta(|s|^2).
 *
 * Via the help of the Rolling Hash method, the above process can be optimized down to linear time.
 * For more details, you can visit [1] and [2].
 *
 * [1] https://en.wikipedia.org/wiki/Rolling_hash
 * [2] http://courses.csail.mit.edu/6.006/spring11/rec/rec06.pdf
 */
public class _214 {
    public String shortestPalindrome(String s) {
        int n = s.length(), pos = -1;
        long B = 29, MOD = 1000000007, POW = 1, hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++, POW = POW * B % MOD) {
            hash1 = (hash1 * B + s.charAt(i) - 'a' + 1) % MOD;
            hash2 = (hash2 + (s.charAt(i) - 'a' + 1) * POW) % MOD;
            if (hash1 == hash2) pos = i;
        }
        return new StringBuilder().append(s.substring(pos + 1, n)).reverse().append(s).toString();
    }
}
