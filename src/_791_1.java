public class _791_1 {

    public String customSortString(String S, String T) {
        StringBuilder builder = new StringBuilder();
        int[] cnt = new int[128];

        for (char ch : T.toCharArray()) {
            cnt[ch]++;
        }
        for (char ch : S.toCharArray()) {
            while (cnt[ch]-- > 0) {
                builder.append(ch);
            }
        }
        for (char ch = 0; ch < 128; ch++) {
            while (cnt[ch]-- > 0) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
