CREATE DATABASE JDBC_EMS;

use JDBC_EMS;

CREATE TABLE address(
	address_id int auto_increment,
    address varchar(50) NOT NULL UNIQUE,
    state char(2) NOT NULL,
    PRIMARY KEY(address_id)
);

CREATE TABLE company(
	company_id int auto_increment,
    name varchar(50) NOT NULL UNIQUE,
    PRIMARY KEY(company_id)
);

CREATE TABLE department(
	department_id int auto_increment,
    name varchar(50) NOT NULL,
    budget double,
    phone_extension varchar(3),
    company_id int NOT NULL,
    FOREIGN KEY (company_id) references company(company_id),
    
    PRIMARY KEY(department_id),
    UNIQUE KEY comp_dept (name, company_id)
);

CREATE TABLE employee(
	employee_id int auto_increment,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
	date_of_birth date,
    email varchar(50) NOT NULL UNIQUE,
    phone char(12) NOT NULL UNIQUE,
    salary double,
    department_id int NOT NULL,
    address_id int NOT NULL,
    FOREIGN KEY (department_id) references department(department_id),
    FOREIGN KEY (address_id) references address(address_id),
    PRIMARY KEY(employee_id)
);

INSERT INTO address(address_id, address, state) VALUES(null, '3125  Hog Camp Road, Oak Lawn', 'IL');
INSERT INTO address(address_id, address, state) VALUES(null, '2014  Bridge Street, Tulsa', 'OK');
INSERT INTO address(address_id, address, state) VALUES(null, '716  Kooter Lane, Charlotte', 'NC');
INSERT INTO address(address_id, address, state) VALUES(null, '2205  Angus Road, New York', 'NY');
INSERT INTO address(address_id, address, state) VALUES(null, '3385  Lost Creek Road, AUSTIN', 'TX');
INSERT INTO address(address_id, address, state) VALUES(null, '456  Pointe Lane, OMAHA', 'NE');
INSERT INTO address(address_id, address, state) VALUES(null, '2035  Benson Park Drive, Oklahoma City', 'OK');
INSERT INTO address(address_id, address, state) VALUES(null, '3127  Victoria Street, Hoffman Estates', 'IL');
INSERT INTO address(address_id, address, state) VALUES(null, '2559  Clinton Street, Philadelphia', 'PA');
INSERT INTO address(address_id, address, state) VALUES(null, '2193  Petunia Way, HARTFORD', 'CT');

INSERT INTO company(company_id, name) VALUES(null, 'Microsoft');
INSERT INTO company(company_id, name) VALUES(null, 'Apple');
INSERT INTO company(company_id, name) VALUES(null, 'Google');
INSERT INTO company(company_id, name) VALUES(null, 'Facebook');
INSERT INTO company(company_id, name) VALUES(null, 'Amazon');

INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Production', 1000000, '111', 1);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Human Resource Management', 1050000, '112', 1);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Marketing', 3500000, '113', 1);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Sales', 5000000, '114', 1);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Production', 1200000, '211', 2);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Human Resource Management', 1650000, '212', 2);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Marketing', 1500000, '213', 2);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Sales', 9000000, '214', 2);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Production', 4000000, '311', 3);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Human Resource Management', 1200000, '312', 3);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Marketing', 4700000, '313', 3);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Sales', 3000000, '314', 3);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Production', 8000000, '411', 4);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Human Resource Management', 3080000, '412', 4);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Marketing', 6100000, '413', 4);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Sales', 1200000, '414', 4);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Production', 8000000, '511', 5);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Human Resource Management', 3080000, '512', 5);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Marketing', 6100000, '513', 5);
INSERT INTO department(department_id, name, budget, phone_extension, company_id) VALUES(null, 'Sales', 1200000, '514', 5);

INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'Kristina', 'Perez', '2017-06-15', 'w94j0rqc0h7@temporary-mail.net', '602-334-8166', 75000, 1, 1);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'Russell', 'Salyers', '1956-07-14', 'uqt7p9x5jh@temporary-mail.net', '480-736-2980', 65000, 1, 2);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'Frank', 'Pruitt', '1987-01-09', '3g7sc3azwhw@temporary-mail.net', '605-301-0440', 60000, 1, 3);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'Harry', 'Pina', '1980-05-15', 'onaurc68cvl@temporary-mail.net', '713-203-2900', 120000, 1, 4);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'Linda', 'Taylor', '1987-12-13', 'l79509j8ibp@temporary-mail.net', '417-246-6563', 35000, 1, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'p@il.ne', '417-246-6564', 30000, 1, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'aaaaaa', 'T', '1987-12-13', 'p@gl.ne', '417-146-6564', 300000, 1, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'pp@il.ne', '117-246-6564', 344444, 1, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'qq11@il.ne', '200-146-1561', 30040, 1, 5);


INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'qtqr11@il.ne', '288-146-1561', 30040, 2, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'qtqe11@il.ne', '278-146-1561', 30040, 2, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'qtwq11@il.ne', '298-146-1561', 30040, 4, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'qtqq11@il.ne', '218-146-1561', 30040, 3, 5);


INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'qqtqr11@il.ne', '288-246-1561', 30040, 6, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'wqtqe11@il.ne', '278-126-1561', 30040, 7, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'eqtwq11@il.ne', '298-142-1561', 30040, 8, 5);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id) VALUES(null, 'a', 'T', '1987-12-13', 'rqtqq11@il.ne', '218-226-1561', 30040, 9, 5);