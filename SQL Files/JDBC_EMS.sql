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
	date_of_birth date,
    email varchar(50) not null,
    phone varchar(10) not null,
    salary double,
    department_id int not null,
    FOREIGN KEY (department_id) references department(department_id),
    address_id int not null,
    FOREIGN KEY (address_id) references address(address_id),
    company_id int not null,
    FOREIGN KEY (company_id) references company(company_id)
    );