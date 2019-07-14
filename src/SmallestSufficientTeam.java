import java.util.*;


/**
 * Smallest Sufficient Team
 *
 * DP
 */
public class SmallestSufficientTeam {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skills = new HashMap<>();
        int[] masks = new int[people.size()];
        for (int i = 0; i < req_skills.length; i++) {
            skills.put(req_skills[i], i);
        }
        for (int i = 0; i < people.size(); i++) {
            for (String skill : people.get(i)) {
                masks[i] |= 1 << skills.get(skill);
            }
        }

        int[][] f = new int[masks.length][1 << skills.size()];
        int inf = 1 << 28;
        for (int i = 0; i < f.length; i++) {
            f[i][0] = 0;

            for (int j = 1; j < f[i].length; j++) {
                if (i == 0) {
                    f[i][j] = (masks[i] | j) == masks[i] ? 1 : inf;
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j ^ (j & masks[i])] + 1);
                }
            }
        }

        int i = masks.length - 1, j = (1 << skills.size()) - 1;
        List<Integer> res = new ArrayList<>();
        while (j > 0) {
            if (i - 1 >= 0 && f[i - 1][j] == f[i][j]) {
                i--;
            } else {
                res.add(i);
                j ^= j & masks[i--];
            }
        }
        return res.stream().sorted().mapToInt($ -> $).toArray();
    }
}


