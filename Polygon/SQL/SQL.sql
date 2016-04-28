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
  PRIMARY KEY (`building_id`),
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
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_users_organisations1_idx` (`organisations_id` ASC),
  CONSTRAINT `fk_users_organisations1`
    FOREIGN KEY (`organisations_id`)
    REFERENCES `polygon`.`organisations` (`organisations_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`building_report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`building_report` ;

CREATE TABLE IF NOT EXISTS `polygon`.`building_report` (
  `report_id` INT(11) NOT NULL AUTO_INCREMENT,
  `building_id` INT(11) NOT NULL,
  `tech_id` INT(11) NOT NULL,
  `roof_remark` VARCHAR(200) NULL DEFAULT NULL,
  `outer_wall_remark` VARCHAR(200) NULL DEFAULT NULL,
  `facility_manager_name` VARCHAR(45) NULL DEFAULT NULL,
  `building_condition` ENUM('CON0', 'CON1', 'CON2', 'CON3') NULL DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  INDEX `fk_building_report_buildings1_idx` (`building_id` ASC),
  INDEX `fk_building_report_users1_idx` (`tech_id` ASC),
  CONSTRAINT `fk_building_report_buildings1`
    FOREIGN KEY (`building_id`)
    REFERENCES `polygon`.`buildings` (`building_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_building_report_users1`
    FOREIGN KEY (`tech_id`)
    REFERENCES `polygon`.`users` (`user_id`)
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
-- Table `polygon`.`building_report_image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`building_report_image` ;

CREATE TABLE IF NOT EXISTS `polygon`.`building_report_image` (
  `image_id` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `report_id` INT(11) NOT NULL,
  `image_type` ENUM('ROOF', 'OUTER_WALL') NULL DEFAULT NULL,
  PRIMARY KEY (`image_id`, `report_id`),
  INDEX `fk_image_has_building_report_building_report1_idx` (`report_id` ASC),
  INDEX `fk_image_has_building_report_image1_idx` (`image_id` ASC),
  CONSTRAINT `fk_image_has_building_report_building_report1`
    FOREIGN KEY (`report_id`)
    REFERENCES `polygon`.`building_report` (`report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_image_has_building_report_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `polygon`.`image` (`image_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`checkup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`checkup` ;

CREATE TABLE IF NOT EXISTS `polygon`.`checkup` (
  `checkup_id` INT(11) NOT NULL AUTO_INCREMENT,
  `building_id` INT(11) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  `tech_id` INT(11) NULL DEFAULT NULL,
  `date_issued` VARCHAR(45) NULL DEFAULT NULL,
  `date_processed` VARCHAR(45) NULL DEFAULT NULL,
  `order_status` ENUM('PENDING', 'FINISHED', 'CANCELLED', 'PROGRESSING') NULL DEFAULT NULL,
  PRIMARY KEY (`checkup_id`),
  INDEX `fk_checkup_buildings_idx` (`building_id` ASC),
  INDEX `fk_checkup_users1_idx` (`customer_id` ASC),
  INDEX `fk_checkup_users2_idx` (`tech_id` ASC),
  CONSTRAINT `fk_checkup_buildings`
    FOREIGN KEY (`building_id`)
    REFERENCES `polygon`.`buildings` (`building_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_checkup_users1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `polygon`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_checkup_users2`
    FOREIGN KEY (`tech_id`)
    REFERENCES `polygon`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`room_report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`room_report` ;

CREATE TABLE IF NOT EXISTS `polygon`.`room_report` (
  `room_report_id` INT(11) NOT NULL AUTO_INCREMENT,
  `building_report_id` INT(11) NOT NULL,
  `room_name` VARCHAR(20) NULL DEFAULT NULL,
  `damage_reperation` VARCHAR(200) NULL DEFAULT NULL,
  `moisture_scan` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`room_report_id`),
  INDEX `fk_room_report_building_report1_idx` (`building_report_id` ASC),
  CONSTRAINT `fk_room_report_building_report1`
    FOREIGN KEY (`building_report_id`)
    REFERENCES `polygon`.`building_report` (`report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`conclusion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`conclusion` ;

CREATE TABLE IF NOT EXISTS `polygon`.`conclusion` (
  `conclusion_id` INT(11) NOT NULL AUTO_INCREMENT,
  `room_report_id` INT(11) NOT NULL,
  `text` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`conclusion_id`),
  INDEX `fk_conclusion_room_report1_idx` (`room_report_id` ASC),
  CONSTRAINT `fk_conclusion_room_report1`
    FOREIGN KEY (`room_report_id`)
    REFERENCES `polygon`.`room_report` (`room_report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`description`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`description` ;

CREATE TABLE IF NOT EXISTS `polygon`.`description` (
  `description_id` INT(11) NOT NULL AUTO_INCREMENT,
  `room_report_id` INT(11) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`description_id`),
  INDEX `fk_description_room_report1_idx` (`room_report_id` ASC),
  CONSTRAINT `fk_description_room_report1`
    FOREIGN KEY (`room_report_id`)
    REFERENCES `polygon`.`room_report` (`room_report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`floorplans`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`floorplans` ;

CREATE TABLE IF NOT EXISTS `polygon`.`floorplans` (
  `idfloorplans` INT(11) NOT NULL AUTO_INCREMENT,
  `image_id` TINYINT(3) NOT NULL,
  `building_id` INT(11) NOT NULL,
  PRIMARY KEY (`idfloorplans`),
  INDEX `fk_floorplans_image1_idx` (`image_id` ASC),
  INDEX `fk_floorplans_buildings1_idx` (`building_id` ASC),
  CONSTRAINT `fk_floorplans_buildings1`
    FOREIGN KEY (`building_id`)
    REFERENCES `polygon`.`buildings` (`building_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_floorplans_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `polygon`.`image` (`image_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`remark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`remark` ;

CREATE TABLE IF NOT EXISTS `polygon`.`remark` (
  `remark_id` INT(11) NOT NULL AUTO_INCREMENT,
  `room_report_id` INT(11) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`remark_id`),
  INDEX `fk_remark_room_report1_idx` (`room_report_id` ASC),
  CONSTRAINT `fk_remark_room_report1`
    FOREIGN KEY (`room_report_id`)
    REFERENCES `polygon`.`room_report` (`room_report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `polygon`.`room_report_image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `polygon`.`room_report_image` ;

CREATE TABLE IF NOT EXISTS `polygon`.`room_report_image` (
  `report_id` INT(11) NOT NULL AUTO_INCREMENT,
  `image_id` TINYINT(3) NOT NULL,
  `image_type` ENUM('FLOOR', 'CEILING', 'WALL', 'DOOR', 'WINDOW') NULL DEFAULT NULL,
  PRIMARY KEY (`report_id`, `image_id`),
  INDEX `fk_room_report_has_image_image1_idx` (`image_id` ASC),
  INDEX `fk_room_report_has_image_room_report1_idx` (`report_id` ASC),
  CONSTRAINT `fk_room_report_has_image_image1`
    FOREIGN KEY (`image_id`)
    REFERENCES `polygon`.`image` (`image_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_room_report_has_image_room_report1`
    FOREIGN KEY (`report_id`)
    REFERENCES `polygon`.`room_report` (`room_report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
