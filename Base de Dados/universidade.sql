-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2022 at 05:42 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `universidade`
--

-- --------------------------------------------------------

--
-- Table structure for table `avaliacao`
--

CREATE TABLE `avaliacao` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(1000) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `disciplina`
--

CREATE TABLE `disciplina` (
  `codigo` int(11) NOT NULL,
  `cargaHoraria` varchar(10) NOT NULL,
  `descricao` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `estudante`
--

CREATE TABLE `estudante` (
  `nrMatricula` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(15) NOT NULL,
  `contacto` varchar(12) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `estudante`
--

INSERT INTO `estudante` (`nrMatricula`, `nome`, `apelido`, `contacto`, `endereco`) VALUES
(1212, 'Betuel Jose', 'Bulande', '84848484', 'Marracuene A'),
(1213, 'Yasmin Torkan', 'Zamani', '84484484', 'Maputo'),
(1234, 'Antonio Zedequias', 'Nguenha', '8988886', 'Polana'),
(844962036, 'Vanio Anibal', 'Macamo', '844962036', 'Hulene A');

-- --------------------------------------------------------

--
-- Table structure for table `notarealiza`
--

CREATE TABLE `notarealiza` (
  `codigo` int(11) NOT NULL,
  `nota` double NOT NULL,
  `nrEstudante` int(11) NOT NULL,
  `codigoDisciplina` int(11) NOT NULL,
  `codigoAvaliacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `estudante`
--
ALTER TABLE `estudante`
  ADD PRIMARY KEY (`nrMatricula`);

--
-- Indexes for table `notarealiza`
--
ALTER TABLE `notarealiza`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `FOREIGN` (`codigoDisciplina`,`codigoAvaliacao`,`nrEstudante`),
  ADD KEY `codigoAvaliacao` (`codigoAvaliacao`),
  ADD KEY `nrEstudante` (`nrEstudante`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notarealiza`
--
ALTER TABLE `notarealiza`
  ADD CONSTRAINT `notarealiza_ibfk_1` FOREIGN KEY (`codigoAvaliacao`) REFERENCES `avaliacao` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notarealiza_ibfk_2` FOREIGN KEY (`nrEstudante`) REFERENCES `estudante` (`nrMatricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notarealiza_ibfk_3` FOREIGN KEY (`codigoDisciplina`) REFERENCES `disciplina` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
