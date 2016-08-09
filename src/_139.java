import java.util.Set;

/**
 * LeetCode 139 - Word Break
 *
 * A very short DP
 * f[i] means whether we break the suffix s[i..]
 */
public class _139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[f.length - 1] = true;
        for (int i = s.length() - 1; i >= 0; i--)
            for (int j = i + 1; j <= s.length(); j++)
                if (wordDict.contains(s.substring(i, j)))
                    f[i] = f[i] || f[j];
        return f[0];
    }
}
