-- LeetCode 181 - Employees Earning More Than Their Managers
SELECT
    a.Name AS Employee
FROM
    Employee a
INNER JOIN 
    Employee b
ON 
    a.ManagerId = b.Id
WHERE
    a.Salary > b.Salary
