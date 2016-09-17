/**
 * LeetCode 358 - Rearrange String k Distance Apart
 *
 * Greedy algorithm + sliding window
 */
public class _358 {
    public String rearrangeString(String str, int k) {
        if (k == 0) return str;
        char[] ans = new char[str.length()];
        int[] cnt = new int[26];
        boolean[] banned = new boolean[26];
        for (int i = 0; i < str.length(); i++) cnt[str.charAt(i) - 'a']++;
        for (int i = 0; i < ans.length; i++) {
            if (i - k >= 0) banned[ans[i - k] - 'a'] = false;
            int max = -1, which = -1;
            for (int j = 0; j < 26; j++)
                if (!banned[j] && cnt[j] > 0 && cnt[j] > max) {
                    max = cnt[j];
                    which = j;
                }
            if (which == -1) return "";
            ans[i] = (char) (which + 'a');
            cnt[which]--;
            banned[ans[i] - 'a'] = true;
        }
        return String.valueOf(ans);
    }
}