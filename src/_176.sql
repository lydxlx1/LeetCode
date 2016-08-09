-- LeetCode 176 - Second Highest Salary
SELECT (
    SELECT DISTINCT
        Salary
    FROM
        Employee
    ORDER BY 
        Salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary