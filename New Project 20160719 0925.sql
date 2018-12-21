-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.52-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema school_db
--

CREATE DATABASE IF NOT EXISTS school_db;
USE school_db;

--
-- Temporary table structure for view `indata`
--
DROP TABLE IF EXISTS `indata`;
DROP VIEW IF EXISTS `indata`;
CREATE TABLE `indata` (
  `index_no` int(11),
  `Ser_name` varchar(45),
  `middle_name` varchar(45),
  `last_name` varchar(45),
  `dob` date,
  `gender` varchar(100),
  `Pass_out_date` date,
  `admission_date` date,
  `father_name` varchar(45),
  `f_occupation` varchar(45),
  `f_tel` varchar(45),
  `mother_name` varchar(45),
  `m_occupation` varchar(45),
  `m_tel` varchar(45),
  `street` varchar(500),
  `city` varchar(45),
  `special_skills` varchar(1000),
  `other_details` varchar(1000),
  `Classes_idClasses` int(11),
  `Travel_mode_idTravel_mode` int(11),
  `idClasses` int(11),
  `class_name` varchar(45),
  `grade` varchar(45),
  `status` varchar(45)
);

--
-- Definition of table `classes`
--

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `idClasses` int(11) NOT NULL,
  `class_name` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClasses`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes`
--

/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` (`idClasses`,`class_name`,`grade`,`status`) VALUES 
 (1,'A','1',NULL),
 (2,'B','1',NULL),
 (3,'C','1',NULL),
 (4,'A','2',NULL),
 (5,'B','2',NULL),
 (6,'C','2',NULL),
 (7,'A','3',NULL),
 (8,'B','3',NULL),
 (9,'C','3',NULL),
 (10,'A','4',NULL),
 (11,'B','4',NULL),
 (12,'C','4',NULL),
 (13,'A','5',NULL),
 (14,'B','5',NULL),
 (15,'C','5',NULL),
 (16,'Class','No',NULL);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `Teachers_nic` varchar(20) NOT NULL,
  PRIMARY KEY (`Teachers_nic`),
  CONSTRAINT `fk_Login_Teachers1` FOREIGN KEY (`Teachers_nic`) REFERENCES `teachers` (`nic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `login_status`
--

DROP TABLE IF EXISTS `login_status`;
CREATE TABLE `login_status` (
  `log_time_date` datetime DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `Login_Teachers_nic` varchar(20) NOT NULL,
  PRIMARY KEY (`Login_Teachers_nic`),
  CONSTRAINT `fk_Login_status_Login1` FOREIGN KEY (`Login_Teachers_nic`) REFERENCES `login` (`Teachers_nic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_status`
--

/*!40000 ALTER TABLE `login_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_status` ENABLE KEYS */;


--
-- Definition of table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `index_no` int(11) NOT NULL,
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
  PRIMARY KEY (`index_no`),
  KEY `fk_Students_Classes` (`Classes_idClasses`),
  KEY `fk_Students_Travel_mode1` (`Travel_mode_idTravel_mode`),
  CONSTRAINT `fk_Students_Classes` FOREIGN KEY (`Classes_idClasses`) REFERENCES `classes` (`idClasses`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Students_Travel_mode1` FOREIGN KEY (`Travel_mode_idTravel_mode`) REFERENCES `travel_mode` (`idTravel_mode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`index_no`,`Ser_name`,`middle_name`,`last_name`,`dob`,`gender`,`Pass_out_date`,`admission_date`,`father_name`,`f_occupation`,`f_tel`,`mother_name`,`m_occupation`,`m_tel`,`street`,`city`,`special_skills`,`other_details`,`Classes_idClasses`,`Travel_mode_idTravel_mode`) VALUES 
 (324234,'gdfgdfg','dfg','dfgfd','2016-07-08','Male','2020-12-31','2016-07-21','dfgdf','dfgd','dfgdf','dfgfd','dfgfd','dfgdf','dfgdf','dfgf','dfgfg','dfgfd',2,1),
 (324235,'ggdgdfg','ggdfgdfg','gdfgdfgdf','2016-07-01','Male','2019-12-31','2016-07-12','dfgdf','dfgdfg','dfgfgdfg','dgdf','dfgdgd','dfgfd','dfgdfgdfg','fdgdfggdgf','dfgfgfdgdfgdfgdfdfgfd','gfgfdgdfgfgdfgdfgdfgdffgdfgdfg',6,1);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;


--
-- Definition of table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
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
  PRIMARY KEY (`nic`),
  KEY `fk_Teachers_Classes1` (`Classes_idClasses`),
  KEY `fk_Teachers_Travel_mode1` (`Travel_mode_idTravel_mode`),
  CONSTRAINT `fk_Teachers_Classes1` FOREIGN KEY (`Classes_idClasses`) REFERENCES `classes` (`idClasses`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teachers_Travel_mode1` FOREIGN KEY (`Travel_mode_idTravel_mode`) REFERENCES `travel_mode` (`idTravel_mode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teachers`
--

/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` (`nic`,`Ser_name`,`middle_name`,`last_name`,`dob`,`gender`,`first_appoint_date`,`school_appoint_date`,`increment_date`,`edu_qualifications`,`proffesional_qualification`,`street`,`city`,`tel`,`spouce_name`,`s_tel`,`s_occupation`,`other_deta`,`Classes_idClasses`,`Travel_mode_idTravel_mode`,`service_grade`) VALUES 
 ('13231312','asd','sdad','asd','2016-07-09','Male','2016-07-16','2016-07-25','2016-07-12','asdsadad','asdsa','sad','sad','213213','sad asdd asdsa','dasdsad','sada','sadsadasd\nsadsad\ndsad',2,4,'2-I');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;


--
-- Definition of table `travel_mode`
--

DROP TABLE IF EXISTS `travel_mode`;
CREATE TABLE `travel_mode` (
  `idTravel_mode` int(11) NOT NULL,
  `mode_name` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTravel_mode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_mode`
--

/*!40000 ALTER TABLE `travel_mode` DISABLE KEYS */;
INSERT INTO `travel_mode` (`idTravel_mode`,`mode_name`,`status`) VALUES 
 (1,'Bus',NULL),
 (2,'Train',NULL),
 (3,'School Van',NULL),
 (4,'Personal Vehicle',NULL),
 (5,'Foot',NULL);
/*!40000 ALTER TABLE `travel_mode` ENABLE KEYS */;


--
-- Definition of view `indata`
--

DROP TABLE IF EXISTS `indata`;
DROP VIEW IF EXISTS `indata`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `indata` AS (select `students`.`index_no` AS `index_no`,`students`.`Ser_name` AS `Ser_name`,`students`.`middle_name` AS `middle_name`,`students`.`last_name` AS `last_name`,`students`.`dob` AS `dob`,`students`.`gender` AS `gender`,`students`.`Pass_out_date` AS `Pass_out_date`,`students`.`admission_date` AS `admission_date`,`students`.`father_name` AS `father_name`,`students`.`f_occupation` AS `f_occupation`,`students`.`f_tel` AS `f_tel`,`students`.`mother_name` AS `mother_name`,`students`.`m_occupation` AS `m_occupation`,`students`.`m_tel` AS `m_tel`,`students`.`street` AS `street`,`students`.`city` AS `city`,`students`.`special_skills` AS `special_skills`,`students`.`other_details` AS `other_details`,`students`.`Classes_idClasses` AS `Classes_idClasses`,`students`.`Travel_mode_idTravel_mode` AS `Travel_mode_idTravel_mode`,`classes`.`idClasses` AS `idClasses`,`classes`.`class_name` AS `class_name`,`classes`.`grade` AS `grade`,`classes`.`status` AS `status` from (`students` join `classes`));



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
