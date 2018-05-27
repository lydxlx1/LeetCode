import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 842 - Split Array into Fibonacci Sequence
 * <p>
 * We just need to enumerate the first two-terms by brute-force and then verify whether it is a valid solution.
 */
public class _842 {

    public List<Integer> splitIntoFibonacci(String S) {
        for (int len1 = 1; len1 < S.length(); len1++)
            for (int len2 = 1; len1 + len2 < S.length(); len2++) {
                List<Integer> list = doit(S, S.substring(0, len1), S.substring(len1, len1 + len2));
                if (list != null)
                    return list;
            }
        return new ArrayList<>();
    }

    private List<Integer> doit(String s, String secondLastTerm, String lastTerm) {
        try {
            List<Integer> list = new ArrayList<>();
            long a = Integer.parseInt(secondLastTerm);
            long b = Integer.parseInt(lastTerm);
            String buffer = "" + a + b;
            list.add((int) a);
            list.add((int) b);
            while (buffer.length() < s.length() && s.startsWith(buffer)) {
                long c = a + b;
                if (c >= Integer.MAX_VALUE)
                    return null;

                list.add((int) c);
                buffer += c;
                a = b;
                b = c;
            }
            return s.equals(buffer) ? list : null;
        } catch (Exception e) {
            return null;
        }
    }
}

