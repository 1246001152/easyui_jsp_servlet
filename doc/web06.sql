/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.23-log : Database - web06
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`web06` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `web06`;

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `biz` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`id`,`name`,`biz`) values (4,'14化学4','14化学本科'),(5,'15体育5','15体育本科'),(6,'16人事6','16人事本科'),(7,'14计本7','14计算机本科'),(11,'12','12'),(12,'111','222'),(13,'123','123'),(14,'你好','123'),(15,'123','123'),(16,'111','1111'),(17,'你好','123'),(18,'123','123'),(19,'你好','111'),(20,'123','123'),(21,'123','1233'),(22,'你好33','1233311'),(23,'1','233');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `ourl` varchar(1000) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `open` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`id`,`name`,`pid`,`ourl`,`level`,`open`) values (1,'综合管理系统',0,NULL,0,1),(2,'学生管理',1,NULL,1,0),(3,'班级管理',1,NULL,1,0),(4,'学生添加',2,'http://www.baidu.com',2,0),(5,'学生修改',2,'http://www.163.com',2,0),(6,'学生删除',2,'http://www.qq.com',2,0),(7,'学生查找',2,'http://www.sina.com',2,0),(8,'班级查找',3,'http://www.qq.com',2,0),(9,'班级添加',3,'http://www.qq.com',2,0),(10,'班级修改',3,'http://www.qq.com',2,0);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(20) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `ssex` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(1000) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `score` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`sno`,`sname`,`ssex`,`birthday`,`email`,`gid`,`score`) values (1,'080606111','张三1','男','1989-11-03','31321@qq.com',1,50.00),(4,'0806061102','张三5','男','2018-08-29','31321@qq.com',2,77.00),(5,'0806061103','张三2','男','1989-11-03','31321@qq.com',1,20.00),(6,'0806061104','张三3','男','1989-11-03','31321@qq.com',1,78.00),(7,'0806061105','李四4','女','1989-11-03','31321@qq.com',1,110.00),(10,'0806061108','李四6','女','1989-11-03','31321@qq.com',2,55.00),(18,'080606110','张三7','女','1989-11-03','31321@qq.com',3,80.00),(19,'0806061106','李四8','男','1989-11-03','31321@qq.com',3,77.00),(20,'080606110','张9','女','1989-11-03','31321@qq.com',3,88.00),(21,'0806061106','李四11','男','1989-11-03','31321@qq.com',4,99.00),(22,'080606110','张三22','女','1989-11-03','31321@qq.com',4,44.00),(23,'080606110','张三33','男','1989-11-03','31321@qq.com',4,76.00),(24,'080606110','李四44','男','1989-11-03','31321@qq.com',4,76.00),(25,'080606110','张三55','男','1989-11-03','31321@qq.com',4,76.00),(26,'080606110','张三66','男','1989-11-03','31321@qq.com',4,76.00),(27,'080606110','张三77','男','1989-11-03','31321@qq.com',4,76.00),(28,'080606110','张三88','男','1989-11-03','31321@qq.com',4,4.00),(29,'080606110','张三99','男','1989-11-03','31321@qq.com',4,55.00),(30,'080606110','张三00','男','1989-11-03','31321@qq.com',4,44.00),(31,'080606110','张三12','男','1989-11-03','31321@qq.com',4,55.00),(32,'080606110','张三13','男','1989-11-03','31321@qq.com',4,55.00),(33,'080606110','张三14','男','1989-11-03','31321@qq.com',4,75.00);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(1000) DEFAULT 'moren.jpg',
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`username`,`password`,`email`,`phone`) values (1,'猪猪侠','pig123','pig123','f252d5d488f64fc1bec048430ba00498_xiaohu.jpg','15600008888'),(2,'小猴子','houzi123','houzi123','9d4a46f9f1f445a0924ad7cb31941445_huhu.jpg','13234567890'),(3,'老沙','aaa111','aaa111','02667fbbdc35462b8dc337b02504e32a_moren.jpg',NULL);

/* Procedure structure for procedure `selectName` */

/*!50003 DROP PROCEDURE IF EXISTS  `selectName` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `selectName`(
	in gname varchar(20)
    )
BEGIN
	select * from grade where name = gname; 
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
