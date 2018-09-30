import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 916 - Word Subsets
 *
 * Counting
 */
public class _916 {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] target = new int[128];
        int[] cnt = new int[128];

        for (String b : B) {
            for (int i = 'a'; i <= 'z'; i++) {
                cnt[i] = 0;
            }
            for (char ch : b.toCharArray()) {
                cnt[ch]++;
            }
            for (int i = 'a'; i <= 'z'; i++) {
                target[i] = Math.max(target[i], cnt[i]);
            }
        }

        for (String a : A) {
            for (int i = 'a'; i <= 'z'; i++) {
                cnt[i] = 0;
            }
            for (char ch : a.toCharArray()) {
                cnt[ch]++;
            }

            boolean isValid = true;
            for (int i = 'a'; i <= 'z'; i++) {
                if (cnt[i] < target[i]) {
                    isValid = false;
                }
            }
            if (isValid) {
                res.add(a);
            }
        }
        return res;
    }
}

