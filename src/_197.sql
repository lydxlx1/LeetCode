-- LeetCode 197 - Rising Temperature
SELECT
    today.Id
FROM
    Weather today
INNER JOIN 
    Weather yesterday
ON
    today.Date = DATE_ADD(yesterday.Date, INTERVAL 1 DAY)
WHERE
    today.Temperature > yesterday.Temperature