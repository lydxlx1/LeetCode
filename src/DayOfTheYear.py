"""
Day of the Year

Math
"""

from typing import *


class Solution:
    def dayOfYear(self, date: str) -> int:
        def is_leap_year(year: int) -> bool:
            if year % 100 == 0:
                return year % 400 == 0
            else:
                return year % 4 == 0

        y, m, d = date.split("-")
        days = [0, 31, 28 if not is_leap_year(int(y)) else 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        return sum(days[i] for i in range(1, int(m))) + int(d)
