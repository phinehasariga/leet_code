# Write your MySQL query statement below
select name , bonus
from Employee 
left join bonus as b
on Employee.empId = b.empId
where bonus < 1000 or bonus is null;