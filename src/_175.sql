-- LeetCode 175 - Combine Two Tables

SELECT
    FirstName,
    LastName,
    City,
    State
FROM
    Person a
LEFT OUTER JOIN
    Address b
ON
    a.PersonId = b.PersonId