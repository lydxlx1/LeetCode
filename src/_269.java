import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode 269 - Alien Dictionary
 * <p>
 * Topological Sort
 * <p>
 * String.chars() returns an IntStream, which is sweet. :)
 *
 *
 * Consider the following case, which is also missed by the solution on LeetCode.
 *
 * ["ab", "a"]
 *
 * Clearly, we should return "" indicating there is no solution.
 * But the solution given by LeetCode is "ab", which is incorrect.
 */
public class _269 {
    public String alienOrder(String[] words) {
        boolean[][] g = new boolean[26][26];
        Set<Integer> chars = String.join("", words).chars().map(i -> i - 'a').boxed().collect(Collectors.toSet());
        int[] inDegree = new int[26];

        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            for (j = 0; j < words[i].length() && j < words[i + 1].length(); j++)
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    g[words[i].charAt(j) - 'a'][words[i + 1].charAt(j) - 'a'] = true;
                    break;
                }
            if (j == words[i + 1].length() && words[i].length() > words[i + 1].length()) return ""; // Don't miss this case.
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                if (g[i][j]) inDegree[j]++;

        StringBuilder builder = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 26; i++)
            if (inDegree[i] == 0 && chars.contains(i)) queue.add(i);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            builder.append((char) (u + 'a'));
            for (int v = 0; v < 26; v++)
                if (g[u][v] && --inDegree[v] == 0) queue.add(v);
        }
        return builder.length() == chars.size() ? builder.toString() : "";
    }
}
