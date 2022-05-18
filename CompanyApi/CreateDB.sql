CREATE TABLE Department
(DepartmentId INT IDENTITY CONSTRAINT PK_Department PRIMARY KEY,
Name VARCHAR(20));
CREATE TABLE Employee
 (EmployeeId INT IDENTITY CONSTRAINT PK_Employee PRIMARY KEY,
FirstName VARCHAR(15),
LastName VARCHAR(15),
ManagerId INT CONSTRAINT FK_Employee_Employee REFERENCES
Employee(EmployeeId),
Salary DECIMAL(6,2) CONSTRAINT CK_Salary CHECK(Salary>100),
Bonus DECIMAL(6,2),
DepartmentId INT CONSTRAINT FK_Employee_Department REFERENCES
Department(DepartmentId));INSERT INTO Department(Name) VALUES ('Sales');
INSERT INTO Department(Name) VALUES ('Marketing');
INSERT INTO Department(Name) VALUES ('Research');
INSERT INTO Department(Name) VALUES ('Administration');
INSERT INTO
Employee(FirstName,LastName,ManagerId,Salary,Bonus,DepartmentId)
VALUES ('Daenerys', 'Targaryen', NULL, 8000, 900, 4);
INSERT INTO
Employee(FirstName,LastName,ManagerId,Salary,Bonus,DepartmentId)
VALUES ('Jaime', 'Lannister', 1, 6000, NULL, 4);
INSERT INTO
Employee(FirstName,LastName,ManagerId,Salary,Bonus,DepartmentId)
VALUES ('Jon', 'Snow', 1, 6000, NULL, 4);
INSERT INTO
Employee(FirstName,LastName,ManagerId,Salary,Bonus,DepartmentId)
VALUES ('Jorah', 'Mormont', 2, 3500, 300, 2);
INSERT INTO
Employee(FirstName,LastName,ManagerId,Salary,Bonus,DepartmentId)
VALUES ('Davos', 'Seaworth', 2, 3000, 500, 1);
INSERT INTO
Employee(FirstName,LastName,ManagerId,Salary,Bonus,DepartmentId)
VALUES ('Arya', 'Stark', 3, 4900, NULL, 3);
INSERT INTO
Employee(FirstName,LastName,ManagerId,Salary,Bonus,DepartmentId)
VALUES ('Theon', 'Greyjoy', 3, 5300, NULL, 3);