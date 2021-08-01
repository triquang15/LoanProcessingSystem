CREATE DATABASE  IF NOT EXISTS `loan_processing_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `loan_processing_system`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: loan_processing_system
-- ------------------------------------------------------
-- Server version	8.0.25

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
  `Id` int NOT NULL AUTO_INCREMENT,
  `AuthorityId` int DEFAULT NULL,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` text COLLATE utf8mb4_unicode_ci,
  `Phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Gender` tinyint DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `IdentityCard` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_Account_AccountType` (`AuthorityId`),
  CONSTRAINT `FK_Account_AccountType` FOREIGN KEY (`AuthorityId`) REFERENCES `authorities` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,NULL,'Mr Quang','$2a$10$0vcudunQTzyNuh4dALWaYO1IgdAPslkIk5uDP5BLUW8bOmVf275ja','Viet Nam','0987774191','Triquang.15qt@gmail.com',1,'2021-08-12','197344123',1),(2,NULL,'Aptech','$2a$10$SIrWK7jfRnbthGHAmSJMMeNGmXGt7qSGn0cIOVK1k4NmOKmA7Io42','Viet Nam','0987774194','aptech@gmail.com',1,'2021-08-17','197123456',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `Id` int NOT NULL,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` text COLLATE utf8mb4_unicode_ci,
  `Phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Gender` tinyint DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Salary` float DEFAULT NULL,
  `Job` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Company` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IdentityCard` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fine`
--

DROP TABLE IF EXISTS `fine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fine` (
  `Id` int NOT NULL,
  `FineInterest` float DEFAULT NULL,
  `Min` double DEFAULT NULL,
  `Max` double DEFAULT NULL,
  `Description` text COLLATE utf8mb4_unicode_ci,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fine`
--

LOCK TABLES `fine` WRITE;
/*!40000 ALTER TABLE `fine` DISABLE KEYS */;
/*!40000 ALTER TABLE `fine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `LoanTypeId` int DEFAULT NULL,
  `AccountId` int DEFAULT NULL,
  `CustomerId` int DEFAULT NULL,
  `PaymentTypeId` int DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  `Period` int DEFAULT NULL,
  `CreateDate` date DEFAULT NULL,
  `DisbursementDate` date DEFAULT NULL,
  `Duration` int DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `Interest` float DEFAULT NULL,
  `Description` text COLLATE utf8mb4_unicode_ci,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_Loan_LoanType` (`LoanTypeId`),
  KEY `FK_Loan_Account` (`AccountId`),
  KEY `FK_Loan_Customer` (`CustomerId`),
  KEY `FK_Loan_PaymentType` (`PaymentTypeId`),
  CONSTRAINT `FK_Loan_Account` FOREIGN KEY (`AccountId`) REFERENCES `account` (`Id`),
  CONSTRAINT `FK_Loan_Customer` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`Id`),
  CONSTRAINT `FK_Loan_LoanType` FOREIGN KEY (`LoanTypeId`) REFERENCES `loantype` (`Id`),
  CONSTRAINT `FK_Loan_PaymentType` FOREIGN KEY (`PaymentTypeId`) REFERENCES `paymenttype` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loanandfinehistory`
--

DROP TABLE IF EXISTS `loanandfinehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loanandfinehistory` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `LoanId` int DEFAULT NULL,
  `FineId` int DEFAULT NULL,
  `PaymentMethodId` int DEFAULT NULL,
  `PaymentAmount` double DEFAULT NULL,
  `AmountLeft` double DEFAULT NULL,
  `DueDate` date DEFAULT NULL,
  `FineInterest` float DEFAULT NULL,
  `FineOverDays` int DEFAULT NULL,
  `FineAmount` double DEFAULT NULL,
  `PaymentDate` date DEFAULT NULL,
  `Description` text COLLATE utf8mb4_unicode_ci,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_LoanAndFineHistory_Loan` (`LoanId`),
  KEY `FK_LoanAndFineHistory_Fine` (`FineId`),
  KEY `FK_LoanAndFineHistory_PaymentMethod` (`PaymentMethodId`),
  CONSTRAINT `FK_LoanAndFineHistory_Fine` FOREIGN KEY (`FineId`) REFERENCES `fine` (`Id`),
  CONSTRAINT `FK_LoanAndFineHistory_Loan` FOREIGN KEY (`LoanId`) REFERENCES `loan` (`Id`),
  CONSTRAINT `FK_LoanAndFineHistory_PaymentMethod` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loanandfinehistory`
--

LOCK TABLES `loanandfinehistory` WRITE;
/*!40000 ALTER TABLE `loanandfinehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `loanandfinehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loantype`
--

DROP TABLE IF EXISTS `loantype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loantype` (
  `Id` int NOT NULL,
  `Interest` float DEFAULT NULL,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Description` text COLLATE utf8mb4_unicode_ci,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loantype`
--

LOCK TABLES `loantype` WRITE;
/*!40000 ALTER TABLE `loantype` DISABLE KEYS */;
/*!40000 ALTER TABLE `loantype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentmethod` (
  `Id` int NOT NULL,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
/*!40000 ALTER TABLE `paymentmethod` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymenttype`
--

DROP TABLE IF EXISTS `paymenttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymenttype` (
  `Id` int NOT NULL,
  `Name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymenttype`
--

LOCK TABLES `paymenttype` WRITE;
/*!40000 ALTER TABLE `paymenttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymenttype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-01 14:30:36
