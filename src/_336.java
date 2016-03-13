import java.util.*;

/**
 * LeetCode 336 - Palindrome Pairs
 *
 * A suboptimal solution that performs well in real.
 * Let us say s1 + s2 is a valid solution.
 * Consider the following three cases.
 * |s1| > |s2|
 * |s1| == |s2|
 * |s1| < |s2|
 * Case 1 and 3 are symmetric. Case 1 and case 2 can be handled by the same code.
 *
 * Let us focus on case 1.
 * Clearly, the reverse of s2 must be a prefix of s1, and the rest of s1 should be a palindrome itself.
 * Therefore, an easy way is to enumerate every prefix of s1 and search in a map built on the reverse of the input.
 *
 * To do better, we should use a trie.
 * Also, we need a linear algorithm to determine for each string whether its suffices are palindromes.
 * However, it turns out that the constant for implementing an optimal solution is too large to pass this problem.
 * Sarcasm.
 */
public class _336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map1.put(words[i], i);
            map2.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        // i starts from -1 to allow empty strings
        for (String s1 : map1.keySet())
            for (int i = -1; i < s1.length(); i++) {
                String s2 = s1.substring(0, i + 1);
                if (map2.containsKey(s2) && !map1.get(s1).equals(map2.get(s2)) && isPalindrome(s1, i + 1, s1.length() - 1))
                    res.add(Arrays.asList(map1.get(s1), map2.get(s2)));
            }
        for (String s2 : map2.keySet())
            for (int i = -1; i < s2.length() - 1; i++) {
                // s2.length() - 1 is important, otherwise, case 2 will be double counted.
                String s1 = s2.substring(0, i + 1);
                if (map1.containsKey(s1) && !map1.get(s1).equals(map2.get(s2)) && isPalindrome(s2, i + 1, s2.length() - 1))
                    res.add(Arrays.asList(map1.get(s1), map2.get(s2)));
            }
        return res;
    }

    boolean isPalindrome(String s, int l, int r) {
        for (; l < r; l++, r--) if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}
