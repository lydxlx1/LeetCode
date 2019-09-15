"""Reverse Substrings Between Each Pair of Parentheses

Simulation via a stack
"""
class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack = [""]
        for ch in s:
            if ch == "(":
                stack.append("")
            elif ch == ")":
                token = stack.pop(-1)
                stack[-1] += "".join(reversed(token))
            else:
                stack[-1] += ch
        return stack[0]
