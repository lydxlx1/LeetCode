import java.util.Arrays;
import java.util.TreeSet;

/**
 * LeetCode 340 - Longest Substring with At Most K Distinct Characters
 * <p>
 * BST solution with O(1) space for streaming data (1 pass)
 */
public class _340_3 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;
        int[] pos = new int[128]; // Note that different letter must share a different pos, so it is safe to use pos as the key
        // pos[i] is the current right most index of the occurrence of letter i
        Arrays.fill(pos, -1);
        TreeSet<Integer> tree = new TreeSet<>((u, v) -> Integer.compare(pos[u], pos[v]));
        for (int i = 0, l = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            tree.remove(ch);
            pos[ch] = i;
            tree.add(ch);
            if (tree.size() > k) l = pos[tree.pollFirst()] + 1;
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}