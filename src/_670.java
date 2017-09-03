/**
 * LeetCode 670 - Maximum Swap
 * <p>
 * Just Brute-force
 */
class _670 {
    public int maximumSwap(int num) {
        char[] chars = ("" + num).toCharArray();
        int ans = num;
        for (int i = 0; i < chars.length; i++)
            for (int j = i + 1; j < chars.length; j++) {
                {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }

                long newValue = Long.parseLong(String.valueOf(chars));
                if (newValue <= Integer.MAX_VALUE) {
                    ans = Math.max(ans, (int) newValue);
                }

                {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
        return ans;
    }
}