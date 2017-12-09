-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sampledb
-- ------------------------------------------------------
-- Server version	5.6.38-log

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
-- Table structure for table `dbnutrient`
--

DROP TABLE IF EXISTS `dbnutrient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbnutrient` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `kcal` int(11) NOT NULL,
  `nut1` double NOT NULL,
  `nut2` double NOT NULL,
  `nut3` double NOT NULL,
  `nut4` double NOT NULL,
  `nut5` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbnutrient`
--

LOCK TABLES `dbnutrient` WRITE;
/*!40000 ALTER TABLE `dbnutrient` DISABLE KEYS */;
INSERT INTO `dbnutrient` VALUES ('01','쌀밥',310,67.3,5.6,0.9,0,4),('02','현미밥',321,68.9,6.3,1.5,0,5),('03','우유',122,11.5,8,4.9,12.6,100),('04','군고구마',124,29.3,1.5,0.2,6.6,15),('05','아메리카노',4,0.1,0.3,0.4,0,30),('06','닭가슴살',109,0,23,1.2,0,65),('07','아몬드',7,0.2,0.3,0.6,0.1,0),('08','떡볶이',280,60,7,3,7,250),('09','삼겹살',348,8,15.8,26.4,0,44),('10','방울토마토',2,0.4,0.1,0,0.1,8),('11','두부',88,0.8,7.6,5.9,0.4,4),('12','귤',39,10,0.5,0.1,8.4,1),('13','김밥',318,57.6,7.3,6.5,0.5,833),('14','단감',70,18.5,0.4,0.2,0,3),('15','딸기',36,8.9,0.8,0.2,4.7,13),('16','돼지고기 수육',449,4,52.3,22.8,2.5,808),('17','돼지고기김치찌개',128,6.3,8.1,8,1.7,477),('18','김',9,1.3,1.5,0.1,0.1,12),('19','탕수육',197,21.6,9,8,7.1,149),('20','모카골드 커피믹스',50,9,0,1.7,6,3),('21','코카콜라',96,24,0,0,23,13),('22','흑미밥',293,66,5,1,0,5),('23','사과',130,34.5,0.6,0.4,25.9,2),('24','양상추',11,2.3,0.9,0.1,1,15),('25','삶은 밤고구마',128,30.2,1.3,0.2,3.1,18),('26','홍시',66,17.5,0.6,0.2,11.8,1),('27','쇠고기등심',436,0,45.4,28.3,0,182),('28','김치볶음밥',446,75.1,8.8,12.4,2.5,844),('29','상추',18,3.5,1.2,0.3,0.1,2),('30','공기밥',310,67.3,5.6,0.9,0,4),('31','깍두기',14,2.6,0.6,0.2,1,125),('32','소주',60,0,0,0,0,0),('33','돈까스',568,24.6,45.2,30.6,2.2,901),('34','바나나',93,25.9,1.2,0.2,24.1,2),('35','양배추',24,5.6,1.4,0.1,3.6,18),('36','미역국',83,5.6,7.9,3.7,0.6,1134),('37','맥주',74,6.2,0.8,0,0,6),('38','돼지고기 삼겹살',661,1.2,34.5,56.4,0,1924),('39','식빵',111,20,4,2,1.6,80),('40','계란말이',112,14.3,22.1,14.3,0.6,127),('41','치킨(중간크기/뼈제거)',249,8.6,19.2,14.9,0.2,260),('42','계란찜',212,3.1,15.1,15.2,1.4,392),('43','양파',24,5.9,0.7,0,0,1),('44','대추방울토마토',2,0.4,0.1,0,0,0),('45','배추김치',25,4.4,1.4,0.2,0.4,232),('46','토마토(중간크기)',14,4.5,0.9,0,2.9,5),('47','찐고구마',130,31.3,1.5,0.2,7.1,2),('48','삶은 계란',77,0.6,6.3,5.3,0.6,139),('49','계란후라이',89,0.4,6.2,6.8,0.4,238),('50','잡곡밥',340,73.5,8.8,2,0.1,273);
/*!40000 ALTER TABLE `dbnutrient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-04  0:25:03
