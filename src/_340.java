import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 340 - Longest Substring with At Most K Distinct Characters
 *
 * O(n) sliding window
 */
public class _340 {
    public int lengthOfLongestSubstringKDistinct(String ss, int k) {
        int ans = 0;
        char[] s = ss.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, pre = 0; i < s.length; i++) {
            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
            while (map.size() > k) {
                map.put(s[pre], map.get(s[pre]) - 1);
                if (map.get(s[pre]) == 0) map.remove(s[pre]);
                pre++;
            }
            ans = Math.max(ans, i - pre + 1);
        }
        return ans;
    }
}
