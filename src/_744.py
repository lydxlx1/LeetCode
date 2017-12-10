"""
LeetCode 744 - Find Smallest Letter Greater Than Target

Stupid problem description...
"""
import itertools as it


class Solution:
    def nextGreatestLetter(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """
        cnt = [0] * 128
        for letter in letters:
            cnt[ord(letter[0])] += 1
        return chr(next(filter(lambda ch: cnt[ch] > 0,
                               it.chain(range(ord(target[0]) + 1, ord('z') + 1),
                                        range(ord('a'), ord(target[0]))))))
