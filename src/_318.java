/**
 * LeetCode 318 - Maximum Product of Word Lengths
 *
 * O(n^2) brute-force
 */
public class _318 {
    public int maxProduct(String[] words) {
        int ans = 0;
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++)
            for (int j = 0; j < words[i].length(); j++)
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if ((mask[i] & mask[j]) == 0) ans = Math.max(ans, words[i].length() * words[j].length());
        return ans;
    }
}