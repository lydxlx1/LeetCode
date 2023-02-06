/**
 * LeetCode 2555 - Maximize Win From Two Segments
 * 
 * Sliding window + Prefix/Suffix max
 */
class Solution {
public:
    int maximizeWin(vector<int>& prize, int k) {
        int n = prize.size();
        if (n == 1)
            return 1;
        
        vector<int> f(n), g(n);
        for (int i=0, pre=0; i<n; i++) {
            while (pre < i && prize[i] - prize[pre] > k)
                pre++;
            f[i] = i - pre + 1;
        }
        for (int i=n-1, pre=n-1; i>=0; i--) {
            while (pre > i && prize[pre] - prize[i] > k)
                pre--;
            g[i] = pre - i + 1;
            if (i + 1 < n)
                g[i] = max(g[i], g[i+1]);
        }

        int ans = 0;
        for (int i=0; i<n-1; i++)
            ans = max(ans, f[i] + g[i+1]);

        return ans;
    }
};