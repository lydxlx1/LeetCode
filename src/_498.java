import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 498 - Diagonal Traverse
 * <p>
 * Sorting-based approach
 */
public class _498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        List<List<Integer>> entries = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                entries.add(Arrays.asList(matrix[i][j], i, j));
        return entries.stream().sorted((u, v) -> {
            int d1 = u.get(1) + u.get(2), d2 = v.get(1) + v.get(2);
            if (d1 != d2) return Integer.compare(d1, d2);
            else return Integer.compare(u.get(1), v.get(1)) * (d1 % 2 == 0 ? -1 : 1);
        }).mapToInt(u -> u.get(0)).toArray();
    }
}

