"""
Invalid Transactions

Brute-force
"""
from typing import *
import collections


class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        Trans = collections.namedtuple("Trans", ["str", "name", "time", "amount", "city"])
        transactions = [Trans(t, *t.split(",")) for t in transactions]
        return [t.str for t in transactions
                if int(t.amount) > 1000
                or any(True for tt in transactions if
                       t.name == tt.name and t.city != tt.city and abs(int(t.time) - int(tt.time)) <= 60)]
