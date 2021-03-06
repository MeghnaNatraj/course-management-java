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
-- Table structure for table `group_a`
--

DROP TABLE IF EXISTS `group_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_a` (
  `gausn` varchar(20) NOT NULL,
  `1st_pref` varchar(45) DEFAULT NULL,
  `2nd_pref` varchar(45) DEFAULT NULL,
  `3rd_pref` varchar(45) DEFAULT NULL,
  `4th_pref` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gausn`),
  KEY `1st_fka` (`1st_pref`),
  KEY `2nd_fka` (`2nd_pref`),
  KEY `3rd_fka` (`3rd_pref`),
  KEY `4th_fka` (`4th_pref`),
  KEY `GAusn` (`gausn`),
  CONSTRAINT `1st_fka` FOREIGN KEY (`1st_pref`) REFERENCES `elective_subject` (`ename`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `2nd_fka` FOREIGN KEY (`2nd_pref`) REFERENCES `elective_subject` (`ename`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `3rd_fka` FOREIGN KEY (`3rd_pref`) REFERENCES `elective_subject` (`ename`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `4th_fka` FOREIGN KEY (`4th_pref`) REFERENCES `elective_subject` (`ename`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `GAusn` FOREIGN KEY (`gausn`) REFERENCES `student` (`usn`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_a`
--

LOCK TABLES `group_a` WRITE;
/*!40000 ALTER TABLE `group_a` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_a` ENABLE KEYS */;
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
