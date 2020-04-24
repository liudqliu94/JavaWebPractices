/**
 * 创建数据库 mybatis_test
 * 创建 品类表 category
 * 创建 产品表 product
 * 创建 订单表 orders
 * 一个 品类 包含 多个 产品，一个 产品 只属于 一个 品类
 * 一个 产品 可能对应 多个 订单，一个 订单 可能 包含 多个 产品 
 * 产品 与 订单 之间是 多对多 关系，因此再创建一张中间表 订单产品表 orders_product
 */
CREATE DATABASE IF NOT EXISTS mybatis_test;

USE mybatis_test;

CREATE TABLE IF NOT EXISTS category (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(30)  DEFAULT NULL,
	price float  DEFAULT 0,
	cid int ,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders (
  id int(11) NOT NULL AUTO_INCREMENT,
  code varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders_product (
  id int(11) NOT NULL AUTO_INCREMENT, 
  oid int ,
  pid int ,
  number int ,
  PRIMARY KEY (id)
);

DELETE FROM category;
INSERT INTO category VALUES (1,'category1');
INSERT INTO category VALUES (2,'category2');

DELETE FROM product;
INSERT INTO product VALUES (1,'product a', 88.88, 1);
INSERT INTO product VALUES (2,'product b', 88.88, 1);
INSERT INTO product VALUES (3,'product c', 88.88, 1);
INSERT INTO product VALUES (4,'product x', 88.88, 2);
INSERT INTO product VALUES (5,'product y', 88.88, 2);
INSERT INTO product VALUES (6,'product z', 88.88, 2);

DELETE FROM orders;
INSERT INTO orders VALUES (1,'code000A');
INSERT INTO orders VALUES (2,'code000B');

DELETE FROM orders_product;
INSERT INTO orders_product VALUES (null, 1, 1, 100);
INSERT INTO orders_product VALUES (null, 1, 2, 100);
INSERT INTO orders_product VALUES (null, 1, 3, 100);
INSERT INTO orders_product VALUES (null, 2, 2, 100);
INSERT INTO orders_product VALUES (null, 2, 3, 100);
INSERT INTO orders_product VALUES (null, 2, 4, 100);
