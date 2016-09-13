/**
 * LeetCode 269 - Alien Dictionary
 *
 * Topological sort and cycle detection using DFS
 */
public class _269_2 {

    // return false if cycle detected
    boolean dfs(int u, boolean[][] g, int[] color, int currentColor, StringBuilder builder) {
        if (color[u] == currentColor) return false;
        if (color[u] > 0) return true; // visited, but in past round, which is fine
        color[u] = currentColor;
        for (int pre = 0; pre < 26; pre++)
            if (g[pre][u] && !dfs(pre, g, color, currentColor, builder)) return false;
        builder.append((char) (u + 'a'));
        return true;
    }

    public String alienOrder(String[] words) {
        boolean[][] g = new boolean[26][26];
        boolean[] hit = new boolean[26];
        for (String word : words)
            for (int i = 0; i < word.length(); i++)
                hit[word.charAt(i) - 'a'] = true;
        for (int i = 0; i < words.length - 1; i++)
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++)
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    g[words[i].charAt(j) - 'a'][words[i + 1].charAt(j) - 'a'] = true;
                    break;
                }
        StringBuilder builder = new StringBuilder();
        int[] color = new int[26];
        int currentColor = 0;
        for (int i = 0; i < 26; i++) if (hit[i] && !dfs(i, g, color, ++currentColor, builder)) return "";
        return builder.toString();
    }
}