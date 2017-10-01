/**
 * LeetCode 686 - Repeated String Match
 * <p>
 * This is an interesting problem.
 * Assume the repeated string does exist. Then, we must have
 * B = [some nullable suffix of A] AA..AA [some nullable prefix of A].
 * <p>
 * Let k = floor(|B| / |A|). Then, we just need to test
 * 1) whether the string by repeating A k times contains B as a substring,
 * 2) whether the string by repeating A (k+1) times contains B as a substring,
 * 3) whether the string by repeating A (k+2) times contains B as a substring.
 * Note that, test 1 makes sense only if |B| is divisible by |A|. But for convenience, we include this case anyway, without increasing the overall asymptotic runtime.
 * <p>
 * Each test can be done in O(|A| + |B|) time using (say) KMP. Therefore, the total runtime is still O(|A| + |B|).
 */
class _686_1 {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder builder = new StringBuilder(A);
        while (builder.length() < B.length())
            builder.append(A);

        int[] next = new int[B.length()];
        for (int i = 0, j = -1; i < B.length(); i++) {
            while (j != -1 && B.charAt(i) != B.charAt(j + 1))
                j = next[j];
            next[i] = i > 0 && B.charAt(i) == B.charAt(j + 1) ? j + 1 : -1;
            j = next[i];
        }

        for (int i = 0; i < 3; i++) {
            if (kmpMatch(builder.toString(), B, next)) // For simplicity, pretend that String.contains is implemented using KMP.
                return builder.length() / A.length();
            builder.append(A);
        }
        return -1;
    }

    private boolean kmpMatch(String s, String pattern, int[] next) {
        for (int i = 0, j = -1; i < s.length(); i++) {
            while (j != -1 && s.charAt(i) != pattern.charAt(j + 1))
                j = next[j];
            if (s.charAt(i) == pattern.charAt(j + 1))
                j++;
            if (j == pattern.length() - 1)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        _686_1 sol = new _686_1();
        System.out.println(sol.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(sol.repeatedStringMatch("abcd", "cdabcdabe"));
        System.out.println(sol.repeatedStringMatch("a", "aa"));
        System.out.println(sol.repeatedStringMatch("abcd", "abcdb"));
    }
}
