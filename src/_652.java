import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 652 - Find Duplicate Subtrees
 * <p>
 * An elegant Tree-DP
 */
public class _652 {

    class State {
        int rootValue;
        int leftTreeId;
        int rightTreeId;

        public State(int rootValue, int leftTreeId, int rightTreeId) {
            this.rootValue = rootValue;
            this.leftTreeId = leftTreeId;
            this.rightTreeId = rightTreeId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            State state = (State) o;

            if (rootValue != state.rootValue) return false;
            if (leftTreeId != state.leftTreeId) return false;
            return rightTreeId == state.rightTreeId;
        }

        @Override
        public int hashCode() {
            int result = rootValue;
            result = 31 * result + leftTreeId;
            result = 31 * result + rightTreeId;
            return result;
        }
    }

    Map<State, Integer> idMap = new HashMap<>();
    Map<Integer, Integer> cnt = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    int globalId = 1; // 0 is used for null

    private int getId(TreeNode root) {
        if (root == null)
            return 0;
        State state = new State(root.val, getId(root.left), getId(root.right));
        if (!idMap.containsKey(state)) {
            idMap.put(state, globalId++);
        }
        int id = idMap.get(state);
        cnt.put(id, cnt.getOrDefault(id, 0) + 1);
        if (cnt.get(id) == 2) {
            res.add(root);
        }
        return id;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getId(root);
        return res;
    }

    public static void main(String[] args) {
        _652 sol = new _652();
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(1);
        System.out.println(sol.findDuplicateSubtrees(a));
    }
}
