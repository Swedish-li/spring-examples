CREATE DATABASE IF NOT EXISTS test_db character set UTF8mb4 collate utf8mb4_bin;

CREATE TABLE IF NOT EXISTS tb_area (
  id INT UNSIGNED NOT NULL PRIMARY KEY,
  parent_id INT UNSIGNED,
  `name` VARCHAR(30),
  short_name VARCHAR(30),
  `coordinate` POINT NOT NULL SRID 4326,
  level SMALLINT,
  sort SMALLINT,
  status TINYINT,
  INDEX(`name`)
) engine=InnoDB;

INSERT INTO tb_area(id,parent_id,name,short_name,`coordinate`,level,sort,status) VALUES (2,null,'test2','t2',ST_SRID( Point(1.23,2.55), 4326),1,1,0);