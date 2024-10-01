-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2024 at 01:47 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taf1`
--

-- --------------------------------------------------------

--
-- Table structure for table `devdata`
--

CREATE TABLE `devdata` (
  `Developpeurs` varchar(32) DEFAULT NULL,
  `Jour` char(11) DEFAULT NULL,
  `NbScripts` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `devdata`
--

INSERT INTO `devdata` (`Developpeurs`, `Jour`, `NbScripts`) VALUES
('Alami', 'Lundi', 1),
('Wafi', 'Lundi', 2),
('Slami', 'Mardi', 9),
('Safi', 'Mardi', 2),
('Alami', 'Mardi', 2),
('Sebihi', 'Mercredi', 2),
('Wafi', 'Jeudi', 3),
('Alaoui', 'Vendredi', 9),
('Wafi', 'Vendredi', 3),
('Sebihi', 'Vendredi', 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
