import re

"""
LeetCode 736 - Parse Lisp Expression
Parser
The only trick in this problem is to decide when to stop the variable list for let-clauses.
"""


class Solution:
    def evaluate(self, expression):
        """
        :type expression: str
        :rtype: int
        """

        self.tokens = re.split(r"[ ]+", expression.replace("(", " ( ").replace(")", " ) ").strip())
        self.ptr = 0

        def peek(i=0):
            return self.tokens[self.ptr + i]

        def next():
            res = peek()
            self.ptr += 1
            return res

        def dfs(vars):
            """
            :type s: str
            :type vars: dict[str, int]
            :rtype: int
            """
            token = next()
            if token == '(':
                token = next()
                if token == 'add':
                    res = dfs(vars) + dfs(vars)
                elif token == 'mult':
                    res = dfs(vars) * dfs(vars)
                else:
                    assert token == 'let'
                    new_vars = vars.copy()
                    while re.match(r'[a-z][a-z0-9]*', peek()) and peek(1) != ')':
                        key = next()  # Do this first
                        new_vars[key] = dfs(new_vars)
                    res = dfs(new_vars)

                assert next() == ')'
                return res
            else:
                return int(token) if re.match(r'[+-]?\d+', token) else vars[token]

        return dfs({})
