create database ems;
use ems;
create table department(
	department_id int not null primary key auto_increment,
    department_code varchar(10) not null,
    department_name varchar(100) not null
);
insert into department(`department_code`, `department_name`)
values
('IT', 'Information Technology'),
('HR', 'Human Resource');

select * from department;

create table employee(
	emp_no int not null primary key auto_increment,
    first_name varchar(100) not null,
    middle_name varchar(100),
    last_name varchar(100) not null,
    gender varchar(100) not null,
    join_date date,
    dob date,
    department_id int,
    designation varchar(100),
    foreign key (department_id) references department(department_id)
);

select * from employee;