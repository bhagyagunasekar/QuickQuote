create database quickquote;

use quickquote;

GRANT ALL PRIVILEGES ON *.* TO qquser@'%' IDENTIFIED BY 'password' WITH GRANT OPTION;


--
-- Table structure for table `ActionType`
--

DROP TABLE IF EXISTS `ActionType`;
CREATE TABLE `ActionType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ActionType`
--

LOCK TABLES `ActionType` WRITE;
INSERT INTO `ActionType` VALUES (1,'Create Quote'),(2,'Modify Quote'),(3,'View Quote'),(4,'Copy Quote'),(5,'Update Status');
UNLOCK TABLES;

--
-- Table structure for table `InsuranceType`
--

DROP TABLE IF EXISTS `InsuranceType`;
CREATE TABLE `InsuranceType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InsuranceType`
--

LOCK TABLES `InsuranceType` WRITE;
INSERT INTO `InsuranceType` VALUES (1,'Auto'),(2,'Home');
UNLOCK TABLES;

