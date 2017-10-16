import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * LeetCode 699 - Falling Squares
 * <p>
 * O(n log n)-time solution using a segment tree that supports the following operations:
 * <p>
 * 1) Query the max-weight on the segment [a, b].
 * 2) Given a segment [a, b] and a weight w, for each element in [a, b], update its weight to w if w is bigger.
 * <p>
 * The following segment tree implementation does not rely on discretization, and the tree is dynamically expanded
 * when necessary.
 */
class _699 {
    class Node {
        int begin;
        int end;
        int height;
        int mask;
        Node left, right;

        public Node(int begin, int end, int height) {
            this.begin = begin;
            this.end = end;
            this.height = height;
        }
    }

    private void push(Node root) {
        root.height = Math.max(root.height, root.mask);
        if (root.left != null) root.left.mask = Math.max(root.left.mask, root.mask);
        if (root.right != null) root.right.mask = Math.max(root.right.mask, root.mask);
        root.mask = 0;
    }

    private void combine(Node root) {
        root.height = Math.max(root.left.height, root.right.height);
    }

    private void grow(Node root) {
        if (root.left == null) {
            if (root.right != null) throw new RuntimeException("Not a full binary tree...");
            int mid = (root.begin + root.end) / 2;
            root.left = new Node(root.begin, mid, root.height);
            root.right = new Node(mid + 1, root.end, root.height);
        }
    }

    private int query(Node root, int begin, int end) {
        push(root);

        if (begin > root.end || end < root.begin) return 0;
        if (begin <= root.begin && root.end <= end) return root.height;

        grow(root);
        int ans = Math.max(query(root.left, begin, end), query(root.right, begin, end));
        combine(root);
        return ans;
    }

    private void update(Node root, int begin, int end, int newHeight) {
        push(root);

        if (begin > root.end || end < root.begin) {
            return;
        } else if (begin <= root.begin && root.end <= end) {
            root.mask = newHeight;
            push(root);
        } else {
            grow(root);
            update(root.left, begin, end, newHeight);
            update(root.right, begin, end, newHeight);
            combine(root);
        }
    }

    private void dfs(Node root) {
        if (root == null) return;
        push(root);
        System.out.println(String.format("left = %d, right = %d, height = %d", root.begin, root.end, root.height));
        dfs(root.left);
        dfs(root.right);

    }


    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer, Integer> squares = new TreeMap<>();
        squares.put(Integer.MIN_VALUE, 0);

        List<Integer> ans = new ArrayList<>();
        int previousAns = 0;
        Node root = new Node(0, 200000000, 0);


        for (int[] position : positions) {
            int begin = position[0], length = position[1], end = begin + length - 1;
            int height = query(root, begin, end);

            update(root, begin, end, height + length);
            previousAns = Math.max(previousAns, height + length);
            ans.add(previousAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        _699 sol = new _699();
        {
            int[][] a = {
                    {1, 2},
                    {2, 3},
                    {6, 1},
            };
            System.out.println(sol.fallingSquares(a));
        }
        {
            int[][] a = {
                    {6, 4},
                    {2, 7},
                    {6, 9},
            };
            System.out.println(sol.fallingSquares(a));
        }
    }
}