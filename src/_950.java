import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 950 - Reveal Cards in Increasing Order
 *
 * Simulation
 */
public class _950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int[] ans = new int[n];
        Queue<Integer> queue = new ArrayDeque<>(IntStream.range(0, n).boxed().collect(Collectors.toList()));

        int ptr = 0;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            ans[head] = deck[ptr++];
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        return ans;
    }
}

