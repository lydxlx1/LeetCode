"""
LeetCode 824 - Goat Latin

Just be careful for capital vowels.
"""


class Solution:
    def toGoatLatin(self, S):
        """
        :type S: str
        :rtype: str
        """

        def convert(S):
            if S[0].lower() in {'a', 'e', 'i', 'o', 'u'}:
                return S + 'ma'
            else:
                return S[1:] + S[0] + 'ma'

        return ' '.join(
            convert(s) + 'a' * (cnt + 1)
            for s, cnt in zip(S.split(' '), range(len(S.split(' '))))
        )
