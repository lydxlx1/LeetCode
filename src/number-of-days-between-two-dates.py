"""1360. Number of Days Between Two Dates

Most programming languages should have date related packages.
Worth getting familiar with them.
"""
from datetime import datetime


class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        date1 = datetime.fromisoformat(date1)
        date2 = datetime.fromisoformat(date2)
        return (max(date1, date2) - min(date1, date2)).days
