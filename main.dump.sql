-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: localhost    Database: oasisdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE if not exists Medida (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  abrev VARCHAR(50) NOT NULL
);

CREATE TABLE if not exists  Insumo (
  codInsumo INT AUTO_INCREMENT PRIMARY KEY,
  nomInsumo VARCHAR(255) NOT NULL,
  cantInsumo INT NOT NULL,
  medidaCompraId INT,
  precioCosto DOUBLE NOT NULL,
  densidad DOUBLE,
  FOREIGN KEY (medidaCompraId) REFERENCES Medida(id)
);
-- Insert data into the Medida table
INSERT INTO Medida (nombre, abrev) VALUES
  ('Litro', 'L'),
  ('Mililitro', 'mL'),
  ('Kilogramo', 'kg'),
  ('Unidad', 'u'),
  ('Gramo', 'g');

-- Insert data into the Insumo table
INSERT INTO Insumo (nomInsumo, cantInsumo, medidaCompraId, precioCosto, densidad) VALUES
  ('Azúcar', 500, 1, 3.99, 0.8),
  ('Agua', 1000, 2, 0.99, NULL),
  ('Limón', 200, 4, 1.49, 1.2),
  ('Hielo', 100, 3, 0.25, NULL),
  ('Menta', 50, 5, 2.99, 0.5),
  ('Canela', 20, 5, 1.99, 0.3),
  ('Jengibre', 30, 4, 1.99, 0.6),
  ('Naranja', 150, 4, 3.49, 0.9),
  ('Maracuyá', 80, 2, 4.99, 1.2),
  ('Manzana', 100, 1, 2.99, NULL);

-- Update the medidaCompraId in Insumo to establish connections
UPDATE Insumo SET medidaCompraId = 1 WHERE codInsumo IN (1, 10);
UPDATE Insumo SET medidaCompraId = 2 WHERE codInsumo IN (2, 9);
UPDATE Insumo SET medidaCompraId = 3 WHERE codInsumo = 4;
UPDATE Insumo SET medidaCompraId = 4 WHERE codInsumo IN (3, 8);
UPDATE Insumo SET medidaCompraId = 5 WHERE codInsumo IN (5, 6, 7);



-- CREATE TABLE `person` (
--   `id` int NOT NULL AUTO_INCREMENT,
--   `name` varchar(255) NOT NULL,
--   `age` int DEFAULT NULL,
--   `email` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;
-- 
-- --
-- -- Dumping data for table `person`
-- --
-- 
-- LOCK TABLES `person` WRITE;
-- /*!40000 ALTER TABLE `person` DISABLE KEYS */;
-- INSERT INTO `person` VALUES (1,'John Doe',25,'john.doe@example.com'),(2,'Jane Smith',30,'jane.smith@example.com'),(3,'Michael Johnson',45,'michael.johnson@example.com'),(4,'Emily Davis',28,'emily.davis@example.com'),(5,'Robert Brown',33,'robert.brown@example.com'),(6,'Jennifer Wilson',41,'jennifer.wilson@example.com'),(7,'William Taylor',22,'william.taylor@example.com'),(8,'Jessica Anderson',35,'jessica.anderson@example.com'),(9,'David Martinez',27,'david.martinez@example.com'),(10,'Sarah Thompson',29,'sarah.thompson@example.com'),(11,'Daniel Garcia',38,'daniel.garcia@example.com'),(12,'Olivia Robinson',31,'olivia.robinson@example.com'),(13,'Matthew Clark',36,'matthew.clark@example.com'),(14,'Sophia Lewis',24,'sophia.lewis@example.com'),(15,'Andrew Lee',32,'andrew.lee@example.com');
-- /*!40000 ALTER TABLE `person` ENABLE KEYS */;
-- UNLOCK TABLES;
-- /*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
-- 
-- /*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
-- /*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
-- /*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
-- /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
-- /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
-- /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- /*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- 
-- -- Dump completed on 2023-05-17  0:45:54
-- 