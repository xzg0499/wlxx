drop table if exists category;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `del` tinyint(1) default 0,

  category_code varchar(100) default null,
  category_name varchar(100) default null,
  category_id bigint default null,
  category_level int default null,
  description varchar(200) default null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

drop table if exists books;
CREATE TABLE `books` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `del` tinyint(1) default 0,

  category bigint default null,
  books_name varchar(100) default null,
  boots_site varchar(100) default null,
  cover_img varchar(100) default null,
  description varchar(200) default null,
  author varchar(100) default null,
  brief_introduction varchar(200) default null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

