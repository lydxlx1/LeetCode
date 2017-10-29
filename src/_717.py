"""
LeetCode 717 - 1-bit and 2-bit Characters

"""
class Solution:
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        i = 0
        while i < len(bits):
            if bits[i] == 0:
                ans = True
                i += 1
            else:
                ans = False
                i += 2
        return ans
