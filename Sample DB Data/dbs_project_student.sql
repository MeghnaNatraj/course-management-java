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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `usn` varchar(20) NOT NULL,
  `sfname` varchar(20) DEFAULT NULL,
  `sminit` varchar(6) DEFAULT NULL,
  `slname` varchar(20) DEFAULT NULL,
  `sbranch` varchar(10) DEFAULT NULL,
  `ssem` int(11) DEFAULT NULL,
  `sec` char(1) DEFAULT NULL,
  `group_A` varchar(50) DEFAULT NULL,
  `group_B` varchar(50) DEFAULT NULL,
  `suser_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`usn`),
  KEY `user_id` (`suser_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`suser_id`) REFERENCES `login` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('IMS10CS045','devi','s',' ','cse',5,'b',NULL,NULL,'IMS10CS045'),('IMS10CS046','dhanya','p','prasad','cse',5,'b',NULL,NULL,'IMS10CS046'),('IMS10CS047','ganesh',' ','s','cse',5,'b',NULL,NULL,'IMS10CS047'),('IMS10CS048','ganesh','s','hegde','cse',5,'b',NULL,NULL,'IMS10CS048'),('IMS10CS049','gagan',' ','g','cse',5,'b',NULL,NULL,'IMS10CS049'),('IMS10CS050','gaurav',' ','g','cse',5,'b',NULL,NULL,'IMS10CS050'),('IMS10CS051','gauti','a',' ','cse',5,'b',NULL,NULL,'IMS10CS051'),('IMS10CS052','greeshma',' ','r','cse',5,'b',NULL,NULL,'IMS10CS052'),('IMS10CS053','kanchana',' ','s','cse',5,'b',NULL,NULL,'IMS10CS053'),('IMS10CS054','kiran',' ','k','cse',5,'b',NULL,NULL,'IMS10CS054');
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

-- Dump completed on 2012-12-09 22:25:25
