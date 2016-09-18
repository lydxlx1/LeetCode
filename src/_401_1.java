import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 401 Binary Watch
 *
 * Brute-force
 */
public class _401_1 {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++)
            for (int min = 0; min < 60; min++)
                if (Integer.bitCount(hour) + Integer.bitCount(min) == num)
                    ans.add(String.format("%d:%02d", hour, min));
        return ans;
    }
}