-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2017 at 04:06 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `factory_table` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `fact_name` text NOT NULL,
  `name` text NOT NULL,
  `mob_no` int(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

CREATE TABLE IF NOT EXISTS `products` (
  `product_id` int(5) NOT NULL AUTO_INCREMENT,

  `id` int(5) NOT NULL,
  `product_name` text NOT NULL,
  `cost` int(12) NOT NULL,
  PRIMARY KEY (`product_id`,`id`),
  FOREIGN KEY fkey(`id`)
  REFERENCES factory_table(`id`)
  ON DELETE CASCADE
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `particular_factory` (
  `id` int(5) NOT NULL,
  `employee_tot_salary` int(10),

  FOREIGN KEY PKEY(`id`)
  REFERENCES factory_table(`id`)
  ON DELETE CASCADE

) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` int(5) NOT NULL AUTO_INCREMENT,

  `id` int(5) NOT NULL,
  `customer_name` text NOT NULL,
  `product_quantity` int(12) NOT NULL,
  `month` date NOT NULL,
  `transportation_cost` int(12) NOT NULL,
  `bill_amount` int(12) NOT NULL,
  PRIMARY KEY(`customer_id`,`id`),
  FOREIGN KEY fc(`id`)
  REFERENCES factory_table(`id`)
  ON DELETE CASCADE

) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `statistics` (
  `id` int(5) NOT NULL,
  `month` date NOT NULL,
  `maintainence` int(12) NOT NULL,
  `raw_material_cost` int(12) NOT NULL,
  `electricity` int(12) NOT NULL,

  PRIMARY KEY(`id`,`month`),
  FOREIGN KEY fc(`id`)
  REFERENCES factory_table(`id`)
  ON DELETE CASCADE

) ENGINE=InnoDB;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
