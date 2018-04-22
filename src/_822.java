import java.util.HashSet;
import java.util.Set;


/**
 * LeetCode 822 - Card Flipping Game
 */
public class _822 {

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> candidates = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            candidates.add(fronts[i]);
            candidates.add(backs[i]);
        }
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                candidates.remove(fronts[i]);
            }
        }
        return candidates.isEmpty() ? 0 : candidates.stream().min(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        _822 sol = new _822();
        System.out.println(sol.flipgame(new int[]{1, 2, 4, 4, 7}, new int[]{1, 3, 4, 1, 3}));
        System.out.println(sol.flipgame(new int[]{1, 2}, new int[]{2, 1}));
    }
}

