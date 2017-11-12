"""
LeetCode 726 - Number of Atoms

LL-Parser

Rules:
1) S -> epsilon, triggered when the next character is epsilon or ')'.
2) S -> [A-Z][a-z]*[0-9]* S, triggered when the next character is [A-Z].
3) S -> (S)[0-9]* S, triggered when the next character is '('.
"""
from collections import defaultdict


class Solution:
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """

        self.ptr = 0

        def _atom(s):
            res = s[self.ptr]
            self.ptr += 1
            while self.ptr < len(s) and str.islower(s[self.ptr]):
                res += s[self.ptr]
                self.ptr += 1
            return res

        def _count(s):
            res = ""
            while self.ptr < len(s) and str.isnumeric(s[self.ptr]):
                res += s[self.ptr]
                self.ptr += 1
            return int(res) if res else 1

        def merge(m, M):
            if len(m) > len(M):
                return merge(M, m)
            for atom, cnt in m.items():
                M[atom] += cnt
            return M

        def doit(s):
            if self.ptr >= len(s) or s[self.ptr] == ')':
                return defaultdict(int)

            if s[self.ptr] == '(':
                self.ptr += 1  # eat (
                m = doit(s)
                self.ptr += 1  # eat )

                count = _count(s)
                m = defaultdict(int, {k: v * count for k, v in m.items()})
            else:
                atom = _atom(s)
                count = _count(s)
                m = defaultdict(int, {atom: count})

            return merge(m, doit(s))

        m = doit(formula)
        return ''.join('{0}{1}'.format(atom, m[atom] if m[atom] > 1 else '') for atom in sorted(m.keys()))
