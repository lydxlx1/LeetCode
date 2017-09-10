import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * LeetCode 673 - Number of Longest Increasing Subsequence
 * <p>
 * O(n log n)-time DP
 * We still use the same DP recurrence, but the runtime can be reduced to O(n log n) via a Treap.
 */
public class _673_1 {

    static class Node {
        static Random rand = new Random();

        final int priority = rand.nextInt();
        int key; // corresponds to some nums[i]. Here, it is not necessarily to store the index i.
        int len; // length of the LIS ending at nums[i].
        int cnt; // number of all the LIS's ending at nums[i].
        int maxLen; // max(x.len), for all x in the subtree
        int maxLenCnt; // sum(x.cnt) if x.len == maxLen, for all x in the subtree
        Node left, right;


        public Node(int key, int len, int cnt) {
            this.key = key;
            this.len = len;
            this.cnt = cnt;
            recompute();
        }

        public Node recompute() {
            maxLen = len;
            maxLenCnt = cnt;
            if (left != null) {
                if (left.maxLen > maxLen) {
                    maxLen = left.maxLen;
                    maxLenCnt = left.maxLenCnt;
                } else if (left.maxLen == maxLen) {
                    maxLenCnt += left.maxLenCnt;
                }
            }
            if (right != null) {
                if (right.maxLen > maxLen) {
                    maxLen = right.maxLen;
                    maxLenCnt = right.maxLenCnt;
                } else if (right.maxLen == maxLen) {
                    maxLenCnt += right.maxLenCnt;
                }
            }
            return this;
        }
    }

    private Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            if (left.priority < right.priority) {
                left.right = merge(left.right, right);
                return left.recompute();
            } else {
                right.left = merge(left, right.left);
                return right.recompute();
            }
        }
    }

    private Node merge(Node... nodes) {
        Node res = null;
        for (Node node : nodes) {
            res = merge(res, node);
        }
        return res;
    }

    /**
     * res[0] < cutoff
     * res[1] >= cutoff
     */
    private Node[] split(Node root, int cutoff) {
        List<Node> smaller = new ArrayList<>();
        List<Node> bigger = new ArrayList<>();

        while (root != null) {
            if (root.key < cutoff) {
                smaller.add(root);
                root = root.right;
            } else {
                bigger.add(root);
                root = root.left;
            }
        }
        smaller.add(null);
        bigger.add(null);

        for (int i = smaller.size() - 2; i >= 0; i--) {
            smaller.get(i).right = smaller.get(i + 1);
            smaller.get(i).recompute();
        }
        for (int i = bigger.size() - 2; i >= 0; i--) {
            bigger.get(i).left = bigger.get(i + 1);
            bigger.get(i).recompute();
        }

        return new Node[]{smaller.get(0), bigger.get(0)};
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Node root = new Node(Integer.MIN_VALUE, 0, 1);
        for (int num : nums) {
            Node[] nodes = split(root, num);
            Node current = new Node(num, nodes[0].maxLen + 1, nodes[0].maxLenCnt);
            root = merge(nodes[0], current, nodes[1]);
        }

        return root.maxLenCnt;
    }

    public static void main(String[] args) {
        _673_1 sol = new _673_1();
        System.out.println(sol.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(sol.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }
}