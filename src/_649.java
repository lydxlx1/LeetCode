import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 649 - Dota2 Senate
 * <p>
 * Greedy + Queue
 * <p>
 * It is easy to see the optimal strategy is to greedily kick out the nearest opponent.
 * Then, it is straightforward to implement the algorithm via a queue.
 * <p>
 * The runtime is O(n) because in each round at most half of the senates can survive, otherwise the game is over.
 */
public class _649 {
    public String predictPartyVictory(String senate) {
        List<Character> list = new ArrayList<>(2 * senate.length()); // 2*length is enough
        List<Boolean> killed = new ArrayList<>(2 * senate.length()); // 2*length is enough
        for (int i = 0; i < senate.length(); i++) {
            list.add(senate.charAt(i));
            killed.add(false);
        }
        for (int i = 0, j = 0; ; ) {
            while (j < list.size()) {
                if (list.get(j) == 'D' && !killed.get(j)) {
                    break;
                }
                j++;
            }
            while (i < list.size()) {
                if (list.get(i) == 'R' && !killed.get(i)) {
                    break;
                }
                i++;
            }
            if (i >= list.size()) return "Dire";
            if (j >= list.size()) return "Radiant";

            killed.set(i, true);
            killed.set(j, true);
            if (i < j) {
                list.add('R');
                killed.add(false);
            } else {
                list.add('D');
                killed.add(false);
            }
        }
    }

    public static void main(String[] args) {
        _649 sol = new _649();
        System.out.println(sol.predictPartyVictory("RD"));
        System.out.println(sol.predictPartyVictory("RDD"));
        System.out.println(sol.predictPartyVictory("D"));
        System.out.println(sol.predictPartyVictory("R"));
    }
}