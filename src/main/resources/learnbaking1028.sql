/*
Navicat MySQL Data Transfer

Source Server         : mydatabase
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : learnbaking

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-10-28 10:51:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderIndex` tinyint(4) DEFAULT NULL,
  `memo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '蛋糕', '1', '千层糕');
INSERT INTO `category` VALUES ('2', '甜品点心', '2', '戚风蛋糕');
INSERT INTO `category` VALUES ('3', '面包', '3', '雪媚娘');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `detailId` int(11) DEFAULT NULL,
  `collectTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '1', '1', '1', '1', '2019-10-23 16:20:35');
INSERT INTO `collect` VALUES ('2', '2', '2', '2', '2', '2019-10-23 16:20:52');
INSERT INTO `collect` VALUES ('3', '3', '3', '3', '3', '2019-10-23 16:21:07');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `workId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '不错不错 容易上手', '2019-10-23 16:13:38', '2', null);
INSERT INTO `comment` VALUES ('2', '2', '还行吧', '2019-10-23 16:19:34', '1', null);
INSERT INTO `comment` VALUES ('3', '3', '还阔以', '2019-10-23 16:20:16', '3', null);

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `videoUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '介绍视频',
  `title` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `imgUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `memo` text COLLATE utf8_unicode_ci,
  `memoTwo` text COLLATE utf8_unicode_ci,
  `howLearn` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bakerName` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `backerImgUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bakerIntroduce` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `peopleCount` int(10) DEFAULT NULL,
  `addTime` date DEFAULT NULL,
  `orderIndex` tinyint(10) DEFAULT NULL,
  `state` tinyint(2) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL COMMENT '分类id对应的category表',
  `isindex` tinyint(2) DEFAULT NULL COMMENT '是否首页展示 0 否 1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'http://vd3.bdstatic.com/mda-jcfmhdhksv52z6a7/sc/mda-jcfmhdhksv52z6a7.mp4', '超高人气千层糕', 'https://cp1.douguo.com/upload/caiku/4/f/d/690x390_4f71800318d509ec5330b26d4ce749fd.jpg', '好吃', '简单易学上手', '报名本课程后，点击去上课按钮，即可学习本课程', '千层糕', 'https://cp1.douguo.com/upload/caiku/4/f/d/690x390_4f71800318d509ec5330b26d4ce749fd.jpg', '九九重阳节，叠叠千层糕。做给爸妈吃的，赞不绝口，Q弹的口感，椰汁的清香，平时做给小朋友吃也很不错哦。', '9.90', '100', '2019-10-23', '1', '1', '1', '1');
INSERT INTO `course` VALUES ('2', 'https://vplay.douguo.com/XMzE5MjQwMTM4NA==__640x356.mp4', '香兰叶戚风蛋糕', 'https://cp1.douguo.com/upload/caiku/5/4/6/690x390_54ada9e1b0fd2ea49b9d6af30f307d26.jpeg', '易学', '一看就会，一做就废', '报名本课程后，点击去上课按钮，即可学习本课程', '戚风蛋糕', 'https://cp1.douguo.com/upload/caiku/5/4/6/690x390_54ada9e1b0fd2ea49b9d6af30f307d26.jpeg', '蛋糕里面最简单也最难烤的就是戚风，戚风戚风有时真的让人气疯，在摸索怎么把戚风烤得完美的道路上我走了整整几个月，试过好多配方，终于确定了这款戚风的方子，每次烤都非常成功', '19.90', '800', '2019-10-23', '2', '0', '2', '0');
INSERT INTO `course` VALUES ('3', 'http://vd4.bdstatic.com/mda-jawgahiiq4ytjv4e/sc/mda-jawgahiiq4ytjv4e.mp4', '雪梅娘', 'http://vd4.bdstatic.com/mda-jawgahiiq4ytjv4e/sc/mda-jawgahiiq4ytjv4e.mp4', '一学就废', '好吃', '报名本课程后，点击去上课按钮，即可学习本课程', '雪媚娘', 'https://cp1.douguo.com/upload/caiku/f/f/6/690x390_ff0e8fbcd08eb5a733d708301d86f566.jpg', '我很喜欢【雪梅娘】，因为她兼具糯米粉粘糯Q弹的口感、奶油的香甜润滑，还有水果的清新，再加上又有那么一个动听的名字，让我如何能不爱上它呢', '9.90', '200', '2019-10-23', '3', '1', '3', '1');

-- ----------------------------
-- Table structure for `detail`
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `memo` text COLLATE utf8_unicode_ci,
  `tips` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addTime` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL COMMENT '0不正常 1正常',
  `orderIndex` tinyint(4) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `introduce` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '介绍',
  `materials` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用料 用-分隔',
  `step` text COLLATE utf8_unicode_ci COMMENT '步骤',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES ('1', 'https://hbimg.huabanimg.com/155cb3c8007f0b10ad3f1b595750f0555f1285413221e-3QNpOH_fw658', '抹茶蛋糕', '不错不错', '做海绵蛋糕碎末时一定要去掉表层、边缘烤得发黄的部位，否则做出来的蛋糕颜色不漂亮 2.烤抹茶芝士蛋糕低温，烘烤的时间不能过长，烤出来的感觉是软软的，好像有一点未凝固，实则已经烤熟，经过冷藏，蛋糕自然凝固 3.蛋糕的脱模，用火枪转一圈或者热毛巾捂一捂，便可取下慕斯圈或者蛋糕模\r\n做菜好吃都有技巧，我的每道菜都有小妙招，大家搜索“豆果”可以直接查看我的菜谱！', '2019-10-23', '0', '2', '2', '双层芝士的缘故，可想而知蛋糕很厚实，更适合秋冬长膘保暖的季节食用，不过，抹茶粉的加入，让厚重的蛋糕有了一丝清爽，配上一杯柠檬苏打水，在这个炎炎夏日作为下午茶还是可行的哈哈！', '海绵蛋糕材料：	鸡蛋 2个\r\n细砂糖 60g	低粉 60g\r\n抹茶粉 5g	抹茶烤芝士蛋糕材料：\r\n奶油芝士 150g	细砂糖 50g\r\n低粉 5g	抹茶粉 5g\r\n淡奶油 30g	鸡蛋 1个\r\n冻芝士蛋糕材料：	蛋黄 1个\r\n细砂糖 30g	牛奶 30g\r\n吉利丁片 6g	马斯卡彭芝士 60g\r\n淡奶油 150g', '步骤1\r\n\r\n海绵蛋糕制作：细砂糖加入鸡蛋中，隔温水，用电动打蛋器打发至蛋糊变浓稠，滴落痕迹不易消失，再加入混合过筛的低粉和抹茶粉，用橡皮刮刀轻轻拌匀');
INSERT INTO `detail` VALUES ('2', 'http://pzo8sfe8e.bkt.clouddn.com/show5.jpg', '戚风蛋糕', '好吃想吃', '木糖醇是醇，细砂糖是糖，木糖醇有甜味，醇和糖从外观和味觉相识度极高', '2019-10-23', '1', '1', '1', '戚风蛋糕在网上有很多的方子，很多烘焙爱好者想烤戚风的时候，都参考了非常多的配方和做法。但是这些方子有的好，有的不好，良莠不齐，经常性的做失败，最后都被戚风气疯了。今天我们来说一个绝对的干货，戚风蛋糕一次就能做成功的做法，看这一个配方就够了，因为这个配方非常的准确！做戚风蛋糕，有的会加泡打粉，有的不需要加泡打粉，我们说的是不用泡打粉的这一种。', '材料：鸡蛋250克（大约5个不大不小的鸡蛋），低筋面粉85克，玉米油40克，牛奶40克，糖90克（其中60克用在蛋黄里，30克用在蛋黄里）', '一，准备工作：把低筋面粉过筛，蛋黄和蛋白分离开。来装蛋黄和蛋白的容器都要无水无油，就按照配方上的分量称准确，不要随意的去改变。');
INSERT INTO `detail` VALUES ('3', 'http://pzo8sfe8e.bkt.clouddn.com/show4.jpg', '千层糕', '美味美味', '马蹄粉容易沉底，蒸之前一定要充分搅拌均匀。\r\n做菜好吃都有技巧，我的每道菜都有小妙招，大家搜索“豆果”可以直接查看我的菜谱！', '2019-10-23', '1', '3', '3', '九九重阳节，叠叠千层糕。做给爸妈吃的，赞不绝口，Q弹的口感，椰汁的清香，平时做给小朋友吃也很不错哦。', '马蹄粉 250g	椰浆 400ml\r\n水 600ml	红糖/黄糖片 200g/2片\r\n炼奶', '步骤1\r\n\r\n红糖加入600ml清水熬至糖融化，糖水晾凉备用。');

-- ----------------------------
-- Table structure for `img`
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `memo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` tinyint(2) DEFAULT NULL,
  `workId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES ('1', 'https://hbimg.huabanimg.com/b3793c9fe5e0b69da22324bcc8998143b8c71ace2300c-hSW6LT_fw658', '软面包', '1', '1');
INSERT INTO `img` VALUES ('2', 'https://hbimg.huabanimg.com/213330b053e71fa22dc73eb0afb88b1298d1e1d62e229-1HhGhH_fw658', '生日蛋糕', '2', '2');
INSERT INTO `img` VALUES ('3', 'https://hbimg.huabanimg.com/155cb3c8007f0b10ad3f1b595750f0555f1285413221e-3QNpOH_fw658', '甜品', '3', '3');
INSERT INTO `img` VALUES ('4', 'https://hbimg.huabanimg.com/213330b053e71fa22dc73eb0afb88b1298d1e1d62e229-1HhGhH_fw658', null, null, '3');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `payType` tinyint(2) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `publisherId` int(11) DEFAULT NULL COMMENT '对应用户表user的id(发布者)',
  `orderIndex` tinyint(4) DEFAULT NULL,
  `state` tinyint(2) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `number` varchar(35) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单号',
  `subject` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单详情',
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '2019-10-23 15:19:51', '1', '1', '1', '0', '1', '9.90', '965325666253256662', '戳链接看订单详情', '超人气脆底生煎包');
INSERT INTO `order` VALUES ('2', '2', '2019-10-23 15:34:02', '2', '2', '1', '0', '0', '29.90', '965325666253256882', '戳链接看订单详情', '招牌蛋糕卷');
INSERT INTO `order` VALUES ('3', '3', '2019-10-22 15:35:28', '1', '3', '4', '1', '1', '19.90', '965325666253652882', '戳链接看订单详情', '芝士夹心曲奇');

-- ----------------------------
-- Table structure for `shopcart`
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderIndex` tinyint(4) DEFAULT NULL,
  `memo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of shopcart
-- ----------------------------
INSERT INTO `shopcart` VALUES ('1', '1', '1', '1', '加入购物车', '1');
INSERT INTO `shopcart` VALUES ('2', '2', '2', '0', '购物车', '0');
INSERT INTO `shopcart` VALUES ('3', '3', '3', '1', '愉快下单', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `imgUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nickName` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL COMMENT '0代表男 1代表女',
  `email` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL COMMENT '0不正常 1正常',
  `memo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orderIndex` tinyint(4) DEFAULT NULL,
  `telphone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '徐磊', '123', 'https://hbimg.huabanimg.com/1f35bd4aa2e9831624eb47e5d32782d39cc1e5181a25b9-XwJ7zs_fw658', 'Maodun', '1', '2458009530@qq.com', '九江', '18', '1', '帅', null, '15270054550');
INSERT INTO `user` VALUES ('2', '杨梦婷', '123', 'http://www.javacoffee.club/noPicture.svg', '美人鱼', '0', '3304944218@qq.com', '九江', '18', '1', '帅气', null, '18370006614');
INSERT INTO `user` VALUES ('3', '徐棣', '123', 'https://hbimg.huabanimg.com/24c5a4430bee4cb0b969d569a3884871b54fdbc316d97-CmVUOo_fw658', '大宝', '0', '3304944218@qq.com', '九江', '18', '0', '美美美', null, null);

-- ----------------------------
-- Table structure for `userlike`
-- ----------------------------
DROP TABLE IF EXISTS `userlike`;
CREATE TABLE `userlike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `workId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户点赞表';

-- ----------------------------
-- Records of userlike
-- ----------------------------
INSERT INTO `userlike` VALUES ('1', '1', null, '1');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `videoUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `memo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` tinyint(2) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `orderIndex` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='课程course表的视频';

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', 'jcfmhdhksv52z6a7.mp4', '千层糕制作视频', '0', '1', '2019-10-23 16:41:12', '1', '1');
INSERT INTO `video` VALUES ('2', 'https://vplay.douguo.com/XMzE5MjQwMTM4NA==__640x356.mp4', '戚风蛋糕', '1', '2', '2019-10-23 16:41:59', '2', '2');
INSERT INTO `video` VALUES ('3', 'jawgahiiq4ytjv4e.mp4', '雪媚娘制作', '1', '3', '2019-10-23 16:42:34', '3', '3');

-- ----------------------------
-- Table structure for `work`
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `title` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `addTime` date DEFAULT NULL,
  `state` tinyint(2) DEFAULT '1' COMMENT '0不正常 1正常',
  `count` int(11) DEFAULT NULL COMMENT '点赞数',
  `categoryId` int(11) DEFAULT NULL,
  `commentCount` int(11) DEFAULT NULL COMMENT '评论数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('1', '1', '第一次做蛋糕', '2019-10-23', '0', '50', '1', null);
INSERT INTO `work` VALUES ('2', '1', '曲奇的制作', '2019-10-22', '1', '20', '2', null);
INSERT INTO `work` VALUES ('3', '2', '雪媚娘的制作', '2019-10-21', '1', '3', '2', null);
INSERT INTO `work` VALUES ('4', '1', 'hahaha', '2019-10-28', null, null, null, null);
INSERT INTO `work` VALUES ('5', '1', '第四次', '2019-10-28', null, null, null, null);
INSERT INTO `work` VALUES ('6', '1', '第四次', '2019-10-28', null, null, null, null);
INSERT INTO `work` VALUES ('7', '1', '第5次', '2019-10-28', '1', null, null, null);
INSERT INTO `work` VALUES ('8', '1', '第6次', '2019-10-28', '1', null, null, null);
