/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2019-05-25 17:30:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `base_dict`
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_dict
-- ----------------------------
INSERT INTO `base_dict` VALUES ('1', '001', '客户行业', '教育培训 ', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('10', '003', '公司性质', '民企', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('12', '004', '年营业额', '1-10万', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('13', '004', '年营业额', '10-20万', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('14', '004', '年营业额', '20-50万', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('15', '004', '年营业额', '50-100万', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('16', '004', '年营业额', '100-500万', null, '5', '1', null);
INSERT INTO `base_dict` VALUES ('17', '004', '年营业额', '500-1000万', null, '6', '1', null);
INSERT INTO `base_dict` VALUES ('18', '005', '客户状态', '基础客户', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('19', '005', '客户状态', '潜在客户', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('2', '001', '客户行业', '电子商务', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('20', '005', '客户状态', '成功客户', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('21', '005', '客户状态', '无效客户', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('22', '006', '客户级别', '普通客户', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('23', '006', '客户级别', 'VIP客户', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('24', '007', '商机状态', '意向客户', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('25', '007', '商机状态', '初步沟通', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('26', '007', '商机状态', '深度沟通', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('27', '007', '商机状态', '签订合同', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('3', '001', '客户行业', '对外贸易', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('30', '008', '商机类型', '新业务', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('31', '008', '商机类型', '现有业务', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('32', '009', '商机来源', '电话营销', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('33', '009', '商机来源', '网络营销', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('34', '009', '商机来源', '推广活动', null, '3', '1', null);
INSERT INTO `base_dict` VALUES ('4', '001', '客户行业', '酒店旅游', null, '4', '1', null);
INSERT INTO `base_dict` VALUES ('5', '001', '客户行业', '房地产', null, '5', '1', null);
INSERT INTO `base_dict` VALUES ('6', '002', '客户信息来源', '电话营销', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('7', '002', '客户信息来源', '网络营销', null, '2', '1', null);
INSERT INTO `base_dict` VALUES ('8', '003', '公司性质', '合资', null, '1', '1', null);
INSERT INTO `base_dict` VALUES ('9', '003', '公司性质', '国企', null, '2', '1', null);

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_user_id` int(11) DEFAULT NULL,
  `cust_create_id` int(11) DEFAULT NULL,
  `cust_source` varchar(255) DEFAULT NULL,
  `cust_industry` varchar(255) DEFAULT NULL,
  `cust_level` varchar(255) DEFAULT NULL,
  `cust_linkman` varchar(255) DEFAULT NULL,
  `cust_phone` varchar(255) DEFAULT NULL,
  `cust_mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  KEY `FKryraye53oqj8fltbtpc7267o1` (`cust_source`),
  KEY `FKlqvnfmgrp4fwpfff5kf60qqxn` (`cust_industry`),
  KEY `FK6ebbnoft0i6yjbkqbs27kq3t3` (`cust_level`),
  CONSTRAINT `FK6ebbnoft0i6yjbkqbs27kq3t3` FOREIGN KEY (`cust_level`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `FKlqvnfmgrp4fwpfff5kf60qqxn` FOREIGN KEY (`cust_industry`) REFERENCES `base_dict` (`dict_id`),
  CONSTRAINT `FKryraye53oqj8fltbtpc7267o1` FOREIGN KEY (`cust_source`) REFERENCES `base_dict` (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '百度', null, null, '1', '6', '23', '李彦宏', '110110110110', '120120120120');
INSERT INTO `customer` VALUES ('2', '腾讯', null, null, '2', '6', '23', '马化腾', '5237453', '1234');
INSERT INTO `customer` VALUES ('3', '阿里巴巴', null, null, '2', '7', '22', '马云', '12435345', '23452345');
INSERT INTO `customer` VALUES ('4', '滴滴', null, null, '3', '6', '22', '李二', '7777', '77777');
INSERT INTO `customer` VALUES ('5', 'CSDN', null, null, '1', '6', '22', '王五', '5555', '55555');
INSERT INTO `customer` VALUES ('6', '字节跳动', null, null, '1', '6', '22', '张三', '2342342', '2342342');
INSERT INTO `customer` VALUES ('7', 'Google', null, null, '5', '6', '23', '李四', '65656', '565656');
INSERT INTO `customer` VALUES ('8', '哔哩哔哩', null, null, '4', '6', '22', '赵六', '4774', '7474747');
INSERT INTO `customer` VALUES ('9', '网易', null, null, '3', '6', '23', '钱七', '3333', '3333');
INSERT INTO `customer` VALUES ('10', '美团', null, null, '1', '6', '22', '熊大', '7777', '777777');
INSERT INTO `customer` VALUES ('11', '今日头条', null, null, '4', '7', '23', null, '565789', '99999');
INSERT INTO `customer` VALUES ('12', '58同城', null, null, '4', '7', '23', null, '232323', '232323');
INSERT INTO `customer` VALUES ('13', '工商银行', null, null, '5', '6', '23', null, '333322', '33323232');
INSERT INTO `customer` VALUES ('14', '聚思鸿', null, null, '2', '6', '22', null, '74825', '74852');
INSERT INTO `customer` VALUES ('15', '招商银行', null, null, '2', '7', '23', null, '4564564', '56456456');
INSERT INTO `customer` VALUES ('16', '中国移动', null, null, '1', '6', '22', null, '656565', '565656565');
INSERT INTO `customer` VALUES ('17', '360安全', null, null, '2', '7', '22', null, '545454', '5454545');
INSERT INTO `customer` VALUES ('18', '广州交通', null, null, '1', '6', '22', null, '1234234', '234234');
INSERT INTO `customer` VALUES ('19', '实地集团', null, null, '3', '6', '22', null, '2342342', '2342342');
INSERT INTO `customer` VALUES ('20', 'IBM', null, null, '4', '7', '23', null, '432545', '23452345');
INSERT INTO `customer` VALUES ('21', '美银', null, null, '1', '6', '22', null, '345234', '234523');
INSERT INTO `customer` VALUES ('22', '拼多多', null, null, '2', '7', '22', null, '7777', '2342342');
INSERT INTO `customer` VALUES ('23', '小米', null, null, '1', '6', '22', null, '55555', '55555555');
INSERT INTO `customer` VALUES ('24', 'vivo', null, null, '2', '7', '23', null, '78456', '784564');
INSERT INTO `customer` VALUES ('25', '华为', null, null, '3', '7', '23', null, '23452345234', '523452345');
INSERT INTO `customer` VALUES ('26', '新浪', null, null, '1', '7', '23', null, '34534', '345345');
INSERT INTO `customer` VALUES ('27', '爱奇艺', null, null, '1', '6', '22', null, '23452345234', '4545453');
INSERT INTO `customer` VALUES ('28', '高德地图', null, null, '5', '7', '23', null, '555454', '335453');
INSERT INTO `customer` VALUES ('29', '百词斩', null, null, '1', '6', '22', null, '88888', '8888');
INSERT INTO `customer` VALUES ('30', '搜狗', null, null, '1', '6', '22', null, '234234242', '34234234');
INSERT INTO `customer` VALUES ('31', 'FaceBook', null, null, '1', '7', '23', null, '11111', '11111111');
INSERT INTO `customer` VALUES ('32', 'YouTube', null, null, '1', '6', '22', null, '5555555', '443534534');
INSERT INTO `customer` VALUES ('33', 'Twitter', null, null, '1', '6', '22', null, '2341234231', '45324523452');
INSERT INTO `customer` VALUES ('35', '魅族', null, null, '2', '7', '23', 'Luna', '2342342', '120120120120');
INSERT INTO `customer` VALUES ('36', '阿里巴巴', null, null, '1', '6', '22', 'Luna1', '2342342', '1234');
INSERT INTO `customer` VALUES ('37', 'fireFox', null, null, '1', '6', '22', 'ttry', '12341234', '12341234');
INSERT INTO `customer` VALUES ('38', '金山词霸', null, null, '1', '6', '22', '阿大', '3456', '3456');

-- ----------------------------
-- Table structure for `linkman`
-- ----------------------------
DROP TABLE IF EXISTS `linkman`;
CREATE TABLE `linkman` (
  `lkm_id` int(11) NOT NULL AUTO_INCREMENT,
  `lkm_name` varchar(255) DEFAULT NULL,
  `lkm_gender` char(1) DEFAULT NULL,
  `lkm_phone` varchar(255) DEFAULT NULL,
  `lkm_mobile` varchar(255) DEFAULT NULL,
  `lkm_email` varchar(255) DEFAULT NULL,
  `lkm_qq` varchar(255) DEFAULT NULL,
  `lkm_position` varchar(255) DEFAULT NULL,
  `lkm_memo` varchar(255) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`lkm_id`),
  KEY `FKt5xpfg9ceoa77nkddv6on7rm` (`cust_id`),
  CONSTRAINT `FKt5xpfg9ceoa77nkddv6on7rm` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linkman
-- ----------------------------
INSERT INTO `linkman` VALUES ('3', '王大', '0', '010101', '101010', null, null, null, null, '3');
INSERT INTO `linkman` VALUES ('4', '熊二', '1', '123412342', '12341234122', null, null, null, null, '25');
INSERT INTO `linkman` VALUES ('5', '王五', '1', '111111', '1111111', null, null, null, null, '1');
INSERT INTO `linkman` VALUES ('6', 'tom', '1', '12341234', '12341234', null, null, null, null, '23');
INSERT INTO `linkman` VALUES ('7', 'jack', '0', '456784', '157564151', null, null, null, null, '2');
INSERT INTO `linkman` VALUES ('8', 'jerry', '0', '48799', '1234897', null, null, null, null, '3');
INSERT INTO `linkman` VALUES ('9', '张三', '1', '7894564', '4545618454', null, null, null, null, '2');
INSERT INTO `linkman` VALUES ('10', '李四', '1', '453453', '789789', null, null, null, null, '4');
INSERT INTO `linkman` VALUES ('11', 'rose', '0', '243578678', '789789', null, null, null, null, '5');
INSERT INTO `linkman` VALUES ('12', 'mark', '1', '3454', '0217485', null, null, null, null, '5');
INSERT INTO `linkman` VALUES ('13', '李二', '0', '2345345', '7845210', null, null, null, null, '4');
INSERT INTO `linkman` VALUES ('14', '熊大', '0', '4523453453', '7485210', null, null, null, null, '7');
INSERT INTO `linkman` VALUES ('15', '光头强', '0', '43453453', '1741852', null, null, null, null, '7');
INSERT INTO `linkman` VALUES ('16', '阿狸', '1', '45345345', '748512875', null, null, null, null, '7');
INSERT INTO `linkman` VALUES ('17', '路费', '1', '5378452', '741741852', null, null, null, null, '8');
INSERT INTO `linkman` VALUES ('18', '江艾', '1', '45025174', '74851207', null, null, null, null, '8');
INSERT INTO `linkman` VALUES ('19', '吴珊珊', '0', '378452', '748562140', null, null, null, null, '21');
INSERT INTO `linkman` VALUES ('20', '刘三', '0', '453453453', '7452', null, null, null, null, '22');
INSERT INTO `linkman` VALUES ('21', '王麻子', '1', '3453453', '4185263', null, null, null, null, '22');
INSERT INTO `linkman` VALUES ('22', '老王', '0', '453', '410527', null, null, null, null, '11');
INSERT INTO `linkman` VALUES ('23', '老李', '1', '34453453', '453241', null, null, null, null, '19');
INSERT INTO `linkman` VALUES ('24', '老大', '1', '53453453', '785242', null, null, null, null, '19');
INSERT INTO `linkman` VALUES ('25', '老二', '0', '3453', '452785678', null, null, null, null, '1');
INSERT INTO `linkman` VALUES ('27', '樊哙', '0', '4789789', '756786', null, null, null, null, '2');
INSERT INTO `linkman` VALUES ('28', '刘备', '0', '5345345', '41425', null, null, null, null, '1');
INSERT INTO `linkman` VALUES ('29', '柳白', '1', '78978978', '86786', null, null, null, null, '3');
INSERT INTO `linkman` VALUES ('30', '王四', '0', '789789', '7555785785', null, null, null, null, '3');
INSERT INTO `linkman` VALUES ('31', '张撒', '1', '789789', '777857857', null, null, null, null, '3');
INSERT INTO `linkman` VALUES ('32', '钱史', '1', '789789', '8689', null, null, null, null, '3');
INSERT INTO `linkman` VALUES ('33', '云快', '0', '789789', '7567527', null, null, null, null, '4');
INSERT INTO `linkman` VALUES ('34', '叶球', '0', '789', '17415272', null, null, null, null, '4');
INSERT INTO `linkman` VALUES ('35', '吴进', '0', '78978', '7572742', null, null, null, null, '4');

-- ----------------------------
-- Table structure for `sale_visit`
-- ----------------------------
DROP TABLE IF EXISTS `sale_visit`;
CREATE TABLE `sale_visit` (
  `visit_id` varchar(255) NOT NULL,
  `visit_time` datetime DEFAULT NULL,
  `visit_interviewee` varchar(255) DEFAULT NULL,
  `visit_addr` varchar(255) DEFAULT NULL,
  `visit_detail` varchar(255) DEFAULT NULL,
  `visit_nexttime` datetime DEFAULT NULL,
  `visit_cust_id` int(11) DEFAULT NULL,
  `visit_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`visit_id`),
  KEY `FKh01ylhow7ppkqvt55hoisa4ku` (`visit_cust_id`),
  KEY `FK1ndldk9dhlv7xqyftts1vf3do` (`visit_user_id`),
  CONSTRAINT `FK1ndldk9dhlv7xqyftts1vf3do` FOREIGN KEY (`visit_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKh01ylhow7ppkqvt55hoisa4ku` FOREIGN KEY (`visit_cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_visit
-- ----------------------------
INSERT INTO `sale_visit` VALUES ('402897816aedc120016aedc91e110000', '2019-05-01 00:00:00', '李阳', '纽约', '没见到人就被赶了出来', '2029-05-30 00:00:00', '20', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aede949e00000', '2019-05-08 00:00:00', '马化腾', '腾讯总部', '谈个200亿的生意', '2019-05-29 00:00:00', '2', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aede9caee0001', '2019-05-01 00:00:00', '马云', '新余', '谈个200亿的生意', '2019-05-14 00:00:00', '3', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aedea6fda0002', '2019-05-01 00:00:00', '李四', '北京', '只喝杯茶了', '2019-05-09 00:00:00', '6', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aedeb061d0003', '2019-05-01 00:00:00', '张三', '二次元世界', '一起看了部动漫', '2019-05-23 00:00:00', '8', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aedebe2ea0004', '2019-05-10 00:00:00', '马化腾', '冰岛', '谈个200亿的生意', '2019-05-30 00:00:00', '3', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aedec33420005', '2019-05-21 00:00:00', '老李', '冰岛', '没见到人就被赶了出来', '2019-05-09 00:00:00', '2', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aedec9a1b0006', '2019-04-02 00:00:00', '老钱', '上海', '谈个200亿的生意', '2019-06-13 00:00:00', '24', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aeded2be50007', '2019-05-01 00:00:00', '王浮', '深圳', '谈个200亿的生意', '2019-05-31 00:00:00', '28', '1');
INSERT INTO `sale_visit` VALUES ('402897816aeddc1e016aedededf40008', '2019-03-05 00:00:00', '雷军', '西安', '把小米收购了', '2019-05-02 00:00:00', '23', '1');
INSERT INTO `sale_visit` VALUES ('402897816aedfb0b016aee0647b50000', '2019-01-07 00:00:00', '老王', '杭州', '收购了CSDN', '2019-06-28 00:00:00', '5', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `codeName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'tom', '汤姆', '1234');
INSERT INTO `user` VALUES ('2', 'rose', '肉丝', '1234');
INSERT INTO `user` VALUES ('3', 'jack', '杰克', '1234');
INSERT INTO `user` VALUES ('7', 'lily', '丽丽', '4321');
INSERT INTO `user` VALUES ('8', 'lisi', '李四', '156753');
INSERT INTO `user` VALUES ('9', 'jerry', '杰瑞', '4444');
INSERT INTO `user` VALUES ('10', 'dfg', '张三', '1234');
INSERT INTO `user` VALUES ('11', 'rhr', '王五', '1234');
INSERT INTO `user` VALUES ('12', 'wedg', '赵六', '123');
INSERT INTO `user` VALUES ('13', 'wehdf', '钱七', 'wert423');
INSERT INTO `user` VALUES ('14', 'yerhe', '卢八', '56');
INSERT INTO `user` VALUES ('15', 'dgeye', '唐九', '5');
INSERT INTO `user` VALUES ('16', 'eggdse', '邓十一', '23');
INSERT INTO `user` VALUES ('17', 'small', '小草', '77777');
INSERT INTO `user` VALUES ('18', 'hedsw', '徐十二', '2345');
INSERT INTO `user` VALUES ('19', 'a', '李白', 'asd');
INSERT INTO `user` VALUES ('20', 'lide', '张三凤', '26456');
INSERT INTO `user` VALUES ('21', 'bigye', '大爷', '456789234');
INSERT INTO `user` VALUES ('22', 'wang', '卢爷', '2345');
INSERT INTO `user` VALUES ('23', 'jary', '卢蛋', '2345');
INSERT INTO `user` VALUES ('24', 'hery', '卢大蛋', '346');
INSERT INTO `user` VALUES ('25', 'perty', '卢二蛋', '5426');
INSERT INTO `user` VALUES ('26', 'uida', '卢蛋蛋', '1234');
INSERT INTO `user` VALUES ('27', 'lala', 'wangba', '123456789');
INSERT INTO `user` VALUES ('28', 'lalaa', '斗罗大陆', '12');
INSERT INTO `user` VALUES ('29', 'qq', 'qq', 'qq');
INSERT INTO `user` VALUES ('30', 'a', 'asdf', 'a');
INSERT INTO `user` VALUES ('31', 'b', 'b', 'b');
INSERT INTO `user` VALUES ('32', 'v', 'v', 'v');
