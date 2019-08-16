CREATE DATABASE `qknavy-db` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

INSERT INTO `qknavy-db`.`sys_db_config`(`id`, `type`, `driver-class-name`, `url`, `username`, `password`) VALUES ('10001', 'com.alibaba.druid.pool.DruidDataSource', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/DATABASE_NAME?characterEncoding=utf8', 'root', 'P@ssw0rd');
INSERT INTO `qknavy-db`.`sys_db_config`(`id`, `type`, `driver-class-name`, `url`, `username`, `password`) VALUES ('10002', 'com.alibaba.druid.pool.DruidDataSource', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/DATABASE_NAME?characterEncoding=utf8', 'root', 'P@ssw0rd');


