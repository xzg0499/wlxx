use user;

create table t_employee(
    id varchar(64) primary key,
    emp_name varchar(128),
)

create table t_user(
    id varchar(64) primary key,
    username varchar(128),
    password varchar(128),

    sex int,
)