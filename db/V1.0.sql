-- CREATE DATABASE timber;
-- USE timber;
-- drop table if exists `user`;
CREATE TABLE `user`(
	 `id` int(20) NOT NULL AUTO_INCREMENT,
	 `username` VARCHAR(20) NOT NULL COMMENT '用户名',
	 `password` VARCHAR(20) DEFAULT NULL COMMENT '密码',
	 `phone` VARCHAR(20) DEFAULT NULL COMMENT '电话',
	 `email` VARCHAR(20) DEFAULT NULL COMMENT '邮箱',
	 `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
	 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- 创建物品表
-- DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
	`id` INT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR ( 20 ) NOT NULL COMMENT '道具名',
	`serial` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '道具序列号',
	`item_type` INT ( 5 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '道具类型',
	`ad` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '物攻',
	`ap` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '魔攻',
	`ad_def` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '物防',
	`ap_def` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '魔防',
	`speed` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '速度',
PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC COMMENT = '物品表';


-- 导入物品表
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (1, '许愿星', 0, 1, 580, 0, 5000, 0, 0, 1000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (2, '狮子心', 0, 1, 580, 5000, 0, 0, 0, 1000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (3, '守护之杖', 0, 1, 2480, 20000, 0, 0, 0, 3000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (4, '创世兵器', 0, 1, 2480, 16000, 0, 0, 0, 5000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (5, '守护神杖', 0, 1, 7960, 0, 40000, 0, 0, 6000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (6, '创世神器', 0, 1, 7960, 30000, 0, 0, 0, 12000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (7, '宿命之剑', 0, 1, 8980, 12000, 0, 0, 0, 0);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (8, '宿命之杖', 0, 1, 8980, 0, 12000, 0, 0, 0);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (9, '宿命之枪', 0, 1, 8980, 8000, 8000, 1000, 1000, 6000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (10, '正宗 空', 0, 1, 21980, 20000, 20000, 2000, 2000, 15000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (11, '生者必灭', 0, 1, 44980, 30000, 30000, 10000, 10000, 20000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (12, '女神头盔', 0, 2, 480, 800, 800, 800, 800, 0);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (13, '光之眼改', 0, 2, 2480, 2500, 2500, 3000, 3000, 1000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (14, '暗之眼改', 0, 2, 7480, 6000, 6000, 6000, 6000, 3000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (15, '女神之铠', 0, 3, 480, 700, 700, 1200, 1200, 400);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (16, '光之铠改', 0, 3, 2480, 2000, 2000, 4500, 4500, 700);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (17, '暗之铠改', 0, 3, 7480, 6000, 6000, 9999, 9999, 1500);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (18, '破坏神铠改', 0, 3, 11980, 9999, 9999, 9999, 9999, 0);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (19, '救世主铠改', 0, 3, 11980, 9999, 9999, 9999, 9999, 0);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (20, '女神护手', 0, 4, 480, 1200, 1200, 400, 400, 300);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (21, '光之痕改', 0, 4, 2480, 4500, 4500, 1500, 1500, 1000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (22, '暗之痕改', 0, 4, 7480, 9999, 9999, 4000, 4000, 3000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (23, '女神之靴', 0, 5, 480, 600, 600, 400, 400, 1000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (24, '光之翼改', 0, 5, 2480, 1500, 1500, 2000, 2000, 3500);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (25, '暗之翼改', 0, 5, 7480, 4000, 4000, 4000, 4000, 9000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (26, '荣誉戒指', 0, 9, 180, 0, 0, 1030, 1030, 10);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (27, '真灭亡之歌', 0, 9, 4980, 0, 9999, 999, 999, 999);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (28, '真新月之舞', 0, 9, 4980, 9999, 0, 999, 999, 999);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (29, '真龙之卷', 0, 9, 11980, 0, 15000, 0, 5000, 0);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (30, '真虎之卷', 0, 9, 11980, 15000, 0, 5000, 0, 0);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (31, '龙腾四海', 0, 9, 19980, 0, 30000, 0, 0, 10000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (32, '凤舞九天', 0, 9, 19980, 20000, 0, 0, 0, 20000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (33, '真蝎狮王', 0, 8, 4980, 5000, 5000, 5000, 5000, 2500);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (34, '真蓝龙', 0, 8, 9980, 10000, 10000, 7500, 7500, 3000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (35, '真帝龙', 0, 8, 17980, 20000, 20000, 10000, 10000, 5000);
INSERT INTO `item`(`id`, `item_name`, `serial`, `item_type`, `item_price`, `ad`, `ap`, `ad_def`, `ap_def`, `speed`) VALUES (36, '水晶圣龙', 0, 8, 39980, 40000, 40000, 20000, 20000, 10000);


-- 角色表
CREATE TABLE `hero` (
	`id` INT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
	`serial` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '序列号',
	`name` VARCHAR ( 12 ) CHARACTER
	SET utf8 NOT NULL DEFAULT '' COMMENT '姓名',
	`level` VARCHAR ( 20 ) NOT NULL COMMENT '等级',
	`class` INT ( 3 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '种族',
	`hero_type` INT ( 3 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '0:战士 1:法师 2:盗贼',
	`profession` INT ( 3 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '职业',
	`guild` VARCHAR ( 12 ) CHARACTER
	SET utf8 NOT NULL DEFAULT '' COMMENT '公会',
	`now_zone_idx` SMALLINT ( 5 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '所在位置',
	`now_zone_x` TINYINT ( 3 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '所在x坐标',
	`now_zone_y` TINYINT ( 3 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '所在y坐标',
	`gold` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '金钱',
	`exp` BIGINT ( 20 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '经验',
	`speed_move` TINYINT ( 3 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '移动速度',
	`speed_attack` SMALLINT ( 5 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '攻击速度',
	`speed_skill` SMALLINT ( 5 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '技能施放速度',
	`str` SMALLINT ( 5 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '力量',
	`intel` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '智力',
	`dex` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '身法',
	`life` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '体质',
	`aim` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '精准',
	`luck` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '福缘',
	`attr` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '魅力',
	`dp` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '物攻',
	`ap` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '魔攻',
	`hc` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '精力',
	`hd` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '体力',
	`hp` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT 'hp',
	`mp` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT 'mp',
	`maxhp` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '最大hp',
	`maxmp` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '最大mp',
	`mount` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '坐骑',
	`weapon` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '武器',
	`head` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '头部',
	`clothes` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '上衣',
	`pants` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '下装',
	`hand` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '护手',
	`foot` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '鞋子',
	`item` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '道具',
	`country` INT ( 10 ) UNSIGNED NOT NULL DEFAULT '0' COMMENT '国家',
PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC COMMENT = '人物表';