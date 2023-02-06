/**
 * LeetCode 2554 - Maximum Number of Integers to Choose From a Range I
 *
 * Simulation
 */
class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        int ans = 0;
        unordered_set<int> ban(banned.begin(), banned.end());
        for (int i=1; i<=n; i++) {
            if (ban.count(i)) continue;
            maxSum -= i;
            if (maxSum >= 0) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
};