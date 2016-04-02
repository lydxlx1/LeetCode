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
        long B = 29, MOD = 1000000007;
        long[] l = new long[n], r = l.clone();
        for (int i = 0; i < n; i++) l[i] = ((i == 0 ? 0 : l[i - 1]) * B + s.charAt(i) - 'a' + 1) % MOD;
        for (int i = n - 1; i >= 0; i--)
            r[i] = ((i == n - 1 ? 0 : r[i + 1]) * B + s.charAt(i) - 'a' + 1) % MOD;

        long POW = B;
        for (int i=0; i<n; i++, POW = POW * B % MOD) {
            long rightHash = (r[0] - (i == n - 1 ? 0 : r[i + 1]) * POW % MOD + MOD) % MOD;
            if (l[i] == rightHash) pos = i;
        }
        return new StringBuilder().append(s.substring(pos + 1, n)).reverse().append(s).toString();
    }

    public static void main(String[] args) {
        System.out.println(new _214().shortestPalindrome(""));
    }
}
