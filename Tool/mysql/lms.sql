-- MySQL dump 10.13  Distrib 5.6.15, for Win64 (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lms_admin`
--

DROP TABLE IF EXISTS `lms_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lms_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createUser` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updateUser` varchar(255) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `deleteStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lms_admin`
--

LOCK TABLES `lms_admin` WRITE;
/*!40000 ALTER TABLE `lms_admin` DISABLE KEYS */;
INSERT INTO `lms_admin` VALUES (1,'admin','gdyb21LQTcIANtvYMT7QVQ==',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `lms_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lms_book`
--

DROP TABLE IF EXISTS `lms_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lms_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `indexNum` varchar(255) DEFAULT NULL,
  `bookName` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `categoryName` varchar(255) DEFAULT NULL,
  `bookStatus` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `press` varchar(255) DEFAULT NULL,
  `bookPicturePath` varchar(255) DEFAULT NULL,
  `summary` varchar(2000) DEFAULT NULL,
  `publishDate` date DEFAULT NULL,
  `createUser` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updateUser` varchar(255) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `deleteStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b2j008bga8uuotevdg1osbes5` (`indexNum`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lms_book`
--

LOCK TABLES `lms_book` WRITE;
/*!40000 ALTER TABLE `lms_book` DISABLE KEYS */;
INSERT INTO `lms_book` VALUES (1,'1001','数学之美（第二版）','9787111407022','计算机与互联网','不可借','吴军',66.8,'电子工业出版社','images/数学之美（第二版）.jpg','几年前，“数学之美”系列文章原刊载于谷歌黑板报，获得上百万次点击，得到读者高度评价。 正式出版前，吴军博士几乎把所有文章都重写了一遍，为的是把高深的数学原理讲得更加通俗易懂，让非专业读者也能领略数学的魅力。\r\n　　《数学之美》第一版上市后深受广大读者欢迎，并荣获国家图书馆第八届文津图书奖。读者说，读了《数学之美》，才发现大学时学的数学知识，比如马尔科夫链、矩阵计算，甚至余弦函数原来都如此亲切，并且栩栩如生，才发现自然语言和信息处理这么有趣。\r\n　　而今，数学在信息产业中的应用越来越广泛，因此，作者在第二版中增加了一些内容，尤其是针对大数据和机器学习的内容，以便满足人们对当下技术的学习需求。',NULL,NULL,NULL,'skye','2017-02-12',0),(2,'1002','Java编程思想(第4版)','9787111407033','计算机与互联网','不可借','埃史尔',75.2,'电子工业出版社','images/Java编程思想(第4版).jpg','《Java编程思想(第4版)》书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Iava’UO系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。从《Java编程思想(第4版)》一书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对c、c++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。',NULL,NULL,NULL,NULL,NULL,0),(3,'1003','算法导论(原书第3版)','9787111407010','计算机与互联网','不可借','Thomas H.Cormen',83.2,'机械工业出版社','images/算法导论(原书第3版).jpg','《算法导论(原书第3版)》内容简介：在有关算法的书中，有一些叙述非常严谨，但不够全面；另一些涉及了大量的题材，但又缺乏严谨性。《算法导论(原书第3版)》将严谨性和全面性融为一体，深入讨论各类算法，并着力使这些算法的设计和分析能为各个层次的读者接受。全书各章自成体系，可以作为独立的学习单元；算法以英语和伪代码的形式描述，具备初步程序设计经验的人就能看懂；说明和解释力求浅显易懂，不失深度和数学严谨性。全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，《算法导论(原书第3版)》也是一本案头必备的参考书或工程实践手册。',NULL,NULL,NULL,NULL,NULL,0),(4,'1004','深入浅出数据分析','9787121184772','计算机与互联网','可借','Michael Milton',68.6,'电子工业出版社','images/深入浅出数据分析 .jpg','《深入浅出数据分析》构思跌宕起伏，行文妙趣横生，无论读者是职场老手，还是业界新人；无论是字斟句酌，还是信手翻阅，都能跟着文字在职场中走上几回，体味数据分析领域的乐趣与挑战。',NULL,NULL,NULL,NULL,NULL,0),(5,'1005','算法(第4版)','9787115293800','计算机与互联网','不可借','Robert Sedgewick',60.3,'人民邮电出版社','images/算法(第4版).jpg','《图灵程序设计丛书:算法(第4版)》编辑推荐：Sedgewick之巨著，与高德纳TAOCP一脉相承，几十年多次修订，经久不衰的畅销书，涵盖所有程序员必须掌握的50种算法。《图灵程序设计丛书:算法(第4版)》全面讲述算法和数据结构的必备知识，具有以下几大特色：\r\n算法领域的经典参考书：Sedgewick畅销著作的最新版，反映了经过几十年演化而成的算法核心知识体系。\r\n内容全面：全面论述排序、搜索、图处理和字符串处理的算法和数据结构，涵盖每位程序员应知应会的50种算法。\r\n全新修订的代码：全新的Java实现代码，采用模块化的编程风格，所有代码均可供读者使用。\r\n与实际应用相结合：在重要的科学、工程和商业应用环境下探讨算法，给出了算法的实际代码，而非同类著作常用的伪代码。\r\n富于智力趣味性：简明扼要的内容，用丰富的视觉元素展示的示例，精心设计的代码，详尽的历史和科学背景知识，各种难度的练习，这一切都将使读者手不释卷。\r\n科学的方法：用合适的数学模型精确地讨论算法性能，这些模型是在真实环境中得到验证的。\r\n与网络相结合：配套网站algs4.cs.princeton.edu提供了本书内容的摘要及相关的代码、测试数据、编程练习、教学课件等资源。',NULL,NULL,NULL,NULL,NULL,0),(6,'1006','Effective Java中文版(第2版)','9787111255833','计算机与互联网','可借','Joshua Bloch',41,'机械工业出版社','images/Effective Java中文版(第2版).jpg','在Java编程中78条极具实用价值的经验规则，这些经验规则涵盖了大多数开发人员每天所面临的问题的解决方案。通过对Java平台设计专家所使用的技术的全面描述，揭示了应该做什么，不应该做什么才能产生清晰、健壮和高效的代码。第2版反映了Java 5中最重要的变化，并删去了过时的内容。\r\n《Sun 公司核心技术丛书:Effective Java中文版(第2版)》中的每条规则都以简短、独立的小文章形式出现，并通过示例代码加以进一步说明。\r\n《Sun 公司核心技术丛书:Effective Java中文版(第2版)》的内容包括：\r\n全新的泛型、枚举、注解、自动装箱、fof-each循环、可变参数、并发机制，等等。\r\n经典主题的全新技术和实践，包括对象．类、类库、方法和序列化。\r\n如何避免Java编程语言中常被误解的细微之处：陷阱和缺陷。',NULL,NULL,NULL,NULL,NULL,0),(7,'1007','鸟哥的Linux私房菜','9787115226266','计算机与互联网','可借','鸟哥',52.8,'人民邮电出版社','images/鸟哥的Linux私房菜.jpg','《鸟哥的Linux私房菜:基础学习篇》是具有知名度的Linux入门书《鸟哥的Linux私房菜基础学习篇》的最新版，全面而详细地介绍了Linux操作系统。《鸟哥的Linux私房菜:基础学习篇》分为5个部分：一部分着重说明Linux的起源及功能，如何规划和安装Linux主机；二部分介绍Linux的文件系统、文件、目录与磁盘的管理；三部分介绍文字模式接口shell和管理系统的好帮手shell脚本，另外还介绍了文字编辑器vi和vim的使用方法；四部分介绍了对于系统安全非常重要的Linux账号的管理，以及主机系统与程序的管理，如查看进程、任务分配和作业管理；五部分介绍了系统管理员(root)的管理事项，如了解系统运行状况、系统服务，针对登录文件进行解析，对系统进行备份以及核心的管理等。',NULL,NULL,NULL,NULL,NULL,0),(8,'2001','新版中日交流标准日本语初级(第2版)','9787107278303','外语学习','可借','人民教育出版社 (编者)',47.5,'人民教育出版社','images/新版中日交流标准日本语初级.jpg','《新版中日交流标准日本语 初级》上、下（第二版）精心策划，官方出品：中日双方编写者再次倾情奉献，精心设计，继续打造人教精品；与最新版教材同步，适合新日本语能力考试用书；手机阅读，离线使用：把《新版标准日本语》装进手机，出行学习不用背书，资源包单独下载，随时随地无流量、离线学习；新版内容，轻松学习：权威语法解释，精良互动练习，让书本知识变得有声有色，让日语学习不再枯燥，实现轻松、快乐学习；内容全面，逐步更新：五十音图示范教学，课文、生词中日文对照，音视频与内容同步播放，随时更新，让日语学习永远学在前沿。',NULL,NULL,NULL,NULL,NULL,0),(9,'2002','新概念英语1','9787560000008','外语学习','可借','日\r\nAlexander L. G.',71.8,'外语教学与研究出版社','imaegs/新概念英语1.jpg','《新概念英语1(套装共4册)》编辑推荐：《新概念英语》是世界闻名的英语教程。《新概念英语1(套装共4册)》将新概念英语学生用书及主要的辅导练习组合在一起，为新概念英语学习者选择提供方便。这套经典教材通过完整的英语学习体系，帮助学生掌握英语的4项基本技能——听、说、读、写，使学生能在学习中发挥自己的潜能。',NULL,NULL,NULL,NULL,NULL,0),(10,'3001','解忧杂货店','9787544270878','小说','可借','东野圭吾',26.6,'南海出版公司','imaegs/解忧杂货店.jpg','僻静的街道上有一家店，不仅销售杂货，还提供烦恼咨询。无论你挣扎犹豫，还是绝望痛苦，欢迎来信！《解忧杂货店》堪称东野圭吾在《白夜行》后很受欢迎的作品，不但荣获中央公论文艺奖，更登上纪伊国屋、诚品、博客来、金石堂等各大排行榜。东野圭吾这次选择的，是生活中平凡的片段：在事业和爱情间艰难抉择的运动员、离家打拼却屡遭挫折的音乐人、想要挣钱报答亲人的女招待……他们真诚又忐忑地写下信件，想要为自己的未来找到新的可能。互不相识的人因一家可以咨询烦恼的杂货店而走到一起，虽未谋面，心与心却真诚相对，这正是东野圭吾想要展现的力量：现代人内心流失的东西，这家杂货店能帮你找回。《解忧杂货店》充分展现了东野圭吾的创作才华。通过书信这种已渐渐淡出人们生活的交谈方式，人物依次登场，精巧的结构让温情、惊喜与感动悄然渗入读者心中，回味无穷。随书附赠解忧杂货店主题温馨书签。',NULL,NULL,NULL,NULL,NULL,0),(11,'3002','白夜行','9787544258609','小说','可借','东野圭吾',29.6,'南海出版公司','images/白夜行.jpg','《白夜行:东野圭吾作品02》讲述了多年以前，大阪的一栋废弃建筑中发现一名遭利器刺死男子的故事。案件扑朔迷离，始终悬而未决。此后20年间，案件滋生出的恶逐渐萌芽生长，绽放出恶之花。案件相关者的人生逐渐被越来越重的阴影笼罩……\r\n\r\n我的天空里没有太阳，总是黑夜，但并不暗，因为有东西代替了太阳。虽然没有太阳那么明亮，但对我来说已经足够。凭借着这份光，我便能把黑夜当成白天。我从来就没有太阳，所以不怕失去。\r\n\r\n《白夜行》出版之后引起巨大轰动，使东野圭吾成为天王级作家。小说被改编成同名电视连续剧，与图书一同为作家带来了如潮好评，使他成为日本、韩国与中国台湾等地很受欢迎的作家之一。“只希望能手牵手在太阳下散步”，这句象征《白夜行:东野圭吾作品02》故事内核的绝望念想，有如一个美丽的幌子，随着无数凌乱、压抑、悲凉的事件片段如纪录片一样一一还原，最后一丝温情也被完全抛弃，万千读者在一曲救赎罪恶的爱情之中悲切动容。',NULL,NULL,NULL,NULL,NULL,0),(12,'3003','摆渡人','9787550013247','小说','可借','克莱儿·麦克福尔',23.2,'百花洲文艺出版社','imaegs/摆渡人.jpg','单亲女孩迪伦，15岁的世界一片狼藉：与母亲总是无话可说，在学校里经常受到同学的捉弄，唯独谈得来的好友也因为转学离开了。这一切都让迪伦感到无比痛苦。\r\n她决定去看望久未谋面的父亲，然而，路上突发交通事故。等她拼命爬出火车残骸之后，却惊恐地发现，自己是仅有的幸存者，而眼前，竟是一片荒原。\r\n此时，迪伦看到不远处的山坡上一个男孩的身影。\r\n男孩将她带离了事故现场。但是，迪伦很快意识到，男孩并不是偶然出现的路人，他似乎是特意在此等候。\r\n命运，从他们相遇的那刻开始，发生了无法预料的转变……',NULL,NULL,NULL,NULL,NULL,0),(13,'3004','追风筝的人','9787550013246','小说','不可借','Khaled Hosseini',29,'上海人民出版社','imaegs/追风筝的人.jpg','12岁的阿富汗富家少爷阿米尔与仆人哈桑情同手足。然而，在一场风筝比赛后，发生了一件悲惨不堪的事，阿米尔为自己的懦弱感到自责和痛苦，逼走了哈桑，不久，自己也跟随父亲逃往美国。\r\n成年后的阿米尔始终无法原谅自己当年对哈桑的背叛。为了赎罪，阿米尔再度踏上暌违二十多年的故乡，希望能为不幸的好友尽最后一点心力，却发现一个惊天谎言，儿时的噩梦再度重演，阿米尔该如何抉择？\r\n故事如此残忍而又美丽，作者以温暖细腻的笔法勾勒人性的本质与救赎，读来令人荡气回肠。',NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `lms_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lms_record`
--

DROP TABLE IF EXISTS `lms_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lms_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `borrowDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `effectiveDate` date DEFAULT NULL,
  `borrowStatus` varchar(255) DEFAULT NULL,
  `createUser` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updateUser` varchar(255) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `deleteStatus` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `book_id` bigint(20) DEFAULT NULL,
  `renewStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmod1tubllme96q3do99ihhxwn` (`user_id`),
  KEY `FKlar1mlhul5620e3lh9t58nmpi` (`book_id`),
  CONSTRAINT `FKlar1mlhul5620e3lh9t58nmpi` FOREIGN KEY (`book_id`) REFERENCES `lms_book` (`id`),
  CONSTRAINT `FKmod1tubllme96q3do99ihhxwn` FOREIGN KEY (`user_id`) REFERENCES `lms_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lms_record`
--

LOCK TABLES `lms_record` WRITE;
/*!40000 ALTER TABLE `lms_record` DISABLE KEYS */;
INSERT INTO `lms_record` VALUES (2,'2017-02-12',NULL,'2016-12-15','阅读中','skye','2017-02-12','skye','2017-02-13',0,1,2,1),(3,'2017-02-12',NULL,'2017-01-24','申请借阅中','skye','2017-02-12',NULL,NULL,0,1,3,NULL),(4,'2017-02-12','2017-02-12','2017-01-24','已归还','skye','2017-02-12','skye','2017-02-12',0,1,1,NULL),(5,'2017-02-12','2017-02-12','2017-01-24','已归还','skye','2017-02-12','skye','2017-02-12',0,1,1,NULL),(6,'2017-02-12',NULL,'2017-01-24','阅读中','skye','2017-02-12','skye','2017-02-12',0,1,1,NULL);
/*!40000 ALTER TABLE `lms_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lms_user`
--

DROP TABLE IF EXISTS `lms_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lms_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eid` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `borrowedCount` int(11) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `borrowCountLimit` int(11) DEFAULT NULL,
  `createUser` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `updateUser` varchar(255) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  `deleteStatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fghgv37cukamdgkjefw0grk76` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lms_user`
--

LOCK TABLES `lms_user` WRITE;
/*!40000 ALTER TABLE `lms_user` DISABLE KEYS */;
INSERT INTO `lms_user` VALUES (1,'skye','仓央嘉措','gdyb21LQTcIANtvYMT7QVQ==','admin','13356789567',0,'banet',10,NULL,NULL,'skye','2017-02-12',0),(2,'admin','李四','gdyb21LQTcIANtvYMT7QVQ==','admin','13356789567',0,'banet',10,NULL,NULL,'',NULL,1),(3,'tom','王五','gdyb21LQTcIANtvYMT7QVQ==','normal','15534256758',0,'wat',5,NULL,NULL,'',NULL,0),(4,'jack','赵六','gdyb21LQTcIANtvYMT7QVQ==','normal','17770770987',0,'wat',5,NULL,NULL,'',NULL,0),(5,'mark','沈七','gdyb21LQTcIANtvYMT7QVQ==','normal','14419192345',0,'wat',5,NULL,NULL,'',NULL,0),(6,'xiu.yi','一休','gdyb21LQTcIANtvYMT7QVQ==','normal','18845678675',0,'wat',5,NULL,NULL,NULL,NULL,0),(7,'touhuo.shan','山头火','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'banet',5,NULL,NULL,NULL,NULL,0),(8,'jiang.song','宋江','gdyb21LQTcIANtvYMT7QVQ==','admin','18845678675',0,'banet',5,NULL,NULL,NULL,NULL,0),(9,'junyi.lu','卢俊义','gdyb21LQTcIANtvYMT7QVQ==','admin','17070743456',0,'banet',5,NULL,NULL,NULL,NULL,0),(10,'yong.wu','吴用','gdyb21LQTcIANtvYMT7QVQ==','normal','14419192345',0,'wat',5,NULL,NULL,NULL,NULL,0),(11,'bei.liu','刘备','gdyb21LQTcIANtvYMT7QVQ==','normal','13356789567',0,'others',5,NULL,NULL,NULL,NULL,0),(12,'fei.zhang','张飞','CE43y1+R//255Gy6q02xUQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(13,'yu.guan','关羽','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(14,'zilong.zhao','赵子龙','gdyb21LQTcIANtvYMT7QVQ==','normal','13356789567',0,'others',5,NULL,NULL,NULL,NULL,0),(15,'chao.ma','马超','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(16,'zhong.huang','黄忠','gdyb21LQTcIANtvYMT7QVQ==','normal','13356789567',0,'others',5,NULL,NULL,NULL,NULL,0),(17,'liang.zhuge','诸葛亮','gdyb21LQTcIANtvYMT7QVQ==','admin','13356789567',0,'others',5,NULL,NULL,NULL,NULL,0),(18,'tong.pang','庞统','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(19,'yi.sima','司马懿','gdyb21LQTcIANtvYMT7QVQ==','admin','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(20,'wei.dian','典韦','gdyb21LQTcIANtvYMT7QVQ==','normal','13356789567',0,'others',5,NULL,NULL,NULL,NULL,0),(21,'yu.zhou','周瑜','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(22,'jia.guo','郭嘉','gdyb21LQTcIANtvYMT7QVQ==','normal','13356789567',0,'others',5,NULL,NULL,NULL,NULL,0),(23,'erniang.sun','孙二娘','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(24,'zetian.wu','武则天','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(25,'ailing.zhang','张爱玲','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(26,'xiaoxian.zhang','张小娴','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(27,'huiyin.lin','林徽因','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(28,'zhimo.xu','徐志摩','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(29,'shumin.bi','毕淑敏','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(30,'kangkang.zhang','张抗抗','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(31,'zijian.chi','迟子建','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(32,'hongjian.fang','方鸿渐','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(33,'zhongshu.qian','钱钟书','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(34,'xueseng.qian','钱钟书','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(35,'sanqiang.qian','钱三强','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(36,'jiang.yang','杨绛','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(37,'enlai.zhou','周恩来','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(38,'xiaoping.deng','邓小平','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(39,'guofeng.hua','华国锋','gdyb21LQTcIANtvYMT7QVQ==','normal','17070743456',0,'others',5,NULL,NULL,NULL,NULL,0),(40,'biao.lin','林彪','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(41,'xiangqian.xu','徐向前','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(42,'dehuai.peng','彭德怀','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(43,'ting.ye','叶挺','gdyb21LQTcIANtvYMT7QVQ==','normal','13978785678',0,'others',5,NULL,NULL,NULL,NULL,0),(44,'xiaofeng,xie','谢晓峰','gdyb21LQTcIANtvYMT7QVQ==','normal','18504345678',0,'others',20,'xiaofeng,xie','2017-01-16',NULL,NULL,0),(45,'shisan.yan','燕十三','gdyb21LQTcIANtvYMT7QVQ==','normal','18504345678',0,'others',10,'shisan.yan','2017-01-16',NULL,NULL,0),(47,'zongsheng.li',' 李宗盛','gdyb21LQTcIANtvYMT7QVQ==','normal','18504345678',0,'others',10,'zongsheng.li','2017-01-16',NULL,NULL,0);
/*!40000 ALTER TABLE `lms_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-16 23:27:30
