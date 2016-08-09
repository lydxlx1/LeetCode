-- LeetCode 180 - Consecutive Numbers
SELECT DISTINCT
    a.Num AS ConsecutiveNums
FROM 
    Logs a 
INNER JOIN (
    SELECT
        Id + 1 AS Id, Num
    FROM
        Logs
) b
ON
    a.Id = b.Id AND a.Num = b.Num
INNER JOIN (
    SELECT
        Id + 2 AS Id, Num
    FROM
        Logs
) c
ON
    a.Id = c.Id AND a.Num = c.Num
