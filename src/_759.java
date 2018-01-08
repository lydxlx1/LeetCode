import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * LeetCode 759 - Employee Free Time
 *
 * Segment Tree
 */
public class _759 {

    final int MIN = -1;
    final int MAX = 100000001;

    class TreeNode {
        int begin, end;
        int sum;
        boolean mask;


        TreeNode left, right;

        TreeNode(int begin, int end, int sum) {
            this.begin = begin;
            this.end = end;
            this.sum = sum;
        }

        void push() {
            if (mask) {
                sum = end - begin;
            }
            if (left != null && mask) { // Only push the mask when it is set
                left.mask = mask;
                right.mask = mask;
            }
            mask = false;
        }

        void grow() {
            if (left == null) {
                int mid = (begin + end) / 2;
                left = new TreeNode(begin, mid, sum == 0 ? 0 : mid - begin);
                right = new TreeNode(mid, end, sum == 0 ? 0 : end - mid);
            }
        }

        void combine() {
            if (left != null) {
                sum = left.sum + right.sum;
            }
        }
    }

    void cover(TreeNode root, int begin, int end) {
        root.push();
        if (begin >= root.end || end <= root.begin) {
            return;
        } else if (begin <= root.begin && root.end <= end) {
            root.mask = true;
            root.push();
        } else {
            root.grow();
            cover(root.left, begin, end);
            cover(root.right, begin, end);
            root.combine();
        }
    }

    void dfs(TreeNode root, List<Interval> res) {
        if (root != null) {
            root.push();
            if (root.sum == 0) {
                if (!res.isEmpty() && res.get(res.size() - 1).end == root.begin) {
                    res.get(res.size() - 1).end = root.end;
                } else {
                    res.add(new Interval(root.begin, root.end));
                }
            } else {
                dfs(root.left, res);
                dfs(root.right, res);
                root.combine();
            }
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeNode root = new TreeNode(MIN, MAX, 0);

        TreeSet<Integer> set = new TreeSet<>();
        for (List<Interval> person : schedule) {
            for (Interval interval : person) {
                cover(root, interval.start, interval.end);
            }
        }

        List<Interval> res = new ArrayList<>();
        dfs(root, res);
        res = res.stream().filter(i -> i.start != MIN && i.end != MAX).collect(Collectors.toList());
        return res;
    }
}



