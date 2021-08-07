-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema webapp
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`movie` (
  `idmovie` INT NOT NULL,
  `movie_title` VARCHAR(45) NOT NULL,
  `movie_type` VARCHAR(45) NOT NULL,
  `movie_rating` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmovie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`multiplex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`multiplex` (
  `idmultiplex` INT NOT NULL,
  `multiplex_name` VARCHAR(45) NOT NULL,
  `multiplex_rating` VARCHAR(45) NOT NULL,
  `multiplex_location` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmultiplex`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`movie_has_multiplex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`movie_has_multiplex` (
  `movie_idmovie` INT NOT NULL,
  `multiplex_idmultiplex` INT NOT NULL,
  PRIMARY KEY (`movie_idmovie`, `multiplex_idmultiplex`),
  INDEX `fk_movie_has_multiplex_multiplex1_idx` (`multiplex_idmultiplex` ASC) VISIBLE,
  INDEX `fk_movie_has_multiplex_movie_idx` (`movie_idmovie` ASC) VISIBLE,
  CONSTRAINT `fk_movie_has_multiplex_movie`
    FOREIGN KEY (`movie_idmovie`)
    REFERENCES `mydb`.`movie` (`idmovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_has_multiplex_multiplex1`
    FOREIGN KEY (`multiplex_idmultiplex`)
    REFERENCES `mydb`.`multiplex` (`idmultiplex`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
