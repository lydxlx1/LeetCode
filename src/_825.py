"""
LeetCode 825 - Friends of Appropriate Ages
"""


class Solution:
    def numFriendRequests(self, ages):
        """
        :type ages: List[int]
        :rtype: int
        """
        cnt = [0] * 121
        for age in ages:
            cnt[age] += 1

        ans = 0
        for a in range(121):
            for b in range(121):
                if b <= 0.5 * a + 7 or b > a or (b > 100 and a < 100):
                    continue
                ans += cnt[a] * cnt[b] if a != b else cnt[a] * (cnt[b] - 1)

        return ans
