/**
 * LeetCode 316 - Remove Duplicate Letters
 * <p>
 * An O(n) greedy solution
 * <p>
 * Given the string s, the greedy choice (the leftmost letter in the answer) is the smallest s[i], s.t.
 * the suffix s[i .. ] contains all the unique letters.
 * <p>
 * After determining the greedy choice s[i], we get a new string s' by
 * 1) removing all letters to the left of s[i],
 * 2) removing all s[i]'s from s.
 * <p>
 * We then recursively solve the problem w.r.t. s'.
 * The runtime is O(26 * n) = O(n).
 */
public class _316 {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < s.charAt(pos)) pos = i;
            if (--cnt[ch - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}