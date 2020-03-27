/* Duplicate Emails 找重复的电子邮箱 */

SELECT 
  Email
FROM 
  Person
GROUP BY 
  Email
HAVING 
  count(Email) > 1;