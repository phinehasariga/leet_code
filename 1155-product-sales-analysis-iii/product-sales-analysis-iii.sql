# Write your MySQL query statement below
SELECT
  product_id,
  year AS first_year,
  quantity,
  price
FROM
  Sales S
WHERE(s.product_id,s.year) in  (select s.product_id,min(s.year) as year from sales s 
group by s.product_id
  );

