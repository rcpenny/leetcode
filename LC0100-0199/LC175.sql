/* Combine Two Tables 组合两个表 */

SELECT 
  p.FirstName, p.LastName,
  a.City, a.State
FROM
  Person p LEFT JOIN Address a
ON 
  p.PersonId = a.PersonId;
