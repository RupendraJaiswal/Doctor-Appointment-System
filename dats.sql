-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: dats
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctordetails`
--

DROP TABLE IF EXISTS `doctordetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctordetails` (
  `DoctorId` varchar(45) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `MiddleName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Address` varchar(60) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `PhoneNumber` varchar(13) NOT NULL,
  `Days` varchar(45) NOT NULL,
  `Timing` varchar(45) NOT NULL,
  `Qualification` varchar(45) NOT NULL,
  `Field` varchar(100) NOT NULL,
  `Experience` varchar(45) NOT NULL,
  PRIMARY KEY (`DoctorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctordetails`
--

LOCK TABLES `doctordetails` WRITE;
/*!40000 ALTER TABLE `doctordetails` DISABLE KEYS */;
INSERT INTO `doctordetails` VALUES ('DI101','Abhishek','','Mishra','Anand Vihar, New Delhi','abhishek123@gmail.com','Male','9565239865','Monday,Tuesday,Thursday,Saturday,','02:00 to 04:00','MBBS','Neurology','5 years'),('DI102','Ashok','','Solanki','Vikas Nagar, Lucknow','ashok157@gmail.com','Male','6332566698','Sunday,Wednesday,Friday,Saturday,','03:00 to 09:00','BDS, BUMS,MBBS,MD','Family Medicine','21 years'),('DI103','Ramesh','Kumar','Mishra','35A, PAC colony, Lucknow','ram178@gmail.com','Male','9852145226','Monday,Tuesday,Friday,Saturday,','09:00 to 12:00pm','MBBS, Medicines','General Medicines','8 years'),('DI104','Santi','Devi','','Lalbagh','sant15737@gmail.com','Female','6212563633','Sunday,Wednesday,Thursday,','03:00 to 09:30','BHMS, MD','Medicines','5 years'),('DI105','Sunita','','Mishra','Daliganj, Lucknowsun16u48','sun173@gmail.com','Female','2596963686','Monday,Tuesday,Friday,','08:00 to 03:00','Cardiologist','Cardiology','8 years'),('DI106','Dinesh','','Singh','Lucknow','sskk@gmail.com','Male','9635865325','Sunday,Tuesday,Wednesday,Thursday,','01:00pm to 05:00pm','MBBs,Md','Medicines','5 years');
/*!40000 ALTER TABLE `doctordetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_appointment`
--

DROP TABLE IF EXISTS `patient_appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_appointment` (
  `AppointmentId` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `AppointmentDate` date NOT NULL,
  `AppointmentNo` varchar(45) NOT NULL,
  `DoctorId` varchar(45) NOT NULL,
  `PatientName` varchar(45) NOT NULL,
  `Age` varchar(3) NOT NULL,
  `Problem` varchar(255) NOT NULL,
  `AppointmentMode` varchar(20) NOT NULL,
  `PatientVisit` varchar(6) NOT NULL,
  `Phone` varchar(13) NOT NULL,
  PRIMARY KEY (`AppointmentId`,`AppointmentNo`),
  UNIQUE KEY `Phone_UNIQUE` (`Phone`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_appointment`
--

LOCK TABLES `patient_appointment` WRITE;
/*!40000 ALTER TABLE `patient_appointment` DISABLE KEYS */;
INSERT INTO `patient_appointment` VALUES (1,'2022-08-09','2022-08-11','AI38875504','DI102','Rajendra','55','fever','Walk In','Yes','895896765'),(2,'2022-08-22','2022-08-25','AI21526652','DI102','Raja','18','Headache','By Phone','No','9682856245'),(3,'2022-08-26','2022-08-27','AI82143278','DI102','Ayash','65','Heart Problem','Walk In','Yes','3296248636'),(4,'2022-08-22','2022-08-25','AI40312327','DI102','Aman','25','Heart Issues','By Phone','yes','6389487120'),(5,'2022-08-22','2022-08-23','AI42735275','DI105','Ram Singh','45','Fever','By Phone','Yes','6355954564'),(6,'2022-08-23','2022-08-26','AI44651557','DI105','Sita','35','Cough','By Phone','No','3256699369'),(7,'2022-08-24','2022-08-26','AI69583285','DI105','Geeta Devi','78','Heart','Walk In','Yes','6882666595'),(8,'2022-08-24','2022-08-29','AI39697875','DI105','Rani','45','Lever','By Phone','Yes','6588225485'),(9,'2022-08-24','2022-08-30','AI60376109','DI105','Vinod','32','Kidney','Walk In','No','3599654556'),(10,'2022-08-24','2022-08-31','AI3066301','DI105','Rajeev','28','Cold','Walk In','No','6852458813'),(11,'2022-08-09','2022-08-16','AI33896796','DI105','Rakesh Kumar','25','Backbone Pain','By Phone','No','8956758956'),(12,'2022-08-23','2022-08-24','AI34547915','DI106','Shyam','45','Fever','By Phone','No','12365894'),(13,'2022-08-10','2022-08-11','AI66950650','DI104','Pankaj','25','Cold','Walk In','No','7895555');
/*!40000 ALTER TABLE `patient_appointment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-14 10:44:09
