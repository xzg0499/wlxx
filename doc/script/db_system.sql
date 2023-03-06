-- CREATE DATABASE db_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ENCRYPTION='N' ;

use db_system;

-- 字典表
drop table if exists t_dict;
create table t_dict(
    id int8 primary key comment '主键',
    creator int8 comment '创建人',
    create_time int8 default null comment '创建时间',
    updater int8 comment '最后一次更新人',
    update_time int8 default null comment '最后一次更新时间',
    is_delete tiny(1) default 0 comment '是否删除',

    dict_code varchar(100) unique comment '字典代码',
    dict_name varchar(100) comment '字典名称',
    level int2 comment '字典层级',
    description varchar(300) comment '描述',
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
    status int default 1 comment '壮态',

    CONSTRAINT dict_item_code_UN UNIQUE KEY (dict_id,dict_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



