import java.util.*;

/**
 * LeetCode 675 - Cut Off Trees for Golf Event
 * <p>
 * BFS approach
 * <p>
 * This problem is worth to further explore.
 * A single BFS could be used to potentially answer multiple queries.
 * That is, consider any path from the root to a leaf in the BFS tree.
 * Then the pairwise shortest distance between any two nodes along the path is known and can be computed in O(1) time.
 * <p>
 * Therefore, an open question arises:
 * What is the minimum number of BFS's we need to perform to find the shortest pairwise distances between consecutive trees?
 */
class _675 {

    final int[] dx = {0, 0, 1, -1};
    final int[] dy = {1, -1, 0, 0};

    int[][] visited;
    int[][] queue;
    int r, c;

    public int cutOffTree(List<List<Integer>> forest) {
        r = forest.size();
        c = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
        Collections.sort(trees, Comparator.comparingInt(tree -> tree[0]));

        visited = new int[r][c];
        queue = new int[r * c][3];
        int totalDist = 0;
        for (int i = 0; i < trees.size(); i++) {
            int startX = i == 0 ? 0 : trees.get(i - 1)[1];
            int startY = i == 0 ? 0 : trees.get(i - 1)[2];
            int endX = trees.get(i)[1];
            int endY = trees.get(i)[2];
            OptionalInt dist = bfs(forest, startX, startY, endX, endY);
            if (dist.isPresent()) {
                totalDist += dist.getAsInt();
            } else {
                return -1;
            }
        }
        return totalDist;
    }

    private OptionalInt bfs(List<List<Integer>> forest, int startX, int startY, int endX, int endY) {
        int head = 0, tail = 1;
        queue[0][0] = startX;
        queue[0][1] = startY;
        queue[0][2] = 0;
        int treeHeight = forest.get(endX).get(endY);
        visited[startX][startY] = treeHeight;
        while (head < tail) {
            int x = queue[head][0], y = queue[head][1], d = queue[head++][2];
            if (x == endX && y == endY) {
                return OptionalInt.of(d);
            }

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i], yy = y + dy[i];
                if (xx >= 0 && xx < r && yy >= 0 && yy < c && visited[xx][yy] < treeHeight && forest.get(xx).get(yy) > 0) {
                    queue[tail][0] = xx;
                    queue[tail][1] = yy;
                    queue[tail++][2] = d + 1;
                    visited[xx][yy] = treeHeight;
                }
            }
        }
        return OptionalInt.empty();
    }

    public static void main(String[] args) {
        _675 sol = new _675();

        {
            List<List<Integer>> forest = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(0, 0, 4),
                    Arrays.asList(7, 6, 5)
            );
            System.out.println(sol.cutOffTree(forest));
        }
        {
            List<List<Integer>> forest = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(0, 0, 0),
                    Arrays.asList(7, 6, 5)
            );
            System.out.println(sol.cutOffTree(forest));
        }
        {
            List<List<Integer>> forest = Arrays.asList(
                    Arrays.asList(2, 3, 4),
                    Arrays.asList(0, 0, 5),
                    Arrays.asList(8, 7, 6)
            );
            System.out.println(sol.cutOffTree(forest));
        }
    }
}