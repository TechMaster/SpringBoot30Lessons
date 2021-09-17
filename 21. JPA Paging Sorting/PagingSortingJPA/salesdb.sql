-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: saledb
-- Source Schemata: salesdb
-- Created: Tue Mar  2 20:13:45 2021
-- Workbench Version: 8.0.22
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema saledb
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `saledb` ;
CREATE SCHEMA IF NOT EXISTS `saledb` ;

-- ----------------------------------------------------------------------------
-- Table saledb.product
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `saledb`.`product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `madein` VARCHAR(45) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 105
DEFAULT CHARACTER SET = utf8mb4;

-- ----------------------------------------------------------------------------
-- Table saledb.roles
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `saledb`.`roles` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;

-- ----------------------------------------------------------------------------
-- Table saledb.users
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `saledb`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `enabled` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;

-- ----------------------------------------------------------------------------
-- Table saledb.users_roles
-- ----------------------------------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `saledb`.`users_roles` (
--   `user_id` INT(11) NULL DEFAULT NULL,
--   `role_id` INT(11) NULL DEFAULT NULL,
--   INDEX `user_fk_idx` (`user_id` ASC) VISIBLE,
--   INDEX `role_fk_idx` (`role_id` ASC) VISIBLE,
--   CONSTRAINT `role_fk`
--     FOREIGN KEY (`role_id`)
--     REFERENCES `saledb`.`roles` (`role_id`)
--     ON DELETE NO ACTION
--     ON UPDATE NO ACTION,
--   CONSTRAINT `user_fk`
--     FOREIGN KEY (`user_id`)
--     REFERENCES `saledb`.`users` (`user_id`)
--     ON DELETE NO ACTION
--     ON UPDATE NO ACTION)
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb4;
SET FOREIGN_KEY_CHECKS = 1;
