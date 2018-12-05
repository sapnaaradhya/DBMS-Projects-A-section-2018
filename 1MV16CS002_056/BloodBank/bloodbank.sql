-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2018 at 02:39 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bloodbank`
--
CREATE DATABASE IF NOT EXISTS `bloodbank` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bloodbank`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `getBloodGroup`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getBloodGroup` ()  SELECT * FROM bloodgroup$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bloodgroup`
--

DROP TABLE IF EXISTS `bloodgroup`;
CREATE TABLE `bloodgroup` (
  `bg_id` int(100) NOT NULL,
  `bg_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `bloodgroup`:
--

--
-- Dumping data for table `bloodgroup`
--

INSERT INTO `bloodgroup` (`bg_id`, `bg_name`) VALUES
(1, 'A+'),
(2, 'A-'),
(3, 'B+'),
(4, 'B-'),
(5, 'O+'),
(6, 'O-'),
(7, 'AB+'),
(8, 'AB-');

-- --------------------------------------------------------

--
-- Table structure for table `camp`
--

DROP TABLE IF EXISTS `camp`;
CREATE TABLE `camp` (
  `camp_id` int(100) NOT NULL,
  `camp_title` varchar(500) NOT NULL,
  `organised_by` varchar(500) NOT NULL,
  `state` int(100) NOT NULL,
  `city` int(100) NOT NULL,
  `pic` varchar(900) NOT NULL,
  `detail` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `camp`:
--

--
-- Dumping data for table `camp`
--

INSERT INTO `camp` (`camp_id`, `camp_title`, `organised_by`, `state`, `city`, `pic`, `detail`) VALUES
(1, 'Sir MVIT', 'Abhikalpana', 1, 1, 'cropped-mvit13.jpg', 'A Blood Donation Camp at Sir MVIT organized by Abhikalpana'),
(2, 'NMIT', 'NIMHANS', 1, 7, 'nitte-meenakshi-institute-of-technology.jpg', 'A Blood Donation Camp at NMIT engg College organized by NIMHANS.'),
(3, 'SVIT College', 'Lions Club', 1, 1, '8.jpg', 'A Blood Donation Camp at SVIT Engg College organized by Lions Club, Bengaluru.'),
(4, 'Reva University', 'Reva Group', 1, 1, '54859_Reva.jpg', 'A Blood Donation Camp at Reva University organized by Reva Group of Mgmt.\r\n ');

-- --------------------------------------------------------

--
-- Table structure for table `donarregistration`
--

DROP TABLE IF EXISTS `donarregistration`;
CREATE TABLE `donarregistration` (
  `donar_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `age` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL,
  `b_id` int(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` int(100) NOT NULL,
  `pic` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `donarregistration`:
--   `b_id`
--       `bloodgroup` -> `bg_id`
--

--
-- Dumping data for table `donarregistration`
--

INSERT INTO `donarregistration` (`donar_id`, `name`, `gender`, `age`, `mobile`, `b_id`, `email`, `pwd`, `pic`) VALUES
(3, 'neeru', 'female', '20', '9463958058', 5, 'neeru.bawa@yahoo.com', 123, 'neeru.jpg'),
(4, 'Paras Bhatia', 'male', '21', '9888961990', 5, 'parasbhatia08@gmail.com', 123, '11168037_1610636085842033_904443745256932191_n.jpg'),
(5, 'Rakesh', 'male', '22', '9876505652', 1, 'rakesh12@gmil.com', 123, '1002679_629448530471361_5912528223898153120_n.jpg'),
(6, 'Manu', 'female', '20', '9779730479', 5, 'manpreetkaler@yahoo.com', 123, '12144826_691191231017304_7118038794667291151_n.jpg'),
(7, 'Sukhwinder', 'male', '22', '01823280290', 1, 'sunnysuyan@gmail.com', 123, 'p3Penguins.jpg'),
(8, 'Abhishek', 'male', '24', '0123456780', 3, 'abhi@ymail.com', 123, 'resizedBlood donation (1).jpg'),
(9, 'Ramanjeet Kaur', 'female', '26', '9295769630', 7, 'rbawa08@yahoo.com', 123, '11261437_1624099511137421_8482759699813102898_n.jpg'),
(10, 'kuldip Banga', 'male', '26', '9878967543', 7, 'kbanga@yahoo.com', 123, '10593057_728311113906338_1063644592728298376_n.jpg'),
(11, 'Jaspinder', 'male', '24', '9445678765', 8, 'singhjaspinder12@gmail.com', 123, '12038392_969929529729736_1007747926670734265_n (1).jpg'),
(12, 'Sahil', 'male', '20', '8591824296', 5, 'sahildubey@gmail.com', 123, '12038380_834746969972073_6382623771453128938_n.jpg'),
(13, 'sonu', 'male', '25', '9594918765', 8, 'sonukhana34@gmail.com', 123, '11863382_1032998280067097_2552428582935820453_n.jpg'),
(14, 'Vinny', 'male', '24', '01824230721', 2, 'vinny786@gmail.com', 123, '11175046_366978330169273_8044521424217911178_n.jpg'),
(15, 'Rishav Bhatia', 'male', '19', '8781846758', 3, 'rbhatia@ymail.com', 123, '1491626_647476172014342_6155162312561723489_n.jpg'),
(16, 'Rahul Bangar', 'male', '25', '9216291294', 4, 'raulban@gmail.com', 123, '11899909_948967995160204_759838727467883977_n.jpg'),
(17, 'Prabhjot', 'male', '24', '9818134576', 4, 'prabh786@gmail.com', 123, '11899866_690854484348510_8725848025714675727_n.jpg'),
(18, 'Ridhima', 'female', '25', '9889786545', 6, 'ridhi@ymail.com', 123, '1.jpg'),
(19, 'Preet karanq', 'female', '28', '8427429079', 6, 'preet22@yahoo.com', 123, '123.jpg'),
(20, 'manat', 'female', '35', '9888976570', 2, 'manat@yahoo.com', 123, 'ccccc.jpg'),
(21, 'Salman', 'male', '45', '9988776644', 4, 'salman@123', 123, 'images.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `donation`
--

DROP TABLE IF EXISTS `donation`;
CREATE TABLE `donation` (
  `donation_id` int(100) NOT NULL,
  `camp_id` int(100) NOT NULL,
  `ddate` datetime NOT NULL,
  `units` int(100) NOT NULL,
  `detail` varchar(800) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `donation`:
--   `camp_id`
--       `camp` -> `camp_id`
--

--
-- Dumping data for table `donation`
--

INSERT INTO `donation` (`donation_id`, `camp_id`, `ddate`, `units`, `detail`, `email`) VALUES
(28, 1, '2014-09-14 00:00:00', 20, '', 'parasbhatia08@gmail.com'),
(29, 2, '2015-05-11 00:00:00', 30, '', 'parasbhatia08@gmail.com'),
(30, 3, '2014-11-04 00:00:00', 25, '', 'parasbhatia08@gmail.com'),
(31, 4, '2014-12-18 00:00:00', 22, '', 'parasbhatia08@gmail.com'),
(32, 2, '2010-06-19 00:00:00', 27, '', 'preet22@yahoo.com'),
(33, 3, '2010-08-20 00:00:00', 17, 'save life', 'manpreetkaler@yahoo.com'),
(34, 4, '2009-06-05 00:00:00', 10, 'give blood', 'manpreetkaler@yahoo.com'),
(35, 1, '2012-09-13 00:00:00', 22, 'save life', 'sahildubey@gmail.com'),
(36, 4, '2018-11-13 00:00:00', 10, '', 'neeru.bawa@yahoo.com'),
(37, 1, '2018-12-03 00:00:00', 3, '', 'salman@123');

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `action` varchar(20) NOT NULL,
  `cdate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `logs`:
--

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`id`, `user_name`, `action`, `cdate`) VALUES
(1, 'user', 'Updated', '2018-12-05 18:07:45'),
(2, 'user', 'Updated', '2018-12-05 18:08:25'),
(3, 'root', 'Deleted', '2018-12-05 18:08:32'),
(4, 'root', 'Inserted', '2018-12-05 18:08:51');

-- --------------------------------------------------------

--
-- Table structure for table `requestes`
--

DROP TABLE IF EXISTS `requestes`;
CREATE TABLE `requestes` (
  `req_id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `age` varchar(100) NOT NULL,
  `mobile` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `bgroup` int(100) NOT NULL,
  `reqdate` datetime NOT NULL,
  `detail` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `requestes`:
--   `bgroup`
--       `bloodgroup` -> `bg_id`
--

--
-- Dumping data for table `requestes`
--

INSERT INTO `requestes` (`req_id`, `name`, `gender`, `age`, `mobile`, `email`, `bgroup`, `reqdate`, `detail`) VALUES
(7, 'balwant singh', 'male', '22', '8427420298', 'balwant11@gmail.com', 3, '2018-01-15 00:00:00', 'save life'),
(8, 'japleen', 'female', '22', '9216291294', 'jsimran08@gmail.com', 5, '2018-01-12 00:00:00', 'save life'),
(9, 'Naresh', 'female', '21', '8427420291', 'nareshheer719@gmail.com', 1, '2018-01-18 00:00:08', 'save life'),
(10, 'Taran', 'male', '55', '7589325050', 'taran@ymail.com', 6, '2018-01-29 00:00:00', ''),
(11, 'Salman', 'male', '45', '9988776644', 'salman@123', 4, '2018-01-18 00:00:00', '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `typeofuser` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `users`:
--

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `pwd`, `typeofuser`) VALUES
('abhi', 'abhi', 'Admin'),
('namratha', 'namratha', 'Admin'),
('user', 'user', 'General'),
('student', 'student', 'General'),
('root', 'admin', 'Admin');

--
-- Triggers `users`
--
DROP TRIGGER IF EXISTS `UpdateLog`;
DELIMITER $$
CREATE TRIGGER `UpdateLog` AFTER UPDATE ON `users` FOR EACH ROW INSERT INTO logs VALUES (null, NEW.username, 'Updated', NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `deleteLog`;
DELIMITER $$
CREATE TRIGGER `deleteLog` AFTER DELETE ON `users` FOR EACH ROW INSERT INTO logs VALUES (null, OLD.username, 'Deleted', NOW())
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `insertLog`;
DELIMITER $$
CREATE TRIGGER `insertLog` AFTER INSERT ON `users` FOR EACH ROW INSERT INTO logs VALUES (null, NEW.username, 'Inserted', NOW())
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bloodgroup`
--
ALTER TABLE `bloodgroup`
  ADD PRIMARY KEY (`bg_id`,`bg_name`);

--
-- Indexes for table `camp`
--
ALTER TABLE `camp`
  ADD PRIMARY KEY (`camp_id`);

--
-- Indexes for table `donarregistration`
--
ALTER TABLE `donarregistration`
  ADD PRIMARY KEY (`donar_id`),
  ADD KEY `b_id` (`b_id`);

--
-- Indexes for table `donation`
--
ALTER TABLE `donation`
  ADD PRIMARY KEY (`donation_id`,`camp_id`),
  ADD KEY `camp_id` (`camp_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `requestes`
--
ALTER TABLE `requestes`
  ADD PRIMARY KEY (`req_id`),
  ADD KEY `bgroup` (`bgroup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bloodgroup`
--
ALTER TABLE `bloodgroup`
  MODIFY `bg_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `camp`
--
ALTER TABLE `camp`
  MODIFY `camp_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `donarregistration`
--
ALTER TABLE `donarregistration`
  MODIFY `donar_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `donation`
--
ALTER TABLE `donation`
  MODIFY `donation_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `requestes`
--
ALTER TABLE `requestes`
  MODIFY `req_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `donarregistration`
--
ALTER TABLE `donarregistration`
  ADD CONSTRAINT `donarregistration_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `bloodgroup` (`bg_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `donation`
--
ALTER TABLE `donation`
  ADD CONSTRAINT `donation_ibfk_1` FOREIGN KEY (`camp_id`) REFERENCES `camp` (`camp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `requestes`
--
ALTER TABLE `requestes`
  ADD CONSTRAINT `requestes_ibfk_1` FOREIGN KEY (`bgroup`) REFERENCES `bloodgroup` (`bg_id`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Metadata
--
USE `phpmyadmin`;

--
-- Metadata for table bloodgroup
--

--
-- Metadata for table camp
--

--
-- Dumping data for table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'bloodbank', 'camp', '[]', '2018-11-08 14:46:14');

--
-- Metadata for table donarregistration
--

--
-- Dumping data for table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'bloodbank', 'donarregistration', '{\"sorted_col\":\"`donarregistration`.`donar_id` ASC\"}', '2018-12-05 10:29:07');

--
-- Metadata for table donation
--

--
-- Metadata for table logs
--

--
-- Metadata for table requestes
--

--
-- Dumping data for table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'bloodbank', 'requestes', '{\"CREATE_TIME\":\"2018-12-05 14:05:18\",\"sorted_col\":\"`requestes`.`mobile` ASC\"}', '2018-12-05 12:57:51');

--
-- Metadata for table users
--

--
-- Dumping data for table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'bloodbank', 'users', '{\"sorted_col\":\"`users`.`username`  DESC\"}', '2018-11-07 07:53:14');

--
-- Metadata for database bloodbank
--

--
-- Dumping data for table `pma__pdf_pages`
--

INSERT INTO `pma__pdf_pages` (`db_name`, `page_descr`) VALUES
('bloodbank', 'schema');

SET @LAST_PAGE = LAST_INSERT_ID();

--
-- Dumping data for table `pma__table_coords`
--

INSERT INTO `pma__table_coords` (`db_name`, `table_name`, `pdf_page_number`, `x`, `y`) VALUES
('bloodbank', 'bloodgroup', @LAST_PAGE, 170, 251),
('bloodbank', 'camp', @LAST_PAGE, 414, 474),
('bloodbank', 'donarregistration', @LAST_PAGE, 390, 86),
('bloodbank', 'donation', @LAST_PAGE, 640, 378),
('bloodbank', 'requestes', @LAST_PAGE, 182, 381),
('bloodbank', 'users', @LAST_PAGE, 636, 245);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
