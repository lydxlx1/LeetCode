"""
LeetCode 833 - Find and Replace in String

"""


class Solution:
    def findReplaceString(self, S, indexes, sources, targets):
        """
        :type S: str
        :type indexes: List[int]
        :type sources: List[str]
        :type targets: List[str]
        :rtype: str
        """
        res, pos = "", 0
        for idx, source, target in sorted(zip(indexes, sources, targets)):
            if S[idx:].startswith(source):
                res += S[pos:idx]
                res += target
                pos = idx + len(source)

        return res + S[pos:]
