/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : order_form

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-03-09 15:27:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `parent_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('5', '宇通公司', 'ytgs', '0');
INSERT INTO `dept` VALUES ('6', '生产科', 'sck', '5');
INSERT INTO `dept` VALUES ('7', '东郊项目部', 'djxmb', '5');
INSERT INTO `dept` VALUES ('8', '朝阳项目部', 'cyxmb', '5');
INSERT INTO `dept` VALUES ('9', '施工单位', 'sgdw', '0');
INSERT INTO `dept` VALUES ('10', '施工单位01', 'sgdw01', '9');
INSERT INTO `dept` VALUES ('11', '施工单位02', 'sgdw02', '9');

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_name` varchar(100) DEFAULT NULL,
  `dict_code` varchar(100) DEFAULT NULL,
  `dict_mark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', '工号类别', 'GHLB', '工号类别');
INSERT INTO `dictionary` VALUES ('2', '工程来源', 'GCLY', '工程来源');
INSERT INTO `dictionary` VALUES ('3', '工程类别', 'GCLB', '工程类别');
INSERT INTO `dictionary` VALUES ('6', '工程性质', 'GCXZ', '工程性质');
INSERT INTO `dictionary` VALUES ('7', '工程地区', 'GCDQ', '工程所在地');
INSERT INTO `dictionary` VALUES ('8', '道路权属', 'DLQS', '道路权属');
INSERT INTO `dictionary` VALUES ('9', '期次', 'QC', '期次');
INSERT INTO `dictionary` VALUES ('11', '路管情况', 'LGQK', '路管情况');
INSERT INTO `dictionary` VALUES ('12', '施工单位', 'SGDW', '施工单位');
INSERT INTO `dictionary` VALUES ('14', '编号性质', 'BHXZ', '编号性质');

-- ----------------------------
-- Table structure for dictionarydata
-- ----------------------------
DROP TABLE IF EXISTS `dictionarydata`;
CREATE TABLE `dictionarydata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictdata_name` varchar(100) DEFAULT NULL,
  `dictdata_code` varchar(100) DEFAULT NULL,
  `dictdata_mark` varchar(200) DEFAULT NULL,
  `dict_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionarydata
-- ----------------------------
INSERT INTO `dictionarydata` VALUES ('1', '安装工程', 'AZGC', '安装工程', '1', '0');
INSERT INTO `dictionarydata` VALUES ('2', '消隐工程', 'XYGC', '消隐工程', '1', '0');
INSERT INTO `dictionarydata` VALUES ('3', '管改工程', 'GGGC', '管改工程', '1', '0');
INSERT INTO `dictionarydata` VALUES ('6', '地铁', 'DT', '地铁', '6', '0');
INSERT INTO `dictionarydata` VALUES ('7', '自备井', 'ZBJ', '自备井', '6', '0');
INSERT INTO `dictionarydata` VALUES ('8', '临时水', 'LSS', '临时水', '6', '0');
INSERT INTO `dictionarydata` VALUES ('9', '东城区', 'DCQ', '东城区', '7', '0');
INSERT INTO `dictionarydata` VALUES ('10', '西城区', 'XCQ', '西城区', '7', '0');
INSERT INTO `dictionarydata` VALUES ('11', '海淀区', 'HDQ', '海淀区', '7', '0');
INSERT INTO `dictionarydata` VALUES ('12', '朝阳区', 'CYQ', '朝阳区', '7', '0');
INSERT INTO `dictionarydata` VALUES ('13', '单独小区路', 'DDXQL', '单独小区路', '8', '0');
INSERT INTO `dictionarydata` VALUES ('14', '单独区属路', 'DDQSL', '单独区属路', '8', '0');
INSERT INTO `dictionarydata` VALUES ('15', '单独市属路', 'DDSSL', '单独市属路', '8', '0');
INSERT INTO `dictionarydata` VALUES ('16', '部分区属路', 'BFQSL', '部分区属路', '8', '0');
INSERT INTO `dictionarydata` VALUES ('17', '部分市属路', 'BFSSL', '部分市属路', '8', '0');
INSERT INTO `dictionarydata` VALUES ('18', '基建', 'JJ', '基建', '2', '1');
INSERT INTO `dictionarydata` VALUES ('19', '管网', 'GW', '管网', '2', '1');
INSERT INTO `dictionarydata` VALUES ('21', '集团', 'JT', '集团', '2', '1');
INSERT INTO `dictionarydata` VALUES ('22', '大干线', 'DGX', '大干线', '3', '22');
INSERT INTO `dictionarydata` VALUES ('23', '东城', 'DC', '东城', '9', '0');
INSERT INTO `dictionarydata` VALUES ('24', '西城', 'XC', '西城', '9', '0');
INSERT INTO `dictionarydata` VALUES ('25', '原路由原管径2', 'YLUYGJ', '原路由原管径', '11', '0');
INSERT INTO `dictionarydata` VALUES ('26', '原路由新管径', 'YLYXGJ', '原路由新管径', '11', '0');
INSERT INTO `dictionarydata` VALUES ('27', '自寻', 'ZX', '自寻', '2', '1');
INSERT INTO `dictionarydata` VALUES ('28', '小口径', 'xkj', '小口径', '3', '21');
INSERT INTO `dictionarydata` VALUES ('29', '大口径', 'dkj', '大口径', '3', '19');
INSERT INTO `dictionarydata` VALUES ('31', '施工单位1', 'sgdw01', '施工单位1', '12', '0');
INSERT INTO `dictionarydata` VALUES ('32', '施工单位2', 'sgdw02', '施工单位2', '12', '0');
INSERT INTO `dictionarydata` VALUES ('33', '安装工程', 'azgc', '安装工程', '3', '18');
INSERT INTO `dictionarydata` VALUES ('34', '消隐', 'XY', '消隐', '2', '2');
INSERT INTO `dictionarydata` VALUES ('36', '补号', 'BH', '补号', '14', '0');
INSERT INTO `dictionarydata` VALUES ('37', '原号', 'YH', '原号', '14', '0');
INSERT INTO `dictionarydata` VALUES ('38', '34344334', '433443', '', '3', '0');

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `resUrl` varchar(255) DEFAULT NULL COMMENT '资源url',
  `type` int(11) DEFAULT NULL COMMENT '资源类型   1:菜单    2：按钮',
  `parentId` int(11) DEFAULT NULL COMMENT '父资源',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `iconCls` varchar(100) DEFAULT NULL,
  `but_fun` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('1', '系统设置', '', '1', '0', '10', null, null);
INSERT INTO `resources` VALUES ('2', '用户管理', '/page/users', '1', '1', '20', null, null);
INSERT INTO `resources` VALUES ('3', '角色管理', '/page/roles', '1', '1', '30', null, null);
INSERT INTO `resources` VALUES ('4', '菜单管理', '/page/resources', '1', '1', '40', null, null);
INSERT INTO `resources` VALUES ('5', '添加用户', '/users/add', '2', '2', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('6', '删除用户', '/users/delete', '2', '2', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('7', '添加角色', '/roles/add', '2', '3', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('8', '删除角色', '/roles/delete', '2', '3', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('9', '添加资源', '/resources/add', '2', '4', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('10', '删除资源', '/resources/delete', '2', '4', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('13', '分配权限', '/roles/saveRoleResources', '2', '3', '4', null, 'saveRoleResources()');
INSERT INTO `resources` VALUES ('14', '修改资源', '/resources/edit', '2', '4', '3', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('15', '修改角色', '/roles/edit', '2', '3', '3', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('16', '添加部门', '/dept/add', '2', '55', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('17', '删除部门', '/dept/delete', '2', '55', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('18', '修改部门', '/dept/edit', '2', '55', '3', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('19', '资源管理', '/page/buttons', '1', '1', '50', null, null);
INSERT INTO `resources` VALUES ('55', '部门管理', '/page/depts', '1', '1', '10', null, null);
INSERT INTO `resources` VALUES ('56', '修改用户', '/users/edit', '2', '2', '3', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('57', '停用', '/users/off', '2', '2', '4', 'icon-off-new', 'off()');
INSERT INTO `resources` VALUES ('58', '启用', '/users/on', '2', '2', '5', 'icon-on-new', 'on()');
INSERT INTO `resources` VALUES ('59', '添加按钮', '/buttons/add', '2', '19', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('60', '修改按钮', '/buttons/edit', '2', '19', '2', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('61', '删除按钮', '/buttons/delete', '2', '19', '3', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('65', '基础数据', '', '1', '0', '70', null, null);
INSERT INTO `resources` VALUES ('66', '基础数据管理', '/page/dicts', '1', '65', '11', null, null);
INSERT INTO `resources` VALUES ('67', '基础数据维护', '/page/dictdatas', '1', '65', '12', null, null);
INSERT INTO `resources` VALUES ('68', '添加类别', '/dict/add', '2', '66', '10', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('69', '删除类别', '/dict/delete', '2', '66', '11', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('70', '修改类别', '/dict/edit', '2', '66', '12', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('72', '添加数据', '/dictdata/add', '2', '67', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('73', '删除数据', '/dictdata/delete', '2', '67', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('74', '修改数据', '/dictdata/edit', '2', '67', '3', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('75', '生产科管理', '', '1', '0', '80', null, null);
INSERT INTO `resources` VALUES ('76', '项目信息', '/page/produces', '1', '75', '10', null, null);
INSERT INTO `resources` VALUES ('77', '项目管理', '', '1', '0', '90', null, null);
INSERT INTO `resources` VALUES ('78', '项目施工过程管理', '/page/roadworks', '1', '77', '10', null, null);
INSERT INTO `resources` VALUES ('79', '添加数据', '/roadworks/add', '2', '78', '10', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('80', '添加数据', '/produces/add', '2', '76', '10', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('81', '修改数据', '/roadworks/edit', '2', '78', '11', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('82', '删除数据', '/produces/delete', '2', '76', '11', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('83', '修改数据', '/produces/edit', '2', '76', '12', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('84', '删除数据', '/roadworks/delete', '2', '78', '12', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('85', '每日工作量', '/page/workdailys', '1', '77', '90', null, null);
INSERT INTO `resources` VALUES ('86', '添加数据', '/workdailys/add', '2', '85', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('87', '删除数据', '/workdailys/delete', '2', '85', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('88', '修改数据', '/workdailys/edit', '2', '85', '3', 'icon-edit-new', 'edit()');
INSERT INTO `resources` VALUES ('89', '施工单位管理', '/page/constructions', '1', '77', '20', null, null);
INSERT INTO `resources` VALUES ('90', '添加数据', '/constructions/add', '2', '89', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('91', '删除数据', '/constructions/delete', '2', '89', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('92', '修改数据', '/constructions/edit', '2', '89', '3', 'icon-edit-new', 'edit()');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '普通用户');
INSERT INTO `role` VALUES ('3', '超级管理员');
INSERT INTO `role` VALUES ('4', '管理部门');
INSERT INTO `role` VALUES ('7', '部门经理11');
INSERT INTO `role` VALUES ('8', '生产科录入人员');
INSERT INTO `role` VALUES ('9', '项目部录入人员');

-- ----------------------------
-- Table structure for role_resources
-- ----------------------------
DROP TABLE IF EXISTS `role_resources`;
CREATE TABLE `role_resources` (
  `roleId` int(11) NOT NULL,
  `resourcesId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`resourcesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resources
-- ----------------------------
INSERT INTO `role_resources` VALUES ('1', '1');
INSERT INTO `role_resources` VALUES ('1', '2');
INSERT INTO `role_resources` VALUES ('1', '3');
INSERT INTO `role_resources` VALUES ('1', '4');
INSERT INTO `role_resources` VALUES ('1', '5');
INSERT INTO `role_resources` VALUES ('1', '6');
INSERT INTO `role_resources` VALUES ('1', '7');
INSERT INTO `role_resources` VALUES ('1', '8');
INSERT INTO `role_resources` VALUES ('1', '9');
INSERT INTO `role_resources` VALUES ('1', '10');
INSERT INTO `role_resources` VALUES ('1', '13');
INSERT INTO `role_resources` VALUES ('1', '14');
INSERT INTO `role_resources` VALUES ('1', '15');
INSERT INTO `role_resources` VALUES ('1', '16');
INSERT INTO `role_resources` VALUES ('1', '17');
INSERT INTO `role_resources` VALUES ('1', '18');
INSERT INTO `role_resources` VALUES ('1', '19');
INSERT INTO `role_resources` VALUES ('1', '55');
INSERT INTO `role_resources` VALUES ('1', '56');
INSERT INTO `role_resources` VALUES ('1', '57');
INSERT INTO `role_resources` VALUES ('1', '58');
INSERT INTO `role_resources` VALUES ('1', '59');
INSERT INTO `role_resources` VALUES ('1', '60');
INSERT INTO `role_resources` VALUES ('1', '61');
INSERT INTO `role_resources` VALUES ('1', '65');
INSERT INTO `role_resources` VALUES ('1', '66');
INSERT INTO `role_resources` VALUES ('1', '67');
INSERT INTO `role_resources` VALUES ('1', '68');
INSERT INTO `role_resources` VALUES ('1', '69');
INSERT INTO `role_resources` VALUES ('1', '70');
INSERT INTO `role_resources` VALUES ('1', '72');
INSERT INTO `role_resources` VALUES ('1', '73');
INSERT INTO `role_resources` VALUES ('1', '74');
INSERT INTO `role_resources` VALUES ('1', '75');
INSERT INTO `role_resources` VALUES ('1', '76');
INSERT INTO `role_resources` VALUES ('1', '77');
INSERT INTO `role_resources` VALUES ('1', '78');
INSERT INTO `role_resources` VALUES ('1', '79');
INSERT INTO `role_resources` VALUES ('1', '80');
INSERT INTO `role_resources` VALUES ('1', '81');
INSERT INTO `role_resources` VALUES ('1', '82');
INSERT INTO `role_resources` VALUES ('1', '83');
INSERT INTO `role_resources` VALUES ('1', '84');
INSERT INTO `role_resources` VALUES ('1', '85');
INSERT INTO `role_resources` VALUES ('1', '86');
INSERT INTO `role_resources` VALUES ('1', '87');
INSERT INTO `role_resources` VALUES ('1', '88');
INSERT INTO `role_resources` VALUES ('1', '89');
INSERT INTO `role_resources` VALUES ('1', '90');
INSERT INTO `role_resources` VALUES ('1', '91');
INSERT INTO `role_resources` VALUES ('1', '92');
INSERT INTO `role_resources` VALUES ('2', '77');
INSERT INTO `role_resources` VALUES ('2', '78');
INSERT INTO `role_resources` VALUES ('2', '79');
INSERT INTO `role_resources` VALUES ('2', '81');
INSERT INTO `role_resources` VALUES ('2', '84');
INSERT INTO `role_resources` VALUES ('2', '85');
INSERT INTO `role_resources` VALUES ('2', '86');
INSERT INTO `role_resources` VALUES ('2', '87');
INSERT INTO `role_resources` VALUES ('2', '88');
INSERT INTO `role_resources` VALUES ('3', '2');
INSERT INTO `role_resources` VALUES ('3', '3');
INSERT INTO `role_resources` VALUES ('3', '4');
INSERT INTO `role_resources` VALUES ('3', '5');
INSERT INTO `role_resources` VALUES ('3', '7');
INSERT INTO `role_resources` VALUES ('3', '8');
INSERT INTO `role_resources` VALUES ('3', '9');
INSERT INTO `role_resources` VALUES ('3', '10');
INSERT INTO `role_resources` VALUES ('4', '1');
INSERT INTO `role_resources` VALUES ('4', '4');
INSERT INTO `role_resources` VALUES ('4', '9');
INSERT INTO `role_resources` VALUES ('4', '10');
INSERT INTO `role_resources` VALUES ('7', '1');
INSERT INTO `role_resources` VALUES ('7', '2');
INSERT INTO `role_resources` VALUES ('7', '3');
INSERT INTO `role_resources` VALUES ('7', '4');
INSERT INTO `role_resources` VALUES ('7', '5');
INSERT INTO `role_resources` VALUES ('7', '6');
INSERT INTO `role_resources` VALUES ('7', '7');
INSERT INTO `role_resources` VALUES ('7', '8');
INSERT INTO `role_resources` VALUES ('7', '9');
INSERT INTO `role_resources` VALUES ('7', '10');
INSERT INTO `role_resources` VALUES ('7', '11');
INSERT INTO `role_resources` VALUES ('7', '13');
INSERT INTO `role_resources` VALUES ('7', '14');
INSERT INTO `role_resources` VALUES ('7', '15');
INSERT INTO `role_resources` VALUES ('7', '16');
INSERT INTO `role_resources` VALUES ('7', '17');
INSERT INTO `role_resources` VALUES ('7', '18');
INSERT INTO `role_resources` VALUES ('7', '55');
INSERT INTO `role_resources` VALUES ('8', '75');
INSERT INTO `role_resources` VALUES ('8', '76');
INSERT INTO `role_resources` VALUES ('8', '80');
INSERT INTO `role_resources` VALUES ('8', '82');
INSERT INTO `role_resources` VALUES ('8', '83');
INSERT INTO `role_resources` VALUES ('9', '77');
INSERT INTO `role_resources` VALUES ('9', '78');
INSERT INTO `role_resources` VALUES ('9', '79');
INSERT INTO `role_resources` VALUES ('9', '81');
INSERT INTO `role_resources` VALUES ('9', '84');
INSERT INTO `role_resources` VALUES ('9', '85');
INSERT INTO `role_resources` VALUES ('9', '86');
INSERT INTO `role_resources` VALUES ('9', '87');
INSERT INTO `role_resources` VALUES ('9', '88');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(33) DEFAULT NULL,
  `password` varchar(33) DEFAULT NULL,
  `enable` int(10) DEFAULT '1' COMMENT '是否启用',
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', '1', '管理员', '北京', '管理员', '1', '15510505500');
INSERT INTO `user` VALUES ('3', 'user2', '121', '1', 'lwb1', '', '', '3', '15810267343');
INSERT INTO `user` VALUES ('4', 'user3', 'user3', '1', 'lwb2', '', '', '4', '15810267343');
INSERT INTO `user` VALUES ('5', 'user4', 'user4', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('8', 'user7', 'user7', '1', null, null, null, '1', null);
INSERT INTO `user` VALUES ('26', 'lwb1', '56d7d4c0ec5c9defdac4b2c13ee6d3d4', '1', 'lwb1', '', '', '6', '15810267343');
INSERT INTO `user` VALUES ('27', 'lwb2', '207457aac2d42075f777e5e9f41e4651', '1', 'lwb2', '', '', '7', '15810267343');
INSERT INTO `user` VALUES ('28', 'lwb3', '950c6a12c370851bc5725d2b816dfe50', '1', 'lwb3', '', '', '8', '15810267343');
INSERT INTO `user` VALUES ('29', 'admini', 'a3c1fd626ed9bb594a2d987d8b8a33b8', '1', 'admini', '', '', '5', '15810267343');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('1', '2');
INSERT INTO `user_role` VALUES ('1', '3');
INSERT INTO `user_role` VALUES ('1', '4');
INSERT INTO `user_role` VALUES ('1', '7');
INSERT INTO `user_role` VALUES ('4', '9');
INSERT INTO `user_role` VALUES ('3', '9');
INSERT INTO `user_role` VALUES ('26', '8');
INSERT INTO `user_role` VALUES ('27', '9');
INSERT INTO `user_role` VALUES ('28', '9');
INSERT INTO `user_role` VALUES ('29', '1');