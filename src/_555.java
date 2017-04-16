/**
 * LeetCode 555 - Split Assembled Strings
 * <p>
 * The problem statement is somewhat confusing...
 * It turns out that the problem can be solved using brute-force but with the following notices.
 * <p>
 * 1) When all strings are connected and the break point is chosen, we can ONLY create the string rightwards.
 * <p>
 * 2) If the break point belongs the i-th string, then only this string may potentially need to be reversed.
 * Any other string needs to choose the larger one from that string and its reverse.
 * <p>
 * 3) If the break point belongs the i-th string and the best cycle is created, we only need to enumerate those
 * starting positions among strs[i].
 * <p>
 * 4) No need to reverse each string each time during runtime. We can pre-store them in an array.
 * <p>
 * 5) Similarly, for each string, we pre-store the larger one of that string and its reverse.
 * <p>
 * This way, the problem can be solved in O(n^2) time.
 */
public class _555 {
    public String splitLoopedString(String[] strs) {
        String ans = "";
        String[] reversed = strs.clone();
        String[] largerStrs = strs.clone();
        for (int i = 0; i < largerStrs.length; i++) {
            reversed[i] = new StringBuilder(strs[i]).reverse().toString();
            if (reversed[i].compareTo(strs[i]) > 0)
                largerStrs[i] = reversed[i];
        }

        for (int i = 0; i < strs.length; i++) {
            for (String firstTerm : new String[]{strs[i], reversed[i]}) {
                StringBuilder builder = new StringBuilder(firstTerm);
                for (int j = 1; j < strs.length; j++)
                    builder.append(largerStrs[(i + j) % strs.length]);

                String doubledCycle = builder.toString() + builder.toString();
                for (int j = 0; j < strs[i].length(); j++) {
                    String tmp = doubledCycle.substring(j, j + doubledCycle.length() / 2);
                    if (tmp.compareTo(ans) > 0)
                        ans = tmp;
                }
            }
        }
        return ans;
    }
}