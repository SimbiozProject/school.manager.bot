-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: bot
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
                           `course_id` bigint NOT NULL,
                           `course_name` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Level 0'),(2,'Level Advanced'),(3,'Level 1'),(4,'Level 2'),(5,'Level 3');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_registration`
--

DROP TABLE IF EXISTS `crm_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crm_registration` (
                                    `user_id` bigint NOT NULL,
                                    `city_name` varchar(255) DEFAULT NULL,
                                    `country_name` varchar(255) DEFAULT NULL,
                                    `date_of_birth` varchar(255) DEFAULT NULL,
                                    `e_mail` varchar(255) DEFAULT NULL,
                                    `first_name` varchar(255) DEFAULT NULL,
                                    `last_name` varchar(255) DEFAULT NULL,
                                    `phone_number` varchar(255) DEFAULT NULL,
                                    `user_name` bigint NOT NULL,
                                    PRIMARY KEY (`user_id`),
                                    KEY `FKpqmqaaawsxsdk3r9wjmkxqxjd` (`user_name`),
                                    CONSTRAINT `FKpqmqaaawsxsdk3r9wjmkxqxjd` FOREIGN KEY (`user_name`) REFERENCES `tg_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_registration`
--

LOCK TABLES `crm_registration` WRITE;
/*!40000 ALTER TABLE `crm_registration` DISABLE KEYS */;
INSERT INTO `crm_registration` VALUES (1,'Minsk','Belarus','1978-07-27','qwerty@mail.ru','Vova','Wef','1234567',1),(2,'Moscow','Russia','2002-03-11','dfghj@gmail.com','Katya','Wash','4534545',2),(3,'Minsk','Belarus','1992-07-23','zxcvbn@gmail.com','Luda','Tyk','5675674',3),(4,'Kiev','Ukraine','1991-07-01','plkmokmok@gmail.com','Olga','Lop','2345675',4),(5,'Kiev','Ukraine','2000-07-28','debbvvg@mail.ru','Denis','Bam','5457890',5);
/*!40000 ALTER TABLE `crm_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hw_for_students`
--

DROP TABLE IF EXISTS `hw_for_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hw_for_students` (
                                   `hw_id` int NOT NULL,
                                   `hw_doc` varchar(255) DEFAULT NULL,
                                   `lesson_number` int DEFAULT NULL,
                                   `group_number` bigint DEFAULT NULL,
                                   PRIMARY KEY (`hw_id`),
                                   KEY `FK7vgk9bl5bgqque0eqoege99gc` (`group_number`),
                                   CONSTRAINT `FK7vgk9bl5bgqque0eqoege99gc` FOREIGN KEY (`group_number`) REFERENCES `student_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hw_for_students`
--

LOCK TABLES `hw_for_students` WRITE;
/*!40000 ALTER TABLE `hw_for_students` DISABLE KEYS */;
INSERT INTO `hw_for_students` VALUES (1,'photo',2,1),(2,'doc',3,2),(3,'photo',6,3),(4,'photo',7,1),(5,'doc',5,4);
/*!40000 ALTER TABLE `hw_for_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hw_from_students`
--

DROP TABLE IF EXISTS `hw_from_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hw_from_students` (
                                    `student_id` int NOT NULL,
                                    `students_hw` varchar(255) DEFAULT NULL,
                                    `lesson_number` int DEFAULT NULL,
                                    `student_name` bigint DEFAULT NULL,
                                    PRIMARY KEY (`student_id`),
                                    KEY `FKeedcalpa9h59pdly4hd4uvca6` (`student_name`),
                                    CONSTRAINT `FKeedcalpa9h59pdly4hd4uvca6` FOREIGN KEY (`student_name`) REFERENCES `tg_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hw_from_students`
--

LOCK TABLES `hw_from_students` WRITE;
/*!40000 ALTER TABLE `hw_from_students` DISABLE KEYS */;
INSERT INTO `hw_from_students` VALUES (1,'doc',4,1),(2,'doc',6,2),(3,'doc',8,3),(4,'doc',3,4),(5,'photo',5,5);
/*!40000 ALTER TABLE `hw_from_students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_answer`
--

DROP TABLE IF EXISTS `question_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question_answer` (
                                   `id` bigint NOT NULL,
                                   `first_answer` varchar(255) DEFAULT NULL,
                                   `fourth_answer` varchar(255) DEFAULT NULL,
                                   `question` varchar(255) DEFAULT NULL,
                                   `right_answer` varchar(255) DEFAULT NULL,
                                   `second_answer` varchar(255) DEFAULT NULL,
                                   `third_answer` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_answer`
--

LOCK TABLES `question_answer` WRITE;
/*!40000 ALTER TABLE `question_answer` DISABLE KEYS */;
INSERT INTO `question_answer` VALUES (1,'be','an','1. My favorite color _____ green.','is','are','is'),(2,'at','on','2. We get up _____ 7 o’clock.','at','in','of'),(3,'a','-','3. There is _____ milk in the fridge.','some','some','the'),(4,'of','from','4. Are you _____ Italy?','from','out','at'),(5,'symbol','-','5. London is the _____ of England.','capital','capital','country'),(6,'play','playing','6. Last Sunday I _____ football with my friends.','played','played','plays'),(7,'the best','well','7. This is _____ film I have ever seen.','the best','good','better'),(8,'do','will','8. _____ I have a ticket to London?','can','should','should'),(9,'often','long','9. How _____ friends do you have?','many','much','many'),(10,'that is','those are','10. Excuse me, _____ my hat.','that is','those is','that are'),(11,'-','An','11. _____ elephants are very beautiful animals.','-','There','A'),(12,'See you there','Nice to meet you','12. How about going to the cinema? _____ ','Sounds good. What’s on?','Sounds good. What\'s on?','Not a problem'),(13,'which','who','13. She is a woman _____ helped me with a job.','who','whose','where'),(14,'said','talked','14. They _____ me they would come the next day.','told','spoke','told'),(15,'getting','gotten','15. I hate _____ up early in the morning.','getting','get','got'),(16,'will','can','16. If I were you I _____ buy this car.','would','would','should'),(17,'so he was ill','but is here','17. He didn’t go to school _____','although he wasn’t ill','because he was there','although he wasn’t ill'),(18,'on','in','18. It’s not a good idea to leave electrical appliance _____ standby.','on','for','at'),(19,'up','of','19. When I want to relax I put my feet _____ ','up','on','down'),(20,'obey','disobeying','20. They are usually punished for _____ a teacher.','disobeying','disobey','obeying'),(21,'know','have been knowing','21. I _____ her since we were teenagers.','have known','knew','have known'),(22,'When','As soon as','22. _____ we came train had already departed.','By the time','By the time','Until'),(23,'to see','seeing','23. I remember _____ him at work and he was tired.','seeing','see','saw'),(24,'couldn\'t see','can\'t have seen','24. You _____ Jack in the gym because he had gone to France.','can’t have seen','can\'t see','haven\'t seen'),(25,'regarding','in order to','25. I was frustrated at not having news _____ the interview I had had before.','regarding','relates','comparing with');
/*!40000 ALTER TABLE `question_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistic_user`
--

DROP TABLE IF EXISTS `statistic_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statistic_user` (
  `chat_id` bigint NOT NULL,
  `active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`chat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistic_user`
--

LOCK TABLES `statistic_user` WRITE;
/*!40000 ALTER TABLE `statistic_user` DISABLE KEYS */;
INSERT INTO `statistic_user` VALUES (738542117,_binary ''),(1083113433,_binary '');
/*!40000 ALTER TABLE `statistic_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_group`
--

DROP TABLE IF EXISTS `student_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_group` (
  `group_id` bigint NOT NULL,
  `group_number` bigint DEFAULT NULL,
  `course_name` bigint DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `FKlvf9be8u2vjjnmj1of4espax7` (`course_name`),
  CONSTRAINT `FKlvf9be8u2vjjnmj1of4espax7` FOREIGN KEY (`course_name`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_group`
--

LOCK TABLES `student_group` WRITE;
/*!40000 ALTER TABLE `student_group` DISABLE KEYS */;
INSERT INTO `student_group` VALUES (1,11,1),(2,10,2),(3,9,3),(4,8,4),(5,7,5);
/*!40000 ALTER TABLE `student_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tg_user`
--

DROP TABLE IF EXISTS `tg_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tg_user` (
  `id_user` bigint NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `block_user` bit(1) DEFAULT NULL,
  `date_of_birthday` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `payment` bit(1) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `course_name` bigint DEFAULT NULL,
  `group_number` bigint DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UK_fyaw5wxwf9pltonloqypcna5w` (`email`),
  UNIQUE KEY `UK_qpp1gqavpibaxbxp7p29gpwwn` (`user_name`),
  KEY `FKq5rodn7o6secholg2l88n7vd3` (`course_name`),
  KEY `FKoc18tg8bn6kvx5mgeuv38x67s` (`group_number`),
  CONSTRAINT `FKoc18tg8bn6kvx5mgeuv38x67s` FOREIGN KEY (`group_number`) REFERENCES `student_group` (`group_id`),
  CONSTRAINT `FKq5rodn7o6secholg2l88n7vd3` FOREIGN KEY (`course_name`) REFERENCES `courses` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tg_user`
--

LOCK TABLES `tg_user` WRITE;
/*!40000 ALTER TABLE `tg_user` DISABLE KEYS */;
INSERT INTO `tg_user` VALUES (1,_binary '',_binary '\0','1978-07-27','qwerty@mail.ru','Vova','Wef',_binary '','user','qaz',1,1),(2,_binary '',_binary '\0','2002-03-11','dfghj@gmail.com','Katya','Wash',_binary '','admin','wsx',2,2),(3,_binary '',_binary '\0','1992-07-23','zxcvbn@gmail.com','Luda','Tyk',_binary '','teacher','edc',3,3),(4,_binary '',_binary '\0','1991-07-01','plkmokmok@gmail.com','Olga','Lop',_binary '','student','rfv',4,4),(5,_binary '\0',_binary '','2000-07-28','debbvvg@mail.ru','Denis','Bam',_binary '\0','student','tgb',3,3);
/*!40000 ALTER TABLE `tg_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_answer`
--

DROP TABLE IF EXISTS `user_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_answer` (
  `user_id` bigint NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `question_id` bigint NOT NULL,
  `user_name` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK4b2q3a5r8pytpnsw3f0ffg6ao` (`question_id`),
  KEY `FKcdm0qlsow9hf0ritcs1mp7f1d` (`user_name`),
  CONSTRAINT `FK4b2q3a5r8pytpnsw3f0ffg6ao` FOREIGN KEY (`question_id`) REFERENCES `question_answer` (`id`),
  CONSTRAINT `FKcdm0qlsow9hf0ritcs1mp7f1d` FOREIGN KEY (`user_name`) REFERENCES `tg_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answer`
--

LOCK TABLES `user_answer` WRITE;
/*!40000 ALTER TABLE `user_answer` DISABLE KEYS */;
INSERT INTO `user_answer` VALUES (1,'1',1,1),(2,'2',2,2),(3,'3',3,3),(4,'1',4,4),(5,'4',5,5);
/*!40000 ALTER TABLE `user_answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-05 22:53:20
