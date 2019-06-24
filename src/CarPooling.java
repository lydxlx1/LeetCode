import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Car Pooling
 *
 * Sweep-line algorithm
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int on = 1, off = 0;
        List<int[]> events = new ArrayList<>();
        for (int[] trip : trips) {
            events.add(new int[]{trip[1], on, trip[0]});
            events.add(new int[]{trip[2], off, trip[0]});
        }
        // event[0]: x-axis coordinate
        // event[1]: on or off
        // event[2]: # of people getting on or off
        Collections.sort(events, Comparator.<int[]>comparingInt(arr -> arr[0]).thenComparingInt(arr -> arr[1]));

        int total = 0;
        for (int[] event : events) {
            if (event[1] == on) {
                total += event[2];
                if (total > capacity) {
                    return false;
                }
            } else {
                total -= event[2];
            }
        }
        return true;
    }
}
