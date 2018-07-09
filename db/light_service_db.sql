-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema light_service
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema light_service
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `light_service` DEFAULT CHARACTER SET utf8 ;
USE `light_service` ;

-- -----------------------------------------------------
-- Table `light_service`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `light_service`.`group` (
  `id` VARCHAR(25) NOT NULL,
  `creation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `light_service`.`light`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `light_service`.`light` (
  `id` VARCHAR(25) NOT NULL,
  `brand_and_type` VARCHAR(60) NULL,
  `purchase_date` DATE NULL,
  `in_use_since` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_usage` VARCHAR(15) NULL,
  `state` VARCHAR(10) NOT NULL DEFAULT 'OFF',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `light_service`.`light_usage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `light_service`.`light_usage` (
  `id` VARCHAR(15) NOT NULL,
  `start_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` TIMESTAMP NULL,
  `lightId` VARCHAR(25) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_light_light-usage_idx` (`lightId` ASC),
  CONSTRAINT `fk_light_light-usage`
    FOREIGN KEY (`lightId`)
    REFERENCES `light_service`.`light` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `light_service`.`profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `light_service`.`profile` (
  `id` VARCHAR(15) NOT NULL,
  `creation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `light_service`.`light_setting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `light_service`.`light_setting` (
  `id` VARCHAR(20) NOT NULL,
  `lightId` VARCHAR(20) NULL,
  `light_state` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `light_service`.`group_setting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `light_service`.`group_setting` (
  `id` VARCHAR(20) NOT NULL,
  `groupId` VARCHAR(20) NULL,
  `light_state` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `light_service`.`membership`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `light_service`.`membership` (
  `lightId` VARCHAR(20) NOT NULL,
  `groupId` VARCHAR(20) NOT NULL,
  `member_since` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`lightId`, `groupId`),
  INDEX `fk_membership_group_idx` (`groupId` ASC),
  CONSTRAINT `fk_membership_light`
    FOREIGN KEY (`lightId`)
    REFERENCES `light_service`.`light` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_membership_group`
    FOREIGN KEY (`groupId`)
    REFERENCES `light_service`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
