import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 664 - Strange Printer
 * <p>
 * O(n^3) DP
 * <p>
 * Assume s = s[1..n]
 * It is clearly we must perform one print operation to print s[1].
 * Since we have to print s[1], why not use this operation to print everything to s[1] and hopefully some letters
 * in the future can be covered freely.
 * <p>
 * Formally, assume all the occurrences of s[1] in s are located at
 * b_1 = 1 < b_2 < b_3 < ... < b_m <= n.
 * <p>
 * Besides s[1] (which must be printed), each of s[b_i] (i > 1) may or may not be overwritten later.
 * If s[b_i] and s[b_j], 1 <= i < j, are printed (i.e., not overwritten) and there is NO s[b_k] printed (via the current print) in the middle,
 * we must optimally and recursively print the substring s[b_i + 1 .. b_j - 1].
 * <p>
 * However, the bad news is that there are 2^{m - 1} different choices.
 * To solve this problem, we use DP again and enumerate the leftmost s[b_i] (i > 1 and s[1] == s[b_i])
 * that is never overwritten in the future.
 * <p>
 * Please refer to the following code for the DP recurrence relation.
 */
class _664 {

    Map<String, Integer> map = new HashMap<>();

    public int strangePrinter(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        if (map.containsKey(s)) return map.get(s);

        int ans = 1 + strangePrinter(s.substring(1)); // only care about s[0]
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == s.charAt(0)) {
                ans = Math.min(ans, strangePrinter(s.substring(1, i)) + strangePrinter(s.substring(i))); // The cost for printing s[0] is included in the latter recursive call.
            }

        map.put(s, ans);
        return ans;
    }
}