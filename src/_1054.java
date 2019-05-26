import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Leetcode 1054 - Distant Barcodes
 *
 * Greedy using PriorityQueue
 */
public class _1054 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] f = new int[11111];
        for (int i : barcodes) {
            f[i]++;
        }
        int len = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.<Integer>comparingInt(i -> f[i]).reversed().thenComparingInt(i -> i));
        for (int i = 0; i < f.length; i++) {
            if (f[i] > 0) {
                queue.add(i);
            }
        }
        while (true) {
            int a = queue.poll();
            if (queue.isEmpty()) {
                barcodes[len++] = a;
                break;
            }

            int b = queue.poll();
            int which = len == 0 || barcodes[len - 1] != a ? a : b;
            barcodes[len++] = which;
            f[which]--;

            if (f[a] > 0) {
                queue.add(a);
            }
            if (f[b] > 0) {
                queue.add(b);
            }
        }
        return barcodes;
    }
}
