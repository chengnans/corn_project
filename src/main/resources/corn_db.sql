/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : corn_db

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 14/02/2025 22:34:18
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agricultural_task
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_task`;
CREATE TABLE `agricultural_task`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `scheme_id` int NOT NULL,
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  `water_usage` double NULL DEFAULT NULL,
  `nitrogen_usage` double NULL DEFAULT NULL,
  `phosphorus_usage` double NULL DEFAULT NULL,
  `potassium_usage` double NULL DEFAULT NULL,
  `task_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `task_date` date NULL DEFAULT NULL,
  `condition` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `scheme_id`(`scheme_id` ASC) USING BTREE,
  CONSTRAINT `agricultural_task_ibfk_1` FOREIGN KEY (`scheme_id`) REFERENCES `scheme` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of agricultural_task
-- ----------------------------
INSERT INTO `agricultural_task` VALUES (1, 1, '播种期', '2024-06-13', '2024-06-20', 40, 6, 5, 4, NULL, NULL, NULL);
INSERT INTO `agricultural_task` VALUES (2, 1, '出苗期', '2024-06-20', '2024-07-20', 30, 5, 2, 3, '除草', '2024-06-29', '玉米3~5叶期进行化学除草');
INSERT INTO `agricultural_task` VALUES (3, 1, '出苗期', '2024-06-20', '2024-07-20', 30, 5, 2, 3, '灌溉', '2024-07-04', '促根壮苗');
INSERT INTO `agricultural_task` VALUES (4, 1, '拔节期', '2024-07-20', '2024-08-10', 25, 6, 3, 2, '苗期管理', '2024-07-21', '6~7展叶期施用玉米专用化控剂。 应避开中午或者高温天喷药。');
INSERT INTO `agricultural_task` VALUES (5, 1, '拔节期', '2024-07-20', '2024-08-10', 25, 6, 3, 2, '施肥', '2024-07-26', '化控后5~7天进行第一次滴肥；加强巡田检查，避免田间管道漏水，造成施肥灌水不匀。');
INSERT INTO `agricultural_task` VALUES (6, 1, '抽穗开花期', '2024-08-10', '2024-08-20', 20, 3, 5, 4, NULL, NULL, NULL);
INSERT INTO `agricultural_task` VALUES (7, 1, '灌浆期', '2024-08-20', '2024-10-05', 22, 4, 4, 3, '施肥', '2024-08-28', '玉米粒灌浆期以氮肥为主，配以适合的磷钾肥');
INSERT INTO `agricultural_task` VALUES (8, 1, '灌浆期', '2024-08-20', '2024-10-05', 22, 4, 4, 3, '施肥', '2024-09-13', '每亩施入尿素5kg+硫酸钾2kg');
INSERT INTO `agricultural_task` VALUES (9, 1, '成熟期', '2024-10-05', '2024-10-20', 10, 1, 1, 1, '收获', '2024-10-12', '关注天气情况，做好人员、车辆、销售渠道等准备工作。 收获应在籽粒生理成熟（乳线消失、黑层出现）后进行。');

-- ----------------------------
-- Table structure for scheme
-- ----------------------------
DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `planting_date` date NULL DEFAULT NULL,
  `target_production` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expected_investment` double NULL DEFAULT NULL,
  `expected_output` double NULL DEFAULT NULL,
  `water_requirement` double NULL DEFAULT NULL,
  `nitrogen` double NULL DEFAULT NULL,
  `phosphorus` double NULL DEFAULT NULL,
  `potassium` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scheme
-- ----------------------------
INSERT INTO `scheme` VALUES (1, '青岛市夏玉米全年农事计划方案', '大河岔村基地', '2024-06-13', '800公斤/亩', 450, 1000, 140, 24, 12, 24);

SET FOREIGN_KEY_CHECKS = 1;
