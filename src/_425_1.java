import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 425 - Word Squares
 * <p>
 * If we fill the matrix from top-most row to bottom-most row, we can use prefixes to do the pruning.
 * A Trie or a HashMap will do the work. (Note string length is at most 5.)
 */
public class _425_1 {

    Map<String, List<String>> prefixMap;
    List<List<String>> ans;
    int m;

    private void dfs(List<String> stack) {
        if (stack.size() >= m) ans.add(new ArrayList<>(stack));
        else {
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) prefix.append(stack.get(i).charAt(stack.size()));
            for (String s : prefixMap.getOrDefault(prefix.toString(), new ArrayList<>())) {
                stack.add(s);
                dfs(stack);
                stack.remove(stack.size() - 1);
            }
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) return new ArrayList<>();
        prefixMap = new HashMap<>();
        ans = new ArrayList<>();
        for (String word : words) {
            String prefix = "";
            for (int i = 0; i < word.length(); i++) {
                prefixMap.putIfAbsent(prefix, new ArrayList<>());
                prefixMap.get(prefix).add(word);
                prefix += word.charAt(i);
            }
        }
        m = words[0].length();
        dfs(new ArrayList<>());
        return ans;
    }
}