/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : bes

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 07/06/2023 17:02:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mine
-- ----------------------------
DROP TABLE IF EXISTS `mine`;
CREATE TABLE `mine`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lon` double(255, 2) NULL DEFAULT NULL,
  `lat` double(255, 2) NULL DEFAULT NULL,
  `products` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mine
-- ----------------------------
INSERT INTO `mine` VALUES (1, 'CZ001', '瑞昌巿武山铜硫矿区', '九江市', '重点开采区', '69.64', 115.40, 29.44, '铜硫', '2022年第2季度产量');
INSERT INTO `mine` VALUES (2, 'CZ002', '九江县城门山铜硫矿区', '九江市', '重点开采区', '26.46', 115.47, 29.40, '铜硫', '2022第二季度产量hh');
INSERT INTO `mine` VALUES (3, 'CZ003', '德兴市铜厂铜矿区富家坞铜钼矿区', '上饶市', '重点开采区', '39.12', 117.43, 28.90, '铜钼', '');
INSERT INTO `mine` VALUES (4, 'CZ004', '德兴市银山九区铜硫矿区', '九江市', '重点开采区', '26.48', 117.35, 28.58, '铜硫', '');
INSERT INTO `mine` VALUES (5, 'CZ005', '德兴市金山金矿区', '九江市', '重点开采区', '45.64', 117.40, 28.58, '金', '');
INSERT INTO `mine` VALUES (6, 'CZ006', '东乡县枫林铜矿区', '抚州市', '重点开采区', '16.72', 116.37, 28.16, '铜', '');
INSERT INTO `mine` VALUES (7, 'CZ007', '铅山县永平铜硫矿区', '上饶市', '重点开采区', '27.38', 115.47, 28.12, '铜', '');
INSERT INTO `mine` VALUES (8, 'CZ008', '贵溪冷水坑银铅锌矿区', '鹰潭市', '重点开采区', '26.34', 117.10, 27.50, '铅锌矿', '');
INSERT INTO `mine` VALUES (9, 'CZ009', '赣中新余式铁矿区', '新余市', '重点开采区', '184.19', 114.44, 27.38, '铁', '');
INSERT INTO `mine` VALUES (10, 'CZ010', '江西崇义县淘锡坑钨矿区', '赣州市', '重点开采区', '112.49', 114.10, 25.41, '钨', '');
INSERT INTO `mine` VALUES (11, 'CZ011', '江西崇义县茅坪钨矿区  ', '赣州市', '重点开采区', '216.35', 114.30, 25.40, '钨', '');
INSERT INTO `mine` VALUES (12, 'CZ012', '宜春市四一四钽铌矿区  ', '宜春市  ', '重点开采区', '18.84', 114.30, 27.39, '钽铌', '');
INSERT INTO `mine` VALUES (13, 'CZ013', ' 鄱阳县金家坞金矿区   ', '上饶市 ', '重点开采区', '30.23', 117.02, 29.25, '金', '');
INSERT INTO `mine` VALUES (14, 'CZ014', '德安县张十八铅锌矿区  ', '九江市', '重点开采区', '9.61', 115.51, 29.23, '铅|锌', '');
INSERT INTO `mine` VALUES (15, 'CZ015', '万年县虎家尖银金矿区  ', '上饶市', '重点开采区', '27.43', 117.02, 28.47, '银|铅|锌', '');
INSERT INTO `mine` VALUES (16, 'CZ016', '横峰县葛源黄山-松树岗铌钽矿区  ', '上饶市', '重点开采区', '46.63', 117.37, 28.36, '铌|钽矿', '');

-- ----------------------------
-- Table structure for mine_sum
-- ----------------------------
DROP TABLE IF EXISTS `mine_sum`;
CREATE TABLE `mine_sum`  (
  `large` int(10) NULL DEFAULT NULL,
  `midsize` int(10) NULL DEFAULT NULL,
  `small` int(10) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '矿区编号\r\n',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tungsten` double(11, 2) NULL DEFAULT NULL COMMENT '钨',
  `cutter` double(11, 2) NULL DEFAULT NULL COMMENT '铁',
  `copper` double(11, 2) NULL DEFAULT NULL COMMENT '铜\r\n',
  `silver` double(11, 2) NULL DEFAULT NULL COMMENT '银',
  `lead` double(11, 2) NULL DEFAULT NULL COMMENT '铅',
  `zinc` double(11, 2) NULL DEFAULT NULL COMMENT '锌',
  `tantalum` double(11, 2) NULL DEFAULT NULL COMMENT '钽',
  `niobium` double(11, 2) NULL DEFAULT NULL COMMENT '铌',
  `tombarthite` double(11, 2) NULL DEFAULT NULL COMMENT '稀土',
  `fluorite` double(11, 2) NULL DEFAULT NULL COMMENT '萤石',
  `other` double(11, 2) NULL DEFAULT NULL COMMENT '其它',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'CZ001', '瑞昌巿武山铜硫矿区', 1.00, 13.00, 21.00, 34.00, 12.00, 1.00, 11.00, 2.00, 2.00, 2.00, 33.00);
INSERT INTO `product` VALUES (2, 'CZ002', '九江县城门山铜硫矿区', 2.00, 1.00, 0.00, 0.00, 0.00, 1.00, 1.00, 1.00, 22.00, 2.00, 22.00);
INSERT INTO `product` VALUES (3, 'CZ003', '德兴市铜厂铜矿区富家坞铜钼矿区', 2.00, 0.00, 0.00, 0.00, 0.00, 11.00, 0.00, 0.00, 0.00, 0.00, 112.00);
INSERT INTO `product` VALUES (4, 'CZ004', '德兴市银山九区铜硫矿区', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (5, 'CZ005', '德兴市金山金矿区', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (6, 'CZ006', '东乡县枫林铜矿区', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (7, 'CZ007', '铅山县永平铜硫矿区', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (8, 'CZ008', '贵溪冷水坑银铅锌矿区', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (9, 'CZ009', '赣中新余式铁矿区', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (10, 'CZ010', '江西崇义县淘锡坑钨矿区', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (11, 'CZ011', '江西崇义县茅坪钨矿区  ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (12, 'CZ012', '宜春市四一四钽铌矿区  ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (13, 'CZ013', ' 鄱阳县金家坞金矿区   ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (14, 'CZ014', '德安县张十八铅锌矿区  ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (15, 'CZ015', '万年县虎家尖银金矿区  ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (16, 'CZ016', '横峰县葛源黄山-松树岗铌钽矿区  ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, 'CZ001', '瑞昌巿武山铜硫矿区', 'published', '2023-05-28 20:22:13');
INSERT INTO `status` VALUES (2, 'CZ002', '九江县城门山铜硫矿区', 'published', '2023-02-30 08:40:16');
INSERT INTO `status` VALUES (3, 'CZ003', '德兴市铜厂铜矿区富家坞铜钼矿区', 'published', NULL);
INSERT INTO `status` VALUES (4, 'CZ004', '德兴市银山九区铜硫矿区', 'published', NULL);
INSERT INTO `status` VALUES (5, 'CZ005', '德兴市金山金矿区', 'published', NULL);
INSERT INTO `status` VALUES (6, 'CZ006', '东乡县枫林铜矿区', 'published', NULL);
INSERT INTO `status` VALUES (7, 'CZ007', '铅山县永平铜硫矿区', 'published', NULL);
INSERT INTO `status` VALUES (8, 'CZ008', '贵溪冷水坑银铅锌矿区', 'published', NULL);
INSERT INTO `status` VALUES (9, 'CZ009', '赣中新余式铁矿区', 'published', NULL);
INSERT INTO `status` VALUES (10, 'CZ010', '江西崇义县淘锡坑钨矿区', 'published', NULL);
INSERT INTO `status` VALUES (11, 'CZ011', '江西崇义县茅坪钨矿区  ', 'published', NULL);
INSERT INTO `status` VALUES (12, 'CZ012', '宜春市四一四钽铌矿区  ', 'published', NULL);
INSERT INTO `status` VALUES (13, 'CZ013', ' 鄱阳县金家坞金矿区   ', 'published', NULL);
INSERT INTO `status` VALUES (14, 'CZ014', '德安县张十八铅锌矿区  ', 'published', NULL);
INSERT INTO `status` VALUES (15, 'CZ015', '万年县虎家尖银金矿区  ', 'published', NULL);
INSERT INTO `status` VALUES (16, 'CZ016', '横峰县葛源黄山-松树岗铌钽矿区  ', 'published', NULL);

SET FOREIGN_KEY_CHECKS = 1;
