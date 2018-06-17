import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * LeetCode 853 - Car Fleet
 * <p>
 * Math
 */
public class _853 {


    public int carFleet(int target, int[] position, int[] speed) {
        double eps = 1E-8;
        Integer[] car = new Integer[position.length];
        for (int i = 0; i < car.length; i++) {
            car[i] = i;
        }
        Arrays.sort(car, Comparator.comparingInt(i -> -position[i]));

        double timeAhead = 0;
        int total = 0;
        for (int i : car) {
            double t = 1.0 * (target - position[i]) / speed[i];
            if (t - eps <= timeAhead) {
                // Current car is faster, but will form a fleet with the car ahead.
                continue;
            } else {
                timeAhead = t;
                total++;
            }
        }
        return total;
    }
}

