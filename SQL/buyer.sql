-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 28, 2020 at 10:13 AM
-- Server version: 5.7.17-log
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buyer`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_goods`
--

CREATE TABLE `t_goods` (
  `G_ID` int(5) NOT NULL,
  `G_CODE` int(7) NOT NULL,
  `G_NAME` varchar(255) NOT NULL,
  `G_QTY` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_goods`
--

INSERT INTO `t_goods` (`G_ID`, `G_CODE`, `G_NAME`, `G_QTY`) VALUES
(21, 5, 'iPhone X', 75);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_goods`
--
ALTER TABLE `t_goods`
  ADD PRIMARY KEY (`G_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_goods`
--
ALTER TABLE `t_goods`
  MODIFY `G_ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
