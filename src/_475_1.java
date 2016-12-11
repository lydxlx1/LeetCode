import java.util.Arrays;

/**
 * LeetCode 475 - Heaters
 * <p>
 * Binary searches the answer
 */
public class _475_1 {
    public int findRadius(int[] houses, int[] heaters) {
        int left = -1, right = 1000000000;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        while (left + 1 < right) {
            int mid = (left + right) / 2; // This will not overflow
            int i = 0, j = 0;
            while (i < houses.length && j < heaters.length)
                if (Math.abs(houses[i] - heaters[j]) <= mid) i++;
                else j++;
            if (i >= houses.length) right = mid;
            else left = mid;
        }
        return right;
    }
}