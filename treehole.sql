/*
 Navicat Premium Data Transfer

 Source Server         : rm-2zel590ug920zx2n6io.mysql.rds.aliyuncs.com_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-2zel590ug920zx2n6io.mysql.rds.aliyuncs.com:3306
 Source Schema         : treehole

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/06/2021 22:14:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_records
-- ----------------------------
DROP TABLE IF EXISTS `chat_records`;
CREATE TABLE `chat_records`  (
  `stu_user_id_send` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发信人用户名',
  `stu_user_id_receive` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收信人用户名',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息内容',
  `send_time` datetime(6) NULL DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`stu_user_id_send`, `stu_user_id_receive`) USING BTREE,
  INDEX `stu_user_id_receive`(`stu_user_id_receive`) USING BTREE,
  CONSTRAINT `stu_user_id_receive` FOREIGN KEY (`stu_user_id_receive`) REFERENCES `student` (`stu_user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_user_id_send` FOREIGN KEY (`stu_user_id_send`) REFERENCES `student` (`stu_user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_records
-- ----------------------------
INSERT INTO `chat_records` VALUES ('12345', '12@qq.com', '你是哪位', '2021-05-27 21:01:14.000000');
INSERT INTO `chat_records` VALUES ('12@qq.com', '12345', '你好', '2021-05-27 21:00:50.000000');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `stu_content_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '跟评文章号',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '昵称',
  `com_contents` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `pub_time` datetime(6) NOT NULL COMMENT '发表时间',
  PRIMARY KEY (`pub_time`) USING BTREE,
  INDEX `stu_content_id`(`stu_content_id`) USING BTREE,
  CONSTRAINT `stu_content_id` FOREIGN KEY (`stu_content_id`) REFERENCES `stu_contents` (`stu_content_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('c234', '小刚', '就是简简单单的看不上你呗，相亲这种事 不就是互相挑嘛\r\n而且慢慢冷淡 不聊了 这不是统一的结束方式吗？两边都好下台阶。 起码我没见过有专门说一句“你不适合 我们不聊了” 这样来结尾的', '2021-06-13 15:23:02.000000');
INSERT INTO `comments` VALUES ('c234', '小明', '还是她请客……我觉得你已经找到原因了啊', '2021-06-13 15:23:32.000000');
INSERT INTO `comments` VALUES ('c234', '小明', '你比妹子大四岁，每次都她请客（也可能只是客气下），你觉得理所当然。\r\n所以，我是妹子都看不上你。', '2021-06-13 15:25:55.000000');
INSERT INTO `comments` VALUES ('c2345', '小红', '他一切都受家人操控，久而久之家人会不会觉得这小子没我不行，凭自己什么也办不到。我猜他是想在发生家庭矛盾时，避免被翻旧账，讲话能有底气，自信的建立是点滴微小事件成功的累积，有人托底有的选，会这么做寻找自信没毛病。', '2021-06-13 15:33:40.000000');
INSERT INTO `comments` VALUES ('c2345', '小刚', '有人托底叫闯荡，没人托底叫生存', '2021-06-13 15:34:17.000000');
INSERT INTO `comments` VALUES ('c23456', '小李', '只要有两天大号不畅 我就会去点一份！ 然后你懂的', '2021-06-13 15:45:03.000000');
INSERT INTO `comments` VALUES ('c23456', '小红', '又多了一名喷射战士', '2021-06-13 15:45:28.000000');
INSERT INTO `comments` VALUES ('c12346', '小明', '这不是肖申克救赎里面犯人在翻修警局屋顶时候，喝冰镇啤酒的画面吗', '2021-06-13 16:46:08.000000');
INSERT INTO `comments` VALUES ('c12345', '一鸣', '人不能……其实也可以……', '2021-06-13 16:46:50.000000');
INSERT INTO `comments` VALUES ('c123', '一鸣', NULL, '2021-06-15 00:00:00.000000');
INSERT INTO `comments` VALUES ('c12346', '一鸣', NULL, '2021-06-15 14:50:53.000000');
INSERT INTO `comments` VALUES ('c123', '一鸣', 'ssasd', '2021-06-15 14:51:26.000000');
INSERT INTO `comments` VALUES ('c123', '一鸣', '一般', '2021-06-15 14:53:31.000000');
INSERT INTO `comments` VALUES ('1', '一鸣', '评论', '2021-06-15 15:04:21.000000');
INSERT INTO `comments` VALUES ('3', '一鸣', '阿萨德', '2021-06-15 15:07:38.000000');
INSERT INTO `comments` VALUES ('3', '一鸣', '阿萨德', '2021-06-15 15:07:52.000000');
INSERT INTO `comments` VALUES ('3', '一鸣', '阿萨德', '2021-06-15 15:09:23.000000');
INSERT INTO `comments` VALUES ('c123', '一鸣', '阿萨德', '2021-06-15 15:09:32.000000');
INSERT INTO `comments` VALUES ('c123', '一鸣', '阿萨德', '2021-06-15 15:09:34.000000');
INSERT INTO `comments` VALUES ('c234', '一鸣', '可以', '2021-06-15 21:34:31.000000');
INSERT INTO `comments` VALUES ('c12345', '一鸣', '软件系统分析 - 测试用例', '2021-06-17 20:48:34.000000');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程号',
  `course_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `classroom` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教室',
  `day` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课日期',
  `time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课时间（第几节课）',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据结构', '0301', 'Monday', '1');
INSERT INTO `course` VALUES ('2', '离散数学', '0204', 'Tuesday', '1');
INSERT INTO `course` VALUES ('3', '线性代数', '0506', 'Wednesday', '1');
INSERT INTO `course` VALUES ('4', '计算机组成原理', '0108', 'Thursday', '1');
INSERT INTO `course` VALUES ('5', '概率论与数理统计', '0403', 'Friday', '1');
INSERT INTO `course` VALUES ('6', '综合素质训练', '0602', 'Monday', '2');
INSERT INTO `course` VALUES ('7', '体育', '0001', 'Tuesday', '2');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `ofc_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '官方号对应群号',
  `create_at` datetime(6) NOT NULL COMMENT '建群日期',
  `group_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群名称',
  `group_capacity` int(5) NOT NULL COMMENT '群容量',
  PRIMARY KEY (`ofc_user_id`) USING BTREE,
  CONSTRAINT `ofcid` FOREIGN KEY (`ofc_user_id`) REFERENCES `official` (`ofc_user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('12345', '2021-06-15 17:53:16.000000', '交大新生群', 1000);
INSERT INTO `group` VALUES ('1234567', '2021-06-15 17:52:16.000000', '北海驴友官方群', 1000);
INSERT INTO `group` VALUES ('1234@qq.com', '2021-06-15 17:52:53.000000', '清华园', 1000);
INSERT INTO `group` VALUES ('18301116@bjtu.edu.cn', '2021-06-15 16:53:59.000000', 'steam交流群', 1000);

-- ----------------------------
-- Table structure for ofc_contents
-- ----------------------------
DROP TABLE IF EXISTS `ofc_contents`;
CREATE TABLE `ofc_contents`  (
  `ofc_content_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '官方文章号',
  `ofc_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '官方昵称',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `contents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章内容',
  `pub_time` datetime(6) NULL DEFAULT NULL COMMENT '发表时间',
  `update_at` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  `views` int(255) NULL DEFAULT NULL COMMENT '浏览量',
  PRIMARY KEY (`ofc_content_id`) USING BTREE,
  INDEX `ofcname`(`ofc_name`) USING BTREE,
  CONSTRAINT `ofcname` FOREIGN KEY (`ofc_name`) REFERENCES `official` (`ofc_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ofc_contents
-- ----------------------------
INSERT INTO `ofc_contents` VALUES ('1', 'pku', '一鸣的故事', '牛逼', '2021-06-15 21:25:31.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('10', '一鸣', '测试2', '测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1', '2021-06-17 21:02:59.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('11', '一鸣', '测试3', '测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1', '2021-06-17 21:03:02.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('2', 'pku', '一鸣的故事', '牛逼', '2021-06-15 21:27:04.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('3', 'pku', '一鸣的故事', '牛逼', '2021-06-15 21:27:37.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('4', 'pku', '一鸣', '一鸣', '2021-06-15 21:28:32.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('5', 'pku', '一鸣', '一鸣', '2021-06-15 21:28:44.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('6', 'thu', '测试内容', '测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试，测试', '2021-06-15 23:21:16.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('7', 'thu', '标题', '内容内容内容内容内容内容内容内容', '2021-06-17 17:46:27.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('8', '一鸣', '测试发表内容', '发表须知\n\n1. 请不要包发表与您的官方主题无关的内容。\n\n2. 内容经过审核后发布。\n\n3. 请勿发布广告或留下联系方式。\n\n4. 请至少填写20个字以上。', '2021-06-17 21:02:09.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('9', '一鸣', '测试1', '测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1测试1', '2021-06-17 21:02:56.000000', NULL, 105);
INSERT INTO `ofc_contents` VALUES ('o1', 'pku', '一个男人的担当', '那是仲春时节，刮了一夜的大风，一大早，他起床后看到阳台上一株木棉的枝条被风折断了，他拿了剪刀将长长的斜面剪去，然后又用一块涂了防治病虫害的塑料布包上。做完这些，他这才长长舒了一口气。\r\n　　他的家庭那时也正如同这木棉一样，经历着一场变故，可他认为，即便被折断了感情，也不能让它的伤痛裸露，要尽可能向人展示它那美丽的一面。\r\n　　他是一名影视演员，在剧中塑造了那么多大义凛然的男子汉形象，也许正因为如此，让他最懂得人的铮铮铁骨其实是以柔肠温情来滋养的，故而在生活中，他也就特别看重家庭亲情。', '2021-06-15 16:35:50.000000', '2021-06-15 16:35:53.000000', 10);
INSERT INTO `ofc_contents` VALUES ('o2', 'thu', '清华园', '辖区以校园围墙为界，南以成府路为界与中关村毗邻；东南以双清路为线与学院路街道接壤；东面以京包铁路为界与东升地区办事处相邻；西隔清华南路、圆明园东路临近燕园街道、青龙桥街道；北以荷清苑路为界与青龙桥街道相邻。地区面积约4平方公里，户籍人口约5.4万人，流动人口约5000人。校内分为教学科研区、学生生活区和教职工住宅区。', '2021-06-15 16:36:50.000000', '2021-06-15 16:36:54.000000', 8);

-- ----------------------------
-- Table structure for official
-- ----------------------------
DROP TABLE IF EXISTS `official`;
CREATE TABLE `official`  (
  `ofc_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '官方用户名',
  `user_nickname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_state` int(1) NULL DEFAULT NULL COMMENT '用户状态，0未注册1已注册',
  `register_date` datetime(6) NULL DEFAULT NULL COMMENT '注册时间',
  `ofc_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '官方机构名称',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构类型',
  `update_at` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ofc_user_id`) USING BTREE,
  INDEX `user_nickname`(`user_nickname`) USING BTREE,
  INDEX `ofc_name`(`ofc_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of official
-- ----------------------------
INSERT INTO `official` VALUES ('123123@qq.com', '情感中心', '123', 1, '2021-05-19 20:14:03.000000', 'pku', 'university', '2021-06-02 20:14:52.000000');
INSERT INTO `official` VALUES ('12345', '交大小助手', '12345', 1, '2020-11-03 20:10:03.000000', 'bjtu', 'university', '2021-06-02 20:10:40.000000');
INSERT INTO `official` VALUES ('123456', '新东方教育', '123456', 1, '2020-07-29 20:11:16.000000', '新东方', 'education', '2021-06-02 20:11:37.000000');
INSERT INTO `official` VALUES ('1234567', '北海旅游', '1234567', 1, '2021-03-10 20:13:22.000000', '北海公司', 'social', '2021-06-02 20:13:36.000000');
INSERT INTO `official` VALUES ('1234@qq.com', '清华园地', '1234', 1, '2020-06-10 20:12:00.000000', 'thu', 'university', '2021-06-02 20:12:35.000000');
INSERT INTO `official` VALUES ('1263193656@qq.com', NULL, '123456', 0, '2021-06-15 19:22:55.000000', '一鸣大公司', NULL, NULL);
INSERT INTO `official` VALUES ('18301116@bjtu.edu.cn', 'steam官方', '123456', 0, '2021-06-10 00:00:00.000000', '一鸣', NULL, NULL);

-- ----------------------------
-- Table structure for stu_contents
-- ----------------------------
DROP TABLE IF EXISTS `stu_contents`;
CREATE TABLE `stu_contents`  (
  `stu_content_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生文章号',
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生昵称',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `contents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `pub_time` datetime(6) NULL DEFAULT NULL COMMENT '发表时间',
  `update_at` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  `tag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '兴趣标签',
  `good` int(255) NULL DEFAULT NULL COMMENT '点赞数',
  `dislike` int(255) NULL DEFAULT NULL COMMENT '点踩数',
  PRIMARY KEY (`stu_content_id`) USING BTREE,
  INDEX `stu_content_id`(`stu_content_id`, `contents`) USING BTREE,
  INDEX `nickname`(`nickname`) USING BTREE,
  CONSTRAINT `nickname` FOREIGN KEY (`nickname`) REFERENCES `student` (`user_nickname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_contents
-- ----------------------------
INSERT INTO `stu_contents` VALUES ('1', '一鸣', NULL, '89441', '2021-06-15 00:00:00.000000', NULL, '开心,伤心,惆怅,闲聊,秘密', 7, 3);
INSERT INTO `stu_contents` VALUES ('2', '一鸣', NULL, '再点', '2021-06-15 15:01:12.000000', NULL, '开心,伤心,惆怅,闲聊,秘密', 0, 0);
INSERT INTO `stu_contents` VALUES ('3', '一鸣', NULL, '内on', '2021-06-15 15:03:27.000000', NULL, '开心,闲聊', 8, 0);
INSERT INTO `stu_contents` VALUES ('4', '一鸣', NULL, '内容', '2021-06-15 15:17:02.000000', NULL, '伤心,闲聊', 1, 0);
INSERT INTO `stu_contents` VALUES ('5', '一鸣', NULL, '内容2', '2021-06-15 15:17:20.000000', NULL, '伤心,闲聊', 0, 0);
INSERT INTO `stu_contents` VALUES ('c1', '小红', '乡下来的小浣熊', '昨日感受了一把朴实善良的人性\r\n开车顺路送朋友去乡下的家里，被朋友的母亲热情的招待了\r\n临走的时候还带着我一起去抓了一只大公鸡，还去地里摘了几大口袋的新鲜蔬菜给我', '2021-06-13 20:58:04.000000', '2021-06-13 20:58:07.000000', '情感,社会', 15, 2);
INSERT INTO `stu_contents` VALUES ('c10', '小刚', '科威特蛋友', '现在想想，老老实实赚钱，踏踏实实工作，能通过自己的劳动得到的才是真正能掌握的东西。\r\n别的什么英雄，故事，U咩，别太当真，乐呵乐呵得了。', '2021-06-15 15:59:42.000000', '2021-06-15 15:59:45.000000', '人文', 1, 0);
INSERT INTO `stu_contents` VALUES ('c11', '一鸣', 'goo', '以前觉得“穷生奸计，富长良心”，看了些书觉得这话也不对，作恶就是作恶，和有钱没钱没关系，倒是和同理心，认知，这些有关。', '2021-06-15 16:00:29.000000', '2021-06-15 16:00:32.000000', '社会', 4, 1);
INSERT INTO `stu_contents` VALUES ('c12', '小李', '翻滚的猫', '几款八九百的便携显示器的色域真低，最高的才72srgb，还不如笔记本自带的屏幕，45ntsc，还144hz，这屏幕顶多值300，一换成便携显示器都600起步。', '2021-06-15 16:01:28.000000', '2021-06-15 16:01:30.000000', '科技 ', 5, 1);
INSERT INTO `stu_contents` VALUES ('c123', '小李', 'nihao', '无论如何,如果认为书本里的女性可以因为自己更强而去欺压男性,那和认同现实里某一处男性因为自己更强而去欺压女性有什么区别.', '2021-05-18 20:45:18.000000', '2021-06-02 20:45:22.000000', '科学,文学,社会', 22, 0);
INSERT INTO `stu_contents` VALUES ('c1234', '小刚', '回字的三种写法', '热身时发现小腿胫骨外侧（应该是外侧吧，内外不分）起了个小肿块，不痛不痒，但总觉得心里有疙瘩，校医院叫周二再去看下。', '2021-05-11 20:59:24.000000', '2021-06-02 20:59:29.000000', '文学,人文,情感 ', 27, 4);
INSERT INTO `stu_contents` VALUES ('c12345', '小红', '面试经大赏', '看了无聊图里面那个没有粽叶的粽子（红枣糯米饭），让我很想吐槽一下有个厨艺非常烂的长辈是多么可怕。', '2021-05-11 21:00:14.000000', '2021-06-02 21:00:18.000000', '社科,人文,社会学 心理学', 6, 2);
INSERT INTO `stu_contents` VALUES ('c123459', '小明', '一肚子不合时宜', '商场里逛一圈，发现很多东西都涨价了，想了想商品涨价只是表象，背后是放水、劳动力贬值，再一想的出个更加简单的结论：加税了而已', '2021-06-13 16:53:05.000000', '2021-06-13 16:53:08.000000', '社科,时事', 2, 1);
INSERT INTO `stu_contents` VALUES ('c12346', '一鸣', '圣多美和普林西比', '干完活，老板买了一小推车的西瓜，我们在炎炎烈日下干西瓜，爽歪歪！！！', '2021-06-13 16:43:51.000000', '2021-06-13 16:43:54.000000', '娱乐,社会', 1, 4);
INSERT INTO `stu_contents` VALUES ('c12347', '小红', '谷神不死', '在路边，右耳蓝牙耳机掉了被小车碾过去，然后还能听，反而是左耳耳机时不时断断续续，右耳完全没问题，什么情况…', '2021-06-13 16:48:33.000000', '2021-06-13 16:48:35.000000', '社科', 4, 2);
INSERT INTO `stu_contents` VALUES ('c12348', '小李', '不否', '突然觉得《扁鹊见蔡桓公》里面，蔡桓公对扁鹊的评价“医之好治不病以为功”其实没什么问题，因为扁鹊是中医啊！', '2021-06-13 16:51:16.000000', '2021-06-13 16:51:19.000000', '文学,娱乐', 0, 0);
INSERT INTO `stu_contents` VALUES ('c1236', '小李', 'hazy', '大家口中相传的垃圾民办三本，一年学费两万六，不知道还有没有上的必要。有些人说是个本科就肯定比专科强，但是两年五万多学费换个本科毕业证真的值吗？', '2021-06-13 20:54:09.000000', '2021-06-13 20:54:12.000000', '社会,教育', 3, 2);
INSERT INTO `stu_contents` VALUES ('c1245', '一鸣', 'simple', '绝望，放了三天假打了二天游戏。独自在一个城市真的寂寞。', '2021-06-13 20:49:26.000000', '2021-06-13 20:49:29.000000', '情感,交友', 4, 0);
INSERT INTO `stu_contents` VALUES ('c12456', '小红', '欧欧', '大家觉得研究生买个ipad有用吗', '2021-06-13 20:50:42.000000', '2021-06-13 20:50:44.000000', '交友', 3, 1);
INSERT INTO `stu_contents` VALUES ('c124567', '小刚', '我的手机呢', '我们当地有个寺庙，爬上去还挺高的，当时我妈几个人上去拜了拜就投了1000块，吓我一跳。我想着这不是给和尚买车买房吗？', '2021-06-13 20:52:12.000000', '2021-06-13 20:52:16.000000', '社会', 3, 2);
INSERT INTO `stu_contents` VALUES ('c13', '小明', '起名好麻烦', '惊觉群体的记忆在遗忘。\r\n通过控制现在控制了过去。\r\n群体的信息共享的渠道被阉割，承载记忆的载体被限制。\r\n群体被原子化，变成可操纵的浪潮。', '2021-06-15 16:02:23.000000', '2021-06-15 16:02:25.000000', '社会 思想', 2, 0);
INSERT INTO `stu_contents` VALUES ('c14', '小红', '路霸', '人生哪有什么低谷，低谷后续还能爬上去\r\n人生就是在结婚那个年纪让你攀升巅峰，然后余生持续不断地滚下去', '2021-06-15 16:03:21.000000', '2021-06-15 16:03:23.000000', '社会', 5, 1);
INSERT INTO `stu_contents` VALUES ('c15', '小刚', 'WaTaFxk', '和一个刚高考完的小伙子聊了会，真是被惊着了。我们这小地方的两所重点高中，现在本科率都在90-95%！十几年前我高考的时候，也还只有百分之五六十啊……', '2021-06-15 16:04:37.000000', '2021-06-15 16:04:40.000000', '教育 社会', 6, 2);
INSERT INTO `stu_contents` VALUES ('c16', '一鸣', 'ti', '在咸鱼上看中了一部xbox series x，卖家是在官网抢到原价订单还没付款，我要的话就直接订单改地址加价100卖给我，会有什么猫腻吗', '2021-06-15 16:06:25.000000', '2021-06-15 16:06:29.000000', '经验', 3, 0);
INSERT INTO `stu_contents` VALUES ('c17', '小李', '匿名', '昨天办完了所有退房手续，住进了新租的房间里。刚退的房是我租过的最满意的吧，我一度怀疑是房东搞慈善，同等条件月租应该再高个500—1000。不续租是因为他们儿子打算回来发展', '2021-06-15 16:07:52.000000', '2021-06-15 16:07:54.000000', '社会', 4, 2);
INSERT INTO `stu_contents` VALUES ('c18', '小明', '踏板车滑向哪里', '今天达成了人生史诗级成就。\r\n网上和人吵架。\r\n吵到一半发现我的观点是错的。\r\n承认错误。双方最后达成了一致观点。', '2021-06-15 16:08:48.000000', '2021-06-15 16:08:50.000000', '人文 娱乐', 6, 0);
INSERT INTO `stu_contents` VALUES ('c19', '小红', '赫连', '遇见不好的事情，唯一能解决的办法就是遇到一件更差的，之前那件就是好事了，也就能接收了\r\n\r\n', '2021-06-15 16:10:12.000000', '2021-06-15 16:10:14.000000', '闲谈', 3, 3);
INSERT INTO `stu_contents` VALUES ('c2', '一鸣', '姑苏', '即将去广州入职，有一个亲戚（我爸的表姐）安家在广州，曾在老家见过。可能因为我大学还不错，她对我比较热情。到广州后按照情理我应该去她们家一趟，朋友们可以说说我需要注意哪些礼节吗？', '2021-06-13 21:02:12.000000', '2021-06-13 21:02:14.000000', '社会', 3, 0);
INSERT INTO `stu_contents` VALUES ('c20', '小刚', 'henhen', '身边一个别人家的孩子是学声乐的，大学毕业后进了一所知名公立中学，上了几年班就辞职开了声乐培训班，公司十来个老师。她当老板，现在已经不用坐班，每年除去所有开销，她自己有一百多万的收入。虽然前期很难，每天也有很多操心事，但看朋友圈就是很闲。就算公司过几年倒闭了，积蓄也很多了，她改作声乐家教也能维持生活。', '2021-06-15 16:11:22.000000', '2021-06-15 16:11:24.000000', '教育 社会', 8, 4);
INSERT INTO `stu_contents` VALUES ('c21', '一鸣', '李小明', '嘿嘿，通过仲裁调解把工资要回来了，开心。\r\n跑两趟就几千块到手，大家一定不要嫌麻烦，连你自己都放弃了，谁还会为你争取。', '2021-06-15 16:12:14.000000', '2021-06-15 16:12:16.000000', '经验 社会', 10, 1);
INSERT INTO `stu_contents` VALUES ('c22', '小李', '铭铭铭铭', '发现我真的没有睡懒觉的命。周一到周五上班的时候，每天都想着周末一定要睡到十一点起床。睡个饱的。结果每次到周末，或者是盘算着早起去办事，或者是前一天忘记拉紧窗帘了导致天亮就醒了。', '2021-06-15 16:13:40.000000', '2021-06-15 16:13:42.000000', '生活', 1, 1);
INSERT INTO `stu_contents` VALUES ('c23', '小明', 'love', '和小学生玩游戏，感觉也挺快乐的，关键是他们技术比我好，比自己一个人呆着强。\r\n\r\n', '2021-06-15 16:14:33.000000', '2021-06-15 16:14:35.000000', '娱乐', 3, 0);
INSERT INTO `stu_contents` VALUES ('c234', '一鸣', '一鸣牛逼', '相亲认识一女孩，初高中校友，小我四岁，现在我们在同一个城市工作。\r\n因为老乡又是校友，第一次见面大家就聊的很好，之后每天都会联系，也主动给我问早安晚安，偶尔开开玩笑喊个宝贝啥的也没关系。但是就这样过了一个周，约了第二顿饭，还是她请客，吃完饭回家后她就不理我了，发消息也回，但是明显就是不想跟你聊天的感觉，突然就这样了，我真窝火，这到底是啥意思？', '2021-06-13 15:10:19.000000', '2021-06-13 15:10:22.000000', '情感,社会 ', 9, 4);
INSERT INTO `stu_contents` VALUES ('c2345', '小李', '珑哥牛逼', '嗯，后路比较硬的人，说话就是不一样啊，不好好努力只能回家躺平当个二代，这电视剧的狗血剧情都能来秀我一脸，我是做错了什么事？', '2021-06-13 15:28:58.000000', '2021-06-13 15:29:01.000000', '社会,人文', 10, 2);
INSERT INTO `stu_contents` VALUES ('c23456', '小明', '小兔叽', '法克，华莱士果然名不虚传，深夜的鸡翅吃了不到十分钟，腹中就汹涌澎湃，害我马上去洗手间清理肠道', '2021-06-13 15:44:15.000000', '2021-06-13 15:44:18.000000', '娱乐', 4, 1);
INSERT INTO `stu_contents` VALUES ('c234567', '小红', 'davy', '最近觉得有些无聊图略反智，好比把套路化的娱乐硬塞到人脸前，而不是多少先得自行琢磨才能会心一笑。前者中大多数必须配合文字，但却是肤浅的文字，具体而言是对各式各样的现象采用刻板的二分法看待。这种倡导对思路的简化给我不好的感觉，不说娱乐至死这种老古板，总之让人的情绪多少变得有点廉价吧？', '2021-06-13 16:41:52.000000', '2021-06-13 16:41:54.000000', '娱乐,社会', 4, 2);
INSERT INTO `stu_contents` VALUES ('c24', '小红', 'zhz', '女朋友陪着看了三个晚上的游戏比赛，昨天就陪她出门逛逛。先去了博物馆，博物馆的趣味性显然是不如游戏的，不过对于吾宅而言有种看啥都新鲜的体验感，各类江浙出土的文物、红色文化纪念，各有所得各有感触，之后由于只预约了一家，隔壁的科技馆和自然馆没去成（出来的时候再预约已经不成了，没名额了）。', '2021-06-15 16:15:55.000000', '2021-06-15 16:15:57.000000', '生活', 1, 1);
INSERT INTO `stu_contents` VALUES ('c25', '小刚', '悲鸣', '猫抓不住蚊虫，却把蜘蛛吃了\r\n这夏天难过了', '2021-06-15 16:16:55.000000', '2021-06-15 16:16:58.000000', '生活', 4, 2);
INSERT INTO `stu_contents` VALUES ('c3', '小李', '格格污', '赛博朋克2077，为了进隐藏结局看控制台改了强尼好感度，然后等5分钟欣对话出来选完就闪退了。', '2021-06-13 21:04:11.000000', '2021-06-13 21:04:14.000000', '娱乐', 2, 1);
INSERT INTO `stu_contents` VALUES ('c4', '一鸣', '昭君', '昨晚梦到和对象手挽手一起压马路，说说笑笑，看人来人往，车水马龙。\r\n即使醒来还是清晰记得那种浑身洋溢的安心感和幸福感。\r\n现实是，还差个两三年魔法师成就就要达成了ಥ_ಥ\r\n最后，谢谢你，大脑', '2021-06-15 15:52:20.000000', '2021-06-15 15:52:23.000000', '情感', 6, 2);
INSERT INTO `stu_contents` VALUES ('c5', '小红', 'hayrideoo', '我发关于那只猫猫的树洞，不是想寻求心理安慰或者所谓的占据舆论高地，我只是想求助于蛋友，身边有没有类似的情况，以及后来的结果如何，我只是想了解一下猫猫骨折自愈的情况。没有别的意思。。。可能是我表达的目的不够明确吧。', '2021-06-15 15:53:20.000000', '2021-06-15 15:53:23.000000', '情感 生活', 15, 1);
INSERT INTO `stu_contents` VALUES ('c6', '小刚', '港边卓妍', '上轿车 一般都是侧身向内坐\r\n那么最为优雅的姿势是什么呢\r\n如何优雅的坐进轿车内呐', '2021-06-15 15:54:16.000000', '2021-06-15 15:54:19.000000', '社科 生活', 3, 0);
INSERT INTO `stu_contents` VALUES ('c7', '小李', '醉洛阳', '最后看了一本小说，叫夜晚的潜水艇。他是一本短篇小说集，看完后有一种感动，写得太美了，而且是中文的美，想象力特别丰富脑洞大开，写得太干净了，就好像你读很美的诗词一样', '2021-06-15 15:55:19.000000', '2021-06-15 15:55:21.000000', '文学', 4, 2);
INSERT INTO `stu_contents` VALUES ('c8', '小明', 'NIM', '刚才出来上厕所，发现厕所比我工作的地方都凉快，我不想回去干活了……', '2021-06-15 15:57:39.000000', '2021-06-15 15:57:41.000000', '社会', 2, 0);
INSERT INTO `stu_contents` VALUES ('c9', '小红', '反光色', '以前很想去的一个岗位, 等了很久, 有机会后又胆怯了…', '2021-06-15 15:58:33.000000', '2021-06-15 15:58:36.000000', '心理', 6, 1);

-- ----------------------------
-- Table structure for stu_friends
-- ----------------------------
DROP TABLE IF EXISTS `stu_friends`;
CREATE TABLE `stu_friends`  (
  `stu_user_id_a` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户a用户名',
  `stu_user_id_b` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户b用户名',
  `start_time` datetime(6) NULL DEFAULT NULL COMMENT '成为好友时间',
  `update_at` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  `friend_level` int(10) NULL DEFAULT NULL COMMENT '好友等级',
  PRIMARY KEY (`stu_user_id_a`, `stu_user_id_b`) USING BTREE,
  INDEX `stu_user_id_b`(`stu_user_id_b`) USING BTREE,
  CONSTRAINT `stu_user_id_a` FOREIGN KEY (`stu_user_id_a`) REFERENCES `student` (`stu_user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_user_id_b` FOREIGN KEY (`stu_user_id_b`) REFERENCES `student` (`stu_user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_friends
-- ----------------------------
INSERT INTO `stu_friends` VALUES ('12@qq.com', '12345', '2021-06-01 21:01:50.000000', '2021-06-02 21:01:54.000000', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生用户名',
  `stu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `user_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `user_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_state` int(1) NULL DEFAULT NULL COMMENT '用户状态，0为未认证，1为已认证',
  `register_date` datetime(6) NULL DEFAULT NULL COMMENT '注册日期',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别，0为男1为女',
  `age` int(255) NULL DEFAULT NULL COMMENT '年龄',
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校名称',
  `stu_tag` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户标签',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `update_at` datetime(6) NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`stu_user_id`) USING BTREE,
  INDEX `stu_user_id`(`stu_user_id`, `user_nickname`) USING BTREE,
  INDEX `user_nickname`(`user_nickname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('10718431222qq.com', NULL, '一鸣2', '123456', 0, '2021-06-15 16:00:22.000000', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES ('12345', '12345', '小明', '12345', 1, '2021-06-02 19:48:38.000000', '男', 20, 'bjtu', '运动', '北京', '2021-06-02 19:50:13.000000');
INSERT INTO `student` VALUES ('123456', '123456', '小红', '123456', 1, '2021-06-02 19:52:17.000000', '女', 19, 'thu', '摄影', '北京', '2021-06-02 19:53:27.000000');
INSERT INTO `student` VALUES ('1234567', '1234567', '小刚', '1234567', 0, '2021-06-02 19:54:56.000000', '男', 21, 'pku', '科技', '北京', '2021-06-02 19:55:45.000000');
INSERT INTO `student` VALUES ('1263193656@qq.com', NULL, '一鸣', '123456', 1, '2021-06-13 17:07:36.000000', '男', 20, 'bjtu', '学生', '北京', '2021-06-13 17:08:50.000000');
INSERT INTO `student` VALUES ('12@qq.com', '1234', '小李', '1234', 1, '2021-06-02 19:58:42.000000', '男', 20, 'bjtu', '美食', '上海', '2021-06-02 19:59:12.000000');
INSERT INTO `student` VALUES ('18231557@bjtu.edu.cn', NULL, '一鸣2', '123456', 0, '2021-06-15 15:59:31.000000', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student` VALUES ('894631772@qq.com', NULL, '一鸣2', '123456', 0, '2021-06-15 15:59:02.000000', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `stu_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生用户名',
  `course_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程号',
  `create_at` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`stu_user_id`, `course_id`) USING BTREE,
  INDEX `course_id`(`course_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_user_id3` FOREIGN KEY (`stu_user_id`) REFERENCES `student` (`stu_user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------

-- ----------------------------
-- Table structure for student_group
-- ----------------------------
DROP TABLE IF EXISTS `student_group`;
CREATE TABLE `student_group`  (
  `stu_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `ofc_user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群名',
  `join_at` datetime(6) NULL DEFAULT NULL COMMENT '进群时间',
  PRIMARY KEY (`stu_user_id`, `ofc_user_id`) USING BTREE,
  INDEX `ofcid2`(`ofc_user_id`) USING BTREE,
  CONSTRAINT `ofcid2` FOREIGN KEY (`ofc_user_id`) REFERENCES `group` (`ofc_user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stuid` FOREIGN KEY (`stu_user_id`) REFERENCES `student` (`stu_user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_group
-- ----------------------------
INSERT INTO `student_group` VALUES ('10718431222qq.com', '12345', '2021-06-15 17:54:55.000000');
INSERT INTO `student_group` VALUES ('10718431222qq.com', '1234567', '2021-06-15 17:56:31.000000');
INSERT INTO `student_group` VALUES ('10718431222qq.com', '18301116@bjtu.edu.cn', '2021-06-15 17:41:46.000000');
INSERT INTO `student_group` VALUES ('12345', '1234@qq.com', '2021-06-15 17:57:04.000000');
INSERT INTO `student_group` VALUES ('12345', '18301116@bjtu.edu.cn', '2021-06-15 17:42:02.000000');
INSERT INTO `student_group` VALUES ('123456', '1234@qq.com', '2021-06-15 18:01:46.000000');
INSERT INTO `student_group` VALUES ('1263193656@qq.com', '1234567', '2021-06-15 17:55:54.000000');
INSERT INTO `student_group` VALUES ('1263193656@qq.com', '1234@qq.com', '2021-06-15 17:57:31.000000');
INSERT INTO `student_group` VALUES ('12@qq.com', '12345', '2021-06-15 17:56:15.000000');
INSERT INTO `student_group` VALUES ('12@qq.com', '18301116@bjtu.edu.cn', '2021-06-15 17:56:47.000000');
INSERT INTO `student_group` VALUES ('18231557@bjtu.edu.cn', '1234@qq.com', '2021-06-15 17:57:44.000000');
INSERT INTO `student_group` VALUES ('18231557@bjtu.edu.cn', '18301116@bjtu.edu.cn', '2021-06-15 17:51:15.000000');
INSERT INTO `student_group` VALUES ('894631772@qq.com', '18301116@bjtu.edu.cn', '2021-06-15 17:54:29.000000');

SET FOREIGN_KEY_CHECKS = 1;
