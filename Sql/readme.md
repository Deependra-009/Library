<h1>Sql Questions</h1>

### 1. Write an SQL query to fetch all records from the `employees` table.

**Answer:**

```sql
SELECT *
FROM employees;
```

---

### 2. Write an SQL query to fetch only the `first_name` and `last_name` columns from the `employees` table.

**Answer:**

```sql
SELECT first_name, last_name
FROM employees;
```

---

### 3. Write an SQL query to fetch unique job titles from the `employees` table.

**Answer:**

```sql
SELECT DISTINCT job_title
FROM employees;
```

---

### 4. Write an SQL query to fetch all employees whose salary is greater than 50,000.

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary > 50000;
```

---

### 5. Write an SQL query to fetch employees who joined between '2020-01-01' and '2022-12-31'.

**Answer:**

```sql
SELECT *
FROM employees
WHERE joining_date BETWEEN '2020-01-01' AND '2022-12-31';
```

---

### 6. Write an SQL query to fetch all employees whose first name starts with 'A'.

**Answer:**

```sql
SELECT *
FROM employees
WHERE first_name LIKE 'A%';
```

---

### 7. Write an SQL query to fetch employees from the `employees` table who do not have a manager (manager_id is NULL).

**Answer:**

```sql
SELECT *
FROM employees
WHERE manager_id IS NULL;
```

---

### 8. Write an SQL query to sort the employees by their salary in descending order.

**Answer:**

```sql
SELECT *
FROM employees
ORDER BY salary DESC;
```

---

### 9. Write an SQL query to find the maximum salary from the `employees` table.

**Answer:**

```sql
SELECT MAX(salary) AS max_salary
FROM employees;
```

---

### 10. Write an SQL query to find the total number of employees in the `employees` table.

**Answer:**

```sql
SELECT COUNT(*) AS total_employees
FROM employees;
```

---

### 11. Write an SQL query to calculate the average salary of employees.

**Answer:**

```sql
SELECT AVG(salary) AS average_salary
FROM employees;
```

---

### 12. Write an SQL query to fetch the department-wise total salary from the `employees` table.

**Answer:**

```sql
SELECT department_id, SUM(salary) AS total_salary
FROM employees
GROUP BY department_id;
```

---

### 13. Write an SQL query to fetch departments having total salary greater than 500,000.

**Answer:**

```sql
SELECT department_id, SUM(salary) AS total_salary
FROM employees
GROUP BY department_id
HAVING SUM(salary) > 500000;
```

---

### 14. Write an SQL query to fetch employee names along with their department names (using JOIN between `employees` and `departments` tables).

**Answer:**

```sql
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id;
```

---

### 15. Write an SQL query to fetch employees who work in the 'IT' department.

**Answer:**

```sql
SELECT e.*
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id
WHERE d.department_name = 'IT';
```

---

### 16. Write an SQL query to fetch employees whose first name contains 'an' anywhere.

**Answer:**

```sql
SELECT *
FROM employees
WHERE first_name LIKE '%an%';
```

---

### 17. Write an SQL query to list all employees who have a salary between 30,000 and 60,000.

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary BETWEEN 30000 AND 60000;
```

---

### 18. Write an SQL query to fetch the second highest salary from the `employees` table.

**Answer:**

```sql
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);
```

---

### 19. Write an SQL query to fetch the top 3 highest salaried employees.

**Answer:**

```sql
SELECT *
FROM employees
ORDER BY salary DESC
LIMIT 3;
```

---

### 20. Write an SQL query to fetch employees along with their managers' names (self-join).

**Answer:**

```sql
SELECT e.first_name AS employee_name, m.first_name AS manager_name
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.employee_id;
```

---

### 21. Write an SQL query to fetch the employee who earns the highest salary in each department.

**Answer:**

```sql
SELECT e.*
FROM employees e
INNER JOIN (
    SELECT department_id, MAX(salary) AS max_salary
    FROM employees
    GROUP BY department_id
) dept_max ON e.department_id = dept_max.department_id AND e.salary = dept_max.max_salary;
```

---

### 22. Write an SQL query to fetch employees who have the same salary.

**Answer:**

```sql
SELECT salary
FROM employees
GROUP BY salary
HAVING COUNT(*) > 1;
```

---

### 23. Write an SQL query to fetch all employees along with their department name, even if no department is assigned.

**Answer:**

```sql
SELECT e.first_name, e.last_name, d.department_name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id;
```

---

### 24. Write an SQL query to create a view called `high_salary_employees` containing employees with salary greater than 100,000.

**Answer:**

```sql
CREATE VIEW high_salary_employees AS
SELECT *
FROM employees
WHERE salary > 100000;
```

---

### 25. Write an SQL query to update the salary of all employees by 10%.

**Answer:**

```sql
UPDATE employees
SET salary = salary * 1.10;
```

---

### 26. Write an SQL query to delete all employees who have not been assigned to any department.

**Answer:**

```sql
DELETE FROM employees
WHERE department_id IS NULL;
```

---

### 27. Write an SQL query to fetch employees along with a row number based on their salary in descending order (using `ROW_NUMBER()`).

**Answer:**

```sql
SELECT first_name, last_name, salary,
       ROW_NUMBER() OVER (ORDER BY salary DESC) AS row_num
FROM employees;
```

---

### 28. Write an SQL query to fetch the total salary and average salary for each department using CTE.

**Answer:**

```sql
WITH dept_salary AS (
    SELECT department_id, SUM(salary) AS total_salary, AVG(salary) AS avg_salary
    FROM employees
    GROUP BY department_id
)
SELECT * FROM dept_salary;
```

---

### 29. Write an SQL query to fetch all employees whose salary is greater than the average salary of all employees.

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);
```

---

### 30. Write an SQL query to fetch the employees who are reporting to the same manager.

**Answer:**

```sql
SELECT manager_id, COUNT(*) AS employee_count
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING COUNT(*) > 1;
```

---

### 31. Write an SQL query to find departments where no employees are assigned.

**Answer:**

```sql
SELECT d.department_id, d.department_name
FROM departments d
LEFT JOIN employees e ON d.department_id = e.department_id
WHERE e.employee_id IS NULL;
```

---

### 32. Write an SQL query to list the top 5 departments with the highest average salary.

**Answer:**

```sql
SELECT department_id, AVG(salary) AS avg_salary
FROM employees
GROUP BY department_id
ORDER BY avg_salary DESC
LIMIT 5;
```

---

### 33. Write an SQL query to fetch the employee with the third highest salary.

**Answer:**

```sql
SELECT * FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 2;
```
> (Here, `OFFSET 2` skips the top 2 salaries to get the 3rd highest.)

---

### 34. Write an SQL query to fetch employees who earn more than their manager.

**Answer:**

```sql
SELECT e.first_name AS employee_name, e.salary AS employee_salary,
       m.first_name AS manager_name, m.salary AS manager_salary
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id
WHERE e.salary > m.salary;
```

---

### 35. Write an SQL query to find duplicate email addresses in the `employees` table.

**Answer:**

```sql
SELECT email, COUNT(*)
FROM employees
GROUP BY email
HAVING COUNT(*) > 1;
```

---

### 36. Write an SQL query to list employees hired in the last 6 months.

**Answer:**

```sql
SELECT *
FROM employees
WHERE joining_date >= CURRENT_DATE - INTERVAL '6 months';
```
> (Note: Syntax may vary slightly depending on your SQL database — like MySQL, PostgreSQL.)

---

### 37. Write an SQL query to find the department with the maximum number of employees.

**Answer:**

```sql
SELECT department_id, COUNT(*) AS employee_count
FROM employees
GROUP BY department_id
ORDER BY employee_count DESC
LIMIT 1;
```

---

### 38. Write an SQL query to display employee names along with their joining year.

**Answer:**

```sql
SELECT first_name, last_name, EXTRACT(YEAR FROM joining_date) AS joining_year
FROM employees;
```

---

### 39. Write an SQL query to fetch the list of employees who joined on a Monday.

**Answer:**

```sql
SELECT *
FROM employees
WHERE EXTRACT(DOW FROM joining_date) = 1;
```
> (In PostgreSQL, DOW (Day Of Week) = 1 for Monday.)

---

### 40. Write an SQL query to create a new table `high_performers` with employees having salary above 90,000.

**Answer:**

```sql
CREATE TABLE high_performers AS
SELECT *
FROM employees
WHERE salary > 90000;
```

---

### 41. Write an SQL query to fetch employees whose name ends with 'n'.

**Answer:**

```sql
SELECT *
FROM employees
WHERE first_name LIKE '%n';
```

---

### 42. Write an SQL query to fetch employees whose salary is either 30,000, 40,000, or 50,000.

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary IN (30000, 40000, 50000);
```

---

### 43. Write an SQL query to find the total salary expense of the company.

**Answer:**

```sql
SELECT SUM(salary) AS total_salary_expense
FROM employees;
```

---

### 44. Write an SQL query to find employees who have been assigned to more than one department (assuming there is an `employee_departments` mapping table).

**Answer:**

```sql
SELECT employee_id
FROM employee_departments
GROUP BY employee_id
HAVING COUNT(department_id) > 1;
```

---

### 45. Write an SQL query to fetch employees who have no email ID recorded.

**Answer:**

```sql
SELECT *
FROM employees
WHERE email IS NULL;
```

---

### 46. Write an SQL query to find the employee with the minimum salary.

**Answer:**

```sql
SELECT *
FROM employees
ORDER BY salary ASC
LIMIT 1;
```

---

### 47. Write an SQL query to calculate the number of employees who joined each year.

**Answer:**

```sql
SELECT EXTRACT(YEAR FROM joining_date) AS joining_year, COUNT(*) AS number_of_employees
FROM employees
GROUP BY EXTRACT(YEAR FROM joining_date)
ORDER BY joining_year;
```

---

### 48. Write an SQL query to fetch employees who joined in the year 2023.

**Answer:**

```sql
SELECT *
FROM employees
WHERE EXTRACT(YEAR FROM joining_date) = 2023;
```

---

### 49. Write an SQL query to fetch employees and categorize their salaries as "Low", "Medium", "High".

**Answer:**

```sql
SELECT first_name, last_name, salary,
    CASE
        WHEN salary < 40000 THEN 'Low'
        WHEN salary BETWEEN 40000 AND 80000 THEN 'Medium'
        ELSE 'High'
    END AS salary_category
FROM employees;
```

---

### 50. Write an SQL query to fetch all departments and the number of employees in each department (including departments with 0 employees).

**Answer:**

```sql
SELECT d.department_id, d.department_name, COUNT(e.employee_id) AS employee_count
FROM departments d
LEFT JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_id, d.department_name;
```

---

### 51. Write an SQL query to find the number of employees under each manager.

**Answer:**

```sql
SELECT manager_id, COUNT(*) AS employee_count
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id;
```

---

### 52. Write an SQL query to fetch the highest, lowest, and average salary in the company.

**Answer:**

```sql
SELECT
    MAX(salary) AS highest_salary,
    MIN(salary) AS lowest_salary,
    AVG(salary) AS average_salary
FROM employees;
```

---

### 53. Write an SQL query to fetch employees who have never been assigned a manager.

**Answer:**

```sql
SELECT *
FROM employees
WHERE manager_id IS NULL;
```

---

### 54. Write an SQL query to fetch employees who joined before 2020 and have a salary greater than 50,000.

**Answer:**

```sql
SELECT *
FROM employees
WHERE joining_date < '2020-01-01' AND salary > 50000;
```

---

### 55. Write an SQL query to fetch all employees ordered by department and then by salary (highest to lowest).

**Answer:**

```sql
SELECT *
FROM employees
ORDER BY department_id ASC, salary DESC;
```

---

### 56. Write an SQL query to fetch the total number of employees and total salary department-wise.

**Answer:**

```sql
SELECT department_id, COUNT(*) AS number_of_employees, SUM(salary) AS total_salary
FROM employees
GROUP BY department_id;
```

---

### 57. Write an SQL query to display only the first 3 characters of employee names.

**Answer:**

```sql
SELECT SUBSTRING(first_name, 1, 3) AS short_name
FROM employees;
```

---

### 58. Write an SQL query to find employees whose salary is above the company average salary.

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);
```

---

### 59. Write an SQL query to fetch employees who have been in the company for more than 5 years.

**Answer:**

```sql
SELECT *
FROM employees
WHERE joining_date <= CURRENT_DATE - INTERVAL '5 years';
```

---

### 60. Write an SQL query to list all managers and the names of their subordinates.

**Answer:**

```sql
SELECT m.first_name AS manager_name, e.first_name AS employee_name
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id;
```

---

### 61. Write an SQL query to find the second highest salary in the company.

**Answer:**

```sql
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);
```

---

### 62. Write an SQL query to find employees who have not received a raise (i.e., no change in salary).

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary = (SELECT salary FROM employees WHERE employee_id = employees.employee_id);
```

---

### 63. Write an SQL query to list employees along with their department name and the total salary for that department.

**Answer:**

```sql
SELECT e.first_name, e.last_name, d.department_name, SUM(e.salary) OVER(PARTITION BY e.department_id) AS department_salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id;
```

---

### 64. Write an SQL query to find employees who are either managers or have a manager.

**Answer:**

```sql
SELECT DISTINCT e.*
FROM employees e
WHERE e.employee_id IN (SELECT manager_id FROM employees WHERE manager_id IS NOT NULL)
   OR e.manager_id IS NOT NULL;
```

---

### 65. Write an SQL query to find departments with more than 3 employees.

**Answer:**

```sql
SELECT department_id, COUNT(*) AS employee_count
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 3;
```

---

### 66. Write an SQL query to get the total number of employees and the average salary of each department, including departments with no employees.

**Answer:**

```sql
SELECT d.department_id, d.department_name, COUNT(e.employee_id) AS total_employees, AVG(e.salary) AS average_salary
FROM departments d
LEFT JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_id, d.department_name;
```

---

### 67. Write an SQL query to fetch the first name, last name, and the department of employees whose names contain the letter "a".

**Answer:**

```sql
SELECT first_name, last_name, department_id
FROM employees
WHERE first_name LIKE '%a%' OR last_name LIKE '%a%';
```

---

### 68. Write an SQL query to find the employee(s) who have the highest salary in each department.

**Answer:**

```sql
SELECT department_id, first_name, last_name, salary
FROM employees
WHERE (department_id, salary) IN (
    SELECT department_id, MAX(salary)
    FROM employees
    GROUP BY department_id
);
```

---

### 69. Write an SQL query to find the employees who have worked the longest in the company.

**Answer:**

```sql
SELECT *
FROM employees
WHERE joining_date = (SELECT MIN(joining_date) FROM employees);
```

---

### 70. Write an SQL query to find the total salary of employees who have been with the company for more than 3 years.

**Answer:**

```sql
SELECT SUM(salary) AS total_salary
FROM employees
WHERE joining_date <= CURRENT_DATE - INTERVAL '3 years';
```

---

### 71. Write an SQL query to find employees who have the same salary as their manager.

**Answer:**

```sql
SELECT e.first_name AS employee_name, m.first_name AS manager_name, e.salary
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id
WHERE e.salary = m.salary;
```

---

### 72. Write an SQL query to fetch the department(s) with the maximum number of employees.

**Answer:**

```sql
SELECT department_id, COUNT(*) AS employee_count
FROM employees
GROUP BY department_id
HAVING COUNT(*) = (SELECT MAX(employee_count)
                   FROM (SELECT department_id, COUNT(*) AS employee_count FROM employees GROUP BY department_id) AS department_counts);
```

---

### 73. Write an SQL query to find employees whose first name starts with 'A' and whose salary is greater than 60,000.

**Answer:**

```sql
SELECT *
FROM employees
WHERE first_name LIKE 'A%' AND salary > 60000;
```

---

### 74. Write an SQL query to find the departments with the highest average salary.

**Answer:**

```sql
SELECT department_id, AVG(salary) AS avg_salary
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (SELECT MAX(avg_salary)
                       FROM (SELECT department_id, AVG(salary) AS avg_salary FROM employees GROUP BY department_id) AS dept_avg_salaries);
```

---

### 75. Write an SQL query to get the total number of employees in each department, ordered by the number of employees in descending order.

**Answer:**

```sql
SELECT department_id, COUNT(*) AS number_of_employees
FROM employees
GROUP BY department_id
ORDER BY number_of_employees DESC;
```

---

### 76. Write an SQL query to find employees whose salary is less than the average salary of their department.

**Answer:**

```sql
SELECT e.first_name, e.last_name, e.salary, e.department_id
FROM employees e
WHERE e.salary < (SELECT AVG(salary)
                  FROM employees
                  WHERE department_id = e.department_id);
```

---

### 77. Write an SQL query to find employees who are managers themselves (i.e., their `employee_id` appears as `manager_id`).

**Answer:**

```sql
SELECT DISTINCT e.first_name, e.last_name
FROM employees e
JOIN employees m ON e.employee_id = m.manager_id;
```

---

### 78. Write an SQL query to list employees and their manager’s name (first and last) in one column.

**Answer:**

```sql
SELECT e.first_name AS employee_first_name, e.last_name AS employee_last_name,
       m.first_name AS manager_first_name, m.last_name AS manager_last_name
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.employee_id;
```

---

### 79. Write an SQL query to get all employees who are in the same department as "John Doe".

**Answer:**

```sql
SELECT e.first_name, e.last_name, e.department_id
FROM employees e
WHERE e.department_id = (SELECT department_id
                          FROM employees
                          WHERE first_name = 'John' AND last_name = 'Doe');
```

---

### 80. Write an SQL query to find employees who have a salary between 40,000 and 60,000, and whose first name starts with "S".

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary BETWEEN 40000 AND 60000
  AND first_name LIKE 'S%';
```

---

### 81. Write an SQL query to fetch the details of employees who have been assigned to more than one department.

**Answer:**

```sql
SELECT employee_id, COUNT(DISTINCT department_id) AS department_count
FROM employee_departments
GROUP BY employee_id
HAVING COUNT(DISTINCT department_id) > 1;
```

---

### 82. Write an SQL query to get the department with the highest salary and the employee name(s) in that department.

**Answer:**

```sql
SELECT e.first_name, e.last_name, e.salary, e.department_id
FROM employees e
WHERE e.department_id = (SELECT department_id
                          FROM employees
                          GROUP BY department_id
                          ORDER BY AVG(salary) DESC
                          LIMIT 1);
```

---

### 83. Write an SQL query to find the employee(s) who have been in the company the longest (i.e., earliest joining date).

**Answer:**

```sql
SELECT *
FROM employees
WHERE joining_date = (SELECT MIN(joining_date) FROM employees);
```

---

### 84. Write an SQL query to find the highest salary of employees in each department.

**Answer:**

```sql
SELECT department_id, MAX(salary) AS highest_salary
FROM employees
GROUP BY department_id;
```

---

### 85. Write an SQL query to list the employees who earn more than the average salary of the company.

**Answer:**

```sql
SELECT *
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);
```

---

### 86. Write an SQL query to fetch all employees who do not have a manager.

**Answer:**

```sql
SELECT *
FROM employees
WHERE manager_id IS NULL;
```

---

### 87. Write an SQL query to find the department with the lowest average salary.

**Answer:**

```sql
SELECT department_id, AVG(salary) AS avg_salary
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (SELECT MIN(avg_salary)
                       FROM (SELECT department_id, AVG(salary) AS avg_salary FROM employees GROUP BY department_id) AS dept_avg_salaries);
```

---

### 88. Write an SQL query to find employees who joined after a specific date (e.g., after '2022-01-01').

**Answer:**

```sql
SELECT *
FROM employees
WHERE joining_date > '2022-01-01';
```

---

### 89. Write an SQL query to calculate the total salary expense for each department, excluding departments with no employees.

**Answer:**

```sql
SELECT department_id, SUM(salary) AS total_salary_expense
FROM employees
GROUP BY department_id
HAVING COUNT(employee_id) > 0;
```

---

### 90. Write an SQL query to fetch employees who have not been assigned to any department.

**Answer:**

```sql
SELECT *
FROM employees
WHERE department_id IS NULL;
```

---

### 91. Write an SQL query to find the employees who have been assigned to multiple projects.

**Answer:**

```sql
SELECT employee_id, COUNT(DISTINCT project_id) AS project_count
FROM employee_projects
GROUP BY employee_id
HAVING COUNT(DISTINCT project_id) > 1;
```

---

### 92. Write an SQL query to fetch the names of employees and their managers.

**Answer:**

```sql
SELECT e.first_name AS employee_name, m.first_name AS manager_name
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.employee_id;
```

---

### 93. Write an SQL query to calculate the total number of employees in the company.

**Answer:**

```sql
SELECT COUNT(*) AS total_employees
FROM employees;
```

---

### 94. Write an SQL query to find the average salary of employees who are not managers.

**Answer:**

```sql
SELECT AVG(salary) AS avg_salary
FROM employees
WHERE employee_id NOT IN (SELECT manager_id FROM employees WHERE manager_id IS NOT NULL);
```

---

### 95. Write an SQL query to find the highest-paid employee in each department.

**Answer:**

```sql
SELECT department_id, first_name, last_name, MAX(salary) AS highest_salary
FROM employees
GROUP BY department_id;
```

---

### 96. Write an SQL query to find the employees who have received a salary increase (i.e., the current salary is greater than the previous salary).

**Answer:**

```sql
SELECT e.first_name, e.last_name, e.salary, ep.previous_salary
FROM employees e
JOIN employee_salary_history ep ON e.employee_id = ep.employee_id
WHERE e.salary > ep.previous_salary;
```

---

### 97. Write an SQL query to fetch the departments where the number of employees is greater than 10.

**Answer:**

```sql
SELECT department_id, COUNT(*) AS employee_count
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 10;
```

---

### 98. Write an SQL query to find employees who earn more than their department's average salary.

**Answer:**

```sql
SELECT e.first_name, e.last_name, e.salary, e.department_id
FROM employees e
WHERE e.salary > (SELECT AVG(salary)
                  FROM employees
                  WHERE department_id = e.department_id);
```

---

### 99. Write an SQL query to list employees who have not received any bonuses.

**Answer:**

```sql
SELECT e.first_name, e.last_name
FROM employees e
LEFT JOIN bonuses b ON e.employee_id = b.employee_id
WHERE b.bonus_amount IS NULL;
```

---

### 100. Write an SQL query to find the second lowest salary in the company.

**Answer:**

```sql
SELECT MIN(salary) AS second_lowest_salary
FROM employees
WHERE salary > (SELECT MIN(salary) FROM employees);
```

---






