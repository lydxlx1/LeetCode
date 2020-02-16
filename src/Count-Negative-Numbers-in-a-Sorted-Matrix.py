"""Count Negative Numbers in a Sorted Matrix

Young Tableau"""

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        r, c = len(grid), len(grid[0])
        i, j = 0, c - 1
        ans = 0
        while i < r and j >= 0:
            if grid[i][j] < 0:
                ans += r - i
                j -= 1
            else:
                i += 1
        return ans
