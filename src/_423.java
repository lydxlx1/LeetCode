import java.util.Arrays;

/**
 * LeetCode 423 - Reconstruct Original Digits from English
 * <p>
 * Greedy
 * There is an order of 0-9 such that for any suffix there is a unique letter that can be used as the key.
 */
public class _423 {

    String[] digits = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
    };

    private void doit(StringBuilder sb, int[] cnt, char target, int digit, String spell) {
        int repeat = cnt[target];
        for (int i = 0; i < repeat; i++) sb.append(digit);
        for (char ch : spell.toCharArray()) cnt[ch] -= repeat;
    }

    public String originalDigits(String s) {
        StringBuilder builder = new StringBuilder();
        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) cnt[ch]++;

        doit(builder, cnt, 'z', 0, digits[0]);
        doit(builder, cnt, 'w', 2, digits[2]);
        doit(builder, cnt, 'g', 8, digits[8]);
        doit(builder, cnt, 'h', 3, digits[3]);
        doit(builder, cnt, 'x', 6, digits[6]);
        doit(builder, cnt, 's', 7, digits[7]);
        doit(builder, cnt, 'v', 5, digits[5]);
        doit(builder, cnt, 'i', 9, digits[9]);
        doit(builder, cnt, 'f', 4, digits[4]);
        doit(builder, cnt, 'o', 1, digits[1]);

        char[] res = builder.toString().toCharArray();
        Arrays.sort(res);
        return String.copyValueOf(res);
    }
}
