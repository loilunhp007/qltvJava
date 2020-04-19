SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE DATABASE IF NOT EXISTS QLTV;
USE QLTV;
Create TABLE IF NOT EXISTS Book_detail(
	bookID int not null Primary key,
    bookName varchar(50) not null,
    bookAuthor varchar(50) ,
    bookPublisher varchar(50) ,
    bookPrice int	not null,
    bookLanguage varchar(20),
    bookPages int
    );
DROP TABLE Book_detail;
CREATE TABLE IF NOT EXISTS Account(
	userID int not null primary key,
	userName varchar(50) not null,
    userPassword varchar(20) not null,
    userEmail varchar(50) not null,
    userSec_q varchar (50) not null,
    userAnser varchar (50) not null
);
CREATE TABLE IF NOT EXISTS Staff(
	staffID int not null primary key,
    staffName varchar(50) not null,
    staffdob varchar(50) not null,
    staffAddr varchar(50) not null,
    staffGender varchar(5) not null,
    staffPhone varchar(12) not null
);
CREATE TABLE IF NOT EXISTS BookLending(
	lendID varchar(10) not null primary key,
    userID int not null,
    staffID int not null,
    createDay varchar(15) not null,
    setdueDay varchar(15) not null,
    CONSTRAINT Lending_account FOREIGN KEY (userID) REFERENCES Account (userID),
    CONSTRAINT Lending_Staff FOREIGN KEY (staffID) REFERENCES Staff (staffID)
);
CREATE TABLE IF NOT EXISTS Lending_detail(
	lendID varchar(10) not null,
    bookID int not null,
    dueDay varchar(15) not null,
    lendStatus varchar(10) not null,
    primary key(lendID,bookID),
     CONSTRAINT Lending_key FOREIGN KEY (lendID) REFERENCES BookLending (lendID),
    CONSTRAINT Lending_Book FOREIGN KEY (bookID) REFERENCES Book_detail (bookID)
);
CREATE TABLE IF NOT EXISTS Author(
	authorID int not null primary key,
    authorName varchar(50) not null,
    authorGender varchar(5) not null,
    authotdob varchar(50) not null,
    authorEmail varchar(50) not null
);
ALTER TABLE Account ADD userAddr varchar(50);
ALTER TABLE Account CHANGE userAnser  userAnswer varchar(50) not null;

