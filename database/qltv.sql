SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE DATABASE IF NOT EXISTS QLTV;
USE QLTV;
Create TABLE IF NOT EXISTS Book_detail(
	bookID int not null Primary key ,
    bookName varchar(50) not null,
    bookAuthorID int not null,
    bookCategoryID int not null,
    bookPublisher varchar(50)not null,
    bookPrice int	not null,
    bookPages int  not null
    );
DROP TABLE Book_detail;
CREATE TABLE IF NOT EXISTS Account(
	userID int not null primary key,
	userName varchar(50) not null,
    userPassword varchar(20) not null,
    startDay varchar(20) not null,
    outofDay varchar(20) not null
);
DROP TABLE Account;
CREATE TABLE IF NOT EXISTS Staff(
	staffID int not null primary key,
    staffName varchar(50) not null,
    staffdob varchar(50) not null,
    staffAddr varchar(50) not null,
    staffGender varchar(5) not null,
    staffPhone varchar(12) not null,
    staffAccountID int not null
);
DROP TABLE Staff;
CREATE TABLE IF NOT EXISTS BookLending(
	lendID int not null,
	lendUserID int not null,
    createDay varchar(15) not null,
    setdueDay varchar(15) not null,
    issued_by int not null,
    primary key(lendID),
    CONSTRAINT Lending_account FOREIGN KEY (lendUserID) REFERENCES Account (userID),
    CONSTRAINT Lending_Staff FOREIGN KEY (issued_by) REFERENCES Staff (staffID)
);
DROP TABLE BookLending;
CREATE TABLE IF NOT EXISTS Lending_detail(
	lendID int not null,
    bookID int not null,
    lendQuantity int not null,
    dueDay varchar(15) not null,
    lendStatus varchar(10) not null,
    primary key(lendID,bookID),
	CONSTRAINT Lending_key FOREIGN KEY (lendID) REFERENCES BookLending (lendID),
    CONSTRAINT Lending_Book FOREIGN KEY (bookID) REFERENCES Book_detail (bookID)
);
DROP TABLE Lending_detail;
CREATE TABLE IF NOT EXISTS Author(
	authorID int not null primary key,
    authorName varchar(50) not null,
    authorGender varchar(5) not null,
	authorDOB varchar(50) not null,
    authorEmail varchar(50) 
);
CREATE TABLE IF NOT EXISTS Categories(
	categoryID int not null primary key,
    categoryName varchar(50) not null
);
CREATE TABLE IF NOT EXISTS Student(
 studentID int not null primary key,
 studentName varchar(50) not null,
 studenDOB varchar(50) not null,
 studenEmail varchar(50) not null,
 studentClass varchar(10) not null,
 accountID int not null
);
DROP TABLE Student;
CREATE TABLE IF NOT EXISTS Role(
	roleID int not null primary key,
    roleName varchar(50) not null
);
CREATE TABLE IF NOT EXISTS AccountRole(
	roleID int not null,
    accountID int not null,
    constraint Accountrole_role foreign key (roleID) references Role(roleID),
    constraint Accountrole_Account foreign key (accountID) references Account(userID),
    primary key(roleID,accountID)
)
DROP TABLE Caterogies;
ALTER TABLE Student DROP CONSTRAINT Student_Account;
ALTER TABLE BookLending DROP CONSTRAINT Lending_Staff;
ALTER TABLE BookLending DROP CONSTRAINT Lending_account;
ALTER TABLE Lending_detail DROP CONSTRAINT Lending_Book;
ALTER TABLE Lending_detail DROP CONSTRAINT Lending_key;
ALTER TABLE BookLending DROP CONSTRAINT Lending_account;
ALTER TABLE BookLending DROP CONSTRAINT Lending_Staff;
ALTER TABLE Book_detail DROP CONSTRAINT Book_Categories;
ALTER TABLE Book_detail ADD CONSTRAINT Book_Categories foreign key(bookCategoryID) REFERENCES Categories (categoryID);
ALTER TABLE BookLending ADD CONSTRAINT Lending_account foreign key(lendUserID) REFERENCES Account(userID);
ALTER TABLE BookLending ADD CONSTRAINT Lending_Staff foreign key(Issued_by) REFERENCES Staff(staffID);
ALTER TABLE Book_detail ADD CONSTRAINT Book_Author FOREIGN KEY(bookAuthorID) REFERENCES Author(authorID);
ALTER TABLE Student ADD CONSTRAINT Student_Account FOREIGN KEY(accountID) REFERENCES Account(userID);
ALTER TABLE Staff ADD CONSTRAINT Staff_Account foreign key(staffAccountID) references Account(userID);
SELECT ac.userName,ac.userPassword,s.staffName 
FROM Staff s Join account ac on s.staffAccountID = ac.userID
WHERE  s.staffAccountID = ac.userID
