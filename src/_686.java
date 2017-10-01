/**
 * LeetCode 686 - Repeated String Match
 *
 * This is an interesting problem.
 * Assume the repeated string does exist. Then, we must have
 * B = [some nullable suffix of A] AA..AA [some nullable prefix of A].
 *
 * Let k = floor(|B| / |A|). Then, we just need to test
 * 1) whether the string by repeating A k times contains B as a substring,
 * 2) whether the string by repeating A (k+1) times contains B as a substring,
 * 3) whether the string by repeating A (k+2) times contains B as a substring.
 * Note that, test 1 makes sense only if |B| is divisible by |A|. But for convenience, we include this case anyway, without increasing the overall asymptotic runtime.
 *
 * Each test can be done in O(|A| + |B|) time using (say) KMP. Therefore, the total runtime is still O(|A| + |B|).
 */
class _686 {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder builder = new StringBuilder(A);
        while (builder.length() < B.length())
            builder.append(A);

        for (int i = 0; i < 3; i++) {
            if (builder.toString().contains(B)) // For simplicity, pretend that String.contains is implemented using KMP.
                return builder.length() / A.length();
            builder.append(A);
        }
        return -1;
    }

    public static void main(String[] args) {
        _686 sol = new _686();
        System.out.println(sol.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(sol.repeatedStringMatch("abcd", "cdabcdabe"));
        System.out.println(sol.repeatedStringMatch("a", "aa"));
        System.out.println(sol.repeatedStringMatch("abcd", "abcdb"));
    }
}
