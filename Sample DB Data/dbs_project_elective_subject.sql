CREATE DATABASE  IF NOT EXISTS `dbs_project` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbs_project`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: dbs_project
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `elective_subject`
--

DROP TABLE IF EXISTS `elective_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elective_subject` (
  `ecode` varchar(10) NOT NULL,
  `ename` varchar(45) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `esem` int(11) DEFAULT NULL,
  `no_of_classes` int(11) DEFAULT NULL,
  `handled_by` varchar(20) DEFAULT NULL,
  `no_of_students` int(11) DEFAULT NULL,
  `egroup` char(1) DEFAULT NULL,
  PRIMARY KEY (`ecode`),
  UNIQUE KEY `Ename_UNIQUE` (`ename`),
  KEY `handled` (`handled_by`),
  CONSTRAINT `handled` FOREIGN KEY (`handled_by`) REFERENCES `teacher` (`t_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elective_subject`
--

LOCK TABLES `elective_subject` WRITE;
/*!40000 ALTER TABLE `elective_subject` DISABLE KEYS */;
INSERT INTO `elective_subject` VALUES ('CSPE611','artificial intelligence',4,60,5,NULL,NULL,NULL,'a'),('CSPE613','advanced DBMS',4,60,5,NULL,NULL,NULL,'a'),('CSPE614','digital signal processing',4,60,5,NULL,NULL,NULL,'a'),('CSPE615','C# and.Net Technologies',4,60,5,NULL,NULL,NULL,'a'),('CSPE616','information retrieval',3,60,5,NULL,NULL,NULL,'b'),('CSPE617','internet technologies',3,60,5,NULL,NULL,NULL,'b'),('CSPE618','information on demand',3,60,5,NULL,NULL,NULL,'b'),('CSPE619','game theory',3,60,5,NULL,NULL,NULL,'b'),('CSPE620','system simulation',3,60,5,NULL,NULL,NULL,'b'),('CSPE621','pattern recognition',4,60,5,NULL,NULL,NULL,'a');
/*!40000 ALTER TABLE `elective_subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-09 22:25:25
