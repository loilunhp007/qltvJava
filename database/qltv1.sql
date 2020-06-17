-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema qltv1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema qltv1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qltv1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `qltv1` ;

-- -----------------------------------------------------
-- Table `qltv1`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`role` (
  `roleID` INT NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`roleID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`staff` (
  `staffID` INT NOT NULL AUTO_INCREMENT,
  `staffName` VARCHAR(50) NOT NULL,
  `staffdob` DATE NOT NULL,
  `staffAddr` VARCHAR(100) NOT NULL,
  `staffGender` VARCHAR(6) NOT NULL,
  `staffPhone` INT NOT NULL,
  `staff_roleID` INT NOT NULL,
  `staffSalary` INT NOT NULL,
  PRIMARY KEY (`staffID`),
  INDEX `staff_role_FK` (`staff_roleID` ASC) VISIBLE,
  CONSTRAINT `staff_role_FK`
    FOREIGN KEY (`staff_roleID`)
    REFERENCES `qltv1`.`role` (`roleID`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`account` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(50) NOT NULL,
  `userPassword` VARCHAR(20) NOT NULL,
  `startDay` VARCHAR(20) NOT NULL,
  `outofDay` VARCHAR(20) NOT NULL,
  `staffID` INT NOT NULL,
  PRIMARY KEY (`userID`),
  INDEX `account_staff_FK` (`staffID` ASC) VISIBLE,
  CONSTRAINT `account_staff_FK`
    FOREIGN KEY (`staffID`)
    REFERENCES `qltv1`.`staff` (`staffID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`author` (
  `authorID` INT NOT NULL AUTO_INCREMENT,
  `authorName` VARCHAR(50) NOT NULL,
  `authorGender` VARCHAR(5) NOT NULL,
  `authorDOB` DATE NOT NULL,
  `authorEmail` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`authorID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`categories` (
  `categoryID` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`categoryID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`book` (
  `bookID` INT NOT NULL AUTO_INCREMENT,
  `bookName` VARCHAR(50) NOT NULL,
  `bookAuthorID` INT NOT NULL,
  `bookCategoryID` INT NOT NULL,
  `bookPublisher` VARCHAR(50) NOT NULL,
  `bookPrice` INT NOT NULL,
  `bookPages` INT NOT NULL,
  PRIMARY KEY (`bookID`),
  INDEX `book_author_FK` (`bookAuthorID` ASC) VISIBLE,
  INDEX `book_category_FK` (`bookCategoryID` ASC) VISIBLE,
  CONSTRAINT `book_author_FK`
    FOREIGN KEY (`bookAuthorID`)
    REFERENCES `qltv1`.`author` (`authorID`),
  CONSTRAINT `book_category_FK`
    FOREIGN KEY (`bookCategoryID`)
    REFERENCES `qltv1`.`categories` (`categoryID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`student` (
  `studentID` INT NOT NULL AUTO_INCREMENT,
  `studentName` VARCHAR(50) NOT NULL,
  `studenDOB` DATE NOT NULL,
  `studenEmail` VARCHAR(50) NOT NULL,
  `studentClass` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`studentID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`booklending`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`booklending` (
  `lendID` INT NOT NULL AUTO_INCREMENT,
  `lendStudentID` INT NOT NULL,
  `createDay` VARCHAR(15) NOT NULL,
  `setdueDay` VARCHAR(15) NOT NULL,
  `issued_by` INT NOT NULL,
  PRIMARY KEY (`lendID`),
  INDEX `lending_student` (`lendStudentID` ASC) VISIBLE,
  INDEX `lend_lendingStaff` (`issued_by` ASC) VISIBLE,
  CONSTRAINT `lend_lendingStaff`
    FOREIGN KEY (`issued_by`)
    REFERENCES `qltv1`.`staff` (`staffID`),
  CONSTRAINT `lending_student`
    FOREIGN KEY (`lendStudentID`)
    REFERENCES `qltv1`.`student` (`studentID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `qltv1`.`lending_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qltv1`.`lending_detail` (
  `lendID` INT NOT NULL,
  `bookID` INT NOT NULL,
  `lendQuantity` INT NOT NULL,
  `dueDay` VARCHAR(15) NOT NULL,
  `lendStatus` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`lendID`, `bookID`),
  INDEX `book_lending_FK` (`bookID` ASC) VISIBLE,
  CONSTRAINT `book_lending_FK`
    FOREIGN KEY (`bookID`)
    REFERENCES `qltv1`.`book` (`bookID`),
  CONSTRAINT `lend_lending_FK`
    FOREIGN KEY (`lendID`)
    REFERENCES `qltv1`.`booklending` (`lendID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
