/* Employee Bonus 员工奖金 */

SELECT
  name, bonus
FROM
  Employee LEFT JOIN Bonus
ON
  Employee.EmpId = Bonus.EmpId
WHERE
  bonus IS NULL or bonus < 1000