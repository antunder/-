-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db02
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cust`
--

DROP TABLE IF EXISTS `cust`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cust` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(10) NOT NULL COMMENT '客户姓名',
  `address` varchar(20) NOT NULL COMMENT '客户地址',
  `kind` tinyint unsigned NOT NULL COMMENT '客户类型，说明：1 为批发客户，2 为零售客户，3为供货商',
  `gender` tinyint unsigned NOT NULL COMMENT '性别，说明：1 男，2 女',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `phone` varchar(20) NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust`
--

LOCK TABLES `cust` WRITE;
/*!40000 ALTER TABLE `cust` DISABLE KEYS */;
INSERT INTO `cust` VALUES (1,'张三','哈尔滨工业大学（威海）',1,1,'2024-05-08 21:28:50','18972888398');
/*!40000 ALTER TABLE `cust` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `good` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL COMMENT '货品名称',
  `state` tinyint unsigned NOT NULL COMMENT '货品状态, 说明: 1 上架, 2 未上架',
  `decri` varchar(10) NOT NULL COMMENT '货品规格，如：200ml，50g',
  `store_id` tinyint unsigned DEFAULT NULL COMMENT '仓库id',
  `jh_pri` double(10,2) unsigned NOT NULL COMMENT '进货价',
  `pf_pri` double(10,2) unsigned NOT NULL COMMENT '批发价',
  `ls_pri` double(10,2) unsigned NOT NULL COMMENT '零售价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `storage` int unsigned NOT NULL COMMENT '货品库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='货品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` VALUES (1,'可乐',2,'150mL',1,2.00,2.30,3.00,'2024-05-10 16:12:31',100),(2,'可乐',1,'1L',1,6.00,6.40,7.00,'2024-05-10 16:13:10',100),(3,'阿萨姆',2,'200mL',2,3.00,3.20,4.00,'2024-05-10 16:13:43',100),(4,'康师傅红烧牛肉面',1,'200g',1,2.00,2.50,3.00,'2024-05-10 16:14:22',100);
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slip`
--

DROP TABLE IF EXISTS `slip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slip` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `kind` tinyint unsigned NOT NULL COMMENT '开单类型,说明：1为销售单，2为采购入库单',
  `state` tinyint unsigned NOT NULL COMMENT '开单状态, 说明: 1 审核, 2 未审核',
  `store_id` tinyint unsigned NOT NULL COMMENT '仓库id',
  `good_id` tinyint unsigned NOT NULL COMMENT '货品id',
  `cust_id` int unsigned NOT NULL COMMENT '客户id',
  `number` int unsigned NOT NULL COMMENT '货品数量',
  `create_time` date NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='开单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slip`
--

LOCK TABLES `slip` WRITE;
/*!40000 ALTER TABLE `slip` DISABLE KEYS */;
INSERT INTO `slip` VALUES (1,1,2,1,1,1,1,'2024-05-10');
/*!40000 ALTER TABLE `slip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slip_detail`
--

DROP TABLE IF EXISTS `slip_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slip_detail` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `good_id` tinyint unsigned NOT NULL COMMENT '货品id',
  `slip_id` tinyint unsigned NOT NULL COMMENT '开单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='开单细节表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slip_detail`
--

LOCK TABLES `slip_detail` WRITE;
/*!40000 ALTER TABLE `slip_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `slip_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL COMMENT '仓库名称',
  `kind` tinyint unsigned NOT NULL COMMENT '仓库类型，说明：1 为大库，2 为门店',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='仓库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'哈威店',2,'2024-05-08 21:00:57'),(2,'山威店',2,'2024-05-08 21:01:18'),(3,'哈威仓',1,'2024-05-09 21:01:32'),(4,'山威仓',1,'2024-05-08 21:01:49'),(5,'高区仓',1,'2024-05-08 21:02:03'),(6,'环翠仓',1,'2024-05-08 21:02:14'),(7,'山东店',2,'2024-05-10 15:31:25');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(10) NOT NULL COMMENT '用户名',
  `password` varchar(10) NOT NULL DEFAULT '123456' COMMENT '用户密码',
  `name` varchar(10) NOT NULL COMMENT '用户姓名',
  `kind` tinyint unsigned NOT NULL COMMENT '用户类型，说明：1 为经理(全部功能)，2 为店员/采购人员(销售单那个页面)，3为仓库管理员(库存管理页面)',
  `gender` tinyint unsigned NOT NULL COMMENT '性别，说明：1 男，2 女',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lisi','123456','李四',1,1,'2024-05-10 18:51:05');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-11  8:59:49
