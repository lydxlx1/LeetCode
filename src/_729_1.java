/**
 * LeetCode 729 - My calendar I
 * <p>
 * Solved by Segment Tree
 */
public class _729_1 {

    class Node {
        int begin, end;
        int max, cnt_mask;
        Node left, right;

        public Node(int begin, int end, int max) {
            this.begin = begin;
            this.end = end;
            this.max = max;
        }

        public void push() {
            max += cnt_mask;
            if (left != null) {
                left.cnt_mask += cnt_mask;
                right.cnt_mask += cnt_mask;
            }
            cnt_mask = 0;
        }

        public void combine() {
            max = Math.max(left.max, right.max);
        }

        public void grow() {
            if (left == null) {
                left = new Node(begin, (begin + end) / 2, max);
                right = new Node((begin + end) / 2, end, max);
            }
        }

        public boolean disjoint(int begin, int end) {
            return this.begin >= end || this.end <= begin;
        }

        public boolean coveredBy(int begin, int end) {
            return begin <= this.begin && this.end <= end;
        }
    }

    public int query(Node root, int begin, int end) {
        root.push();
        if (root.disjoint(begin, end)) return 0;
        else if (root.coveredBy(begin, end)) return root.max;
        else {
            root.grow();
            int res = Math.max(query(root.left, begin, end), query(root.right, begin, end));
            root.combine();
            return res;
        }
    }

    public void update(Node root, int begin, int end, int delta) {
        root.push();
        if (root.disjoint(begin, end)) return;
        else if (root.coveredBy(begin, end)) {
            root.cnt_mask += delta;
            root.push();
        } else {
            root.grow();
            update(root.left, begin, end, delta);
            update(root.right, begin, end, delta);
            root.combine();
        }
    }


    Node events;

    public _729_1() {
        events = new Node(0, 1000000000, 0);

    }

    public boolean book(int start, int end) {
        if (query(events, start, end) > 0)
            return false;
        else {
            update(events, start, end, 1);
            return true;
        }
    }

    public static void main(String[] args) {
        _729_1 cal = new _729_1();
        System.out.println(cal.book(10, 20));
        System.out.println(cal.book(15, 25));
        System.out.println(cal.book(20, 30));
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */