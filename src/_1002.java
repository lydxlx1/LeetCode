import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * LeetCode 1002 - Find Common Characters
 */
public class _1002 {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int totalCnt = 1 << 29;
            for (String s : A) {
                int cnt = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == ch) {
                        cnt++;
                    }
                }
                totalCnt = Math.min(totalCnt, cnt);
            }

            for (int i = 0; i < totalCnt; i++) {
                res.add("" + ch);
            }
        }
        return res;
    }
}