-- 创建数据库
CREATE DATABASE IF NOT EXISTS mysystem;

-- 切换数据库
USE mysystem;

-- 创建表
DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(30) DEFAULT NULL,
	description varchar(30) DEFAULT NULL,
	password varchar(30) DEFAULT NULL,
	birth DATE DEFAULT NULL,
	PRIMARY KEY (id)
);
DROP TABLE IF EXISTS roles;
CREATE TABLE IF NOT EXISTS roles (
	id int NOT NULL AUTO_INCREMENT,
	uuid int NOT NULL UNIQUE,
	name varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
);
DROP TABLE IF EXISTS privileges;
CREATE TABLE IF NOT EXISTS privileges (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(30) DEFAULT NULL,
	url varchar(30) DEFAULT NULL,
	isparent int NOT NULL DEFAULT 0,
	pid int NOT NULL DEFAULT -1,
	PRIMARY KEY (id)
);
DROP TABLE IF EXISTS users_roles;
CREATE TABLE IF NOT EXISTS users_roles (
	id int NOT NULL AUTO_INCREMENT,
	user_id int NOT NULL,
	role_id int NOT NULL,
	PRIMARY KEY(id)
);
DROP TABLE IF EXISTS roles_privileges;
CREATE TABLE IF NOT EXISTS roles_privileges (
	id int NOT NULL AUTO_INCREMENT,
	role_id int NOT NULL,
	privilege_id int NOT NULL,
	PRIMARY KEY (id)
);

-- 数据准备
DELETE FROM users;
INSERT INTO users VALUES(1, '张三', '我是老板', '123', '2020-04-20');
INSERT INTO users VALUES(2, '李四', '我是总经理', '123', '2020-04-21');
INSERT INTO users VALUES(3, '王五', '我是部门主管', '123', '2020-04-22');
INSERT INTO users VALUES(4, '员工4', '我是员工', '123', '2020-04-23');
INSERT INTO users VALUES(5, '员工5', '我是员工', '123', '2020-04-24');

DELETE FROM roles;
INSERT INTO roles VALUES(1, 100, '老板');
INSERT INTO roles VALUES(2, 200, '总经理');
INSERT INTO roles VALUES(3, 300, '部门主管');
INSERT INTO roles VALUES(4, 400, '员工');

DELETE FROM privileges;
INSERT INTO privileges VALUES(1, '经理管理', '', 0, -1);
INSERT INTO privileges VALUES(2, '主管管理', '', 0, -1);
INSERT INTO privileges VALUES(3, '员工管理', '', 0, -1);
INSERT INTO privileges VALUES(4, '员工信息查看', '', 0, -1);

DELETE FROM users_roles;
INSERT INTO users_roles VALUES (1, 1, 1);
INSERT INTO users_roles VALUES (2, 2, 2);
INSERT INTO users_roles VALUES (3, 3, 3);
INSERT INTO users_roles VALUES (4, 4, 4);
INSERT INTO users_roles VALUES (5, 5, 4);

DELETE FROM roles_privileges;
INSERT INTO roles_privileges VALUES (1, 1, 1);
INSERT INTO roles_privileges VALUES (2, 2, 2);
INSERT INTO roles_privileges VALUES (3, 3, 3);
INSERT INTO roles_privileges VALUES (4, 4, 4);