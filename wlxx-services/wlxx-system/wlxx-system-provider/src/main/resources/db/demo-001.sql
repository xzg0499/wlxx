drop table if exists org;
create table org(
    id bigint not null AUTO_INCREMENT primary key,
    create_date datetime default null,
    create_by varchar(100) default null,
    update_date datetime default null,
    update_by varchar(100) default null,

    org_code varchar(100) default null,
    org_name varchar(100) default null,
    org_id bigint default null,
    org_type int default null,
    org_level int default null
);

drop table if exists emp;
create table emp(
    id bigint not null AUTO_INCREMENT primary key,
    create_date datetime default null,
    create_by varchar(100) default null,
    update_date datetime default null,
    update_by varchar(100) default null,

    emp_name varchar(100) default null,
    emp_code varchar(100) default null,
    org_id bigint default null
);

drop table if exists user;
create table user(
    id bigint not null AUTO_INCREMENT primary key,
    create_date datetime default null,
    create_by varchar(100) default null,
    update_date datetime default null,
    update_by varchar(100) default null,
    
    username varchar(100) default null,
    real_name varchar(100) default null,
    password varchar(100) default null,
    emp_id bigint default null
);

drop table if exists token;
create table token(
    id bigint not null AUTO_INCREMENT primary key,
    create_date datetime default null,
    create_by varchar(100) default null,
    update_date datetime default null,
    update_by varchar(100) default null,

    token varchar(200) default null,
    expired tinyint(1) default 0,
    revoked tinyint(1) default 0,
    user_id bigint default null
);



