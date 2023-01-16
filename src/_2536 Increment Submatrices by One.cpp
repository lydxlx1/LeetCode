/**
 * LeetCode 2536 - Increment Submatrices by One
 *
 * 2D suffix / prefix sum
 * Inclusion & Exclusion
 * Time complexity: O(Q + N^2)
 * Space complexity: O(N^2)
 */
class Solution {
public:
  vector<vector<int>> rangeAddQueries(int n, vector<vector<int>> &queries) {
    vector<vector<int>> mat(n, vector<int>(n, 0));

    // Here, mat[x][y] means we want to add mat[x][y] to all elements in the submatrics (or quadrant)
    // with top-left corner being (x, y). 
    // Then, each submatrix update can be splitted into four quadrant updates, using inclusion-exclusion.
    // This is also like a 2D suffix sum.
    for (auto &query: queries) {
      int x = query[0], y = query[1], xx = query[2], yy = query[3];
      mat[x][y]++;
      if (xx + 1 < n)
        mat[xx + 1][y]--;
      if (yy + 1 < n)
        mat[x][yy + 1]--;
      if (xx + 1 < n && yy + 1 < n)
        mat[xx + 1][yy + 1]++;
    }

    // Now, the actual value of final mat[x][y] is equal to the quadrant sum with bottom-right corner being (x, y),
    // which is again a 2D prefix sum and can be handled inclusion-exclusion too.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int &res = mat[i][j];
        res += i - 1 >= 0 ? mat[i - 1][j] : 0;
        res += j - 1 >= 0 ? mat[i][j - 1] : 0;
        res -= i - 1 >= 0 && j - 1 >= 0 ? mat[i - 1][j - 1] : 0;
      }
    }
    return mat;
  }
};
