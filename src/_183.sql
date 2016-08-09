-- LeetCode 183 - Customers Who Never Orders
SELECT
    a.Name AS Customers
FROM
    Customers a
LEFT OUTER JOIN
    Orders b
ON
    a.Id = b.CustomerId
WHERE
    b.CustomerId IS NULL