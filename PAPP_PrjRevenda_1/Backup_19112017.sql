-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbrevenda
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

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
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro` (
  `id_carro` int(11) NOT NULL AUTO_INCREMENT,
  `id_modelo` int(11) DEFAULT NULL,
  `id_marca` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_carro`),
  KEY `id_modelo` (`id_modelo`),
  KEY `id_marca` (`id_marca`),
  CONSTRAINT `carro_ibfk_1` FOREIGN KEY (`id_modelo`) REFERENCES `modelo` (`id_modelo`),
  CONSTRAINT `carro_ibfk_2` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES (21,3,8),(22,3,1),(23,3,2),(24,2,1),(25,2,2),(27,2,8),(28,7,10);
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Kia'),(2,'Ford'),(8,'Chevrolet'),(10,'Honda');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `id_modelo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_modelo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (2,'MBB'),(3,'Prisma'),(7,'Civic');
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `id_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `nro_pagamento` varchar(10) NOT NULL,
  `data_vencimento` date NOT NULL,
  `data_pagamento` date DEFAULT NULL,
  `multa` decimal(10,2) DEFAULT NULL,
  `valor_liquido` decimal(10,2) DEFAULT NULL,
  `liquidacao` tinyint(4) DEFAULT NULL,
  `id_venda` int(11) NOT NULL,
  PRIMARY KEY (`id_pagamento`),
  KEY `pagamento_ibfk_1` (`id_venda`),
  CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,'1/1','2017-12-16','2017-11-16',NULL,100.00,1,1),(2,'1/2','2018-01-16','2017-11-16',NULL,100.00,1,1),(3,'1/3','2018-02-16','2017-11-16',NULL,100.00,1,1),(4,'1/4','2018-03-16',NULL,NULL,100.00,NULL,1),(5,'1/5','2018-04-16',NULL,NULL,100.00,NULL,1),(6,'1/6','2018-05-16',NULL,NULL,100.00,NULL,1),(7,'1/7','2018-06-16','2017-11-16',NULL,100.00,1,1),(8,'1/8','2018-07-16',NULL,NULL,100.00,NULL,1),(9,'1/9','2018-08-16',NULL,NULL,100.00,NULL,1),(10,'1/10','2018-09-16',NULL,NULL,100.00,NULL,1),(11,'2/1','2017-12-16','2017-11-16',NULL,200.00,1,2),(12,'2/2','2018-01-16',NULL,NULL,200.00,NULL,2),(13,'3/1','2017-12-17',NULL,NULL,2500.00,NULL,3),(14,'3/2','2018-01-17',NULL,NULL,2500.00,NULL,3),(15,'3/3','2018-02-17',NULL,NULL,2500.00,NULL,3),(16,'3/4','2018-03-17',NULL,NULL,2500.00,NULL,3),(17,'3/5','2018-04-17',NULL,NULL,2500.00,NULL,3),(18,'3/6','2018-05-17',NULL,NULL,2500.00,NULL,3),(19,'3/7','2018-06-17',NULL,NULL,2500.00,NULL,3),(20,'3/8','2018-07-17',NULL,NULL,2500.00,NULL,3),(21,'4/1','2017-12-19',NULL,NULL,500.00,NULL,4);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proprietario`
--

DROP TABLE IF EXISTS `proprietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proprietario` (
  `id_proprietario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `pais` varchar(100) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `estado` varchar(100) NOT NULL,
  PRIMARY KEY (`id_proprietario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprietario`
--

LOCK TABLES `proprietario` WRITE;
/*!40000 ALTER TABLE `proprietario` DISABLE KEYS */;
INSERT INTO `proprietario` VALUES (2,'Luis','Austria','30','M. Rondon','Cachoeirinha','Brasil','51 992306745','luis.gomes@tbsa.com','Rio Grande do Sul'),(3,'Zé ruela','Rua dos bobos','sn','Zé ruela','Zé ruela','Brasil','0','0','Acre');
/*!40000 ALTER TABLE `proprietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `nro` int(11) NOT NULL,
  `data_venda` date NOT NULL,
  `ano` int(4) NOT NULL,
  `descricao` varchar(1000) DEFAULT NULL,
  `ar_condicionado` tinyint(4) DEFAULT NULL,
  `toca_fita` tinyint(4) DEFAULT NULL,
  `roda_liga` tinyint(4) DEFAULT NULL,
  `tapete` tinyint(4) DEFAULT NULL,
  `alarme` tinyint(4) DEFAULT NULL,
  `tipo` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `km` int(11) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `numero_parcela` int(11) NOT NULL,
  `id_carro` int(11) DEFAULT NULL,
  `id_proprietario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `id_carro` (`id_carro`),
  KEY `id_proprietario` (`id_proprietario`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`id_carro`) REFERENCES `carro` (`id_carro`),
  CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`id_proprietario`) REFERENCES `proprietario` (`id_proprietario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,1,'2017-11-16',2017,'',0,0,0,0,0,'Utilitario','Novo',0,1000.00,10,27,2),(2,2,'2017-11-16',2010,'',1,1,0,0,0,'Passeio','Novo',0,400.00,2,21,3),(3,3,'2017-11-17',2018,'',0,0,0,0,0,'Passeio','Novo',0,20000.00,8,28,3),(4,4,'2017-11-19',2010,'',1,0,0,0,0,'Utilitario','Usado',1000,500.00,1,21,3);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbrevenda'
--

--
-- Dumping routines for database 'dbrevenda'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-19 20:41:51
