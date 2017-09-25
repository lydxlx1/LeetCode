import java.util.TreeSet;

/**
 * LeetCode 683 - K Empty Slots
 * <p>
 * Just use the lower and higher methods in a BST
 */
class _683 {

    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int pos = flowers[i];
            tree.add(pos);
            if (tree.lower(pos) != null && pos - tree.lower(pos) - 1 == k)
                return i + 1;
            if (tree.higher(pos) != null && tree.higher(pos) - pos - 1 == k)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        _683 sol = new _683();
        System.out.println(sol.kEmptySlots(new int[]{1, 3, 2}, 1));
        System.out.println(sol.kEmptySlots(new int[]{1, 2, 3}, 1));
    }
}
