/*
SQLyog Ultimate v10.51 
MySQL - 5.1.73-community : Database - bbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bbs`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `userpwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`userpwd`) values (1,'admin','123456'),(2,'tom','123456'),(3,'jack','123456');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `hit` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`id`,`username`,`content`,`createtime`,`ip`,`hit`) values (1,'tom','你好','2016-02-09 13:14:33','127.0.0.1',49),(2,'jack','这是测试评论','2016-02-01 13:42:05','192.168.1.100',0),(3,'rose','这是测试评论2','2016-02-01 13:42:33','192.168.100.200',0),(5,'jack2','这是测试评论2','2016-02-01 13:44:17','192.168.100.200',0),(6,'jack3','这是测试评论3','2016-02-01 13:44:17','192.168.100.200',0),(7,'jack4','这是测试评论4','2016-02-01 13:44:17','192.168.100.200',0),(8,'jack5','这是测试评论5','2016-02-01 13:44:17','192.168.100.200',0),(9,'jack6','这是测试评论6','2016-02-01 13:44:17','192.168.100.200',0),(10,'jack7','这是测试评论7','2016-02-01 13:44:17','192.168.100.200',0),(11,'jack8','这是测试评论8','2016-02-01 13:44:17','192.168.100.200',2),(12,'12231','32(⊙o⊙)…32432','2016-02-01 13:44:18','192.168.100.200',0),(13,'jack10','这是测试评论10','2016-02-01 13:44:18','192.168.100.200',0),(14,'jack11','这是测试评论11','2016-02-01 13:44:18','192.168.100.200',0),(15,'jack12','这是测试评论12','2016-02-01 13:44:18','192.168.100.200',0),(16,'jack13','这是测试评论13','2016-02-01 13:44:18','192.168.100.200',0),(17,'jack14','这是测试评论14','2016-02-01 13:44:18','192.168.100.200',0),(18,'jack15','这是测试评论15','2016-02-01 13:44:18','192.168.100.200',0),(19,'jack16','这是测试评论16','2016-02-01 13:44:18','192.168.100.200',0),(20,'jack17','这是测试评论17','2016-02-01 13:44:18','192.168.100.200',0),(21,'jack18','这是测试评论18','2016-02-01 13:44:18','192.168.100.200',0),(22,'jack19','这是测试评论19','2016-02-01 13:44:18','192.168.100.200',0),(23,'jack20','这是测试评论20','2016-02-01 13:44:19','192.168.100.200',0),(24,'王二小111','今天有雨夹雪！！1111','2016-11-07 13:16:35','0:0:0:0:0:0:0:1',0),(88,'建军节','和环境很好','2016-11-07 15:02:59','0:0:0:0:0:0:0:1',0),(89,'hhh','hhhh','2016-11-07 15:03:50','0:0:0:0:0:0:0:1',1),(90,'于依依','于依依','2016-11-07 15:05:28','0:0:0:0:0:0:0:1',0),(92,'ds2','sd','2016-11-07 15:08:32','192.168.1.58',0),(93,'嘎嘎嘎','嘎嘎嘎','2016-11-07 15:20:05','192.168.1.28',0),(94,'测试修改','修改成功！！！！','2016-11-07 16:06:05','192.168.1.37',0),(102,'aaa','aaa','2016-11-08 11:24:05','0:0:0:0:0:0:0:1',2),(103,'111','1111','2016-11-08 13:42:19','0:0:0:0:0:0:0:1',0),(104,'222','222','2016-11-08 13:42:37','0:0:0:0:0:0:0:1',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
