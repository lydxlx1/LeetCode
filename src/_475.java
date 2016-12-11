import java.util.TreeSet;

/**
 * LeetCode 475 - Heaters
 */
public class _475 {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for (int heater : heaters) tree.add(heater);
        for (int house : houses) {
            Integer closestHeater = 0, min = Integer.MAX_VALUE;
            if ((closestHeater = tree.floor(house)) != null)
                min = Math.min(min, house - closestHeater);
            if ((closestHeater = tree.ceiling(house)) != null)
                min = Math.min(min, closestHeater - house);
            radius = Math.max(radius, min);
        }
        return radius;
    }
}