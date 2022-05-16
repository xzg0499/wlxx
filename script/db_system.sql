-- CREATE DATABASE db_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ENCRYPTION='N' ;

use db_system;

-- 字典表
drop table if exists t_dict;
create table t_dict(
    id varchar(60) primary key comment '主键',
    creator varchar(60) comment '创建人',
    create_time datetime null default null comment '创建时间',
    updater varchar(60) comment '最后一次更新人',
    update_time datetime null default null comment '最后一次更新时间',

    dict_code varchar(100) unique comment '字典代码',
    dict_name varchar(100) comment '字典名称',
    level int comment '字典层级',
    description varchar(300) comment '描述'

)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 字典表子项
drop table if exists t_dict_item;
create table t_dict_item(
    id varchar(60) primary key comment '主键',
    creator varchar(60) comment '创建人',
    create_time datetime null default null comment '创建时间',
    updater varchar(60) comment '最后一次更新人',
    update_time datetime null default null comment '最后一次更新时间',
    dict_id varchar(60) comment '字典表主键：t_dict.id',

    dict_code varchar(100) comment '字典项代码',
    dict_name varchar(100) comment '字典项名称',
    sort int default 0 comment '排序',
    CONSTRAINT dict_item_code_UN UNIQUE KEY (dict_id,dict_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



-- 配置表
drop table if exists t_global_config;
create table t_global_config(
    id varchar(60) primary key comment '主键',
    creator varchar(60) comment '创建人',
    create_time datetime null default null comment '创建时间',
    updater varchar(60) comment '最后一次更新人',
    update_time datetime null default null comment '最后一次更新时间',
    dict_id varchar(60) comment '字典表主键：t_dict.id',

    config_key varchar(100) comment '配置键',
    config_name varchar(100) comment '配置项名称',
    config_value varchar(100) comment '配置值'
);

-- 用户配置
drop table if exists t_user_config;
create table t_user_config(
    id varchar(60) primary key comment '主键',
    creator varchar(60) comment '创建人',
    create_time datetime null default null comment '创建时间',
    updater varchar(60) comment '最后一次更新人',
    update_time timestamp null default null comment '最后一次更新时间',

    user_id varchar(60) comment '用户ID'

);