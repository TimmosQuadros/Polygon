-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema polygon
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema polygon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `polygon` DEFAULT CHARACTER SET utf8 ;
USE `polygon` ;
DROP TABLE users ;
DROP TABLE buildings ;
DROP TABLE organisations ;
-- -----------------------------------------------------
-- Table `polygon`.`buildings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polygon`.`buildings` (
  `building_id` INT(11) NOT NULL AUTO_INCREMENT,
  `building_name` VARCHAR(32) NULL DEFAULT NULL,
  `street_address` VARCHAR(64) NULL DEFAULT NULL,
  `zipcode` DECIMAL(8,0) NULL DEFAULT NULL,
  `build_year` DECIMAL(4,0) NULL DEFAULT NULL,
  `floor_area` DECIMAL(8,0) NULL DEFAULT NULL,
  PRIMARY KEY (`building_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polygon`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `organisation_name` VARCHAR(45) NULL DEFAULT NULL,
  `user_type` ENUM('admin', 'tech', 'cust') NOT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `user_email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`organisations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `polygon`.`organisations` (
  `organisations_id` INT(11) NOT NULL AUTO_INCREMENT,
  `organisation_name` VARCHAR(45) NULL,
  `users_user_id` INT(11) NOT NULL,
  `buildings_building_id` INT(11) NOT NULL,
  PRIMARY KEY (`organisations_id`),
  INDEX `fk_organisations_users_idx` (`users_user_id` ASC),
  INDEX `fk_organisations_buildings1_idx` (`buildings_building_id` ASC),
  CONSTRAINT `fk_organisations_buildings1`
    FOREIGN KEY (`buildings_building_id`)
    REFERENCES `polygon`.`buildings` (`building_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_organisations_users`
    FOREIGN KEY (`users_user_id`)
    REFERENCES `polygon`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
