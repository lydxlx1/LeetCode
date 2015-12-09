/**
 * LeetCode 316 - Remove Duplicate Letters
 *
 * An O(n) greedy solution
 *
 * Given the string s, the greedy choice (the leftmost letter in the answer) is the smallest s[i], s.t.
 * the suffix s[i .. ] contains all the unique letters.
 *
 * After determining the greedy choice s[i], we get a new string s' by
 * 1) removing all letters to the left of s[i],
 * 2) removing all s[i]'s from s.
 *
 * We then recursively solve the problem w.r.t. s'.
 * The runtime is O(26 * n) = O(n).
 */
public class _316 {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        boolean[] isCandidate = new boolean[26];
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            isCandidate[ch - 'a'] = true;
            if (--cnt[ch - 'a'] == 0) break;
        }
        for (int i = 0; i < 26; i++)
            if (isCandidate[i]) {
                char ch = (char) (i + 'a');
                for (int j = 0; j < s.length(); j++)
                    if (s.charAt(j) == ch) return ch + removeDuplicateLetters(s.substring(j + 1).replaceAll("" + ch, ""));
            }
        return "";
    }
}