-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 20, 2019 at 07:21 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdjava2`
--

-- --------------------------------------------------------

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE IF NOT EXISTS `equipe` (
  `ID_Equipe` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) NOT NULL,
  `Ville` varchar(10) NOT NULL,
  PRIMARY KEY (`ID_Equipe`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipe`
--

INSERT INTO `equipe` (`ID_Equipe`, `Nom`, `Ville`) VALUES
(17, 'Fcb', 'Barcelona'),
(21, 'Juventus', 'Turin'),
(22, 'Psg', 'Paris'),
(56, 'EquipeX', 'VilleX');

-- --------------------------------------------------------

--
-- Table structure for table `joueur`
--

DROP TABLE IF EXISTS `joueur`;
CREATE TABLE IF NOT EXISTS `joueur` (
  `ID_Joueur` int(20) NOT NULL AUTO_INCREMENT,
  `Nom_Joueur` varchar(20) NOT NULL,
  `Prenom_Joueur` varchar(20) NOT NULL,
  `Poste` varchar(20) NOT NULL,
  `ID_EQUIPE` int(10) NOT NULL,
  PRIMARY KEY (`ID_Joueur`),
  KEY `ID_EQUIPE` (`ID_EQUIPE`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `joueur`
--

INSERT INTO `joueur` (`ID_Joueur`, `Nom_Joueur`, `Prenom_Joueur`, `Poste`, `ID_EQUIPE`) VALUES
(3, 'Messi', 'Lionnel', 'Forward', 17),
(4, 'Gerard', 'Piqué', 'Defense', 17),
(5, 'Luis', 'Suarez', 'Forward', 17),
(6, 'Cristiano', 'Ronaldo', 'Forward', 21),
(7, 'Danilo', 'Danilo', 'Defense', 21),
(10, 'Neymar', 'Neymar', 'Forward', 22),
(11, 'Mbappé', 'Kylian', 'Forward', 22),
(12, 'Navas', 'Keylor', 'Goalkeeper', 22),
(13, 'Sarabia', 'Pablo', 'MidFielder', 22),
(14, 'Lcardi', 'Mauro', 'Forward', 22),
(15, 'Silva', 'Diago', 'Defense', 22);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `ID_EQUIPE` FOREIGN KEY (`ID_EQUIPE`) REFERENCES `equipe` (`ID_Equipe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
