/**
 * LeetCode 809 - Expressive Words
 */
public class _809 {

    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (isok(S, word)) {
                ans++;
            }
        }
        return ans;
    }

    boolean isok(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            int ii = i + 1, jj = j + 1;
            while (ii < a.length() && a.charAt(ii) == a.charAt(i)) ii++;
            while (jj < b.length() && b.charAt(jj) == b.charAt(j)) jj++;

            int cnt1 = ii - i, cnt2 = jj - j;
            if (cnt1 < 3 && cnt1 != cnt2) return false;
            if (cnt1 >= 3 && cnt1 < cnt2) return false;

            i = ii;
            j = jj;
        }

        return i >= a.length() && j >= b.length();
    }
}
