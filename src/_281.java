import java.util.List;

/**
 * LeetCode 281 - Zigzag Iterator
 */
public class _281 {

    private final List<Integer>[] lists;
    final int[] ptr;
    private int row = 0;

    public _281(List<Integer> v1, List<Integer> v2) {
        lists = new List[2];
        lists[0] = v1;
        lists[1] = v2;
        ptr = new int[2];
    }

    public int next() {
        if (!hasNext()) throw new RuntimeException("Running out of integers...");
        int value = lists[row].get(ptr[row]);
        ptr[row]++;
        row = (row + 1) % lists.length;
        return value;
    }

    public boolean hasNext() {
        for (int i = 0; i < lists.length; i++, row = (row + 1) % lists.length)
            if (ptr[row] < lists[row].size()) return true;
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */