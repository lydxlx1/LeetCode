-- LeetCode 196 - Delete Duplicate Emails
-- Cannot Delete/Update and Select the same table at a time
DELETE FROM
    Person
WHERE 
    Id NOT IN (
        SELECT 
            Id
        FROM (
            SELECT
                MIN(Id) AS Id,
                Email
            FROM
                Person
            GROUP BY
                Email
        ) b
    )