import java.util.*;
import java.util.stream.IntStream;

/**
 * LeetCode 957 - Prison Cells After N Days
 *
 * Math
 * There can be at most 2^8 = 256 different states, and we will guarantee to hit a cycle after 256 + 1 steps
 * by Pigeonhole principle.
 */
public class _957 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> states = new ArrayList<>();

        states.add(cells);
        map.put(hash(cells), 0);
        while (true) {
            int[] newCells = cells.clone();
            for (int i = 0; i < cells.length; i++) {
                if (i > 0 && i < 7 && (cells[i - 1] + cells[i + 1] == 0 || cells[i - 1] + cells[i + 1] == 2)) {
                    newCells[i] = 1;
                } else {
                    newCells[i] = 0;
                }
            }

            if (states.size() == N) {
                return newCells;
            }

            int hash = hash(newCells);
            if (map.containsKey(hash)) {
                int pos = map.get(hash);
                N -= pos;
                int cycle = states.size() - pos;
                return states.get(pos + N % cycle);
            } else {
                map.put(hash, states.size());
                states.add(newCells);
            }
            cells = newCells;
        }
    }

    private int hash(int[] a) {
        int hash = 0;
        for (int i : a) {
            hash = hash * 2 + i;
        }
        return hash;
    }
}

