import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 451 - Sort Characters by Frequency
 * <p>
 * Counting-sort
 */
public class _451 {
    public String frequencySort(String s) {
        int[] letterCnt = new int[128];
        for (char ch : s.toCharArray()) letterCnt[ch]++;
        Map<Integer, List<Character>> frequencyMap = new HashMap<>();
        for (char ch = 0; ch < 128; ch++)
            if (letterCnt[ch] > 0) {
                frequencyMap.putIfAbsent(letterCnt[ch], new ArrayList<>());
                frequencyMap.get(letterCnt[ch]).add(ch);
            }
        StringBuilder builder = new StringBuilder();
        for (int i = s.length(); i >= 1; i--)
            if (frequencyMap.containsKey(i)) {
                for (char ch : frequencyMap.get(i))
                    for (int j = 0; j < i; j++) builder.append(ch);
            }
        return builder.toString();
    }
}