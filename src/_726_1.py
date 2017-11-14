"""
LeetCode 726 - Number of Atoms

Non-recursive solution using a stack

It is easy to parse the original string (via a stack) in a right-to-left fashion.
This is because the quantities are located to the right of each group.
"""
from collections import defaultdict


class Solution:
    def countOfAtoms(self, formula):
        """
        :type formula: str
        :rtype: str
        """
        stack = [1]
        atom, multiplier, base = ("", 0, 1)
        map = defaultdict(int)
        for ch in reversed(formula):  # read the formula from right to left
            if ch == '(':
                stack.pop(-1)
            elif str.islower(ch):
                atom += ch
            elif str.isdigit(ch):
                multiplier += base * (ord(ch) - ord('0'))
                base *= 10
            elif str.isupper(ch):
                atom += ch
                map[atom[::-1]] += max(multiplier, 1) * stack[-1]
                atom, multiplier, base = ("", 0, 1)
            elif ch == ')':
                stack.append(max(multiplier, 1) * stack[-1])  # prefix prod
                atom, multiplier, base = ("", 0, 1)
            else:
                raise

        return "".join('{0}{1}'.format(atom, map[atom] if map[atom] > 1 else "") for atom in sorted(map.keys()))


sol = Solution()
print(sol.countOfAtoms("H2O"))
print(sol.countOfAtoms("Mg(OH)2"))
print(sol.countOfAtoms("K4(ON(SO3)2)2"))

