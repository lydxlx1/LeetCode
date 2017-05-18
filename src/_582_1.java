import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 582 - Kill Process
 * <p>
 * A union-find-set-like solution
 */
public class _582_1 {

    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Boolean> canBeKilled = new HashMap<>();
    List<Integer> killed = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        for (int i = 0; i < pid.size(); i++)
            parent.put(pid.get(i), ppid.get(i));
        for (int node : pid)
            dfs(node, kill);
        return killed;
    }

    private boolean dfs(int root, int kill) {
        if (canBeKilled.containsKey(root))
            return canBeKilled.get(root);
        boolean bool;
        if (root == kill)
            bool = true;
        else if (root == 0)
            bool = false;
        else
            bool = dfs(parent.get(root), kill);
        if (bool)
            killed.add(root);
        canBeKilled.put(root, bool);
        return bool;
    }
}