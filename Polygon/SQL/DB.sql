-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema polygon
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `polygon` ;

-- -----------------------------------------------------
-- Schema polygon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `polygon` DEFAULT CHARACTER SET utf8 ;
USE `polygon` ;

-- -----------------------------------------------------
-- Table `polygon`.`organisations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`organisations` ;

CREATE TABLE IF NOT EXISTS `polygon`.`organisations` (
  `organisations_id` INT(11) NOT NULL AUTO_INCREMENT,
  `organisation_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`organisations_id`),
  UNIQUE INDEX `organisation_name_UNIQUE` (`organisation_name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`buildings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`buildings` ;

CREATE TABLE IF NOT EXISTS `polygon`.`buildings` (
  `building_id` INT(11) NOT NULL AUTO_INCREMENT,
  `organisations_id` INT(11) NOT NULL,
  `building_name` VARCHAR(32) NULL DEFAULT NULL,
  `street_address` VARCHAR(64) NULL DEFAULT NULL,
  `zipcode` DECIMAL(8,0) NULL DEFAULT NULL,
  `build_year` DECIMAL(4,0) NULL DEFAULT NULL,
  `floor_area` DECIMAL(8,0) NULL DEFAULT NULL,
  PRIMARY KEY (`building_id`, `organisations_id`),
  UNIQUE INDEX `building_name_UNIQUE` (`building_name` ASC),
  INDEX `fk_buildings_organisations1_idx` (`organisations_id` ASC),
  CONSTRAINT `fk_buildings_organisations1`
    FOREIGN KEY (`organisations_id`)
    REFERENCES `polygon`.`organisations` (`organisations_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`image` ;

CREATE TABLE IF NOT EXISTS `polygon`.`image` (
  `image_id` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `image_type` VARCHAR(25) NULL DEFAULT NULL,
  `image` LONGBLOB NULL DEFAULT NULL,
  `image_size` VARCHAR(25) NULL DEFAULT NULL,
  `image_ctgy` VARCHAR(25) NULL DEFAULT NULL,
  `image_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`image_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`users` ;

CREATE TABLE IF NOT EXISTS `polygon`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `organisations_id` INT(11) NOT NULL,
  `user_type` ENUM('ADMIN', 'TECH', 'CUST') NOT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `user_email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `organisations_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_users_organisations_idx` (`organisations_id` ASC),
  CONSTRAINT `fk_users_organisations`
    FOREIGN KEY (`organisations_id`)
    REFERENCES `polygon`.`organisations` (`organisations_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`floorplans`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`floorplans` ;

CREATE TABLE IF NOT EXISTS `polygon`.`floorplans` (
  `idfloorplans` INT(11) NOT NULL AUTO_INCREMENT,
  `image_id` TINYINT(3) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `organisations_id` INT(11) NOT NULL,
  PRIMARY KEY (`idfloorplans`),
  INDEX `fk_floorplans_image1_idx` (`image_id` ASC),
  INDEX `fk_floorplans_users1_idx` (`user_id` ASC, `organisations_id` ASC),
  CONSTRAINT `fk_floorplans_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `polygon`.`image` (`image_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_floorplans_users1`
    FOREIGN KEY (`user_id` , `organisations_id`)
    REFERENCES `polygon`.`users` (`user_id` , `organisations_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
