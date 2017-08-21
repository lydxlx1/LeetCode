import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 662 - Maximum Width of Binary Tree
 * <p>
 * This BFS version will NOT cause any integer overflow issue.
 * <p>
 * We use a Deque to maintain the nodes (including null's)  on the current row, where
 * <p>
 * 1) We exclude the leading null's.
 * 2) We exclude the trailing null's.
 * 3) Each node has a associated field size, which is initialized to 1.
 * 4) If there are two consecutive null's, merge them into one while summing up their sizes.
 * 5) The sum of sizes of the deque is the largest width of the current row.
 * <p>
 * Note that, step 4 guarantees that the runtime of the algorithm is O(n).
 * This is because that the number of null's in each row is the same order as the number of nodes (in the tree) on that row.
 * So, the total number of null's is no more than O(n).
 * <p>
 * Without (4), the algorithm is still correct, but can have an Theta(2^n) runtime in the worst case.
 * Consider the example below.
 * <p>
 * *
 * / \
 * *  *
 * /    \
 * *     *
 * /       \
 * *        *
 * .....
 */
class _662_1 {

    class Data {
        TreeNode node;
        int size;

        public Data(TreeNode node) {
            this.node = node;
            this.size = 1;
        }

    }

    private Deque<Data> minimize(Deque<Data> deque) {
        Deque<Data> res = new ArrayDeque<>();
        while (!deque.isEmpty() && deque.peekFirst().node == null) deque.pollFirst();
        while (!deque.isEmpty() && deque.peekLast().node == null) deque.pollLast();
        for (Data data : deque) {
            if (data.node == null && !res.isEmpty() && res.peekLast().node == null) {
                res.peekLast().size += data.size;
            } else {
                res.add(data);
            }
        }
        return res;
    }

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<Data> current = minimize(new ArrayDeque<>(Arrays.asList(new Data(root))));
        while (!current.isEmpty()) {
            int size = 0;
            Deque<Data> next = new ArrayDeque<>();
            for (Data data : current) {
                size += data.size;
                if (data.node != null) {
                    next.addLast(new Data(data.node.left));
                    next.addLast(new Data(data.node.right));
                } else {
                    data.size *= 2;
                    next.addLast(data);
                    // Equivalently, one can do the following.
                    // next.addLast(data);
                    // next.addLast(data);
                }
            }
            ans = Math.max(ans, size);
            current = minimize(next);
        }
        return ans;
    }
}