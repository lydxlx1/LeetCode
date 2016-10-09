/**
 * LeetCode 418 - Sentence Screen Fitting
 * <p>
 * Simulation
 * <p>
 * We spend O(n) time on padding each row, resulting in an O(n * rows)-time solution.
 * Here, n denotes the number of sentences.
 * <p>
 * Conceptually, each row consists of the following three parts:
 * 1. a nullable suffix of the given list, followed by
 * 2. as many as complete given lists, followed by
 * 3. a nullable proper prefix of the given list
 * <p>
 * Part 1 and 3 can be handled by brute-force in O(n) time, and part 2 can be done in O(1) time via a division
 * after we pre-compute the total length of the sentences. Therefore, the overall runtime is O(n * rows).
 *
 * https://discuss.leetcode.com/topic/62297/a-simple-simulation
 */
public class _418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sum = 0, ans = 0, which = 0;
        for (String s : sentence) sum += s.length();
        for (int i = 0; i < rows; i++) {
            int remaining = cols + 1; // reserve an extra space for the dummy space to the left of the first letter
            while (which < sentence.length && sentence[which].length() + 1 <= remaining)
                remaining -= sentence[which++].length() + 1;
            if (which >= sentence.length) {
                which = 0;
                ans = ans + 1 + remaining / (sum + sentence.length);
                remaining %= sum + sentence.length;
                while (which < sentence.length && sentence[which].length() + 1 <= remaining)
                    remaining -= sentence[which++].length() + 1;
            }
        }
        return ans;
    }
}
