/**
 * LeetCode 277 - Find the Celebrity
 *
 * O(n) solution using adjacent matrix
 */
public class _277 extends Relation {
    public int findCelebrity(int n) {
        int cand = 0;
        for (int i = 1; i < n; i++)
            if (knows(cand, i)) cand = i;
        for (int i = 0; i < n; i++)
            if (i != cand && (knows(cand, i) || !knows(i, cand))) return -1;
        return cand;
    }
}