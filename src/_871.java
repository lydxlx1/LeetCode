import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 871 - Minimum Number of Refueling Stops
 * <p>
 * Note that the tank has infinite capacity, so this problem can be simply solved by greedy.
 */
public class _871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        Queue<Integer> fuels = new PriorityQueue<>(Comparator.<Integer>comparingInt(i -> i).reversed());
        int fuel = startFuel;
        int i = 0;
        while (fuel < target) {
            while (i < stations.length && stations[i][0] <= fuel) {
                fuels.add(stations[i][1]);
                i++;
            }
            if (fuels.isEmpty()) {
                return -1;
            }
            fuel += fuels.poll();
            stops++;
        }
        return stops;
    }
}

