"""
LeetCode 696 - Count Binary Substrings

O(n)-time/space solution
The space complexity can be further optimized to O(1), though.
"""


class Solution:
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        list = []
        cnt = 0
        for i in range(len(s)):
            if i == 0 or s[i] == s[i - 1]:
                cnt += 1
            else:
                list.append(cnt)
                cnt = 1
        list.append(cnt)
        return sum(min(list[i], list[i + 1]) for i in range(len(list) - 1))


sol = Solution()
print(sol.countBinarySubstrings('00110011'))
print(sol.countBinarySubstrings('10101'))
