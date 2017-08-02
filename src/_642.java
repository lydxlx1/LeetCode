import java.util.*;

/**
 * LeetCode 642 - Design Search Autocomplete System
 * <p>
 * Brute-force solution
 */
public class _642 {

    Map<String, Integer> frequency = new HashMap<>();
    String current = "";


    public _642(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++)
            frequency.put(sentences[i], times[i]);
    }

    public List<String> input(char c) {
        if (c == '#') {
            frequency.put(current, frequency.getOrDefault(current, 0) + 1);
            current = "";
            return Collections.EMPTY_LIST;
        } else {
            current += c;
            List<String> cand = new ArrayList<>(4);
            for (String s : frequency.keySet())
                if (s.startsWith(current)) {
                    cand.add(s);
                    cand.sort(Comparator.<String>comparingInt(i -> frequency.get(i)).reversed().thenComparing(i -> i));
                    if (cand.size() == 4) cand.remove(3);
                }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < 3 && i < cand.size(); i++)
                res.add(cand.get(i));
            return res;
        }
    }
}

