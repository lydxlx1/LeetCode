import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 401 - Binary Watch
 *
 * Brute-force
 */
public class _401 {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for (int bit = 0; bit < (1 << 10); bit++) {
            if (Integer.bitCount(bit) != num) continue;
            int hour = bit >> 6, min = bit & 0b111111;
            if (hour < 12 && min < 60) ans.add(String.format("%d:%02d", hour, min));
        }
        return ans;
    }
}