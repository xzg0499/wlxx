-- db_system.emp definition
drop table if exists emp;
CREATE TABLE `emp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `del` tinyint(1) default 0,

  `emp_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `emp_code` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `org_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- db_system.org definition
drop table if exists org;
CREATE TABLE `org` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `del` tinyint(1) default 0,

  `org_code` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `org_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `org_id` bigint DEFAULT NULL,
  `org_type` int DEFAULT NULL,
  `org_level` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- db_system.token definition
drop table if exists token;
CREATE TABLE `token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `del` tinyint(1) default 0,

  `token` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `expired` tinyint(1) DEFAULT '0',
  `revoked` tinyint(1) DEFAULT '0',
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- db_system.`user` definition
drop table if exists user;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `del` tinyint(1) default 0,

  `username` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `real_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `emp_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


drop table if exists tenant;
CREATE TABLE `tenant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `del` tinyint(1) default 0,

  `tenant_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;