CREATE DATABASE  IF NOT EXISTS `loan_processing_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `loan_processing_system`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: loan_processing_system
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-01 13:47:04
