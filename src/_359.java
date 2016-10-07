import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 359 - Logger Rate Limiter
 * <p>
 * Simple HashMap solution
 */
public class _359 {

    private final Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public _359() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean flag = !map.containsKey(message) || timestamp - map.get(message) >= 10;
        if (flag) map.put(message, timestamp);
        return flag;
    }
}