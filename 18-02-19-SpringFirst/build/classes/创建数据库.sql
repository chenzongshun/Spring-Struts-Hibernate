/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.17-log : Database - 18-02-10-hibernatefirst
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`18-02-10-hibernatefirst` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `18-02-10-hibernatefirst`;

/*Table structure for table `cst_customer` */

DROP TABLE IF EXISTS `cst_customer`;

CREATE TABLE `cst_customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_source` varchar(255) DEFAULT NULL,
  `cust_industry` varchar(255) DEFAULT NULL,
  `cust_level` varchar(255) DEFAULT NULL,
  `cust_linkman` varchar(255) DEFAULT NULL,
  `cust_phone` varchar(255) DEFAULT NULL,
  `cust_mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `cst_customer` */

insert  into `cst_customer`(`cust_id`,`cust_name`,`cust_source`,`cust_industry`,`cust_level`,`cust_linkman`,`cust_phone`,`cust_mobile`) values 
(1,'1顺1',NULL,NULL,NULL,NULL,NULL,NULL),
(2,'2',NULL,NULL,NULL,NULL,NULL,NULL),
(3,'3',NULL,NULL,NULL,NULL,NULL,NULL),
(4,'4',NULL,NULL,NULL,NULL,NULL,NULL),
(5,'5',NULL,NULL,NULL,NULL,NULL,NULL),
(6,'6',NULL,NULL,NULL,NULL,NULL,NULL),
(7,'7',NULL,NULL,NULL,NULL,NULL,NULL),
(8,'8',NULL,NULL,NULL,NULL,NULL,NULL),
(9,'9',NULL,NULL,NULL,NULL,NULL,NULL),
(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(11,'','',NULL,'','','',''),
(12,'444444444444','11111111',NULL,'1111111111111111111111','11111111111111','11111111111111111111','111111111'),
(13,'777','7777777777777',NULL,'777777777','77777777','777777777777777777','77777777'),
(14,'888888','8888888888888',NULL,'8888888888','88888888888','88888888888888','888888888888'),
(15,'df否','',NULL,'','','',''),
(16,'否','',NULL,'','','','');

/*Table structure for table `cst_linkman` */

DROP TABLE IF EXISTS `cst_linkman`;

CREATE TABLE `cst_linkman` (
  `lKm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lkm_gender` char(1) DEFAULT NULL,
  `lkm_name` varchar(255) DEFAULT NULL,
  `lkm_phone` varchar(255) DEFAULT NULL,
  `lkm_email` varchar(255) DEFAULT NULL,
  `lkm_qq` varchar(255) DEFAULT NULL,
  `lkm_mobile` varchar(255) DEFAULT NULL,
  `lkm_memo` varchar(255) DEFAULT NULL,
  `lkm_position` varchar(255) DEFAULT NULL,
  `lkm_cust_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`lKm_id`),
  KEY `FKh9yp1nql5227xxcopuxqx2e7q` (`lkm_cust_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `cst_linkman` */

insert  into `cst_linkman`(`lKm_id`,`lkm_gender`,`lkm_name`,`lkm_phone`,`lkm_email`,`lkm_qq`,`lkm_mobile`,`lkm_memo`,`lkm_position`,`lkm_cust_id`) values 
(1,NULL,'顺1',NULL,NULL,NULL,NULL,NULL,NULL,1),
(2,NULL,'顺2',NULL,NULL,NULL,NULL,NULL,NULL,1),
(3,NULL,'顺3',NULL,NULL,NULL,NULL,NULL,NULL,1),
(4,'1','fsd ','fsd ',NULL,NULL,'fsd ',NULL,NULL,1),
(5,'1','的','的',NULL,NULL,'的',NULL,NULL,1),
(6,'1','到','到',NULL,NULL,'到',NULL,NULL,1),
(7,'1','好','好',NULL,NULL,'好',NULL,NULL,1);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_memo`) values 
(1,'保洁',NULL),
(2,'保安',NULL),
(3,'男公关',NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_state` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_code`,`user_name`,`user_password`,`user_state`) values 
(1,'1','u1','1',NULL),
(2,'2','u2','2',NULL);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values 
(1,3),
(2,1),
(2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
