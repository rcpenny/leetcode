/* Customers Who Never Order 从不订购的客户 */

SELECT
  c.name as 'Customers'
FROM
  customers c
WHERE
  c.id not in (
    select customerid from orders
  )