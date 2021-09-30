CREATE DATABASE  IF NOT EXISTS `parentChildren_directory`;
USE `parentChildren_directory`;

--
-- Table structure for table `parent_children`
--

DROP TABLE IF EXISTS `parent_children`;

CREATE TABLE `parent_children` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` integer(10) DEFAULT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `children` text(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `parent_children`
--

INSERT INTO `parent_children` VALUES 
	(1,'Jay','23','Jay Changela', '[
      {
        "Name": "Abhi",
         "Age": "5",
         "FullName": "Abhi Changela",
        "children": []
      }
]'),
(2,'Parth','28','Parth Patel', '[
      {
        "Name": "Raj",
        "Age": "8",
		"FullName": "Raj Patel",
        "children": []
      }
]');

