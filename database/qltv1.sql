-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 13, 2020 lúc 06:56 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltv`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `userID` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `startDay` varchar(20) NOT NULL,
  `outofDay` varchar(20) NOT NULL,
  `staffID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`userID`, `userName`, `userPassword`, `startDay`, `outofDay`, `staffID`) VALUES
(1, 'lap123', '123456', '2020-13-05', '9999-9-29', 5),
(2, 'quan123', '123456', '2020-13-05', '9999-9-29', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `authorID` int(11) NOT NULL,
  `authorName` varchar(50) NOT NULL,
  `authorGender` varchar(5) NOT NULL,
  `authorDOB` date NOT NULL,
  `authorEmail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `author`
--

INSERT INTO `author` (`authorID`, `authorName`, `authorGender`, `authorDOB`, `authorEmail`) VALUES
(1, 'Ernest Hemingway', 'Male', '1899-07-21', NULL),
(2, 'Patricia Highsmith', 'Male', '1921-01-19', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booklending`
--

CREATE TABLE `booklending` (
  `lendID` int(11) NOT NULL,
  `lendStudentID` int(11) NOT NULL,
  `createDay` varchar(15) NOT NULL,
  `setdueDay` varchar(15) NOT NULL,
  `issued_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `booklending`
--

INSERT INTO `booklending` (`lendID`, `lendStudentID`, `createDay`, `setdueDay`, `issued_by`) VALUES
(1, 1, '2020-13-05', '2020-03-20', 4),
(2, 2, '2020-13-05', '2020-03-20', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book_detail`
--

CREATE TABLE `book_detail` (
  `bookID` int(11) NOT NULL,
  `bookName` varchar(50) NOT NULL,
  `bookAuthorID` int(11) NOT NULL,
  `bookCategoryID` int(11) NOT NULL,
  `bookPublisher` varchar(50) NOT NULL,
  `bookPrice` int(11) NOT NULL,
  `bookPages` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `book_detail`
--

INSERT INTO `book_detail` (`bookID`, `bookName`, `bookAuthorID`, `bookCategoryID`, `bookPublisher`, `bookPrice`, `bookPages`) VALUES
(1, 'The Old Man and the Sea', 1, 1, '1952', 300000, 300),
(2, 'The Talented Mr. Ripley ', 2, 1, '1955', 257000, 168);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `categoryID` int(11) NOT NULL,
  `categoryName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`categoryID`, `categoryName`) VALUES
(1, 'Literature'),
(2, 'Math');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lending_detail`
--

CREATE TABLE `lending_detail` (
  `lendID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `lendQuantity` int(11) NOT NULL,
  `dueDay` varchar(15) NOT NULL,
  `lendStatus` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `lending_detail`
--

INSERT INTO `lending_detail` (`lendID`, `bookID`, `lendQuantity`, `dueDay`, `lendStatus`) VALUES
(1, 1, 1, '2020-5-19', 'Lending'),
(2, 2, 1, '2020-5-19', 'Lending');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `roleID` int(11) NOT NULL,
  `roleName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`roleID`, `roleName`) VALUES
(1, 'Staff'),
(2, 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `staffID` int(11) NOT NULL,
  `staffName` varchar(50) NOT NULL,
  `staffdob` date NOT NULL,
  `staffAddr` varchar(50) NOT NULL,
  `staffGender` varchar(5) NOT NULL,
  `staffPhone` varchar(12) NOT NULL,
  `staff_roleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`staffID`, `staffName`, `staffdob`, `staffAddr`, `staffGender`, `staffPhone`, `staff_roleID`) VALUES
(4, 'Quan', '2000-12-01', 'Ho Chi Minh city', 'Male', '0123456789', 1),
(5, 'Lap', '2000-12-01', 'Ha Noi city', 'Male', '9876543210', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `studentID` int(11) NOT NULL,
  `studentName` varchar(50) NOT NULL,
  `studenDOB` date NOT NULL,
  `studenEmail` varchar(50) NOT NULL,
  `studentClass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`studentID`, `studentName`, `studenDOB`, `studenEmail`, `studentClass`) VALUES
(1, 'Joe', '1999-03-24', '', 'AK181'),
(2, 'Peter', '1998-12-17', '', 'AK182');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userID`),
  ADD KEY `account_staff_FK` (`staffID`);

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`authorID`);

--
-- Chỉ mục cho bảng `booklending`
--
ALTER TABLE `booklending`
  ADD PRIMARY KEY (`lendID`),
  ADD KEY `lending_student` (`lendStudentID`),
  ADD KEY `lend_lendingStaff` (`issued_by`);

--
-- Chỉ mục cho bảng `book_detail`
--
ALTER TABLE `book_detail`
  ADD PRIMARY KEY (`bookID`),
  ADD KEY `book_author_FK` (`bookAuthorID`),
  ADD KEY `book_category_FK` (`bookCategoryID`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categoryID`);

--
-- Chỉ mục cho bảng `lending_detail`
--
ALTER TABLE `lending_detail`
  ADD PRIMARY KEY (`lendID`,`bookID`),
  ADD KEY `book_lending_FK` (`bookID`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleID`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`),
  ADD KEY `staff_role_FK` (`staff_roleID`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `author`
--
ALTER TABLE `author`
  MODIFY `authorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `booklending`
--
ALTER TABLE `booklending`
  MODIFY `lendID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `book_detail`
--
ALTER TABLE `book_detail`
  MODIFY `bookID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `categoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `roleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `staff`
--
ALTER TABLE `staff`
  MODIFY `staffID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `student`
--
ALTER TABLE `student`
  MODIFY `studentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_staff_FK` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`);

--
-- Các ràng buộc cho bảng `booklending`
--
ALTER TABLE `booklending`
  ADD CONSTRAINT `lend_lendingStaff` FOREIGN KEY (`issued_by`) REFERENCES `staff` (`staffID`),
  ADD CONSTRAINT `lending_student` FOREIGN KEY (`lendStudentID`) REFERENCES `student` (`studentID`);

--
-- Các ràng buộc cho bảng `book_detail`
--
ALTER TABLE `book_detail`
  ADD CONSTRAINT `book_author_FK` FOREIGN KEY (`bookAuthorID`) REFERENCES `author` (`authorID`),
  ADD CONSTRAINT `book_category_FK` FOREIGN KEY (`bookCategoryID`) REFERENCES `categories` (`categoryID`);

--
-- Các ràng buộc cho bảng `lending_detail`
--
ALTER TABLE `lending_detail`
  ADD CONSTRAINT `book_lending_FK` FOREIGN KEY (`bookID`) REFERENCES `book_detail` (`bookID`),
  ADD CONSTRAINT `lend_lending_FK` FOREIGN KEY (`lendID`) REFERENCES `booklending` (`lendID`);

--
-- Các ràng buộc cho bảng `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_role_FK` FOREIGN KEY (`staff_roleID`) REFERENCES `role` (`roleID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
