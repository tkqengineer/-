/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : ssm-shiro

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-05-30 22:26:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', 'create:user:add');
INSERT INTO `resource` VALUES ('2', 'create:user:delete');
INSERT INTO `resource` VALUES ('3', 'create:user:update');
INSERT INTO `resource` VALUES ('4', 'create:vip:add');
INSERT INTO `resource` VALUES ('5', 'create:vip:delete');
INSERT INTO `resource` VALUES ('6', 'create:vip:update');

-- ----------------------------
-- Table structure for role_ resource
-- ----------------------------
DROP TABLE IF EXISTS `role_ resource`;
CREATE TABLE `role_ resource` (
  `roleid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_ resource
-- ----------------------------
INSERT INTO `role_ resource` VALUES ('1', '1');
INSERT INTO `role_ resource` VALUES ('1', '2');
INSERT INTO `role_ resource` VALUES ('1', '3');
INSERT INTO `role_ resource` VALUES ('2', '4');
INSERT INTO `role_ resource` VALUES ('2', '5');
INSERT INTO `role_ resource` VALUES ('2', '6');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'admin');
INSERT INTO `roles` VALUES ('2', 'vip');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'alex', '123456');
INSERT INTO `user` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
