import java.util.PriorityQueue;

/**
 * LeetCode 499 - The Maze II
 * <p>
 * A* Search, which is much faster
 */
public class _499 {
    static class State implements Comparable<State> {
        int dist, x, y;
        String path;

        State(int dist, String path, int x, int y) {
            this.dist = dist;
            this.path = path;
            this.x = x;
            this.y = y;
        }

        public int compareTo(State o) {
            if (dist != o.dist) return Integer.compare(dist, o.dist);
            else return path.compareTo(o.path);
        }
    }

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private char[] dir = "rldu".toCharArray();

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int r = maze.length, c = maze[0].length;
        State[][] states = new State[r][c];
        State init = new State(0, "", ball[0], ball[1]);
        states[ball[0]][ball[1]] = init;
        PriorityQueue<State> queue = new PriorityQueue<>();
        queue.add(init);
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            for (int k = 0; k < dx.length; k++) {
                int x = cur.x, y = cur.y;
                while (x >= 0 && x < r && y >= 0 && y < c && maze[x][y] == 0) {
                    x += dx[k];
                    y += dy[k];
                    if (x - dx[k] == hole[0] && y - dy[k] == hole[1]) break; // Stop if we just passed the hole
                }
                x -= dx[k];
                y -= dy[k];

                int d = cur.dist + Math.abs(x - cur.x) + Math.abs(y - cur.y);
                String s = cur.path + dir[k];
                State old = states[x][y];
                State neww = new State(d, s, x, y);
                if (old == null || neww.compareTo(old) < 0) {
                    states[x][y] = neww;
                    queue.add(neww);
                }
            }
        }
        return states[hole[0]][hole[1]] == null ? "impossible" : states[hole[0]][hole[1]].path;
    }
}

