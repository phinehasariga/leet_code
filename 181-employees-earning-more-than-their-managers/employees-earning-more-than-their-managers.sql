# Write your MySQL query statement below
select b.name as Employee from employee as a
join employee as b
on a.id = b.managerid
where b.salary > a.salary;