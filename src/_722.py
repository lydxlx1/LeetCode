"""
LeetCode 722 - Remove Comments

Just string manipulation...
"""


class Solution:
    def removeComments(self, source):
        """
        :type source: List[str]
        :rtype: List[str]
        """
        s = "\n".join(source)
        i = 0
        res = ""

        def eat(s, start, target):
            for i in range(start, len(s)):
                if s[i:i + len(target)] == target:
                    return i + len(target)
            return len(s)

        while i < len(s):
            if s[i:i + 2] == '//':
                res += "\n";
                i = eat(s, i, '\n')
            elif s[i:i + 2] == '/*':
                i = eat(s, i + 2, '*/')
            else:
                res += s[i]
                i += 1

        return [token for token in res.split("\n") if token]
