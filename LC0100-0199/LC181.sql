/* Employees Earning More Than Their Managers 超过经理收入的员工 */

SELECT
  e.name as 'Employee'
FROM
  employee e, employee m
WHERE
  e.managerid = m.id 
    AND
  e.salary > m.salary;