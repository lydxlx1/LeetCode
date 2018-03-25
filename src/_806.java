/**
 * LeetCode 806 - Number of Lines To Write String
 */
public class _806 {

    public int[] numberOfLines(int[] widths, String S) {
        int cnt = 0;
        int line = 0;

        for (char ch : S.toCharArray()) {
            int width = widths[ch - 'a'];
            if (line + width > 100) {
                cnt++;
                line = 0;
            }
            line += width;
        }
        if (line > 0) {
            cnt++;
        }
        return new int[]{cnt, line};
    }
}
