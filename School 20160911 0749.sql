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
-- Definition of table `classes`
--

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `idClasses` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClasses`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes`
--

/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` (`idClasses`,`class_name`,`grade`,`status`) VALUES 
 (1,'A','1','1'),
 (2,'B','1','1'),
 (3,'C','1','1'),
 (4,'A','2','1'),
 (5,'B','2','1'),
 (6,'C','2','1'),
 (7,'A','3','1'),
 (8,'B','3','1'),
 (9,'C','3','1'),
 (10,'A','4','1'),
 (11,'B','4','1'),
 (12,'C','4','1'),
 (13,'A','5','1'),
 (14,'B','5','1'),
 (15,'C','5','1'),
 (16,'No','class','0');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;


--
-- Definition of table `gradeupper`
--

DROP TABLE IF EXISTS `gradeupper`;
CREATE TABLE `gradeupper` (
  `idGradeUpper` int(100) NOT NULL AUTO_INCREMENT,
  `last_update` varchar(500) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idGradeUpper`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gradeupper`
--

/*!40000 ALTER TABLE `gradeupper` DISABLE KEYS */;
INSERT INTO `gradeupper` (`idGradeUpper`,`last_update`,`status`) VALUES 
 (1,'2016','1');
/*!40000 ALTER TABLE `gradeupper` ENABLE KEYS */;


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
INSERT INTO `login` (`password`,`email`,`status`,`Teachers_nic`) VALUES 
 ('asela1974','','Admin','741890186V');
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
) ENGINE=InnoDB AUTO_INCREMENT=7702 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

/*!40000 ALTER TABLE `students` DISABLE KEYS */;
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

--
-- Dumping data for table `teachers`
--

/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` (`nic`,`Ser_name`,`middle_name`,`last_name`,`dob`,`gender`,`first_appoint_date`,`school_appoint_date`,`increment_date`,`edu_qualifications`,`proffesional_qualification`,`street`,`city`,`tel`,`spouce_name`,`s_tel`,`s_occupation`,`other_deta`,`Classes_idClasses`,`Travel_mode_idTravel_mode`,`service_grade`,`status`,`teachers_cat_idteachers_cat`) VALUES 
 ('741890186V','K A','Asela','Indika','1974-07-07','Male','1998-02-16','2008-10-07','2016-04-01','Digree','TRAINED','44.OPATHELLA,RUKMALE','VEYANGODA','0710805242','G.K.H.P.RANASINGHE  ','0710866990','ASSISTANT DIRECTOR','SLPS 111',16,5,'2-I','1',3);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;


--
-- Definition of table `teachers_cat`
--

DROP TABLE IF EXISTS `teachers_cat`;
CREATE TABLE `teachers_cat` (
  `idteachers_cat` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`idteachers_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teachers_cat`
--

/*!40000 ALTER TABLE `teachers_cat` DISABLE KEYS */;
INSERT INTO `teachers_cat` (`idteachers_cat`,`cat_name`) VALUES 
 (1,'Deploma'),
 (2,'Digree'),
 (3,'Graduate'),
 (4,'Traning');
/*!40000 ALTER TABLE `teachers_cat` ENABLE KEYS */;


--
-- Definition of table `tleave`
--

DROP TABLE IF EXISTS `tleave`;
CREATE TABLE `tleave` (
  `tid` int(11) NOT NULL,
  `date1` date NOT NULL,
  `type1` varchar(100) DEFAULT NULL,
  `des` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`tid`,`date1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tleave`
--

/*!40000 ALTER TABLE `tleave` DISABLE KEYS */;
/*!40000 ALTER TABLE `tleave` ENABLE KEYS */;


--
-- Definition of table `travel_mode`
--

DROP TABLE IF EXISTS `travel_mode`;
CREATE TABLE `travel_mode` (
  `idTravel_mode` int(11) NOT NULL AUTO_INCREMENT,
  `mode_name` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTravel_mode`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travel_mode`
--

/*!40000 ALTER TABLE `travel_mode` DISABLE KEYS */;
INSERT INTO `travel_mode` (`idTravel_mode`,`mode_name`,`status`) VALUES 
 (1,'Bus','1'),
 (2,'Car','1'),
 (3,'Van','1'),
 (4,'Train','1'),
 (5,'Bike','1'),
 (6,'Foot','1'),
 (7,'Other','1');
/*!40000 ALTER TABLE `travel_mode` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
