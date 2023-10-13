-- CREATE DATABASE db_system DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ENCRYPTION='N' ;

use db_system;

-- 字典表
drop table if exists t_dict;
create table t_dict(
    id int8 primary key comment '主键',
    creator int8 comment '创建人',
    create_time int8 default 0 comment '创建时间',
    updater int8 comment '最后一次更新人',
    update_time int8 default 0 comment '最后一次更新时间',
    is_delete tiny(1) default 0 comment '是否删除',

    dict_code varchar(100) unique comment '字典代码',
    dict_name varchar(100) comment '字典名称',
    level int2 comment '字典层级',
    description varchar(300) comment '描述'
);

-- 员工

-- 组织

-- 用户


