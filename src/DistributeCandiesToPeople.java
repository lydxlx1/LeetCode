/**
 * Distribute Candies to People
 *
 * Brute-force
 * Only need sqrt(n) time
 */
public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int i = 1; candies > 0; i++) {
            int take = Math.min(i, candies);
            res[(i - 1) % num_people] += take;
            candies -= take;
        }
        return res;
    }
}
