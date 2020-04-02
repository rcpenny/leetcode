/* Find the Team Size 求团队人数 */

SELECT
  e.employee_id, s.team_size
FROM
  Employee e LEFT JOIN (
    SELECT team_id, count(*) team_size
    FROM Employee GROUP BY team_id
  ) s
ON
  e.team_id = s.team_id