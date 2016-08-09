-- LeetCode 178 - Rank Scores
SELECT
    Score,
    (SELECT COUNT(DISTINCT b.score) FROM (SELECT DISTINCT Score FROM Scores) AS b WHERE b.Score >= a.Score) AS Rank
FROM Scores AS a
ORDER BY Rank