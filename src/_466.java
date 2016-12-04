/**
 * LeetCode 466 - Count the Repetitions
 * <p>
 * DP
 * Assume that s2 is self-repeating forever, i.e., s2s2s2s2s2...
 * Let f[i] be the maximum number of letters of s2 (in self-repeating mode) that i copies of s1 can match.
 * <p>
 * The final answer will be floor(f[n1] / (|s2| * n2)).
 */
public class _466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        String s2Padded = s2;
        while (s2Padded.length() < s1.length()) s2Padded += s2;
        s2Padded += s2;

        // matchFrom[i] is the maximum number letters of s2 (in self-repeating mode and starting from s2[i])
        // that a SINGLE copy of s1 can match.
        // This dp array can be computed in less time, but it is fine to use brute-force here
        int[] matchFrom = new int[s2Padded.length()];
        for (int beginIndex = 0; beginIndex < matchFrom.length; beginIndex++) {
            String a = s1;
            String b = s2Padded.substring(beginIndex);
            int i = 0, j = 0;
            while (i < a.length() && j < b.length())
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            matchFrom[beginIndex] = j;
        }

        int[] f = new int[n1 + 1];
        for (int i = 1; i < f.length; i++) {
            int letterMatched = f[i - 1] % s2.length();
            f[i] = f[i - 1] + matchFrom[letterMatched];
        }

        return f[n1] / (s2.length() * n2);
    }
}