/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : wechat

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-03 18:31:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for worldcup_pk_broadcast
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_broadcast`;
CREATE TABLE `worldcup_pk_broadcast` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matchId` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于文字直播';

-- ----------------------------
-- Records of worldcup_pk_broadcast
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_contract
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_contract`;
CREATE TABLE `worldcup_pk_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '好友契约id',
  `guessType` int(11) DEFAULT NULL COMMENT '猜输赢0还是猜比分1',
  `stakeId` int(11) NOT NULL COMMENT '赌注id',
  `status` int(11) DEFAULT '0' COMMENT '契约状态，可以分为0未开始，1开局，2结束',
  `matchId` int(11) NOT NULL COMMENT '比赛id',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '契约创建时间',
  `yn` int(11) DEFAULT '1' COMMENT '0代表删除  1代表正常可用',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友契约表';

-- ----------------------------
-- Records of worldcup_pk_contract
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_contract_group
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_contract_group`;
CREATE TABLE `worldcup_pk_contract_group` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '群pk契约id',
  `guessType` int(11) DEFAULT NULL COMMENT '竞猜类型,0猜输赢，1猜比分',
  `status` int(11) DEFAULT NULL COMMENT '0代表未开局，1代表开局，2代表结束',
  `matchId` int(11) NOT NULL COMMENT '比赛id',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '契约创建时间',
  `yn` int(11) DEFAULT '1' COMMENT '0代表已删除，1代表可用',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `number` int(11) DEFAULT NULL COMMENT '每个契约是相同的下注数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群pk契约表';

-- ----------------------------
-- Records of worldcup_pk_contract_group
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_contract_user
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_contract_user`;
CREATE TABLE `worldcup_pk_contract_user` (
  `cid` int(11) NOT NULL COMMENT '契约id',
  `uid` varchar(50) NOT NULL COMMENT 'openid,用户唯一标识',
  `myGuess` varchar(20) DEFAULT NULL COMMENT '用户猜测结果',
  `time` datetime DEFAULT NULL COMMENT '加入契约的时间',
  `result` int(11) DEFAULT '2' COMMENT '记录用户输赢,0输，1赢 2未出结果',
  `yn` int(11) DEFAULT '1' COMMENT '0删除，1代表可用',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `联合唯一索引` (`cid`,`uid`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='契约与用户的关联表';

-- ----------------------------
-- Records of worldcup_pk_contract_user
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_contract_user_group
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_contract_user_group`;
CREATE TABLE `worldcup_pk_contract_user_group` (
  `cid` int(11) NOT NULL COMMENT '契约id',
  `uid` varchar(50) NOT NULL COMMENT '参与者的openid',
  `number` int(11) DEFAULT NULL COMMENT '下注数量',
  `myGuess` varchar(20) DEFAULT NULL COMMENT '用户竞猜结果',
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '加入契约的时间',
  `result` int(11) DEFAULT '2' COMMENT '记录用户的比赛结果,0输，1赢，2是未出结果',
  `yn` int(11) DEFAULT '1' COMMENT '0删除，1代表正常',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `契约用户联合索引` (`cid`,`uid`) USING BTREE COMMENT '联合索引替换联合主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群pk契约与用户的关联表';

-- ----------------------------
-- Records of worldcup_pk_contract_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_create_contract
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_create_contract`;
CREATE TABLE `worldcup_pk_create_contract` (
  `cid` int(11) NOT NULL COMMENT '契约id',
  `createUser` varchar(50) NOT NULL COMMENT '创建人openid',
  `yn` int(11) DEFAULT '1' COMMENT '0删除，1可用',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cid` (`cid`,`createUser`) USING BTREE COMMENT 'cid与创建人openid联合索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友pk契约的创建者';

-- ----------------------------
-- Records of worldcup_pk_create_contract
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_create_contract_group
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_create_contract_group`;
CREATE TABLE `worldcup_pk_create_contract_group` (
  `cid` int(11) NOT NULL COMMENT '契约id',
  `createUser` varchar(50) NOT NULL COMMENT '创建人openid',
  `yn` int(11) DEFAULT '1' COMMENT '0代表删除，1正常',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群pk的创建者';

-- ----------------------------
-- Records of worldcup_pk_create_contract_group
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_evaluation`;
CREATE TABLE `worldcup_pk_evaluation` (
  `openid` varchar(50) NOT NULL COMMENT '用户唯一标识',
  `tricky_brains` int(11) DEFAULT '0' COMMENT '整蛊专家',
  `food_anchor` int(11) DEFAULT '0' COMMENT '美食主播',
  `imagination_talent` int(11) DEFAULT '0' COMMENT '脑洞达人',
  `iron_cock` int(11) DEFAULT '0' COMMENT '铁公鸡',
  `wealthy` int(11) DEFAULT '0' COMMENT '富甲一方',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `openid唯一标识` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通过用户的赌注类型，对用户的评价';

-- ----------------------------
-- Records of worldcup_pk_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_events
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_events`;
CREATE TABLE `worldcup_pk_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '赛事id',
  `name` varchar(100) DEFAULT NULL COMMENT '赛事名称',
  `logo` varchar(100) DEFAULT NULL COMMENT '赛事标志',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛事表';

-- ----------------------------
-- Records of worldcup_pk_events
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_matches
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_matches`;
CREATE TABLE `worldcup_pk_matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '比赛id',
  `stageId` int(11) DEFAULT NULL COMMENT '阶段id',
  `status` int(20) DEFAULT NULL COMMENT '状态,根据接口来的 8对应已结束',
  `time` datetime DEFAULT NULL COMMENT '比赛时间',
  `homeid` int(11) DEFAULT NULL COMMENT '主队id',
  `home_grade` int(11) DEFAULT NULL COMMENT '主队分数',
  `visitid` int(11) DEFAULT NULL COMMENT '客队id',
  `visit_grade` int(11) DEFAULT NULL COMMENT '客队比分',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `round` int(11) DEFAULT NULL COMMENT '比赛轮次',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛表';

-- ----------------------------
-- Records of worldcup_pk_matches
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_stage
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_stage`;
CREATE TABLE `worldcup_pk_stage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '赛事类型,1-联赛 2-杯赛',
  `mode` int(11) DEFAULT NULL COMMENT '比赛方式, 1-积分 2-淘汰',
  `name_zh` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worldcup_pk_stage
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_stake
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_stake`;
CREATE TABLE `worldcup_pk_stake` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '赌注id',
  `type` int(11) DEFAULT NULL COMMENT '赌注类型，3为自定义赌注',
  `name` varchar(100) DEFAULT NULL COMMENT '赌注的名称或者备注文字',
  `logo` varchar(100) DEFAULT NULL COMMENT '系统初始赌注的图片',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '赌注生成时间',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isOriginal` int(11) DEFAULT '0' COMMENT '是否原始存在0代表后来自定义的，1代表系统定义的',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='赌注表';

-- ----------------------------
-- Records of worldcup_pk_stake
-- ----------------------------
INSERT INTO `worldcup_pk_stake` VALUES ('1', '4', '献50大洋', 'wechat/images/deed/50.png', '2018-06-01 15:56:49', '2018-06-01 15:56:49', '2018-06-03 17:38:43', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('2', '4', '献100大洋', 'wechat/images/deed/100.png', '2018-06-01 15:57:10', '2018-06-01 15:57:10', '2018-06-03 17:38:50', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('3', '1', '做俯卧撑', 'wechat/images/deed/fwc2.png', '2018-06-01 15:57:27', '2018-06-01 15:57:27', '2018-06-03 17:41:11', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('4', '1', '在大街上喊', 'wechat/images/deed/dh.png', '2018-06-01 15:57:47', '2018-06-01 15:57:47', '2018-06-03 17:39:24', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('5', '2', '请吃炸鸡', 'wechat/images/deed/czj.png', '2018-06-01 15:57:57', '2018-06-01 15:57:57', '2018-06-03 17:39:04', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('6', '3', '自定义', 'wechat/images/deed/zdy.png', '2018-06-01 15:58:09', '2018-06-01 15:58:09', '2018-06-03 17:40:46', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('7', '1', '跑三公里', 'wechat/images/deed/pb.png', '2018-06-01 15:58:44', '2018-06-01 15:58:44', '2018-06-03 17:40:53', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('8', '1', '穿女装', 'wechat/images/deed/nz.png', '2018-06-01 15:58:56', '2018-06-01 15:58:56', '2018-06-03 17:39:42', '1');
INSERT INTO `worldcup_pk_stake` VALUES ('9', '2', '请吃炸鸡', 'wechat/images/deed/zj.png', '2018-06-01 15:59:01', '2018-06-01 15:59:01', '2018-06-03 17:39:11', '1');

-- ----------------------------
-- Table structure for worldcup_pk_status_dict
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_status_dict`;
CREATE TABLE `worldcup_pk_status_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(11) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='足球状态码统计';

-- ----------------------------
-- Records of worldcup_pk_status_dict
-- ----------------------------
INSERT INTO `worldcup_pk_status_dict` VALUES ('1', '1', '进球');
INSERT INTO `worldcup_pk_status_dict` VALUES ('2', '2', '角球');
INSERT INTO `worldcup_pk_status_dict` VALUES ('3', '3', '黄牌');
INSERT INTO `worldcup_pk_status_dict` VALUES ('4', '4', '红牌');
INSERT INTO `worldcup_pk_status_dict` VALUES ('5', '5', '界外球');
INSERT INTO `worldcup_pk_status_dict` VALUES ('6', '6', '任意球');
INSERT INTO `worldcup_pk_status_dict` VALUES ('7', '7', '球门球');
INSERT INTO `worldcup_pk_status_dict` VALUES ('8', '8', '点球');
INSERT INTO `worldcup_pk_status_dict` VALUES ('9', '9', '换人');
INSERT INTO `worldcup_pk_status_dict` VALUES ('10', '10', '比赛开始');
INSERT INTO `worldcup_pk_status_dict` VALUES ('11', '11', '中场');
INSERT INTO `worldcup_pk_status_dict` VALUES ('12', '12', '结束');
INSERT INTO `worldcup_pk_status_dict` VALUES ('13', '13', '半场比分');
INSERT INTO `worldcup_pk_status_dict` VALUES ('14', '15', '两黄变红');
INSERT INTO `worldcup_pk_status_dict` VALUES ('15', '17', '乌龙球');
INSERT INTO `worldcup_pk_status_dict` VALUES ('16', '21', '射正');
INSERT INTO `worldcup_pk_status_dict` VALUES ('17', '22', '射偏');
INSERT INTO `worldcup_pk_status_dict` VALUES ('18', '23', '进攻');
INSERT INTO `worldcup_pk_status_dict` VALUES ('19', '24', '危险进攻');
INSERT INTO `worldcup_pk_status_dict` VALUES ('20', '25', '控球率');

-- ----------------------------
-- Table structure for worldcup_pk_team
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_team`;
CREATE TABLE `worldcup_pk_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '球队id',
  `name` varchar(100) DEFAULT NULL COMMENT '球队名字',
  `logo` varchar(100) DEFAULT NULL COMMENT '球队标志',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `country_logo` varchar(100) DEFAULT NULL COMMENT '国家图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='球队表';

-- ----------------------------
-- Records of worldcup_pk_team
-- ----------------------------

-- ----------------------------
-- Table structure for worldcup_pk_user
-- ----------------------------
DROP TABLE IF EXISTS `worldcup_pk_user`;
CREATE TABLE `worldcup_pk_user` (
  `openid` varchar(50) NOT NULL COMMENT '用户唯一标志',
  `imageUrl` varchar(300) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `currency` int(11) DEFAULT '8000' COMMENT '游戏币',
  `wins` int(11) DEFAULT '0' COMMENT '竞猜胜利场次',
  `lasttime` datetime DEFAULT NULL COMMENT '上次登陆时间',
  `all` int(11) DEFAULT '0' COMMENT '总竞猜场数',
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `openid唯一` (`openid`) USING HASH COMMENT '用户唯一标志'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of worldcup_pk_user
-- ----------------------------
INSERT INTO `worldcup_pk_user` VALUES ('test', null, null, null, null, null, null, '2018-06-01 09:12:50', null, '1');
