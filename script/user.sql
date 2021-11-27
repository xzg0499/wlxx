use db_user;

-- 用户表
drop table if exists t_user;
create table t_user(
    id varchar(60) primary key comment '主键',
    creator varchar(60) comment '创建人',
    create_time timestamp not null default current_timestamp() comment '创建时间',
    last_updater varchar(60) comment '最后一次更新人',
    last_update_time timestamp not null default current_timestamp() comment '最后一次更新时间',

    username varchar(100) comment '用户名',
    loginname varchar(100) comment '用户账号',
    password varchar(100) comment '密码',

);

-- 人员表（员工表）
drop table if exists t_person(
    id varchar(60) primary key comment '主键',
    creator varchar(60) comment '创建人',
    create_time timestamp not null default current_timestamp() comment '创建时间',
    last_updater varchar(60) comment '最后一次更新人',
    last_update_time timestamp not null default current_timestamp() comment '最后一次更新时间',

    name varchar(60) comment '姓名',
    sex tinyint(1) comment '性别',
);
