/**
 * LeetCode 767 - Reorganize String
 * <p>
 * Greedy Solution
 */
public class _767 {

    char findMax(char[] cnt, char no) {
        int max = 0;
        char ch = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            if (i != no) {
                if (cnt[i] > max) {
                    max = cnt[i];
                    ch = i;
                }
            }
        }
        return ch;
    }

    public String reorganizeString(String S) {
        char[] cnt = new char[128];
        for (char ch : S.toCharArray()) {
            cnt[ch]++;
        }

        StringBuilder builder = new StringBuilder();
        char pre = 0;
        for (int i = 0; i < S.length(); i++) {
            char cur = findMax(cnt, pre);
            if (cur == 0) {
                return "";
            } else {
                builder.append(cur);
                cnt[cur]--;
                pre = cur;
            }
        }
        return builder.toString();
    }
}



