"""
LeetCode 748 - Shortest Completing Word

Basically, there are two different directions.
1) Counter-based.
We represent each string as a counter and try to find out whether there exists a word counter that
completely dominates the plate counter.

2) Sorting-based
We represent each string in sorted order and try to find out whether there exists a (sorted) word
that contains the (sorted) plate as a sub-sequence.
The sub-sequence test can be done in linear time using two pointers.
"""
from collections import Counter


class Solution:
    def shortestCompletingWord(self, license_plate, words):
        """
        :type licensePlate: str
        :type words: List[str]
        :rtype: str
        """
        license_plate = Counter(''.join(filter(str.isalpha, license_plate)).lower())
        ans = None
        for word in words:
            if not (license_plate - Counter(word.lower())) and (not ans or len(word) < len(ans)):
                ans = word
        return ans
