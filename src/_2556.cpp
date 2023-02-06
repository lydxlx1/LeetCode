/**
 * LeetCode 2556 - Disconnect Path in a Binary Matrix by at Most One Flip
 *
 * DP approach to count # of distinct paths
 * 
 * 1. First check whether there exist one path.
 * 2. If so, then the question boils down to identify a cut-vertex of the graph.
 * 3. A simple way to tell whether (i, j) is a cut-vertex is by counting # of 
 *    distinct 1-path from (0, 0) to (i, j) and from (i, j) to (r - 1, c - 1). 
 *    By rule of product, if the product of these two counts is equal to the 
 *    total distinct # of 1-path from (0, 0) to (r - 1, c - 1), then it is a 
 *    cut-vertex; vice versa.
 * 4. The overall count can be very large. One possible way is to do the calculation
 *    modulo some big prime number.
 */
class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        long long mod = 1000000007;
        int r = grid.size(), c = grid[0].size();
        vector<vector<long long>> f(r + 2, vector<long long>(c + 2));
        vector<vector<long long>> g(r + 2, vector<long long>(c + 2));

        if (grid[0][0] == 0 || grid[r - 1][c - 1] == 0)
            return true;
        
        f[1][1] = 1;
        for (int i=1; i<=r; i++)
            for (int j=1; j<=c; j++) {
                if (i == 1 && j == 1) continue;
                if (grid[i-1][j-1] == 1) 
                    f[i][j] = (f[i-1][j] + f[i][j-1]) % mod;
            }
                    
        g[r][c] = 1;
        for (int i=r; i>=1; i--)
            for (int j=c; j>=1; j--) {
                if (i == r && j == c) continue;
                if (grid[i-1][j-1] == 1)
                    g[i][j] = (g[i+1][j] + g[i][j+1]) % mod;
            }
        
        if (f[r][c] == 0)
            return true;
        assert (f[r][c] == g[1][1]);
        for (int i=1; i<=r; i++)
            for (int j=1; j<=c; j++) {
                if (i == 1 && j == 1) continue;
                if (i == r && j == c) continue;
                long long tmp = f[i][j] * g[i][j] % mod;
                if (tmp == f[r][c]) {
                    return true;
                }
            }
        return false;        
    }
};