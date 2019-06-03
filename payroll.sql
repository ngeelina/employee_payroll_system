/*
SQLyog Enterprise - MySQL GUI v6.15
MySQL - 5.1.36-community-log : Database - payrolldb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `payrolldb`;

USE `payrolldb`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `emp_ID` varchar(10) NOT NULL,
  `date` date NOT NULL,
  `status` tinyint(1) DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `attendance` */

insert  into `attendance`(`emp_ID`,`date`,`status`) values ('2021','2012-09-30',1),('2023','2012-09-25',0),('2021','2012-10-01',1),('2031','2012-10-01',0),('2023','2012-10-01',0),('2023','2012-09-26',0),('2023','2012-09-28',0),('2021','2012-10-02',1),('2023','2012-10-02',0),('2031','2012-10-02',0),('2020','2012-10-02',0),('2022','2012-10-02',0),('2020','2012-09-25',0),('2020','2012-09-26',0),('2020','2012-09-27',0),('2020','2012-09-28',0),('2020','2012-09-29',0),('2020','2012-10-01',0),('2025','2012-09-25',0),('2025','2012-09-26',0),('2025','2012-09-29',0),('2025','2012-10-01',0),('2031','2012-09-25',0),('2031','2012-09-26',0),('2031','2012-09-29',0),('2025','2012-10-02',0);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `dept_no` varchar(10) NOT NULL,
  `dept_name` varchar(30) NOT NULL,
  `status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`dept_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `department` */

insert  into `department`(`dept_no`,`dept_name`,`status`) values ('d1002','Electrical',0),('d1005','Administration',0),('d004','Civil',0),('d1008','Science',0),('d2002','Computer',0);

/*Table structure for table `desig_salary` */

DROP TABLE IF EXISTS `desig_salary`;

CREATE TABLE `desig_salary` (
  `designation` varchar(15) NOT NULL,
  `des_id` int(11) NOT NULL AUTO_INCREMENT,
  `basic_pay` int(11) NOT NULL,
  `DA_allow` int(11) DEFAULT '0',
  `HRA_allow` int(11) DEFAULT '0',
  `TA_allow` int(11) DEFAULT '0',
  `GPF_dedu` int(11) DEFAULT '0',
  `IT_dedu` int(11) DEFAULT '0',
  `GIS_dedu` int(11) DEFAULT '0',
  `Holdings` int(11) DEFAULT '0',
  `LIC_dedu` int(11) DEFAULT '0',
  `status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`des_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3014 DEFAULT CHARSET=latin1;

/*Data for the table `desig_salary` */

insert  into `desig_salary`(`designation`,`des_id`,`basic_pay`,`DA_allow`,`HRA_allow`,`TA_allow`,`GPF_dedu`,`IT_dedu`,`GIS_dedu`,`Holdings`,`LIC_dedu`,`status`) values ('Lab Assistant',3006,15000,5,5,0,0,0,0,10,0,0),('Junior lecturer',3005,15000,0,0,0,0,0,0,0,0,0),('senior lecturer',3004,35000,0,0,5,0,0,0,5,0,0),('Manager',3012,20000,10,11,0,10,0,0,0,0,0),('HOD',3013,45000,0,5,0,0,5,0,0,0,0);

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `emp_bar` varchar(10) NOT NULL,
  `emp_ID` int(11) NOT NULL,
  `first_name` varchar(15) NOT NULL,
  `middle_name` varchar(15) DEFAULT ' ',
  `last_name` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `hire_date` date NOT NULL,
  `dept_name` varchar(30) NOT NULL,
  `designation` varchar(15) NOT NULL,
  `city` varchar(20) NOT NULL,
  `phone_no` int(15) NOT NULL,
  `email_ID` varchar(30) NOT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`emp_bar`),
  FULLTEXT KEY `last_name` (`last_name`),
  FULLTEXT KEY `middle_name` (`middle_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employees` */

insert  into `employees`(`emp_bar`,`emp_ID`,`first_name`,`middle_name`,`last_name`,`dob`,`hire_date`,`dept_name`,`designation`,`city`,`phone_no`,`email_ID`,`status`) values ('kec2021s',2021,'Dharma',' Raj','Gurung','1990-09-03','1990-06-17','Administration','senior lecturer','Lalitpur',5554929,'best_world2009@live.com\r ',0),('kec2031s',2031,'Samir\r\n',' ','Shrestha\r\n','1990-09-03','2010-05-15','Administration','Manager','Kathmandu\r\n',5554929,'best_world2009@live.com\r\n',0),('kec2022s',2022,'Angeelina','','RajKarnikar','1990-01-01','2012-08-12','Computer','HOD','Lalipur',5555555,'ssssssssss',0),('kec2020s',2020,'Jyoshna','','Joshi','1990-06-27','2012-09-15','Computer','senior lecturer','Lalitpur',55555555,'asdfdsfsadfadsf',0),('kec2025s',2025,'Sanam','','Maharjan','1990-01-01','2012-09-14','Administration','Manager','Lalitpur',5555555,'55555dddd',0);

/*Table structure for table `logdetails` */

DROP TABLE IF EXISTS `logdetails`;

CREATE TABLE `logdetails` (
  `username` varchar(10) NOT NULL,
  `login` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `logout` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `logdetails` */

insert  into `logdetails`(`username`,`login`,`logout`) values ('admin','2012-07-18 01:43:31','2012-07-18 01:43:44'),('user','2012-07-18 02:22:53','2012-07-18 02:22:59'),('admin','2012-07-18 17:54:16','2012-07-18 17:54:21'),('user','2012-07-18 17:54:35','2012-07-18 17:54:38'),('admin','2012-07-21 13:22:23','2012-07-21 13:24:21'),('admin','2012-07-21 13:24:26','2012-07-21 13:24:48'),('admin','2012-07-21 13:28:14','2012-07-21 13:28:32'),('admin','2012-07-21 13:29:23','2012-07-21 13:29:37'),('admin','2012-07-21 13:35:05','2012-07-21 13:35:09'),('user','2012-07-21 13:35:15','2012-07-21 13:43:19'),('admin','2012-07-21 13:52:30','2012-07-21 13:53:19'),('admin','2012-07-21 13:53:39','2012-07-21 13:54:14'),('admin','2012-07-21 13:54:21','2012-07-21 13:54:26'),('user','2012-07-21 14:43:03','2012-07-21 14:47:27'),('admin','2012-07-21 14:47:00','2012-07-21 14:47:27'),('admin','2012-07-21 15:21:50','2012-07-21 15:24:43'),('user','2012-07-21 15:24:35','2012-07-21 15:24:43'),('admin','2012-07-21 15:24:52','2012-07-21 15:34:42'),('admin','2012-07-21 15:33:41','2012-07-21 15:34:42'),('admin','2012-07-21 15:37:15','2012-07-21 15:38:04'),('user','2012-07-21 15:38:14','2012-07-21 15:38:16'),('admin','2012-07-21 15:38:20','2012-07-21 15:38:52'),('user','2012-07-21 15:39:04','2012-07-21 15:45:41'),('user','2012-07-21 15:45:52','2012-07-21 15:45:55'),('admin','2012-07-21 15:45:59','2012-07-21 15:46:01'),('admin','2012-07-21 15:46:08','2012-07-21 15:46:10'),('admin','2012-07-21 15:46:14','2012-07-21 15:46:27'),('admin','2012-07-21 15:46:31','2012-07-21 15:46:33'),('admin','2012-07-21 15:46:42','2012-07-21 15:46:44'),('user','2012-07-21 15:46:52','2012-07-21 15:47:42'),('admin','2012-07-21 15:48:58','2012-07-21 15:49:17'),('admin','2012-07-21 15:50:08','2012-07-21 15:50:35'),('user','2012-07-21 15:52:05','2012-07-21 15:52:10'),('admin','2012-07-21 15:52:55','2012-07-21 15:53:14'),('admin','2012-07-21 15:54:45','2012-07-21 15:54:51'),('admin','2012-07-21 15:59:59','2012-07-21 16:00:24'),('admin','2012-07-21 16:01:27','2012-07-21 16:01:37'),('user','2012-07-21 16:05:14','2012-07-21 16:05:19'),('admin','2012-07-21 16:19:07','2012-07-21 16:19:37'),('admin','2012-07-21 16:21:02','2012-07-21 16:21:57'),('admin','2012-07-21 16:22:27','2012-07-21 16:23:40'),('user','2012-07-21 16:23:53','2012-07-21 16:24:04'),('user','2012-07-21 16:50:42','2012-07-21 16:50:55'),('user','2012-07-21 16:54:18','2012-07-21 16:54:27'),('admin','2012-07-21 19:06:09','2012-07-21 19:06:17'),('user','2012-07-21 19:06:28','2012-07-21 19:06:47'),('user','2012-07-21 19:07:11','2012-07-21 19:07:33'),('user','2012-07-21 19:12:53','2012-07-21 19:13:04'),('user','2012-07-21 19:16:13','2012-07-21 19:16:21'),('user','2012-07-21 19:17:14','2012-07-21 19:18:03'),('admin','2012-07-21 19:18:11','2012-07-21 19:21:27'),('admin','2012-07-21 19:24:55','2012-07-21 19:25:57'),('admin','2012-07-21 20:11:27','2012-07-21 20:15:20'),('user','2012-07-21 20:19:03','2012-07-21 20:20:24'),('admin','2012-07-21 20:29:29','2012-07-21 20:30:06'),('admin','2012-07-21 20:43:54','2012-07-21 20:44:17'),('admin','2012-07-21 20:45:58','2012-07-21 20:46:09'),('admin','2012-07-21 20:46:48','2012-07-21 20:46:50'),('admin','2012-07-21 23:21:31','2012-07-21 23:37:36'),('admin','2012-07-22 06:55:59','2012-07-22 06:56:12'),('admin','2012-07-22 08:06:47','2012-07-22 08:07:08'),('user','2012-07-22 08:10:37','2012-07-22 08:10:43'),('user','2012-07-22 08:10:52','2012-07-22 08:11:36'),('user','2012-07-22 08:42:11','2012-07-22 08:42:21'),('admin','2012-07-22 08:42:26','2012-07-22 08:42:41'),('admin','2012-07-22 08:47:48','2012-07-22 08:48:00'),('user','2012-07-22 08:49:39','2012-07-22 08:49:47'),('admin','2012-07-22 11:22:59','2012-07-22 14:15:33'),('admin','2012-07-22 11:25:41','2012-07-22 14:15:33'),('admin','2012-07-22 11:27:42','2012-07-22 14:15:33'),('admin','2012-07-22 11:29:06','2012-07-22 14:15:33'),('admin','2012-07-22 11:33:52','2012-07-22 14:15:33'),('admin','2012-07-22 14:15:22','2012-07-22 14:15:33'),('admin','2012-07-22 14:25:17','2012-07-22 14:25:45'),('admin','2012-07-22 14:36:03','2012-07-22 14:36:28'),('admin','2012-07-22 14:36:38','2012-07-22 14:36:44'),('admin','2012-07-22 14:37:09','2012-07-22 14:37:47'),('admin','2012-07-22 14:46:09','2012-07-22 14:46:19'),('admin','2012-07-22 14:47:58','2012-07-22 14:48:02'),('admin','2012-07-22 14:51:57','2012-07-22 14:52:15'),('admin','2012-07-22 17:25:39','2012-07-22 17:26:35'),('admin','2012-07-22 19:30:52','2012-07-22 19:34:19'),('admin','2012-07-22 19:33:57','2012-07-22 19:34:19'),('admin','2012-07-22 19:37:12','2012-07-22 19:37:39'),('admin','2012-07-22 19:39:06','2012-07-22 19:40:21'),('admin','2012-07-22 19:40:40','2012-07-22 19:41:06'),('admin','2012-07-22 19:41:16','2012-07-22 19:41:25'),('admin','2012-07-23 02:49:09','2012-07-23 02:51:05'),('admin','2012-07-23 05:25:44','2012-07-23 05:26:32'),('admin','2012-07-23 05:28:06','2012-07-23 05:28:15'),('admin','2012-07-24 12:46:55','2012-07-24 12:46:58'),('admin','2012-07-24 13:13:37','2012-07-24 13:14:01'),('admin','2012-07-24 13:14:06','2012-07-24 13:14:54'),('admin','2012-09-24 20:36:58','2012-09-25 05:35:49'),('admin','2012-09-24 20:37:06','2012-09-25 05:35:49'),('admin','2012-09-25 05:35:23','2012-09-25 05:35:49'),('admin','2012-09-25 14:19:20','2012-09-25 14:19:50'),('admin','2012-09-25 11:25:54','2012-09-25 11:26:47'),('admin','2012-09-25 06:03:09','2012-09-25 06:03:59'),('admin','2012-09-25 06:03:00','2012-09-25 06:03:03'),('admin','2012-09-25 14:28:48','2012-09-25 14:29:12'),('admin','2012-09-25 14:32:38','2012-09-25 14:32:51'),('admin','2012-09-25 14:37:48','2012-09-25 14:37:59'),('admin','2012-09-25 14:39:33','2012-09-25 14:39:41'),('admin','2012-09-25 14:41:17','2012-09-25 14:41:25'),('admin','2012-09-25 15:21:53','2012-09-25 15:20:51'),('admin','2012-09-25 15:53:22','2012-09-25 15:53:36'),('admin','2012-09-27 09:38:30','2012-09-27 09:39:35'),('admin','2012-09-27 09:56:19','2012-09-27 11:38:09'),('admin','2012-09-27 11:37:16','2012-09-27 11:38:09'),('admin','2012-09-27 11:41:46','2012-09-27 11:42:30'),('admin','2012-09-27 12:02:19','2012-09-27 12:04:05'),('admin','2012-09-27 12:21:29','2012-09-27 12:23:00'),('admin','2012-09-27 12:23:53','2012-09-27 12:24:35'),('admin','2012-09-27 12:31:01','2012-09-27 12:31:30'),('admin','2012-09-27 12:33:22','2012-09-27 12:33:48'),('admin','2012-09-27 12:41:20','2012-09-27 12:42:01'),('admin','2012-09-27 13:33:19','2012-09-27 13:36:12'),('admin','2012-09-27 13:37:10','2012-09-27 13:37:32'),('admin','2012-09-27 13:40:10','2012-09-27 13:40:33'),('admin','2012-09-27 13:42:23','2012-09-27 13:43:23'),('admin','2012-09-27 14:37:24','2012-09-27 14:46:23'),('admin','2012-09-27 14:41:40','2012-09-27 14:46:23'),('admin','2012-09-27 15:18:21','2012-09-27 15:18:35'),('admin','2012-09-27 15:25:16','2012-09-27 15:25:52'),('user','2012-09-30 02:09:26','2012-09-30 02:09:49'),('user','2012-09-30 02:35:26','2012-09-30 02:37:36'),('user','2012-09-30 02:40:08','2012-09-30 02:42:13'),('user','2012-09-30 02:42:41','2012-09-30 02:44:01'),('user','2012-09-30 02:47:25','2012-09-30 02:47:57'),('user','2012-09-30 02:51:25','2012-09-30 02:51:47'),('user','2012-09-30 02:52:15','2012-09-30 02:52:39'),('user','2012-09-30 02:58:58','2012-09-30 02:59:38'),('user','2012-09-30 09:05:39','2012-09-30 09:08:09'),('user','2012-09-30 09:08:48','2012-09-30 09:09:30'),('user','2012-09-30 09:13:00','2012-09-30 09:13:35'),('user','2012-09-30 09:18:00','2012-09-30 09:18:28'),('user','2012-09-30 19:56:27','2012-09-30 19:58:54'),('user','2012-10-01 01:07:00','2012-10-01 01:07:51'),('user','2012-10-01 01:16:28','2012-10-01 01:18:27'),('user','2012-10-01 01:25:38','2012-10-01 01:26:18'),('user','2012-10-01 01:29:22','2012-10-01 01:30:12'),('user','2012-10-01 01:49:00','2012-10-01 01:49:40'),('user','2012-10-01 02:30:15','2012-10-01 02:30:30'),('user','2012-10-01 02:33:02','2012-10-01 02:42:40'),('user','2012-10-01 02:46:25','2012-10-01 02:46:56'),('user','2012-10-01 02:47:32','2012-10-01 02:47:55'),('user','2012-10-01 02:50:17','2012-10-01 02:50:41'),('user','2012-10-01 02:51:48','2012-10-01 02:54:08'),('user','2012-10-01 20:28:37','2012-10-01 20:31:42'),('user','2012-10-01 20:30:47','2012-10-01 20:31:42'),('user','2012-10-01 20:47:14','2012-10-01 20:49:51'),('user','2012-10-01 20:56:07','2012-10-01 20:57:03'),('user','2012-10-01 20:57:19','2012-10-01 20:57:47'),('user','2012-10-01 20:58:09','2012-10-01 20:59:03'),('user','2012-10-01 21:01:17','2012-10-01 21:02:05'),('user','2012-10-01 21:03:19','2012-10-01 21:03:32'),('user','2012-10-01 21:06:19','2012-10-01 21:08:16'),('user','2012-10-01 21:08:37','2012-10-01 21:16:50'),('user','2012-10-01 21:10:44','2012-10-01 21:16:50'),('user','2012-10-01 21:18:56','2012-10-01 21:19:45'),('user','2012-10-01 22:53:32','2012-10-01 23:04:49'),('user','2012-10-01 23:17:27','2012-10-01 23:22:10'),('user','2012-10-01 23:22:59','2012-10-01 23:24:03'),('user','2012-10-01 23:24:31','2012-10-01 23:24:47'),('user','2012-10-01 23:32:34','2012-10-01 23:35:57'),('user','2012-10-01 23:36:05','2012-10-01 23:36:35'),('user','2012-10-01 23:36:46','2012-10-01 23:37:09'),('user','2012-10-01 23:38:29','2012-10-01 23:38:57'),('user','2012-10-01 23:40:27','2012-10-01 23:40:39'),('user','2012-10-01 23:41:58','2012-10-01 23:42:09'),('user','2012-10-01 23:43:21','2012-10-01 23:43:53'),('user','2012-10-01 23:46:21','2012-10-01 23:46:38'),('user','2012-10-01 23:47:52','2012-10-01 23:48:05'),('user','2012-10-01 23:49:55','2012-10-01 23:50:01'),('admin','2012-10-01 23:50:09','2012-10-02 00:13:46'),('user','2012-10-02 00:13:14','2012-10-02 00:13:46'),('user','2012-10-02 00:14:26','2012-10-02 00:14:58'),('user','2012-10-02 00:17:31','2012-10-02 00:18:19'),('admin','2012-10-02 00:31:03','2012-10-02 00:32:39'),('admin','2012-10-02 00:32:50','2012-10-02 00:33:39'),('admin','2012-10-02 00:53:08','2012-10-02 00:53:21'),('user','2012-10-02 00:53:28','2012-10-02 00:54:54'),('admin','2012-10-02 00:54:59','2012-10-02 00:58:09'),('admin','2012-10-02 01:06:50','2012-10-02 01:08:54'),('user','2012-10-02 01:18:32','2012-10-02 01:19:29'),('user','2012-10-02 01:20:31','2012-10-02 01:20:40'),('admin','2012-10-02 01:32:19','2012-10-02 01:34:26'),('admin','2012-10-02 01:34:32','2012-10-02 01:39:37'),('admin','2012-10-02 01:39:43','2012-10-02 01:41:21'),('admin','2012-10-02 01:48:52','2012-10-02 01:49:59'),('user','2012-10-02 01:50:07','2012-10-02 01:50:30'),('user','2012-10-02 02:19:17','2012-10-02 02:21:50'),('user','2012-10-02 02:23:54','2012-10-02 02:24:15'),('user','2012-10-02 02:26:20','2012-10-02 02:26:54'),('user','2012-10-02 02:29:30','2012-10-02 02:30:58'),('user','2012-10-02 02:47:40','2012-10-02 02:48:26'),('admin','2012-10-02 08:14:31','2012-10-02 08:24:24'),('user','2012-10-02 08:24:38','2012-10-02 08:25:23'),('admin','2012-10-02 09:45:15','2012-10-02 09:52:08'),('user','2012-10-02 09:52:21','2012-10-02 09:54:36'),('admin','2012-10-02 09:54:46','2012-10-02 09:57:19'),('user','2012-10-02 09:57:27','2012-10-02 09:58:52'),('admin','2012-10-02 10:25:24','2012-10-02 10:25:51'),('admin','2012-10-02 10:36:13','2012-10-02 10:36:56'),('admin','2012-10-02 10:37:57','2012-10-02 10:41:54'),('admin','2012-10-02 10:43:21','2012-10-02 10:54:58'),('user','2012-10-02 10:55:06','2012-10-02 10:57:47'),('user','2012-10-02 11:00:31','2012-10-02 11:02:51'),('user','2012-10-02 11:06:30','2012-10-02 11:07:38'),('admin','2012-10-02 11:24:10','2012-10-02 11:25:26'),('admin','2012-10-02 11:29:28','2012-10-02 11:30:00'),('admin','2012-10-02 11:36:05','2012-10-02 11:37:22'),('admin','2012-10-02 11:37:28','2012-10-02 11:37:41'),('admin','2012-10-02 11:39:44','2012-10-02 11:39:52'),('admin','2012-10-02 11:42:22','2012-10-02 11:44:18'),('user','2012-10-02 11:44:26','2012-10-02 11:44:41'),('user','2012-10-02 12:00:43','2012-10-02 12:04:13'),('admin','2012-10-02 12:04:25',NULL);

/*Table structure for table `logsdetails` */

DROP TABLE IF EXISTS `logsdetails`;

/*!50001 DROP VIEW IF EXISTS `logsdetails` */;
/*!50001 DROP TABLE IF EXISTS `logsdetails` */;

/*!50001 CREATE TABLE `logsdetails` (
  `username` varchar(15) NOT NULL,
  `Fullname` varchar(47) DEFAULT NULL,
  `login` timestamp NULL DEFAULT NULL,
  `logout` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 */;

/*Table structure for table `salary` */

DROP TABLE IF EXISTS `salary`;

CREATE TABLE `salary` (
  `emp_ID` varchar(10) NOT NULL,
  `sal_from` date NOT NULL COMMENT 'Salary from',
  `sal_to` date NOT NULL COMMENT 'salary till',
  `sal_date` date NOT NULL COMMENT 'salary taken date',
  `holding_amt` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `salary` */

insert  into `salary`(`emp_ID`,`sal_from`,`sal_to`,`sal_date`,`holding_amt`) values ('2021','2012-09-30','2012-10-02','2012-10-02',5);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(15) NOT NULL,
  `type` varchar(10) NOT NULL,
  `password` varchar(15) NOT NULL,
  `emp_ID` varchar(10) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`username`,`type`,`password`,`emp_ID`) values ('admin','Admin','strict','2021'),('user','User','record','2031');

/*View structure for view logsdetails */

/*!50001 DROP TABLE IF EXISTS `logsdetails` */;
/*!50001 DROP VIEW IF EXISTS `logsdetails` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `logsdetails` AS select `users`.`username` AS `username`,concat(`employees`.`first_name`,_latin1' ',`employees`.`middle_name`,_latin1' ',`employees`.`last_name`) AS `Fullname`,`logdetails`.`login` AS `login`,`logdetails`.`logout` AS `logout` from (`employees` join (`users` join `logdetails` on((`users`.`username` = `logdetails`.`username`))) on((`employees`.`emp_ID` = `users`.`emp_ID`))) where (`logdetails`.`logout` is not null) order by `logdetails`.`logout` desc */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;