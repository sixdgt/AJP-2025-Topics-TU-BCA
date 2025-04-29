-- create database case_study_one;
use case_study_one;
-- query for creating admin table
create table admin(
	admin_id int not null primary key auto_increment,
    admin_full_name varchar(255) not null,
    admin_email varchar(255) unique not null,
    admin_password varchar(255) not null,
    is_removed tinyint default 0,
    created_at timestamp default current_timestamp,
    removed_at timestamp null
);
-- query for creating student table
create table student(
	student_id int not null primary key auto_increment,
    student_first_name varchar(255) not null,
    student_middle_name varchar(255) null,
    student_last_name varchar(255) not null,
    address varchar(255) not null,
    profile_img varchar(255) null,
    gender varchar(100) not null,
    dob date,
    student_email varchar(255) unique not null,
    student_password varchar(255) not null,
    admin_id int,
    is_removed tinyint default 0,
    created_at timestamp default current_timestamp,
    removed_at timestamp null,
    foreign key (admin_id) references admin(admin_id)
);
-- query for creating course table
create table course(
	course_id int not null primary key auto_increment,
    course_code varchar(100) not null,
    course_title varchar(255) not null,
    course_desc varchar(255) not null,
    course_start date not null,
    course_end date not null,
    course_status tinyint default 0,
    admin_id int,
    course_category varchar(200) not null,
    is_removed tinyint default 0,
    created_at timestamp default current_timestamp,
    removed_at timestamp null,
    foreign key (admin_id) references admin(admin_id)
);
-- query for creating enroll table
create table enroll(
	enroll_id int not null primary key auto_increment,
    student_id int,
    course_id int,
    enrolled_at timestamp default current_timestamp,
    enroll_status tinyint default 0,
    foreign key (student_id) references student(student_id),
    foreign key (course_id) references course(course_id)
);

desc student;
desc course;
desc admin;
desc enroll;