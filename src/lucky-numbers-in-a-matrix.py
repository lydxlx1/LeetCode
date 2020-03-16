"""1380. Lucky Numbers in a Matrix

Linear-time solution
Since all elements are distinct in the matrix, we can pre-compute the min value per each row and the max value per each column.
Then, we scan the matrix one more time and find all the candidates.
"""

from typing import List


class Solution:
    def luckyNumbers(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        row_min = [min(row) for row in matrix]
        col_max = [max(matrix[i][j] for i in range(len(matrix)))
                   for j in range(len(matrix[0]))]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == row_min[i] and matrix[i][j] == col_max[j]:
                    ans.append(matrix[i][j])
        return ans
