"""
LeetCode 728 - Self Dividing Numbers
"""


class Solution:
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """

        def is_self_dividing(n):
            s = str(n)
            return '0' not in s and all(n % (ord(i) - ord('0')) == 0 for i in s)

        return [i for i in range(left, right + 1) if is_self_dividing(i)]
