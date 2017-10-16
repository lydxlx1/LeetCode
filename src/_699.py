"""
LeetCode 699 - Falling Squares

O(n^2)-time simple solution
"""


class Solution:
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        squares = []
        ans = []
        previous_ans = 0
        for begin, length in positions:
            end = begin + length - 1
            height = max((square[2] for square in squares if not (begin > square[1] or end < square[0])), default=0)
            squares.append((begin, end, height + length))

            previous_ans = max(previous_ans, height + length)
            ans.append(previous_ans)

        return ans


sol = Solution()
print(sol.fallingSquares([[1, 2], [2, 3], [6, 1]]))
