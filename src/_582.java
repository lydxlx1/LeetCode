import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 582 - Kill Process
 */
public class _582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int parent = -1;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int u = pid.get(i);
            int p = ppid.get(i);
            if (u == kill)
                parent = p;
            tree.putIfAbsent(u, new ArrayList<>());
            tree.putIfAbsent(p, new ArrayList<>());
            tree.get(u).add(p);
            tree.get(p).add(u);
        }
        List<Integer> res = new ArrayList<>();
        dfs(kill, parent, tree, res);
        return res;
    }

    private void dfs(int root, int parent, Map<Integer, List<Integer>> tree, List<Integer> res) {
        res.add(root);
        for (int child : tree.get(root))
            if (child != parent)
                dfs(child, root, tree, res);
    }
}