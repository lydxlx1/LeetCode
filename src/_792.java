import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * LeetCode 792 - Number of Matching Subsequences
 * <p>
 * O(n + m)-time solution, where n is len(S), m is sum(len(words[i])).
 */
public class _792 {

    public int numMatchingSubseq(String S, String[] words) {
        int[] ptr = new int[words.length];
        List<Integer>[] queues = new List[26];
        for (int i = 0; i < 26; i++) {
            queues[i] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            int ch = words[i].charAt(0) - 'a';
            queues[ch].add(i);
        }

        for (int i = 0; i < S.length(); i++) {
            int ch = S.charAt(i) - 'a';
            List<Integer> matches = queues[ch];
            queues[ch] = new ArrayList<>();

            for (int j : matches) {
                ptr[j]++;
                if (ptr[j] < words[j].length()) {
                    int chch = words[j].charAt(ptr[j]) - 'a';
                    queues[chch].add(j);
                }
            }
        }
        return (int) IntStream.range(0, words.length).filter(i -> ptr[i] >= words[i].length()).count();
    }
}
