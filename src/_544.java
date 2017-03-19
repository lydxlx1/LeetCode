/**
 * LeetCode 544 - Output Contest Matches
 * <p>
 * Brute-force
 * Just need to understand the problem statement carefully.
 */
public class _544 {

    public String findContestMatch(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) res[i] = "" + (i + 1);
        for (; n > 1; n /= 2)
            for (int i = 0; i < n / 2; i++)
                res[i] = "(" + res[i] + "," + res[n - 1 - i] + ")";
        return res[0];
    }

    public static void main(String[] args) {
        _544 sol = new _544();
        System.out.println(sol.findContestMatch(128));
    }
}
