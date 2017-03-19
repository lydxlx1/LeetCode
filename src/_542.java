import java.util.*;

/**
 * LeetCode 542 - 01 Matrix
 * <p>
 * BFS
 * We insert all the positions of zeros into the queue initially.
 */
public class _542 {

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) return new ArrayList<>();
        int r = matrix.size(), c = matrix.get(0).size();
        List<List<Integer>> res = new ArrayList<>(r);
        for (int i = 0; i < r; i++) {
            List<Integer> list = new ArrayList<>(c);
            for (int j = 0; j < c; j++) list.add(-1);
            res.add(list);
        }

        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (matrix.get(i).get(j) == 0) {
                    queue.add(Arrays.asList(i, j));
                    res.get(i).set(j, 0);
                }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int i = queue.peek().get(0);
            int j = queue.poll().get(1);
            int d = res.get(i).get(j);
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < r && y >= 0 && y < c && res.get(x).get(y) == -1) {
                    res.get(x).set(y, d + 1);
                    queue.add(Arrays.asList(x, y));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _542 sol = new _542();
    }
}
