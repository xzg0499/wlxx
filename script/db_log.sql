-- CREATE DATABASE db_log DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT ENCRYPTION='N' ;

use db_log;

drop table if exists t_operation_log;
create table t_operation_log(
    id varchar(60) primary key comment '主键',
    creator varchar(60) comment '创建人',
    create_time datetime null default null comment '创建时间',
    updater varchar(60) comment '最后一次更新人',
    update_time datetime null default null comment '最后一次更新时间',

    system_id varchar(100) not null comment '系统ID',
    module_id varchar(100) not null comment '模块ID',
    operate_id varchar(100) comment '操作ID',

    in_param text comment '入参',
    out_param text comment '出参'

)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

