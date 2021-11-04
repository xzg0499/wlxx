use wlxx;

drop table if exists t_dict;
create table t_dict(
    id varchar(64) primary key,
    dict_id varchar(128),
    dict_name varchar(128),
    level int default 0,
    parent_id varchar(128),
    sort int
)

