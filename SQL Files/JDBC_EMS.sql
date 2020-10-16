<<<<<<< HEAD:JBDC_EMS.sql
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
=======
create table department(
	department_id int PRIMARY KEY auto_increment,
    name varchar(50) not null,
    budget double,
    phone_extension varchar(3)
    );

create table address(
	address_id int PRIMARY KEY auto_increment,
    address varchar(50) not null,
    state char(2) not null
    );

create table company(
	company_id int PRIMARY KEY auto_increment,
    name varchar(50) not null
    );

create table employee(
	employee_id int PRIMARY KEY auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
>>>>>>> 97c72302aa5630e41a2525f68af6324a18eb5fba:SQL Files/JDBC_EMS.sql
	date_of_birth date,
    email varchar(50) NOT NULL UNIQUE,
    phone char(12) NOT NULL UNIQUE,
    salary double,
<<<<<<< HEAD:JBDC_EMS.sql
    department_id int NOT NULL,
    address_id int NOT NULL,
    company_id int NOT NULL,
=======
    department_id int not null,
>>>>>>> 97c72302aa5630e41a2525f68af6324a18eb5fba:SQL Files/JDBC_EMS.sql
    FOREIGN KEY (department_id) references department(department_id),
    address_id int not null,
    FOREIGN KEY (address_id) references address(address_id),
<<<<<<< HEAD:JBDC_EMS.sql
    FOREIGN KEY (company_id) references company(company_id),
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

INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id, company_id) VALUES(null, 'Kristina', 'Perez', '2017-06-15', 'w94j0rqc0h7@temporary-mail.net', '602-334-8166', 75000, 1, 1, 1);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id, company_id) VALUES(null, 'Russell', 'Salyers', '1956-07-14', 'uqt7p9x5jh@temporary-mail.net', '480-736-2980', 65000, 1, 2, 2);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id, company_id) VALUES(null, 'Frank', 'Pruitt', '1987-01-09', '3g7sc3azwhw@temporary-mail.net', '605-301-0440', 60000, 1, 3, 3);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id, company_id) VALUES(null, 'Harry', 'Pina', '1980-05-15', 'onaurc68cvl@temporary-mail.net', '713-203-2900', 120000, 1, 4, 4);
INSERT INTO employee(employee_id, first_name, last_name, date_of_birth, email, phone, salary, department_id, address_id, company_id) VALUES(null, 'Linda', 'Taylor', '1987-12-13', 'l79509j8ibp@temporary-mail.net', '417-246-6563', 35000, 1, 5, 5);
=======
    company_id int not null,
    FOREIGN KEY (company_id) references company(company_id)
    );
>>>>>>> 97c72302aa5630e41a2525f68af6324a18eb5fba:SQL Files/JDBC_EMS.sql
