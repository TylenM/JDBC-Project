-- scripts to run to fill with dummy data
use jdbc_ems;

insert into company(company_id, name) values(null, "Best Boughts");
insert into company(company_id, name) values(null, "Leelay's Electronics");


-- creating dummy departments
-- scripts to run to fill with dummy data
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Sales",1000000.0,"111", 6);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Electronics",125000.0,"222", 6);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Head Quarters",100.0,"333", 6);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"IT" ,375000.0, "444", 6);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Geek Squad",4000.0,"321", 6);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Food & Bevrage", 7000.0, "545", 6);
-- --------------lelia's departments--------------------------
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Sales",100.0,"111", 7);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"XL Monicals",2000.0,"919", 7);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Electronics",125.0,"222", 7);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Head Quarters",110.0,"333", 7);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"IT" ,375.0, "444", 7);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Geek Squad",40.0,"321", 7);
insert into department(department_id, name, budget, phone_extension, company_id) 
    values(null,"Food & Bevrage", 700.0, "545", 7);

-- dummy addresses
insert into address(address_id, address, state)
    values(null, "2078  Stratford Drive", "HI");

insert into address(address_id, address, state)
    values(null, "2131  Ferrell Street", "CA");

insert into address(address_id, address, state)
    values(null, "1574  Lyon Avenue", "CA");

insert into address(address_id, address, state)
    values(null, "2729  Aaron Smith Drive", "OR");

insert into address(address_id, address, state)
    values(null, "4815  Traders Alley", "MI");

insert into address(address_id, address, state)
    values(null, "2569  Bobcat Drive", "MI");

insert into address(address_id, address, state)
    values(null, "706  Despard Street", "CA");

insert into address(address_id, address, state)
    values(null, "3587  Parkview Drive", "AZ");

insert into address(address_id, address, state)
    values(null, "943  Clair Street", "WA");

insert into address(address_id, address, state)
    values(null, "2163  Baker Avenue", "NY");





-- dummy employees
-- scripts to run to fill with dummy data
insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Ellie", "Goulding","ellie@e.com" ,"777-777-7778" ,"2010-10-01" , 1000.0,2, 1, 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Deb", "Marshall","d@d.com" ,"321-321-3211" ,"2010-11-01" , 3000.0,1, 2, 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Daniel", "DeLuis","danile@d.com" ,"444-444-4444" ,"2010-12-01" , 3000.0,5, 3, 1);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Trix", "Bunnieton","t@t.com" ,"545-455-5555" ,"2010-22-01" , 3430.0,5, 4, 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Ritz", "Martin","r@r.com" ,"345-345-3455" ,"2010-10-03" , 5.0,3, 5, 1);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"lia", "Jean","lia@lia.com" ,"lianewlia@lia.com" ,"2010-08-01" , 101.0,4, 6, 1);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Jared", "Diamond","jared@google.com" ,"123-555-0010" ,"2010-02-01" , 12000.0,3,7 , 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Ellie", "June","ellie@google.com" ,"123-555-0009" ,"2008-09-21" , 76000.0,1, 8, 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Jenny", "Jones","jenny@google.com" ,"123-555-0008" ,"2007-14-22" , 34000.0,2, 9, 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Penny", "Pam","penny@google.com" ,"123-555-0007" ,"2005-08-11" , 65000.0,2, 9, 1);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Peter", "Pan","peter@google.com" ,"123-555-0006" ,"2003-12-09" , 90000.0,1, 8, 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"James", "George","james@google.com" ,"123-555-0004" ,"1998-05-12" , 20000.0,1, 6, 2);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Bill", "Gates","bill@google.com" ,"123-555-0002" ,"1994-04-16" , 25000.0,1, 6, 1);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Joe", "MacDonald","joe@google.com" ,"123-555-0000" ,"1990-08-27" , 55000.0,1, 5, 1);

insert into employee(employee_id,first_name, last_name, email, phone, date_of_birth, salary, department_id, address_id, company_id) 
    values(null,"Josh", "MacDonald","joe@google.com" ,"123-555-0020" ,"1990-08-27" , 65000.0,1, 5, 1);