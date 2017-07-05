# CREATE DATABASE smart4j_test;

# ####
# CREATE TABLE `customer` (
#   `id` BIGINT NOT NULL AUTO_INCREMENT,
#   `name` VARCHAR(255) DEFAULT NULL,
#   `contact` VARCHAR(255) DEFAULT NULL,
#   `telephone` VARCHAR(255) DEFAULT NULL,
#   `email` VARCHAR(255) DEFAULT NULL,
#   `remark` TEXT,
#   PRIMARY KEY (`id`)
# ) ENGINE = InnoDB DEFAULT CHARSET = utf8;
# ####

TRUNCATE customer;

INSERT INTO customer VALUES (1, 'customer1', 'Jack', '13512345678', 'jack@gmail.con', NULL);
INSERT INTO customer VALUES (2, 'customer2', 'Rose', '13523456789', 'rose@gmail.con', NULL);
