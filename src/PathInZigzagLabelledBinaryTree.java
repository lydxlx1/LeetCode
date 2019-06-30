import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Path In Zigzag Labelled Binary Tree
 *
 * Math
 */
public class PathInZigzagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        for (int i = label; i > 0; i /= 2) {
            level++;
        }

        List<Integer> res = new ArrayList<>();
        if (level % 2 == 0) {
            label = reverse(label, level);
        }
        while (label > 0) {
            if (level % 2 == 1) {
                res.add(label);
            } else {
                res.add(reverse(label, level));
            }
            label /= 2;
            level--;
        }
        Collections.reverse(res);
        return res;
    }

    private int reverse(int label, int level) {
        return (1 << level) + (1 << (level - 1)) - 1 - label;
    }
}
