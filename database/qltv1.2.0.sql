-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: qltv2
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `startDay` varchar(20) NOT NULL,
  `outofDay` varchar(20) NOT NULL,
  `staffID` int NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `account_staff_FK` (`staffID`),
  CONSTRAINT `account_staff_FK` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'lap123','123456','2020-13-05','9999-9-29',5),(2,'quan123','123456','2020-13-05','9999-9-29',4);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author` (
  `authorID` int NOT NULL AUTO_INCREMENT,
  `authorName` varchar(50) NOT NULL,
  `authorGender` varchar(10) NOT NULL,
  `authorDOB` date NOT NULL,
  `authorEmail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`authorID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Ernest Hemingway','Male','1899-07-21',NULL),(2,'Patricia Highsmith','Male','1921-01-19',NULL);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `bookID` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(50) NOT NULL,
  `bookAuthorID` int NOT NULL,
  `bookCategoryID` int NOT NULL,
  `bookPublisher` varchar(50) NOT NULL,
  `bookPrice` int NOT NULL,
  `bookPages` int NOT NULL,
  PRIMARY KEY (`bookID`),
  KEY `book_author_FK` (`bookAuthorID`),
  KEY `book_category_FK` (`bookCategoryID`),
  CONSTRAINT `book_author_FK` FOREIGN KEY (`bookAuthorID`) REFERENCES `author` (`authorID`),
  CONSTRAINT `book_category_FK` FOREIGN KEY (`bookCategoryID`) REFERENCES `categories` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'The Old Man and The Fish',1,1,'1952',300000,268),(2,'New Book 2',1,1,'1985',800000,13),(4,'Fairy Tail',2,1,'2016',175000,35),(5,'Death Note 1',1,1,'1965',73000,12),(6,'Death Note 2',2,1,'1969',126000,45),(7,'Death Note 3',1,1,'2000',99000,200),(8,'English For Beginners',2,2,'2016',846000,8),(9,'Java For Begginers',1,1,'1965',400000,47),(10,'New 3',2,2,'1965',40000,45),(11,'Book 11',1,2,'2019',400000,350),(12,'Book 12',2,2,'2020',10000,1),(13,'Book 11',2,2,'1965',40000,23);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booklending`
--

DROP TABLE IF EXISTS `booklending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booklending` (
  `lendID` int NOT NULL AUTO_INCREMENT,
  `lendStudentID` int NOT NULL,
  `createDay` date NOT NULL,
  `returndate` date NOT NULL,
  `issued_by` int NOT NULL,
  PRIMARY KEY (`lendID`),
  KEY `lending_student` (`lendStudentID`),
  KEY `lend_lendingStaff` (`issued_by`),
  CONSTRAINT `lend_lendingStaff` FOREIGN KEY (`issued_by`) REFERENCES `staff` (`staffID`),
  CONSTRAINT `lending_student` FOREIGN KEY (`lendStudentID`) REFERENCES `student` (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booklending`
--

LOCK TABLES `booklending` WRITE;
/*!40000 ALTER TABLE `booklending` DISABLE KEYS */;
INSERT INTO `booklending` VALUES (1,1,'2020-05-13','2020-05-20',4),(2,2,'2020-05-13','2020-05-20',5),(3,3,'2020-06-01','2020-05-20',5),(5,3,'2020-06-02','2020-05-20',5),(6,2,'2020-06-03','2020-05-20',5),(7,2,'2020-06-06','2021-06-22',5);
/*!40000 ALTER TABLE `booklending` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `categoryID` int NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Literature'),(2,'Math');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lending_detail`
--

DROP TABLE IF EXISTS `lending_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lending_detail` (
  `lendID` int NOT NULL,
  `bookID` int NOT NULL,
  `dueDay` varchar(15) DEFAULT NULL,
  `lendStatus` varchar(10) NOT NULL,
  PRIMARY KEY (`lendID`,`bookID`),
  KEY `book_lending_FK` (`bookID`),
  CONSTRAINT `book_lending_FK` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`),
  CONSTRAINT `lend_lending_FK` FOREIGN KEY (`lendID`) REFERENCES `booklending` (`lendID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lending_detail`
--

LOCK TABLES `lending_detail` WRITE;
/*!40000 ALTER TABLE `lending_detail` DISABLE KEYS */;
INSERT INTO `lending_detail` VALUES (1,1,'2020-5-19','Lending'),(2,2,'2020-5-19','Lending'),(3,7,'2020-06-06','Returned'),(5,6,'2020-06-06','Returned'),(6,1,'2020-06-05','Returned'),(6,4,'2020-06-05','Returned'),(6,7,'2020-06-05','Returned'),(7,4,'null','Lending'),(7,7,'null','Lending'),(7,8,'null','Lending');
/*!40000 ALTER TABLE `lending_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleID` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) NOT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Staff'),(2,'Admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staffID` int NOT NULL AUTO_INCREMENT,
  `staffName` varchar(50) NOT NULL,
  `staffdob` date NOT NULL,
  `staffAddr` varchar(50) NOT NULL,
  `staffGender` varchar(10) NOT NULL,
  `staffPhone` varchar(12) NOT NULL,
  `staff_roleID` int NOT NULL,
  PRIMARY KEY (`staffID`),
  KEY `staff_role_FK` (`staff_roleID`),
  CONSTRAINT `staff_role_FK` FOREIGN KEY (`staff_roleID`) REFERENCES `role` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (4,'Quan','2000-12-01','Ho Chi Minh city','Male','0123456789',1),(5,'Lap','2000-12-01','Ha Noi city','Male','9876543210',2);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `studentID` int NOT NULL AUTO_INCREMENT,
  `studentName` varchar(50) NOT NULL,
  `studentDOB` date NOT NULL,
  `studentEmail` varchar(50) NOT NULL,
  `studentClass` varchar(10) NOT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Joe','1999-03-24','jordanmoo123@gmail.com','AK181'),(2,'Peter','1998-12-17','pee2115@gmail.com','AK182'),(3,'sarah','1999-05-20','sarah123@gmail.com','AKA183'),(4,'Glenn','2003-05-12','glenn01@gmail.com','AKA118');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-06 14:37:03
