/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : order_form

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-03-13 18:49:27
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('16', '系列', 'XL', '系列');
INSERT INTO `dictionary` VALUES ('17', '型号', 'XH', '型号');
INSERT INTO `dictionary` VALUES ('18', '经销商', 'JXS', '经销商');

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionarydata
-- ----------------------------
INSERT INTO `dictionarydata` VALUES ('39', '系列1', 'XL1', '系列1', '16', '0');
INSERT INTO `dictionarydata` VALUES ('40', '系列2', 'XL2', '系列2', '16', '0');
INSERT INTO `dictionarydata` VALUES ('41', '33', '33', '33', '17', '0');
INSERT INTO `dictionarydata` VALUES ('42', '经销商1', 'JXS1', '经销商1', '18', '0');
INSERT INTO `dictionarydata` VALUES ('43', '经销商2', 'JXS2', '经销商2', '18', '0');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_company` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `order_company_phone` varchar(30) DEFAULT NULL COMMENT '公司电话',
  `order_company_fax` varchar(100) DEFAULT NULL COMMENT '公司传真',
  `order_company_website` varchar(100) DEFAULT NULL COMMENT '公司网址',
  `order_date` varchar(30) DEFAULT NULL COMMENT '订货日期',
  `order_price_group` varchar(50) DEFAULT NULL COMMENT '价格组',
  `order_number` varchar(50) DEFAULT NULL COMMENT '客户单号',
  `order_urgent` int(1) DEFAULT NULL COMMENT '是否加急 1是、0否',
  `order_seller` varchar(50) DEFAULT NULL COMMENT '销售员',
  `order_delivery_date` varchar(30) DEFAULT NULL COMMENT '交货日期',
  `order_customer_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `order_contract_number` varchar(50) DEFAULT NULL COMMENT '合同编号',
  `order_ins_date` varchar(30) DEFAULT NULL COMMENT '安装日期',
  `order_customer_phone` varchar(20) DEFAULT NULL COMMENT '客户手机',
  `order_customer_telephone` varchar(20) DEFAULT NULL COMMENT '客户电话',
  `order_tube_date` varchar(30) DEFAULT NULL COMMENT '该管日期',
  `order_address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `order_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `order_additional_amount` double DEFAULT NULL COMMENT '附加金额',
  `order_additional_remark` varchar(255) DEFAULT NULL COMMENT '附加金额说明',
  `order_sales_amount` double DEFAULT NULL COMMENT '销售金额',
  `order_total` double DEFAULT NULL COMMENT '订货总数',
  `order_total_number` double DEFAULT NULL COMMENT '片数合计',
  `order_payment` double DEFAULT NULL COMMENT '付款',
  `order_margin` double DEFAULT NULL COMMENT '保证金',
  `order_total_payment` double DEFAULT NULL COMMENT '应付款总额',
  `order_available_balance` double DEFAULT NULL COMMENT '可用余额',
  `order_credits` double DEFAULT NULL COMMENT '信用额度',
  `order_time` varchar(30) DEFAULT NULL COMMENT '订货时间',
  `order_delivery_time` varchar(30) DEFAULT NULL COMMENT '交货时间',
  `order_status` varchar(20) DEFAULT NULL COMMENT '订单状态',
  `order_review` varchar(255) DEFAULT NULL COMMENT '订单审核人',
  `order_review_time` varchar(30) DEFAULT NULL COMMENT '订单审核时间',
  `order_financial_audit` varchar(255) DEFAULT NULL COMMENT '财务审核人',
  `order_financial_audit_time` varchar(30) DEFAULT NULL COMMENT '财务审核时间',
  `order_single` varchar(255) DEFAULT NULL COMMENT '制单',
  `order_single_time` varchar(30) DEFAULT NULL COMMENT '制单时间',
  `order_dealer` varchar(255) DEFAULT NULL COMMENT '经销商',
  `order_type` int(1) DEFAULT NULL COMMENT '类型 1返货，0退货',
  `order_customer_type` varchar(255) DEFAULT NULL COMMENT '客户分类',
  `order_customer_address` varchar(255) DEFAULT NULL COMMENT '所属区域',
  `order_contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `order_contact_phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `order_contact_fax` varchar(255) DEFAULT NULL COMMENT '联系人传真',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '北京圣火采暖设备有限责任公司订单', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', null, '', null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '42', '0', '', '', '', '', '');
INSERT INTO `orders` VALUES ('2', '北京圣火采暖设备有限责任公司订单', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '背后切勿', '', null, '', null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '42', '0', '', '', '', '', '');
INSERT INTO `orders` VALUES ('3', '北京圣火采暖设备有限责任公司订单', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', null, '', null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '42', '0', '', '', '', '', '');
INSERT INTO `orders` VALUES ('4', '北京圣火采暖设备有限责任公司订单', '1', '1', '1', '2018-03-13 17:35:22', '1', '1', '0', '1', '2018-03-13 17:07:20', '1', '1', '2018-03-13 17:07:22', '1', '1', '2018-03-13 17:07:23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2018-03-13 17:07:37', '2018-03-13 17:07:40', '1', '1', '2018-03-13 17:07:49', '1', '2018-03-13 17:07:47', '1', '2018-03-13 17:07:44', '42', '0', '1', '1', '1', '1', '2');
INSERT INTO `orders` VALUES ('5', '北京圣火采暖设备有限责任公司订单', '1', '3123', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', null, '123', null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '42', '0', '', '', '', '', '3123');
INSERT INTO `orders` VALUES ('6', '北京圣火采暖设备有限责任公司订单1', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', null, '', null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '42', '0', '', '', '', '', '');

-- ----------------------------
-- Table structure for orders_detail
-- ----------------------------
DROP TABLE IF EXISTS `orders_detail`;
CREATE TABLE `orders_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `detail_series` varchar(255) DEFAULT NULL COMMENT '系列',
  `detail_model` varchar(255) DEFAULT NULL COMMENT '型号',
  `detail_number_group` int(11) DEFAULT NULL COMMENT '组数',
  `detail_number` int(11) DEFAULT NULL COMMENT '片数',
  `detail_total_number` int(11) DEFAULT NULL COMMENT '片数小计',
  `detail_room` varchar(255) DEFAULT NULL COMMENT '房间',
  `detail_hight` double DEFAULT NULL COMMENT '高',
  `detail_width` double DEFAULT NULL COMMENT '宽',
  `detail_unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `detail_color` varchar(255) DEFAULT NULL COMMENT '颜色',
  `detail_water_type` varchar(255) DEFAULT NULL COMMENT '进水方式',
  `detail_center_distance` varchar(100) DEFAULT NULL COMMENT '中心距',
  `detail_interface_caliber` varchar(255) DEFAULT NULL COMMENT '接口口径',
  `detail_market_price` double DEFAULT NULL COMMENT '市场单价',
  `detail_market_price_amount` double DEFAULT NULL COMMENT '市场价金额',
  `detail_market_retail_price` double DEFAULT NULL COMMENT '市场零售价',
  `detail_market_retail_price_amount` double DEFAULT NULL COMMENT '市场零售金额',
  `detail_custom_fee` double DEFAULT NULL COMMENT '定制费单价',
  `detail_total_custom_fee` double DEFAULT NULL COMMENT '定制费小计',
  `detail_should_produce` double DEFAULT NULL COMMENT '应生产量',
  `detail_delivery_time` varchar(30) DEFAULT NULL COMMENT '发货时间',
  `detail_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `detail_order_status` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `detail_generated_status` varchar(255) DEFAULT NULL COMMENT '生产状态',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders_detail
-- ----------------------------
INSERT INTO `orders_detail` VALUES ('4', '39', '', null, null, null, '', null, null, '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '1');
INSERT INTO `orders_detail` VALUES ('5', '39', '41', null, null, null, '', null, null, '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '2');
INSERT INTO `orders_detail` VALUES ('6', '39', '41', null, null, null, '', null, null, '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '3');
INSERT INTO `orders_detail` VALUES ('7', '39', '41', '1', '1', '4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '4');
INSERT INTO `orders_detail` VALUES ('8', '40', '41', '3', '3', '4', '3', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '4');
INSERT INTO `orders_detail` VALUES ('9', '40', '41', '4', '4', '4', '4', null, null, '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '4');
INSERT INTO `orders_detail` VALUES ('12', '40', '41', '5', '5', null, '', null, null, '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '4');
INSERT INTO `orders_detail` VALUES ('13', '39', '41', '3', '23', '213', '123', '123', '1', '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '5');
INSERT INTO `orders_detail` VALUES ('14', '39', '41', null, null, null, '', null, null, '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '1');
INSERT INTO `orders_detail` VALUES ('15', '40', '41', null, null, null, '', null, null, '', '', '', '', '', null, null, null, null, null, null, null, '', '', '', '', '6');

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
INSERT INTO `resources` VALUES ('75', '订单管理', '', '1', '0', '80', null, null);
INSERT INTO `resources` VALUES ('76', '订单基本信息', '/page/orders', '1', '75', '1', null, null);
INSERT INTO `resources` VALUES ('77', '添加订单', '/orders/add', '2', '76', '1', 'icon-add-new', 'add()');
INSERT INTO `resources` VALUES ('78', '删除订单', '/orders/delete', '2', '76', '2', 'icon-remove-new', 'remove()');
INSERT INTO `resources` VALUES ('79', '修改订单', '/orders/edit', '2', '76', '3', 'icon-edit-new', 'edit()');

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

-- ----------------------------
-- Function structure for fun_a_dept
-- ----------------------------
DROP FUNCTION IF EXISTS `fun_a_dept`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fun_a_dept`(dept_id int) RETURNS varchar(4000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(4000);
DECLARE sTempChd VARCHAR(4000);

SET sTemp = '$';
SET sTempChd = cast(dept_id as char);

WHILE sTempChd is not NULL DO
SET sTemp = CONCAT(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM dept where FIND_IN_SET(parent_Id,sTempChd)>0;
END WHILE;
return sTemp;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for fun_a_dictdata
-- ----------------------------
DROP FUNCTION IF EXISTS `fun_a_dictdata`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fun_a_dictdata`(ids int) RETURNS varchar(4000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(4000);
DECLARE sTempChd VARCHAR(4000);

SET sTemp = '$';
SET sTempChd = cast(ids as char);

WHILE sTempChd is not NULL DO
SET sTemp = CONCAT(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM dictionarydata where FIND_IN_SET(parent_id,sTempChd)>0;
END WHILE;
return sTemp;
END
;;
DELIMITER ;
