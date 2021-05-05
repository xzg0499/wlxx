use user;

create table t_user(
    id varchar(64) primary key,
    username varchar(128),
    loginname varchar(128),
    password varchar(128),

    sex int,
)