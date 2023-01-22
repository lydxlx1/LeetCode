"""
2545. Sort the Students by Their Kth Score
"""
class Solution:
    def sortTheStudents(self, score: List[List[int]], k: int) -> List[List[int]]:
      return sorted(score, key=lambda row: -row[k])
