/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jsp_project

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-05 22:41:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `bank_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank
-- ----------------------------

-- ----------------------------
-- Table structure for cash_record
-- ----------------------------
DROP TABLE IF EXISTS `cash_record`;
CREATE TABLE `cash_record` (
  `pay_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `cash_date` datetime DEFAULT NULL,
  `pay_money` decimal(10,2) DEFAULT NULL,
  `incom_money` decimal(10,2) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pay_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cash_record
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `province_id` bigint(20) DEFAULT NULL,
  `city_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(500) DEFAULT NULL,
  `picture_url` varchar(500) DEFAULT NULL,
  `one_word` varchar(500) DEFAULT NULL,
  `introduce` varchar(2000) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `course_count` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `effective` tinyint(2) DEFAULT NULL,
  `replay_date` datetime DEFAULT NULL,
  `replay_username` varchar(50) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `charge_type` tinyint(2) DEFAULT NULL,
  `status` tinyint(3) DEFAULT NULL,
  `reason` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for exchange_code
-- ----------------------------
DROP TABLE IF EXISTS `exchange_code`;
CREATE TABLE `exchange_code` (
  `exchange_code_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `exchange_record_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `exchange_code` varchar(100) DEFAULT NULL,
  `exchange_money` decimal(10,0) DEFAULT NULL,
  `exchange_status` tinyint(2) DEFAULT NULL,
  `exchange_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`exchange_code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange_code
-- ----------------------------

-- ----------------------------
-- Table structure for exchange_record
-- ----------------------------
DROP TABLE IF EXISTS `exchange_record`;
CREATE TABLE `exchange_record` (
  `exchange_record_id` bigint(20) DEFAULT NULL,
  `activity_name` varchar(500) DEFAULT NULL,
  `activity_desc` varchar(2000) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange_record
-- ----------------------------

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `forum_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `replay_user_id` bigint(20) DEFAULT NULL,
  `fourm_type` tinyint(2) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `forum_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manager_account` varchar(50) DEFAULT NULL,
  `manager_password` varchar(100) DEFAULT NULL,
  `manager_name` varchar(50) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `contact` varchar(11) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for money_record
-- ----------------------------
DROP TABLE IF EXISTS `money_record`;
CREATE TABLE `money_record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `pay_money` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of money_record
-- ----------------------------

-- ----------------------------
-- Table structure for new_msg
-- ----------------------------
DROP TABLE IF EXISTS `new_msg`;
CREATE TABLE `new_msg` (
  `new_mes_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `msg_name` varchar(100) DEFAULT NULL,
  `one_word` varchar(500) DEFAULT NULL,
  `msg_content` text,
  `msg_content_url` varchar(255) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `publish_username` varchar(255) DEFAULT NULL,
  `effective` tinyint(2) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `news_type` tinyint(2) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`new_mes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of new_msg
-- ----------------------------

-- ----------------------------
-- Table structure for pay_record
-- ----------------------------
DROP TABLE IF EXISTS `pay_record`;
CREATE TABLE `pay_record` (
  `pay_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `pay_money` decimal(10,2) DEFAULT NULL,
  `discount_money` decimal(10,2) DEFAULT NULL,
  `payer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pay_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay_record
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `province_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------

-- ----------------------------
-- Table structure for section
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `section_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_id` bigint(20) DEFAULT NULL,
  `section_name` varchar(100) DEFAULT NULL,
  `time_length` int(11) DEFAULT NULL,
  `section_url` varchar(500) DEFAULT NULL,
  `section_content` text,
  `remark` varchar(1000) DEFAULT NULL,
  `free` tinyint(2) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `status` tinyint(3) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of section
-- ----------------------------

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog` (
  `sys_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manager_id` bigint(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `ip_appress` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sys_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of syslog
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_introduce` varchar(500) DEFAULT NULL,
  `teacher_special` varchar(500) DEFAULT NULL,
  `teacher_length` varchar(50) DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `head_picture_url` varchar(500) DEFAULT NULL,
  `bank_id` bigint(20) DEFAULT NULL,
  `account_no` varchar(30) DEFAULT NULL,
  `account_name` varchar(30) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_grade
-- ----------------------------
DROP TABLE IF EXISTS `teacher_grade`;
CREATE TABLE `teacher_grade` (
  `grade_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(100) DEFAULT NULL,
  `grade_percent` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_grade
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `home_address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `register_data` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `province_id` bigint(20) DEFAULT NULL,
  `city_id` bigint(20) DEFAULT NULL,
  `user_type` bigint(20) DEFAULT NULL,
  `remain_money` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for user_course_eval
-- ----------------------------
DROP TABLE IF EXISTS `user_course_eval`;
CREATE TABLE `user_course_eval` (
  `user_course_eval_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `eval_level` tinyint(5) DEFAULT NULL,
  `eval_content` varchar(2000) DEFAULT NULL,
  `eval_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_course_eval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_course_eval
-- ----------------------------
