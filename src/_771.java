/**
 * LeetCode 771 - Jewels and Stones
 */
public class _771 {

    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        boolean[] hash = new boolean[128];
        for (char ch : J.toCharArray()) {
            hash[ch] = true;
        }
        for (char ch : S.toCharArray()) {
            if (hash[ch]) {
                ans++;
            }
        }
        return ans;
    }
}



