/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : sxt

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-02-13 19:37:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `sex` varchar(3) NOT NULL,
  `age` int(3) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小鸟酱', '111', '女', '19', '2020-02-04');
INSERT INTO `user` VALUES ('11', '欧尼酱', '123', '女', '18', '2000-07-19');
INSERT INTO `user` VALUES ('12', '萌白酱', 'wdnmd', '女', '18', '2017-02-02');
INSERT INTO `user` VALUES ('13', 'aaa', '11111', '男', '18', '2020-02-11');
