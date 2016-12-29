import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 267 - Palindrome Permutation II
 * <p>
 * 2ms Solution
 * Beat 95.41%
 */
public class _267 {
    public List<String> generatePalindromes(String s) {
        int[] cnt = new int[128];
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i)]++;

        int oddChar = -1;
        for (int i = 0; i < cnt.length; i++)
            if (cnt[i] % 2 == 1) {
                if (oddChar != -1) return Collections.emptyList();
                else oddChar = i;
            }

        char[] str = new char[s.length() / 2];
        for (int i = 0, len = 0; i < cnt.length; i++)
            for (int j = 0; j < cnt[i] / 2; j++)
                str[len++] = (char) i;

        List<String> ans = new ArrayList<>();
        do {
            StringBuilder builder = new StringBuilder(s.length());
            for (int i = 0; i < str.length; i++) builder.append(str[i]);
            if (oddChar != -1) builder.append((char) oddChar);
            for (int i = str.length - 1; i >= 0; i--) builder.append(str[i]);
            ans.add(builder.toString());
        } while (nextPermutation(str));

        return ans;
    }

    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void reverse(char[] a, int l, int r) {
        for (; l < r; l++, r--) swap(a, l, r);
    }

    public boolean nextPermutation(char[] a) {
        for (int i = a.length - 2; i >= 0; i--)
            if (a[i] < a[i + 1]) {
                int minIndex = i + 1;
                for (int j = i + 2; j < a.length; j++)
                    if (a[j] > a[i] && a[j] < a[minIndex])
                        minIndex = j;
                swap(a, i, minIndex);
                reverse(a, i + 1, a.length - 1);
                return true;
            }
        return false;
    }
}