#combine two tables
#因为这里说了 regardless if there is an address for each of those people
#所以就是说全部的left join就好
select Person.FirstName, Person.LastName, Address.City, Address.State
from Person left join Address
on Person.PersonId = Address.PersonId;


Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

select MAX(Employee.Salary)
from Employee
where Employee.Salary < (select MAX(Employee.Salary) from Employee)

#或者还可以写成,只不过要慢一些
select MAX(Employee.Salary)
from Employee
where Employee.Salary not in(select MAX(Employee.Salary) from Employee);


The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+
#这里要用到两个表格，一个代表employee表，一个是manager表，并且这里是自己跟自己join所以要用到的是inner join

select e1.Name
from Employee e1 inner join Employee e2
on e1.ManagerId = e2.Id
where e1.Salary > e2.Salary;

Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
#这里说的是要找出重复的email，所以首先想到利用group by对email进行归类，然后将数量大于1的emailselect出来就好了
select Person.Email
from Person
group by Person.Email
having count(*) > 1;

Customer who never order
#这里要利用到left join,或者left outer join,然后要找never order所以只需要加上条件是Orders.CustomerId is null即可
select Customers.Name
from Customers left join Orders
on Customers.Id = Orders.CustomerId
where Orders.CustomerId is null;


#delete duplicate
#需要用到delete语句，并且需要先进行p1.Id > p2.Id的判断
delete p1
from Person p1, Person p2
where p1.Id > p2.Id and p1.Email = p2.Email;

# rising temperature
#遇到这种题，类似于自己在自己里面找两个元素的大小关系，这时候就要考虑用到inner join
#再就是对于API的熟练使用
select w1.Id
from Weather w1 inner join Weather w2 
on TO_DAYS(w1.Date) = TO_DAYS(w2.Date) + 1
where w1.temperature > w2.temperature;

The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
#按照题目中要求的，先找到三个column然后再在里面继续寻找，
#前提是两个表的departmentId相等然后salary是当前dep的最大salary
#然后找最大salary又是一个函数，相当于双重迭代关系
select dep.Name, emp.Name, emp.Salary
from Department dep, Employee emp
where emp.DepartmentId = dep.Id and 
Salary = (select max(Salary) from Employee emp2 where dep.Id = emp2.DepartmentId);

#Nth highest Salary
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct Employee.Salary
      from Employee
      group by Salary
      order by Salary DESC
      limit N,1
  );
END

#RANK SCORE
select Scores.Score, COUNT(Ranking.Score) as RANK
from Scores, (select distinct Score from Scores) Ranking
where Scores.Score <= Ranking.Score
group by Scores.Id, Scores.Score
order by Scores.Score DESC;

#select consecutive numbers which occur more than 2 times larger or equal to 3
#pay attention to distinct
#因为题目的意思是只要出现多于三次的我就找出来，
#而我做的是以3为一个基准，有可能一个num出现了4次那么这个数就会在结果中出现两次，
#所以要用distinct来选出unique的

select distinct l1.Num
from Logs l1, Logs l2, Logs l3
where l1.Id = l2.Id - 1 and
l2.Id = l3.Id - 1 and 
l1.Num = l2.Num and
l2.Num = l3.Num;




The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, your SQL query should return the following rows.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |

| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+

select d.Name as Department, e.Name as Employee, e.Salary as Salary
from Employee e inner join Department d 
on e.DepartmentId = d.Id
where (select count(distinct e1.Salary) from Employee e1 
	where e1.Salary > e.Salary and e1.DepartmentId = e.DepartmentId) < 3
order by d.Name, e.Salary DESC;