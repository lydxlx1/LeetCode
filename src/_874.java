import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * LeetCode 874 - Walking Robot Simulation
 */
public class _874 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<List<Integer>> noway = new HashSet<>();
        for (int[] obstacle : obstacles) {
            noway.add(Arrays.asList(obstacle[0], obstacle[1]));
        }

        int ans = 0, x = 0, y = 0, dir = 0;
        for (int command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int t = 0; t < command; t++) {
                    int xx = x + dx[dir];
                    int yy = y + dy[dir];
                    if (noway.contains(Arrays.asList(xx, yy))) {
                        break;
                    } else {
                        x = xx;
                        y = yy;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}

