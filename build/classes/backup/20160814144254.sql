-- MySQL dump 10.13  Distrib 5.1.52, for Win32 (ia32)
--
-- Host: localhost    Database: school_db
-- ------------------------------------------------------
-- Server version	5.1.52-community

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
-- Current Database: `school_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `school_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `school_db`;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `idClasses` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClasses`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'A','1','1'),(2,'B','1','1'),(3,'C','1','1'),(4,'A','2','1'),(5,'B','2','1'),(6,'C','2','1'),(7,'A','3','1'),(8,'B','3','1'),(9,'C','3','1'),(10,'A','4','1'),(11,'B','4','1'),(12,'C','4','1'),(13,'A','5','1'),(14,'B','5','1'),(15,'C','5','1'),(16,'No','class','0');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradeupper`
--

DROP TABLE IF EXISTS `gradeupper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gradeupper` (
  `idGradeUpper` int(100) NOT NULL AUTO_INCREMENT,
  `last_update` varchar(500) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idGradeUpper`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradeupper`
--

LOCK TABLES `gradeupper` WRITE;
/*!40000 ALTER TABLE `gradeupper` DISABLE KEYS */;
INSERT INTO `gradeupper` VALUES (1,'2016','1');
/*!40000 ALTER TABLE `gradeupper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `Teachers_nic` varchar(20) NOT NULL,
  PRIMARY KEY (`Teachers_nic`),
  CONSTRAINT `fk_Login_Teachers1` FOREIGN KEY (`Teachers_nic`) REFERENCES `teachers` (`nic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('123','ddsf','Admin','123'),('12345','dfd','Limit','124');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_status`
--

DROP TABLE IF EXISTS `login_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_status` (
  `log_time_date` datetime DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `Login_Teachers_nic` varchar(20) NOT NULL,
  PRIMARY KEY (`Login_Teachers_nic`),
  CONSTRAINT `fk_Login_status_Login1` FOREIGN KEY (`Login_Teachers_nic`) REFERENCES `login` (`Teachers_nic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_status`
--

LOCK TABLES `login_status` WRITE;
/*!40000 ALTER TABLE `login_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `index_no` int(11) NOT NULL AUTO_INCREMENT,
  `Ser_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `Pass_out_date` date DEFAULT NULL,
  `admission_date` date DEFAULT NULL,
  `father_name` varchar(45) DEFAULT NULL,
  `f_occupation` varchar(45) DEFAULT NULL,
  `f_tel` varchar(45) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `m_occupation` varchar(45) DEFAULT NULL,
  `m_tel` varchar(45) DEFAULT NULL,
  `street` varchar(500) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `special_skills` varchar(1000) DEFAULT NULL,
  `other_details` varchar(1000) DEFAULT NULL,
  `Classes_idClasses` int(11) NOT NULL,
  `Travel_mode_idTravel_mode` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`index_no`),
  KEY `fk_Students_Classes` (`Classes_idClasses`),
  KEY `fk_Students_Travel_mode1` (`Travel_mode_idTravel_mode`),
  CONSTRAINT `fk_Students_Classes` FOREIGN KEY (`Classes_idClasses`) REFERENCES `classes` (`idClasses`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Students_Travel_mode1` FOREIGN KEY (`Travel_mode_idTravel_mode`) REFERENCES `travel_mode` (`idTravel_mode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Arrachchilage','Nimal','Siripala','2014-08-10','Male','2016-07-30','2009-07-16','Kamal','Business','0714323338','Lalitha','Housewife','123345','Daraluwa','Gampaha','no','no2',13,1,'0'),(2,'a','b','c','1998-07-01','Female','2019-12-31','2016-07-25','g','h','12345678','k','s','2','d','e','g','i',14,1,'0'),(3,'Gihan','','Munasinghe','2016-07-07','Male','2018-12-31','2016-07-15','sunil','Mecanic','0773555842','Nalani','Teacher','0716998694','22/b pitiyegedra','Bemmulla','Good sporter	','Blind',15,2,'0'),(4,'cc','c','a','2016-07-08','Female','2019-12-31','2016-08-05','ssss','dsfdsfdsfdsfds','3432324324','fdsfdsfdsfdsfdsfd','adsasdasdasd','3243243432','cccc','ssss','dsfsfdsffsdfa','sfdfdfdsfdfdfs',13,3,'0'),(5,'Manjula','','Pushpakumara','2016-08-12','Male','2017-12-31','2016-09-03','faname','fajob','fatel','moname','mojob','motel','a','b','dsgsdgsg\njjjjjjjjjjjjjjj\njjjjjjjjjjjjjj\nhhhhhhhhhhhhhhhhhh','sdggsg\njjjjjjjjjjjjjjjjjjjjjjjj\njjjjjjjjjjjjjjjjjjjjjjj\njfdesr',14,4,'0');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `nic` varchar(200) NOT NULL,
  `Ser_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `first_appoint_date` date DEFAULT NULL,
  `school_appoint_date` date DEFAULT NULL,
  `increment_date` date DEFAULT NULL,
  `edu_qualifications` varchar(1000) DEFAULT NULL,
  `proffesional_qualification` varchar(1000) DEFAULT NULL,
  `street` varchar(200) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `spouce_name` varchar(500) DEFAULT NULL,
  `s_tel` varchar(45) DEFAULT NULL,
  `s_occupation` varchar(45) DEFAULT NULL,
  `other_deta` varchar(1000) DEFAULT NULL,
  `Classes_idClasses` int(11) NOT NULL,
  `Travel_mode_idTravel_mode` int(11) NOT NULL,
  `service_grade` varchar(100) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `teachers_cat_idteachers_cat` int(11) NOT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_Teachers_Classes1` (`Classes_idClasses`),
  KEY `fk_Teachers_Travel_mode1` (`Travel_mode_idTravel_mode`),
  KEY `fk_teachers_teachers_cat1` (`teachers_cat_idteachers_cat`),
  CONSTRAINT `fk_Teachers_Classes1` FOREIGN KEY (`Classes_idClasses`) REFERENCES `classes` (`idClasses`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_teachers_teachers_cat1` FOREIGN KEY (`teachers_cat_idteachers_cat`) REFERENCES `teachers_cat` (`idteachers_cat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teachers_Travel_mode1` FOREIGN KEY (`Travel_mode_idTravel_mode`) REFERENCES `travel_mode` (`idTravel_mode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES ('123','PK','Chamara','Sasmith','2016-08-05','Male','2016-08-27','2016-09-02','2016-08-30','A/L','SE','Kuruduwaththa','Veyangoda','07143','Hashi','075','null','asd',1,2,'2-II','1',2),('12345','a','b','c','2016-08-12','Male','2016-08-12','2016-08-20','2016-08-03','al','','s','c','','  ','','','',16,6,'2-I',NULL,3),('123456','f','m','l','2016-07-01','Male','2016-07-15','2016-07-07','2016-07-14','al','pro','s','c','071','ff mm ll','075','job','odet',1,1,'I',NULL,2),('124','dfdf','fdf','fdfd',NULL,'Female',NULL,NULL,NULL,'fee','ww','eeeeeeee','ve','222','asds','123','aa','ad',1,1,'fdg','1',1),('53545','dgf','gdf','df','2016-07-08','Female','2016-07-14','2016-07-04','2016-07-08','dgd','dfgdg','gf','dg','534535345','gdfg dfg dfg','3534','dfgd','gfdfg',5,6,'2-II',NULL,3);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_cat`
--

DROP TABLE IF EXISTS `teachers_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers_cat` (
  `idteachers_cat` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`idteachers_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_cat`
--

LOCK TABLES `teachers_cat` WRITE;
/*!40000 ALTER TABLE `teachers_cat` DISABLE KEYS */;
INSERT INTO `teachers_cat` VALUES (1,'Deploma'),(2,'Digree'),(3,'Graduate');
/*!40000 ALTER TABLE `teachers_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tleave`
--

DROP TABLE IF EXISTS `tleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tleave` (
  `tid` int(11) NOT NULL,
  `date1` date NOT NULL,
  `type1` varchar(100) DEFAULT NULL,
  `des` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`tid`,`date1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tleave`
--

LOCK TABLES `tleave` WRITE;
/*!40000 ALTER TABLE `tleave` DISABLE KEYS */;
INSERT INTO `tleave` VALUES (123,'2016-07-12','Medical','ghgfhgfhgfhgfhhgfhgfhg'),(123,'2016-07-28','casu','leda'),(123,'2016-09-06','casu',''),(124,'2016-08-10','casu','eeeeqa');
/*!40000 ALTER TABLE `tleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_mode`
--

DROP TABLE IF EXISTS `travel_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travel_mode` (
  `idTravel_mode` int(11) NOT NULL AUTO_INCREMENT,
  `mode_name` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTravel_mode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_mode`
--

LOCK TABLES `travel_mode` WRITE;
/*!40000 ALTER TABLE `travel_mode` DISABLE KEYS */;
INSERT INTO `travel_mode` VALUES (1,'Bus','1'),(2,'Car','1'),(3,'Van','1'),(4,'Train','1'),(5,'Bike','1'),(6,'Foot','1');
/*!40000 ALTER TABLE `travel_mode` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-14 14:42:55
