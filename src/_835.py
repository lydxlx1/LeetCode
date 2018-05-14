from collections import Counter

"""
LeetCode 835 - Image Overlap

Math
Note that: To align B[ii][jj] to A[i][j], there exists an UNIQUE translation (i - ii, j - jj).
"""


class Solution:
    def largestOverlap(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: int
        """
        n = len(A)
        cnt = Counter()
        for i in range(n):
            for j in range(n):
                if A[i][j] == 1:
                    for ii in range(n):
                        for jj in range(n):
                            if B[ii][jj] == 1:
                                cnt[(i - ii, j - jj)] += 1
        return max(list(cnt.values()) + [0])
