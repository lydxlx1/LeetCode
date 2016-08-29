/**
 * LeetCode 370 Range Addition
 *
 * Using Segment Tree
 */
public class _370_3 {

    class SegmentTree {
        int[] begin, end, cnt, mask;

        public SegmentTree(int n) {
            begin = new int[4 * n];
            end = new int[4 * n];
            cnt = new int[4 * n];
            mask = new int[4 * n];
            build(1, 0, n - 1);
        }

        private void build(int i, int left, int right) {
            begin[i] = left;
            end[i] = right;
            if (left < right) {
                int mid = (left + right) / 2;
                build(2 * i, left, mid);
                build(2 * i + 1, mid + 1, right);
            }
        }

        private void push(int i) {
            cnt[i] += mask[i] * (end[i] - begin[i] + 1);
            if (begin[i] < end[i]) {
                mask[2 * i] += mask[i];
                mask[2 * i + 1] += mask[i];
            }
            mask[i] = 0;
        }

        public void add(int i, int left, int right, int delta) {
            push(i);
            if (right < begin[i] || end[i] < left) return;
            if (left <= begin[i] && end[i] <= right) {
                mask[i] += delta;
                push(i);
            } else {
                add(2 * i, left, right, delta);
                add(2 * i + 1, left, right, delta);
            }
        }

        public int query(int i, int index) {
            push(i);
            if (begin[i] > index || end[i] < index) return 0;
            else if (begin[i] == index && end[i] == index) return cnt[i];
            else return query(2 * i, index) + query(2 * i + 1, index);
        }
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        SegmentTree tree = new SegmentTree(length);
        for (int[] update : updates) tree.add(1, update[0], update[1], update[2]);
        for (int i = 0; i < length; i++) ans[i] = tree.query(1, i);
        return ans;
    }
}