-- LeetCode 184 - Department Highest Salary
SELECT d.Name AS Department, e.Name AS Employee, e.Salary AS Salary
FROM ( 
    SELECT Name, DepartmentId, Salary
    FROM Employee a
    WHERE NOT EXISTS (SELECT * FROM Employee b WHERE a.DepartmentId = b.DepartmentId AND a.Salary < b.Salary)
) e
INNER JOIN Department d
ON e.DepartmentId = d.Id