/**
 * LeetCode 715 - Range Module
 * <p>
 * O(n log q)-time solution using dynamic segment tree
 * <p>
 * I have already applied many useful optimizations, but feel free to let me know if you have any other thoughts.
 */
public class _715 {

    enum State {
        COVERED,
        UNCOVERED,
        MIXED,
    }

    enum Mask {
        NEUTRAL,
        COVER,
        UNCOVER,
    }

    class Node {
        int begin;
        int end;
        State state;
        Mask mask;
        Node left, right;

        public Node(int begin, int end, State state) {
            this.begin = begin;
            this.end = end;

            this.state = state;
            this.mask = Mask.NEUTRAL;
        }
    }

    private void push(Node root) {
        if (root.mask == Mask.COVER) {
            root.state = State.COVERED;
        } else if (root.mask == Mask.UNCOVER) {
            root.state = State.UNCOVERED;
        }

        // If root.mask == neutral, then don't overwrite its two children.
        if (root.mask != Mask.NEUTRAL && root.left != null) {
            root.left.mask = root.right.mask = root.mask;
        }

        root.mask = Mask.NEUTRAL;
    }

    private void combine(Node root) {
        if (root.left.state == State.COVERED && root.right.state == State.COVERED) {
            root.state = State.COVERED;
            root.left = root.right = null; // optimization
        } else if (root.left.state == State.UNCOVERED && root.right.state == State.UNCOVERED) {
            root.state = State.UNCOVERED;
            root.left = root.right = null; // optimization
        } else {
            root.state = State.MIXED;
        }
    }

    private void grow(Node root) {
        if (root.left == null) {
            if (root.right != null) throw new RuntimeException("Not a full binary tree...");
            int mid = (root.begin + root.end) / 2;
            root.left = new Node(root.begin, mid, root.state);
            root.right = new Node(mid, root.end, root.state);
        }
    }

    Node root;
    int left, right;
    Mask mask;

    private void update(Node root) {
        push(root);
        if (left >= root.end || right <= root.begin) {
            return;
        } else if (left <= root.begin && right >= root.end) {
            root.mask = mask;
            push(root);
        } else {
            grow(root);
            update(root.left);
            update(root.right);
            combine(root);
        }
    }

    private boolean query(Node root) {
        push(root);
        if (left >= root.end || right <= root.begin) {
            return true; // Identity for logical AND
        } else if (left <= root.begin && root.end <= right) {
            return root.state == State.COVERED;
        } else if (root.begin <= left && right <= root.end && (root.state == State.COVERED || root.state == State.UNCOVERED)) {
            // An optimization for this problem. Not quite commonly used in other segment tree applications.
            // If the segment in the current root completely covers the query interval and it is not a mixed node, we can directly tell the answer without further descending the tree.
            return root.state == State.COVERED;
        } else {
            grow(root);
            boolean l = query(root.left);
            boolean r = query(root.right);
            combine(root);
            return l && r; // query(root.left) && query(root.right) might be wrong as the short-circuit property might skip the latter call and thus will affect the combine() function.
        }
    }

    public _715() {
        root = new Node(0, 1000000000, State.UNCOVERED);
    }

    public void addRange(int left, int right) {
        this.left = left;
        this.right = right;
        this.mask = Mask.COVER;
        update(root);
    }

    public boolean queryRange(int left, int right) {
        this.left = left;
        this.right = right;
        return query(root);
    }

    public void removeRange(int left, int right) {
        this.left = left;
        this.right = right;
        this.mask = Mask.UNCOVER;
        update(root);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */