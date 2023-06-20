-- MySQL dump 10.13  Distrib 5.7.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: supermarket
-- ------------------------------------------------------
-- Server version	5.7.28

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
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '商品名',
  `stock` int(10) unsigned NOT NULL COMMENT '库存',
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `good_id_stock_price_index` (`id`,`stock`,`price`)
) ENGINE=InnoDB AUTO_INCREMENT=2026 DEFAULT CHARSET=utf8 COMMENT='商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` VALUES (1026,'橙子香水',54,306.55),(1027,'蜂蜜燕麦片',363,965.48),(1028,'香草冰淇淋',789,830.36),(1029,'蜂蜜酸奶',35,598.61),(1030,'薄荷沐浴盐',294,618.01),(1031,'香蕉牛奶',906,608.97),(1032,'蜂蜜燕麦片',923,753.73),(1033,'椰子牛奶',922,556.68),(1034,'椰子饼干',772,459.84),(1035,'香蕉曲奇',994,262.69),(1036,'酸奶饮料',981,557.26),(1037,'花生酱',36,233.39),(1038,'绿茶包',493,415.43),(1039,'烤玉米',487,154.69),(1040,'烧烤鸡翅',586,926.65),(1041,'松露巧克力',453,841.39),(1042,'烧烤鸡翅',374,32.93),(1043,'蜂蜜面膜',191,351.44),(1044,'鸡蛋汤',8,870.47),(1045,'甜菜根汁',455,66.06),(1046,'葡萄干',596,333.59),(1047,'烤玉米',191,487.97),(1048,'蜂蜜面包',730,951.71),(1049,'薯片',452,372.87),(1050,'香橙巧克力',666,412.53),(1051,'烤肉串',965,201.95),(1052,'香橙面膜',876,574.96),(1053,'花生酱',415,518.34),(1054,'煎蛋饼',31,379.50),(1055,'深焙咖啡豆',276,819.89),(1056,'蜂蜜酸奶',450,614.52),(1057,'酸奶饮料',414,238.51),(1058,'橄榄蜡烛',623,572.62),(1059,'椰子牛奶',885,868.66),(1060,'鸡蛋三明治',101,559.18),(1061,'草莓冰淇淋',305,696.54),(1062,'橙子冰沙',685,661.82),(1063,'深焙咖啡豆',821,547.63),(1064,'花生酱饼干',139,56.04),(1065,'烤牛排',212,850.24),(1066,'柠檬洗洁精',646,886.00),(1067,'椰子饼干',307,956.32),(1068,'橙味清洁剂',735,192.86),(1069,'香辣鸡翅',206,362.11),(1070,'香草奶昔',951,70.82),(1071,'芒果香皂',272,169.60),(1072,'牛肉汉堡',442,777.76),(1073,'白葡萄酒',439,30.19),(1074,'冰淇淋筒',63,366.24),(1075,'香辣鸡翅',764,534.09),(1076,'绿茶包',52,977.90),(1077,'香草冰淇淋',228,919.74),(1078,'甜菜根汁',592,862.53),(1079,'蓝莓果酱',699,890.50),(1080,'巧克力饼干',390,615.47),(1081,'椰子饼干',932,677.83),(1082,'酸奶饮料',601,342.15),(1083,'松露巧克力',292,533.55),(1084,'蜂蜜柚子茶',47,340.31),(1085,'蜂蜜燕麦饼',716,142.09),(1086,'柠檬洗洁精',623,45.97),(1087,'芒果洗发水',873,949.98),(1088,'红葡萄酒',23,778.41),(1089,'烤玉米',435,607.20),(1090,'巧克力曲奇',954,408.18),(1091,'烤鸡腿',68,284.37),(1092,'煎蛋饼',507,820.47),(1093,'烤玉米',322,900.79),(1094,'葡萄柚果汁',92,53.96),(1095,'芝士披萨',846,698.09),(1096,'红葡萄酒',913,133.04),(1097,'橙子冰沙',774,386.38),(1098,'葡萄干',985,366.73),(1099,'牛奶巧克力',227,21.49),(1100,'酸黄瓜汤',379,911.04),(1101,'牛奶巧克力',594,654.57),(1102,'花生酱饼干',73,873.83),(1103,'酸黄瓜汤',68,292.72),(1104,'柠檬洗洁精',35,718.18),(1105,'巧克力饼干',281,781.49),(1106,'薄荷口香糖',230,708.55),(1107,'甜菜根汁',19,650.68),(1108,'薯片',295,502.03),(1109,'鸡肉馄饨',946,703.26),(1110,'蜂蜜柚子茶',322,373.78),(1111,'橄榄蜡烛',312,601.36),(1112,'香辣鸡翅',40,179.51),(1113,'蜂蜜燕麦饼',177,367.47),(1114,'红葡萄酒',847,979.90),(1115,'香草奶昔',878,222.87),(1116,'橙子果汁',776,548.62),(1117,'花生酱',670,628.93),(1118,'葡萄柚果汁',832,450.91),(1119,'烤肉串',981,339.22),(1120,'柠檬洗衣液',680,171.04),(1121,'椰子饼干',540,516.34),(1122,'蜂蜜柚子茶',879,426.18),(1123,'香草冰淇淋',216,724.17),(1124,'烤玉米',35,123.08),(1125,'酸黄瓜片',866,695.74),(1126,'香辣鸡翅',813,40.92),(1127,'芒果香皂',46,371.02),(1128,'煎蛋饼',443,610.79),(1129,'香橙巧克力',747,258.94),(1130,'橙子洗手液',348,127.40),(1131,'橙子洗手液',420,945.88),(1132,'芝士披萨',402,280.59),(1133,'香蕉沐浴露',179,384.01),(1134,'柠檬洗衣液',958,245.06),(1135,'巧克力饼干',361,939.87),(1136,'酸黄瓜汤',632,768.43),(1137,'花生酱饼干',992,250.68),(1138,'酸黄瓜脆片',218,410.30),(1139,'香蕉曲奇',524,317.33),(1140,'黑巧克力',182,836.75),(1141,'冰淇淋筒',490,39.81),(1142,'芒果香皂',755,996.23),(1143,'薄荷口香糖',150,23.70),(1144,'香橙牛肉',650,114.11),(1145,'酸黄瓜脆片',476,816.69),(1146,'烤肉串',397,23.21),(1147,'薄荷口香糖',864,220.21),(1148,'柠檬鸡肉',313,839.43),(1149,'烤肉串',594,737.37),(1150,'橙子口红',830,632.59),(1151,'蜂蜜燕麦片',148,127.90),(1152,'柠檬鸡肉',409,134.11),(1153,'芒果洗发水',175,34.15),(1154,'香草蜡烛',749,176.26),(1155,'香蕉牛奶',969,723.60),(1156,'红葡萄酒',684,631.56),(1157,'熏制火腿',321,833.97),(1158,'酸奶饮料',969,446.73),(1159,'烤肉串',317,403.33),(1160,'香蕉曲奇',437,918.14),(1161,'橄榄蜡烛',328,177.47),(1162,'花生酱饼干',161,883.07),(1163,'蓝莓果酱',60,634.19),(1164,'蜂蜜面膜',636,240.31),(1165,'薄荷沐浴盐',352,166.12),(1166,'鸡蛋汤',762,786.21),(1167,'蓝莓酸奶',123,520.65),(1168,'蘑菇罐头',543,683.82),(1169,'橙子口红',584,39.03),(1170,'蜂蜜面膜',452,376.44),(1171,'椰子饼干',743,952.19),(1172,'红酒醋',531,682.20),(1173,'红酒醋',364,243.52),(1174,'椰子沐浴露',32,590.50),(1175,'绿茶包',626,815.94),(1176,'煎蛋饼',680,374.77),(1177,'洋葱粉',582,69.62),(1178,'薯片',779,627.62),(1179,'薄荷沐浴盐',985,810.32),(1180,'草莓果冻',64,391.53),(1181,'蜂蜜面膜',545,576.20),(1182,'橙子洗手液',457,714.38),(1183,'冰淇淋筒',114,688.34),(1184,'柠檬洗洁精',721,652.41),(1185,'芝士披萨',569,571.36),(1186,'香蕉沐浴露',108,576.89),(1187,'柠檬鸡肉',114,908.08),(1188,'蜂蜜酸奶',554,302.38),(1189,'椰子饼干',706,365.92),(1190,'柠檬洗衣液',925,8.54),(1191,'芝士披萨',414,200.77),(1192,'烤鸭胸肉',255,44.38),(1193,'蜂蜜面包',122,218.78),(1194,'深焙咖啡豆',125,165.71),(1195,'香橙牛肉',464,219.44),(1196,'香草蜡烛',166,972.71),(1197,'香蕉沐浴露',226,961.62),(1198,'黑巧克力',168,640.78),(1199,'洋葱粉',539,641.95),(1200,'橄榄油',537,166.30),(1201,'蜂蜜燕麦片',270,94.86),(1202,'柠檬洗发水',441,512.25),(1203,'黑巧克力',279,500.50),(1204,'橙味清洁剂',209,757.61),(1205,'深焙咖啡豆',839,706.85),(1206,'薄荷沐浴盐',837,8.55),(1207,'柠檬洗洁精',129,862.84),(1208,'甜菜根汁',146,890.56),(1209,'绿茶包',860,637.70),(1210,'芒果冰沙',204,475.42),(1211,'薄荷口香糖',768,783.75),(1212,'柠檬洗洁精',421,85.35),(1213,'烤玉米',330,636.74),(1214,'柠檬洗洁精',567,451.45),(1215,'黑巧克力',128,153.01),(1216,'香蕉沐浴露',312,338.67),(1217,'烤玉米',878,164.47),(1218,'薯片',56,368.82),(1219,'草莓冰淇淋',555,933.24),(1220,'巧克力饼干',647,637.61),(1221,'牛肉汉堡',798,229.08),(1222,'香草蜡烛',340,264.13),(1223,'薯片',7,592.97),(1224,'柠檬鸡肉',352,399.18),(1225,'香橙牛肉',252,91.30),(1226,'柠檬洗衣液',690,294.26),(1227,'柠檬洗衣液',17,249.66),(1228,'牛奶巧克力',136,826.31),(1229,'香蕉牛奶',389,45.08),(1230,'牛肉汉堡',298,332.53),(1231,'香辣鸡翅',646,247.10),(1232,'橙子口红',110,755.55),(1233,'葡萄干',206,47.25),(1234,'花生酱',278,8.53),(1235,'椰子牛奶',18,781.42),(1236,'橄榄蜡烛',441,371.01),(1237,'鸡肉卷',602,799.21),(1238,'酸黄瓜片',177,474.85),(1239,'蜂蜜燕麦片',499,293.01),(1240,'葡萄柚果汁',830,197.03),(1241,'牛奶巧克力',268,83.53),(1242,'草莓冰淇淋',178,292.61),(1243,'白葡萄酒',706,424.74),(1244,'柠檬洗发水',254,256.12),(1245,'花生酱饼干',889,903.16),(1246,'芒果洗发水',85,579.14),(1247,'葡萄干',960,569.43),(1248,'柠檬洗衣液',992,83.48),(1249,'鸡蛋汤',374,309.83),(1250,'葡萄汁',597,326.72),(1251,'烤玉米',713,913.67),(1252,'花生酱',503,502.08),(1253,'洋葱粉',107,849.69),(1254,'洋葱粉',69,245.03),(1255,'冰淇淋筒',377,66.10),(1256,'草莓果冻',199,744.35),(1257,'香辣鸡翅',555,542.74),(1258,'烤鱼片',253,205.21),(1259,'巧克力曲奇',71,248.68),(1260,'芒果洗发水',656,913.63),(1261,'巧克力曲奇',41,616.27),(1262,'香橙巧克力',811,199.71),(1263,'橙味清洁剂',987,357.16),(1264,'蜂蜜香皂',299,374.52),(1265,'香橙牛肉',307,176.67),(1266,'芒果香皂',563,43.81),(1267,'椰子饼干',297,484.86),(1268,'蜂蜜酸奶',742,820.60),(1269,'香醋',420,261.35),(1270,'葡萄汁',88,189.59),(1271,'香草冰淇淋',922,142.39),(1272,'香草奶昔',286,105.47),(1273,'椰子沐浴露',421,207.19),(1274,'巧克力曲奇',913,877.94),(1275,'香醋',289,694.77),(1276,'巧克力饼干',860,147.52),(1277,'烤鱼片',483,316.53),(1278,'香橙巧克力',19,828.11),(1279,'草莓冰淇淋',847,333.76),(1280,'松露巧克力',151,44.33),(1281,'熏制火腿',195,717.42),(1282,'鸡蛋三明治',976,921.41),(1283,'绿茶包',127,409.28),(1284,'松露巧克力',684,527.05),(1285,'甜菜根汁',114,625.81),(1286,'葡萄汁',961,415.17),(1287,'芒果香皂',939,789.23),(1288,'柠檬鸡肉',268,470.60),(1289,'橙子果汁',318,382.67),(1290,'鸡肉卷',897,457.21),(1291,'烤玉米',342,537.20),(1292,'香草奶昔',532,965.78),(1293,'蜂蜜燕麦片',655,726.37),(1294,'酸黄瓜脆片',12,495.40),(1295,'橙子口红',787,964.71),(1296,'烤玉米',569,460.91),(1297,'香蕉牛奶',400,460.69),(1298,'巧克力蛋糕',60,705.54),(1299,'鸡蛋汤',510,675.36),(1300,'葡萄干',513,89.94),(1301,'蜂蜜燕麦饼',564,752.75),(1302,'香蕉沐浴露',763,440.74),(1303,'橄榄蜡烛',403,178.75),(1304,'鸡肉馄饨',793,704.72),(1305,'洋葱粉',265,684.44),(1306,'酸奶饮料',737,419.99),(1307,'葡萄干',627,300.25),(1308,'香蕉曲奇',26,843.54),(1309,'香橙牛肉',548,401.39),(1310,'葡萄柚果汁',715,378.12),(1311,'巧克力蛋糕',395,878.27),(1312,'葡萄柚果汁',594,299.46),(1313,'芒果冰沙',625,282.28),(1314,'薯片',170,771.79),(1315,'花生酱饼干',903,764.93),(1316,'柠檬洗发水',428,631.12),(1317,'橙子口红',581,520.15),(1318,'深焙咖啡豆',125,314.16),(1319,'柠檬洗洁精',21,369.05),(1320,'烤肉串',748,577.64),(1321,'巧克力蛋糕',859,667.30),(1322,'椰子沐浴露',687,103.06),(1323,'烤牛排',652,965.83),(1324,'香草冰淇淋',1000,99.08),(1325,'蜂蜜香皂',782,29.27),(1326,'蓝莓果酱',61,788.47),(1327,'香醋',779,504.85),(1328,'烤鸭胸肉',946,961.55),(1329,'烧烤鸡翅',511,576.28),(1330,'香草蜡烛',312,277.99),(1331,'橙子香水',396,847.19),(1332,'橙味清洁剂',750,602.52),(1333,'煎蛋饼',557,697.35),(1334,'薯片',747,157.38),(1335,'香橙面膜',930,311.93),(1336,'蜂蜜燕麦粥',93,556.61),(1337,'香辣鸡翅',422,739.98),(1338,'熏制火腿',534,289.78),(1339,'素食罐头',496,180.01),(1340,'素食罐头',42,69.19),(1341,'烤鸭胸肉',780,714.49),(1342,'巧克力蛋糕',189,366.51),(1343,'鸡蛋汤',8,543.00),(1344,'橙味清洁剂',563,462.33),(1345,'蘑菇罐头',981,205.70),(1346,'橄榄油',813,489.65),(1347,'煎蛋饼',416,429.71),(1348,'巧克力饼干',181,417.10),(1349,'烤玉米',947,340.11),(1350,'蜂蜜面膜',336,70.65),(1351,'烤玉米',776,955.04),(1352,'牛奶巧克力',241,621.08),(1353,'烧烤鸡翅',687,777.24),(1354,'橙子香水',529,793.94),(1355,'橄榄蜡烛',897,739.17),(1356,'蓝莓酸奶',593,166.66),(1357,'花生酱',696,970.13),(1358,'香橙巧克力',826,202.73),(1359,'鸡蛋三明治',516,478.11),(1360,'花生酱',443,785.85),(1361,'蓝莓酸奶',554,372.56),(1362,'蜂蜜酸奶',66,647.84),(1363,'芒果冰沙',24,59.69),(1364,'葡萄汁',473,741.68),(1365,'蘑菇罐头',906,26.25),(1366,'柠檬蛋糕',57,713.58),(1367,'葡萄干',987,526.50),(1368,'橙子冰沙',659,357.94),(1369,'薄荷沐浴盐',12,732.41),(1370,'草莓冰淇淋',783,398.38),(1371,'牛肉汉堡',675,73.36),(1372,'蜂蜜柚子茶',520,502.54),(1373,'巧克力曲奇',897,232.31),(1374,'白葡萄酒',859,793.68),(1375,'芝士意面',5,42.76),(1376,'蜂蜜柚子茶',464,591.37),(1377,'蜂蜜柚子茶',210,508.61),(1378,'鸡蛋汤',335,617.21),(1379,'蓝莓酸奶',751,700.58),(1380,'鸡蛋汤',281,274.07),(1381,'蜂蜜燕麦片',134,518.88),(1382,'橙子果汁',151,231.92),(1383,'烤玉米',227,675.29),(1384,'巧克力饼干',817,960.11),(1385,'葡萄汁',257,476.75),(1386,'烤肉串',28,632.04),(1387,'甜菜根汁',4,188.28),(1388,'酸奶饮料',802,792.06),(1389,'橄榄蜡烛',481,740.30),(1390,'烤玉米',26,864.75),(1391,'鸡蛋汤',594,851.56),(1392,'蓝莓酸奶',791,497.37),(1393,'葡萄干',152,130.05),(1394,'鸡蛋三明治',985,542.58),(1395,'草莓果冻',75,236.81),(1396,'柠檬洗洁精',859,826.64),(1397,'烤鸭胸肉',707,974.32),(1398,'鸡肉卷',902,841.44),(1399,'烤肉串',368,141.63),(1400,'洋葱粉',954,536.80),(1401,'红葡萄酒',825,48.66),(1402,'芒果香皂',666,843.18),(1403,'烤肉串',901,728.89),(1404,'芒果洗发水',754,55.42),(1405,'柠檬洗发水',259,690.49),(1406,'香草蜡烛',747,871.79),(1407,'花生酱',939,153.14),(1408,'香草冰淇淋',899,821.50),(1409,'烤牛排',404,749.61),(1410,'深焙咖啡豆',169,532.03),(1411,'甜菜根汁',267,941.05),(1412,'酸黄瓜汤',458,72.77),(1413,'蘑菇罐头',253,182.42),(1414,'香橙牛肉',651,388.28),(1415,'芒果香皂',413,895.74),(1416,'柠檬洗衣液',323,853.73),(1417,'橄榄蜡烛',188,307.47),(1418,'蓝莓果酱',871,789.94),(1419,'蜂蜜面包',915,624.34),(1420,'酸黄瓜汤',493,387.13),(1421,'绿茶包',285,701.51),(1422,'芒果香皂',475,707.83),(1423,'蜂蜜燕麦粥',464,396.68),(1424,'香辣鸡翅',473,334.37),(1425,'橙子洗手液',450,35.64),(1426,'香醋',694,769.06),(1427,'橄榄蜡烛',901,268.42),(1428,'橄榄蜡烛',491,674.88),(1429,'薄荷口香糖',940,832.00),(1430,'黑巧克力',314,364.76),(1431,'煎蛋饼',219,420.83),(1432,'葡萄柚果汁',972,456.18),(1433,'酸黄瓜脆片',790,286.64),(1434,'香草奶昔',531,407.81),(1435,'香橙牛肉',635,359.87),(1436,'烤鸡腿',578,30.23),(1437,'烤鸡腿',19,907.91),(1438,'蜂蜜柚子茶',947,788.87),(1439,'松露巧克力',570,38.47),(1440,'蜂蜜香皂',609,899.20),(1441,'橙味清洁剂',585,262.06),(1442,'甜菜根汁',722,454.57),(1443,'烤鸭胸肉',955,763.16),(1444,'冰淇淋筒',848,548.56),(1445,'鸡肉卷',501,896.17),(1446,'白葡萄酒',129,215.78),(1447,'橙味清洁剂',406,273.62),(1448,'黑巧克力',877,731.56),(1449,'素食罐头',851,915.86),(1450,'薄荷口香糖',809,624.83),(1451,'香橙牛肉',467,802.95),(1452,'素食罐头',122,457.92),(1453,'香蕉牛奶',285,910.22),(1454,'芝士意面',58,362.35),(1455,'甜菜根汁',551,3.41),(1456,'蜂蜜面膜',727,658.50),(1457,'大蒜粉',899,111.99),(1458,'绿茶包',900,196.96),(1459,'葡萄干',494,581.35),(1460,'柠檬蛋糕',112,981.29),(1461,'柠檬洗衣液',948,395.45),(1462,'香草冰淇淋',363,502.23),(1463,'香草奶昔',288,555.36),(1464,'橙子洗手液',437,609.26),(1465,'香辣鸡翅',30,301.82),(1466,'红酒醋',671,970.09),(1467,'香草冰淇淋',376,347.12),(1468,'芒果香皂',888,463.71),(1469,'鸡蛋三明治',562,349.92),(1470,'芒果香皂',740,487.26),(1471,'酸黄瓜汤',580,842.44),(1472,'甜菜根汁',697,812.79),(1473,'香橙巧克力',487,656.54),(1474,'橙子洗手液',128,782.65),(1475,'香橙牛肉',15,312.97),(1476,'芒果香皂',82,792.26),(1477,'大蒜粉',928,505.49),(1478,'香蕉沐浴露',487,708.60),(1479,'橙味清洁剂',622,929.55),(1480,'香辣鸡翅',946,920.92),(1481,'薄荷口香糖',426,925.77),(1482,'烤鸡腿',667,294.70),(1483,'芒果冰沙',903,904.64),(1484,'柠檬蛋糕',890,216.94),(1485,'大蒜粉',212,47.19),(1486,'芒果洗发水',505,706.13),(1487,'白葡萄酒',395,455.38),(1488,'椰子饼干',927,840.10),(1489,'烧烤鸡翅',572,763.64),(1490,'薄荷口香糖',516,556.97),(1491,'红酒醋',865,660.72),(1492,'蜂蜜面包',600,64.34),(1493,'鸡蛋三明治',344,491.66),(1494,'牛奶巧克力',80,850.77),(1495,'葡萄汁',190,886.83),(1496,'烤肉串',824,427.71),(1497,'蜂蜜燕麦粥',317,995.24),(1498,'薄荷口香糖',373,812.45),(1499,'白葡萄酒',813,140.36),(1500,'鸡蛋汤',600,999.11),(1501,'巧克力曲奇',299,514.45),(1502,'薄荷口香糖',309,157.21),(1503,'煎蛋饼',377,291.14),(1504,'香醋',854,919.78),(1505,'香蕉牛奶',191,807.15),(1506,'素食罐头',205,521.85),(1507,'香橙牛肉',155,199.31),(1508,'蜂蜜面膜',46,337.96),(1509,'柠檬蛋糕',359,894.76),(1510,'草莓果冻',577,177.54),(1511,'芒果香皂',580,639.01),(1512,'椰子牛奶',791,254.78),(1513,'香草冰淇淋',937,969.95),(1514,'薄荷沐浴盐',620,108.06),(1515,'烤玉米',146,626.86),(1516,'香辣鸡翅',891,542.00),(1517,'甜菜根汁',60,818.11),(1518,'香辣鸡翅',611,465.54),(1519,'橙子果汁',81,938.98),(1520,'椰子牛奶',575,506.38),(1521,'蜂蜜香皂',668,45.03),(1522,'椰子沐浴露',128,226.82),(1523,'橄榄蜡烛',791,691.44),(1524,'大蒜粉',561,375.67),(1525,'葡萄柚果汁',921,835.14),(1526,'黑巧克力',672,220.93),(1527,'蜂蜜燕麦饼',203,693.74),(1528,'烧烤鸡翅',691,167.45),(1529,'花生酱',754,265.46),(1530,'柠檬蛋糕',811,692.48),(1531,'香草蜡烛',769,183.79),(1532,'椰子饼干',16,365.99),(1533,'橄榄蜡烛',804,207.45),(1534,'椰子饼干',795,526.90),(1535,'烧烤鸡翅',234,964.26),(1536,'巧克力饼干',965,820.63),(1537,'柠檬蛋糕',252,360.24),(1538,'蘑菇罐头',803,123.13),(1539,'烤肉串',391,27.27),(1540,'柠檬鸡肉',510,806.98),(1541,'柠檬洗衣液',702,907.86),(1542,'柠檬蛋糕',617,116.30),(1543,'冰淇淋筒',622,467.84),(1544,'鸡蛋汤',861,314.24),(1545,'香橙面膜',711,412.78),(1546,'烤牛排',839,96.57),(1547,'香橙牛肉',344,776.15),(1548,'蜂蜜柚子茶',782,12.59),(1549,'素食罐头',499,894.74),(1550,'薯片',347,263.14),(1551,'大蒜粉',927,410.82),(1552,'草莓果冻',259,375.87),(1553,'鸡蛋汤',113,836.08),(1554,'烤鱼片',416,785.87),(1555,'花生酱',688,408.99),(1556,'烤肉串',265,970.34),(1557,'鸡肉卷',662,40.67),(1558,'薄荷口香糖',880,343.17),(1559,'葡萄干',489,116.04),(1560,'蜂蜜面膜',646,177.28),(1561,'巧克力曲奇',815,67.90),(1562,'橙子洗手液',963,997.44),(1563,'蜂蜜面膜',849,966.98),(1564,'洋葱粉',829,110.86),(1565,'蜂蜜面包',504,914.37),(1566,'芒果香皂',264,977.84),(1567,'香蕉曲奇',800,859.15),(1568,'烧烤鸡翅',121,878.22),(1569,'酸黄瓜片',479,56.84),(1570,'烤鸭胸肉',577,55.88),(1571,'冰淇淋筒',753,566.40),(1572,'酸黄瓜汤',768,389.23),(1573,'素食罐头',578,924.44),(1574,'煎蛋饼',156,152.09),(1575,'酸黄瓜片',444,777.55),(1576,'烤鱼片',172,363.27),(1577,'蜂蜜面膜',383,573.10),(1578,'橙子香水',148,452.53),(1579,'香醋',745,127.03),(1580,'蘑菇罐头',110,819.62),(1581,'红葡萄酒',955,53.12),(1582,'酸黄瓜片',515,481.31),(1583,'橙味清洁剂',87,314.28),(1584,'葡萄干',126,634.77),(1585,'深焙咖啡豆',738,240.87),(1586,'巧克力蛋糕',306,692.33),(1587,'香橙牛肉',294,118.07),(1588,'牛奶巧克力',305,573.05),(1589,'芒果洗发水',340,710.62),(1590,'柠檬洗衣液',385,276.10),(1591,'薄荷口香糖',867,526.47),(1592,'薄荷沐浴盐',901,879.24),(1593,'葡萄干',231,429.89),(1594,'香橙牛肉',761,670.43),(1595,'洋葱粉',378,52.78),(1596,'烤牛排',770,838.56),(1597,'柠檬蛋糕',225,994.33),(1598,'甜菜根汁',238,809.93),(1599,'香辣鸡翅',439,382.46),(1600,'香橙巧克力',722,162.85),(1601,'柠檬蛋糕',639,561.88),(1602,'蜂蜜酸奶',343,83.54),(1603,'橙子洗手液',636,369.76),(1604,'绿茶包',998,602.20),(1605,'椰子牛奶',269,295.50),(1606,'蜂蜜面膜',577,631.66),(1607,'牛奶巧克力',857,222.20),(1608,'芒果冰沙',127,477.75),(1609,'香草奶昔',1,65.17),(1610,'橙子口红',100,199.69),(1611,'橙子冰沙',802,752.35),(1612,'香橙巧克力',752,485.63),(1613,'香蕉牛奶',908,86.22),(1614,'蘑菇罐头',410,63.09),(1615,'蜂蜜柚子茶',699,242.66),(1616,'鸡蛋三明治',805,310.14),(1617,'煎蛋饼',576,687.04),(1618,'香草奶昔',100,412.48),(1619,'甜菜根汁',826,488.80),(1620,'蜂蜜柚子茶',605,798.94),(1621,'煎蛋饼',710,351.97),(1622,'烤肉串',94,801.01),(1623,'深焙咖啡豆',275,4.39),(1624,'葡萄干',800,77.77),(1625,'蜂蜜燕麦片',488,490.86),(1626,'香辣鸡翅',461,532.34),(1627,'烤肉串',190,477.37),(1628,'冰淇淋筒',397,746.89),(1629,'椰子牛奶',239,335.68),(1630,'橄榄蜡烛',860,381.90),(1631,'红酒醋',135,891.66),(1632,'香橙牛肉',6,996.06),(1633,'巧克力饼干',14,60.75),(1634,'香蕉曲奇',54,925.53),(1635,'芝士意面',334,408.58),(1636,'柠檬蛋糕',954,418.93),(1637,'烤肉串',361,64.66),(1638,'蜂蜜香皂',227,508.83),(1639,'蜂蜜酸奶',350,408.57),(1640,'烤鸡腿',656,300.19),(1641,'葡萄干',610,701.86),(1642,'香草蜡烛',992,899.98),(1643,'葡萄柚果汁',656,516.58),(1644,'烤玉米',431,538.50),(1645,'烤肉串',808,4.51),(1646,'草莓果冻',336,60.62),(1647,'蜂蜜燕麦片',241,440.95),(1648,'熏制火腿',211,46.70),(1649,'香橙牛肉',602,212.83),(1650,'薯片',173,493.48),(1651,'深焙咖啡豆',703,283.24),(1652,'素食罐头',957,218.68),(1653,'酸奶饮料',563,398.17),(1654,'香橙牛肉',451,647.99),(1655,'蜂蜜柚子茶',848,601.96),(1656,'烧烤鸡翅',637,754.04),(1657,'大蒜粉',477,843.23),(1658,'香橙巧克力',192,669.29),(1659,'蜂蜜香皂',147,339.64),(1660,'葡萄汁',595,996.74),(1661,'葡萄干',381,76.11),(1662,'柠檬蛋糕',590,106.40),(1663,'草莓冰淇淋',505,573.59),(1664,'香蕉沐浴露',186,609.86),(1665,'橙味清洁剂',653,980.37),(1666,'大蒜粉',632,215.31),(1667,'甜菜根汁',742,471.99),(1668,'葡萄干',825,764.90),(1669,'芒果冰沙',994,511.40),(1670,'椰子沐浴露',935,201.62),(1671,'香橙牛肉',731,18.87),(1672,'香醋',455,182.26),(1673,'椰子沐浴露',648,980.07),(1674,'冰淇淋筒',45,243.23),(1675,'烤玉米',505,190.10),(1676,'鸡肉馄饨',813,536.59),(1677,'柠檬洗衣液',627,903.14),(1678,'鸡蛋汤',546,145.37),(1679,'蜂蜜面包',753,442.76),(1680,'鸡蛋汤',715,570.56),(1681,'甜菜根汁',997,500.27),(1682,'蓝莓果酱',354,521.98),(1683,'香草冰淇淋',450,965.39),(1684,'蓝莓果酱',508,584.67),(1685,'香橙面膜',74,612.92),(1686,'红葡萄酒',525,533.71),(1687,'蜂蜜面膜',885,890.20),(1688,'巧克力饼干',596,229.18),(1689,'椰子牛奶',93,403.50),(1690,'柠檬洗发水',574,665.84),(1691,'薄荷口香糖',1000,795.92),(1692,'薯片',133,64.71),(1693,'橙子洗手液',855,296.75),(1694,'酸奶饮料',687,725.07),(1695,'橄榄蜡烛',712,683.29),(1696,'蜂蜜燕麦粥',602,165.02),(1697,'柠檬洗洁精',842,429.63),(1698,'香蕉牛奶',569,841.47),(1699,'甜菜根汁',529,893.49),(1700,'酸黄瓜脆片',651,624.78),(1701,'薄荷口香糖',923,735.00),(1702,'酸奶饮料',965,726.49),(1703,'蓝莓果酱',912,643.24),(1704,'烤鸭胸肉',354,696.02),(1705,'大蒜粉',432,681.80),(1706,'巧克力饼干',316,57.38),(1707,'橄榄油',147,871.53),(1708,'素食罐头',825,598.40),(1709,'煎蛋饼',703,888.15),(1710,'烤鸭胸肉',402,780.83),(1711,'大蒜粉',476,973.95),(1712,'甜菜根汁',705,465.19),(1713,'柠檬蛋糕',569,290.62),(1714,'甜菜根汁',631,132.03),(1715,'素食罐头',725,345.21),(1716,'煎蛋饼',490,566.00),(1717,'橙子果汁',146,863.44),(1718,'芒果香皂',640,95.11),(1719,'花生酱',996,33.13),(1720,'蜂蜜燕麦饼',189,183.27),(1721,'柠檬洗洁精',711,972.22),(1722,'香草奶昔',208,34.59),(1723,'香橙牛肉',692,473.51),(1724,'巧克力蛋糕',927,30.23),(1725,'芒果洗发水',15,311.39),(1726,'烤牛排',245,266.25),(1727,'牛肉汉堡',173,641.51),(1728,'花生酱',1,438.78),(1729,'鸡蛋汤',65,848.44),(1730,'椰子牛奶',374,364.32),(1731,'葡萄干',653,319.56),(1732,'蜂蜜香皂',992,921.27),(1733,'香蕉牛奶',290,296.80),(1734,'蓝莓酸奶',994,381.43),(1735,'香辣鸡翅',858,709.27),(1736,'葡萄汁',755,17.51),(1737,'花生酱',202,644.65),(1738,'蜂蜜燕麦粥',179,261.83),(1739,'橙子洗手液',80,352.44),(1740,'红酒醋',723,294.66),(1741,'花生酱',741,140.12),(1742,'香草冰淇淋',57,331.76),(1743,'香蕉牛奶',842,277.23),(1744,'牛肉汉堡',576,858.34),(1745,'鸡肉卷',898,483.14),(1746,'大蒜粉',727,613.07),(1747,'椰子牛奶',606,928.74),(1748,'橙子口红',871,73.29),(1749,'甜菜根汁',930,696.08),(1750,'蜂蜜面膜',896,344.02),(1751,'黑巧克力',435,765.87),(1752,'巧克力曲奇',590,202.85),(1753,'薄荷口香糖',653,825.69),(1754,'香辣鸡翅',305,308.09),(1755,'甜菜根汁',83,620.16),(1756,'橙子香水',309,486.20),(1757,'甜菜根汁',302,256.47),(1758,'鸡肉馄饨',582,949.75),(1759,'薄荷沐浴盐',795,772.70),(1760,'巧克力饼干',61,984.78),(1761,'蜂蜜燕麦粥',894,280.72),(1762,'蜂蜜柚子茶',998,790.26),(1763,'花生酱',764,680.96),(1764,'薄荷口香糖',876,353.43),(1765,'橙味清洁剂',198,370.96),(1766,'蜂蜜香皂',183,674.82),(1767,'橄榄油',345,41.89),(1768,'蘑菇罐头',988,446.86),(1769,'蜂蜜燕麦饼',369,199.81),(1770,'薄荷沐浴盐',194,800.56),(1771,'烤肉串',172,434.70),(1772,'巧克力曲奇',200,876.11),(1773,'草莓果冻',802,541.37),(1774,'椰子沐浴露',7,147.44),(1775,'牛肉汉堡',501,554.39),(1776,'芒果冰沙',64,686.25),(1777,'橙子洗手液',291,916.69),(1778,'芝士意面',448,482.23),(1779,'烤鸡腿',237,278.02),(1780,'蓝莓果酱',786,45.57),(1781,'香辣鸡翅',670,884.27),(1782,'巧克力饼干',693,551.27),(1783,'芒果洗发水',344,935.18),(1784,'黑巧克力',773,19.18),(1785,'牛肉汉堡',362,69.67),(1786,'香橙牛肉',401,82.87),(1787,'蜂蜜柚子茶',457,570.30),(1788,'牛奶巧克力',354,0.11),(1789,'香橙面膜',743,710.73),(1790,'葡萄汁',143,713.77),(1791,'大蒜粉',745,73.54),(1792,'薄荷口香糖',241,285.87),(1793,'葡萄柚果汁',879,423.92),(1794,'香辣鸡翅',326,801.14),(1795,'柠檬洗发水',577,77.80),(1796,'椰子沐浴露',217,999.16),(1797,'烤鸡腿',843,419.60),(1798,'煎蛋饼',367,667.22),(1799,'牛奶巧克力',314,420.50),(1800,'烤鱼片',413,647.90),(1801,'蜂蜜燕麦片',937,881.52),(1802,'香橙面膜',422,124.47),(1803,'鸡蛋三明治',743,622.10),(1804,'葡萄汁',268,389.28),(1805,'薄荷口香糖',460,110.11),(1806,'鸡肉馄饨',877,353.75),(1807,'烤鱼片',689,858.90),(1808,'巧克力饼干',356,409.85),(1809,'酸黄瓜片',478,557.94),(1810,'甜菜根汁',805,519.41),(1811,'牛奶巧克力',690,337.57),(1812,'烤玉米',166,532.37),(1813,'香醋',407,148.18),(1814,'鸡蛋三明治',50,790.44),(1815,'柠檬蛋糕',117,440.65),(1816,'椰子饼干',969,117.30),(1817,'香草奶昔',973,529.19),(1818,'草莓果冻',683,161.61),(1819,'烤牛排',314,592.17),(1820,'芒果香皂',952,896.14),(1821,'香蕉曲奇',799,840.14),(1822,'草莓冰淇淋',259,924.79),(1823,'蜂蜜酸奶',758,363.61),(1824,'蘑菇罐头',27,845.96),(1825,'鸡蛋汤',733,56.51),(1826,'巧克力曲奇',793,14.29),(1827,'橙味清洁剂',718,219.62),(1828,'柠檬蛋糕',395,752.79),(1829,'烧烤鸡翅',28,168.43),(1830,'橙子香水',269,29.80),(1831,'酸黄瓜汤',134,718.89),(1832,'红葡萄酒',983,862.47),(1833,'蜂蜜柚子茶',332,295.01),(1834,'牛肉汉堡',196,765.87),(1835,'香草奶昔',320,334.90),(1836,'鸡肉卷',486,468.94),(1837,'椰子饼干',388,647.75),(1838,'花生酱',683,426.48),(1839,'橄榄蜡烛',807,451.25),(1840,'蓝莓酸奶',462,100.41),(1841,'椰子沐浴露',440,348.76),(1842,'红葡萄酒',166,550.44),(1843,'花生酱饼干',646,548.60),(1844,'橄榄蜡烛',711,621.60),(1845,'花生酱',817,584.34),(1846,'芒果冰沙',488,625.00),(1847,'葡萄干',259,487.53),(1848,'红葡萄酒',421,902.02),(1849,'香蕉曲奇',930,519.29),(1850,'蜂蜜燕麦片',711,702.03),(1851,'薄荷口香糖',958,334.71),(1852,'柠檬洗洁精',705,937.28),(1853,'冰淇淋筒',486,656.61),(1854,'绿茶包',390,210.37),(1855,'蜂蜜面包',424,857.56),(1856,'巧克力饼干',501,487.64),(1857,'香草奶昔',994,899.66),(1858,'香橙牛肉',47,318.48),(1859,'香蕉沐浴露',565,308.04),(1860,'蜂蜜柚子茶',836,157.45),(1861,'蜂蜜面包',844,951.37),(1862,'芒果洗发水',863,766.46),(1863,'芒果香皂',591,631.89),(1864,'烧烤鸡翅',177,134.60),(1865,'花生酱',348,400.58),(1866,'香橙面膜',279,643.52),(1867,'鸡蛋三明治',981,10.68),(1868,'煎蛋饼',947,525.27),(1869,'柠檬洗发水',558,193.33),(1870,'红酒醋',950,451.54),(1871,'蓝莓果酱',204,232.70),(1872,'巧克力饼干',622,9.30),(1873,'松露巧克力',637,675.85),(1874,'香草冰淇淋',296,403.12),(1875,'橙子香水',723,753.88),(1876,'柠檬洗洁精',925,835.27),(1877,'巧克力蛋糕',359,222.07),(1878,'松露巧克力',663,603.93),(1879,'松露巧克力',217,933.94),(1880,'花生酱',815,719.91),(1881,'香草奶昔',887,620.38),(1882,'烤玉米',853,515.52),(1883,'橙子果汁',647,286.85),(1884,'蘑菇罐头',802,438.59),(1885,'椰子饼干',511,106.66),(1886,'蜂蜜燕麦饼',637,259.63),(1887,'花生酱',37,60.78),(1888,'香辣鸡翅',357,404.38),(1889,'柠檬洗发水',634,62.03),(1890,'冰淇淋筒',841,786.28),(1891,'酸黄瓜汤',729,888.51),(1892,'橄榄油',384,878.30),(1893,'橙子果汁',275,698.11),(1894,'牛肉汉堡',878,365.82),(1895,'牛肉汉堡',515,840.88),(1896,'草莓果冻',453,471.07),(1897,'鸡肉馄饨',477,742.33),(1898,'香辣鸡翅',321,796.61),(1899,'香蕉牛奶',212,452.74),(1900,'鸡蛋三明治',772,433.41),(1901,'橄榄油',439,210.57),(1902,'黑巧克力',454,320.48),(1903,'香蕉曲奇',566,33.38),(1904,'蜂蜜燕麦粥',775,455.06),(1905,'蜂蜜燕麦片',860,709.22),(1906,'烤鸡腿',891,217.47),(1907,'酸奶饮料',87,480.78),(1908,'蜂蜜柚子茶',709,158.76),(1909,'冰淇淋筒',787,30.03),(1910,'薄荷口香糖',611,744.90),(1911,'蜂蜜酸奶',714,576.04),(1912,'酸黄瓜脆片',796,810.10),(1913,'鸡肉卷',471,586.22),(1914,'香橙巧克力',417,151.37),(1915,'香蕉牛奶',78,979.81),(1916,'蜂蜜燕麦粥',984,975.49),(1917,'深焙咖啡豆',830,445.92),(1918,'椰子沐浴露',901,850.13),(1919,'芒果香皂',993,311.52),(1920,'鸡肉卷',283,21.35),(1921,'烤牛排',749,808.53),(1922,'橙味清洁剂',298,591.62),(1923,'巧克力蛋糕',717,684.63),(1924,'深焙咖啡豆',937,955.25),(1925,'鸡肉卷',842,79.24),(1926,'芒果香皂',5,832.66),(1927,'蜂蜜酸奶',479,19.88),(1928,'酸奶饮料',314,832.62),(1929,'芒果香皂',328,873.62),(1930,'牛肉汉堡',384,677.91),(1931,'白葡萄酒',389,437.57),(1932,'蜂蜜燕麦饼',754,592.64),(1933,'蜂蜜燕麦片',839,234.73),(1934,'花生酱',383,624.58),(1935,'酸奶饮料',948,926.13),(1936,'薄荷沐浴盐',358,997.53),(1937,'酸黄瓜汤',583,525.76),(1938,'烤鸡腿',823,190.64),(1939,'香橙牛肉',665,62.24),(1940,'橄榄蜡烛',176,978.96),(1941,'香草奶昔',353,82.55),(1942,'芒果香皂',156,864.59),(1943,'薯片',48,293.89),(1944,'洋葱粉',168,466.36),(1945,'蜂蜜燕麦饼',257,134.23),(1946,'花生酱饼干',144,567.77),(1947,'葡萄柚果汁',592,901.06),(1948,'鸡蛋三明治',692,405.25),(1949,'巧克力饼干',891,39.92),(1950,'香草蜡烛',421,457.68),(1951,'深焙咖啡豆',327,847.93),(1952,'烤鸭胸肉',359,300.06),(1953,'花生酱',958,212.89),(1954,'香辣鸡翅',380,773.68),(1955,'花生酱',888,591.74),(1956,'橙子果汁',798,228.25),(1957,'香辣鸡翅',781,769.26),(1958,'芝士披萨',222,417.38),(1959,'煎蛋饼',392,121.44),(1960,'素食罐头',377,525.55),(1961,'香蕉牛奶',572,374.25),(1962,'牛奶巧克力',788,545.79),(1963,'柠檬洗发水',488,818.56),(1964,'葡萄柚果汁',235,864.70),(1965,'葡萄汁',847,498.93),(1966,'甜菜根汁',141,795.03),(1967,'甜菜根汁',243,315.66),(1968,'蜂蜜面包',997,562.19),(1969,'橄榄蜡烛',326,317.61),(1970,'香橙牛肉',645,528.79),(1971,'烤鱼片',118,708.75),(1972,'烧烤鸡翅',36,0.05),(1973,'甜菜根汁',376,109.88),(1974,'芒果香皂',857,784.02),(1975,'香草奶昔',644,629.55),(1976,'橙子冰沙',969,371.12),(1977,'蘑菇罐头',74,187.11),(1978,'香蕉曲奇',724,765.98),(1979,'薄荷口香糖',756,217.48),(1980,'薄荷口香糖',83,53.22),(1981,'洋葱粉',684,927.49),(1982,'橙子香水',983,104.97),(1983,'橄榄油',783,541.32),(1984,'柠檬蛋糕',272,514.01),(1985,'葡萄柚果汁',386,175.48),(1986,'橄榄蜡烛',827,477.41),(1987,'花生酱饼干',75,549.56),(1988,'薯片',797,677.28),(1989,'蘑菇罐头',573,48.37),(1990,'牛肉汉堡',95,574.68),(1991,'素食罐头',772,8.83),(1992,'牛肉汉堡',576,617.08),(1993,'黑巧克力',65,125.04),(1994,'蓝莓果酱',386,670.87),(1995,'芝士意面',985,246.40),(1996,'柠檬洗洁精',386,871.48),(1997,'蜂蜜燕麦粥',962,390.33),(1998,'薄荷沐浴盐',38,67.93),(1999,'烤鱼片',826,552.50),(2000,'蜂蜜面膜',958,287.94),(2001,'蜂蜜柚子茶',383,436.74),(2002,'酸黄瓜汤',877,984.33),(2003,'蜂蜜燕麦粥',398,276.61),(2004,'蘑菇罐头',167,268.48),(2005,'橙味清洁剂',683,715.20),(2006,'冰淇淋筒',648,409.24),(2007,'红酒醋',354,5.38),(2008,'柠檬洗衣液',317,47.20),(2009,'草莓冰淇淋',899,183.06),(2010,'红葡萄酒',294,253.99),(2011,'洋葱粉',943,361.05),(2012,'松露巧克力',611,241.62),(2013,'牛肉汉堡',422,717.05),(2014,'薯片',355,766.22),(2015,'松露巧克力',396,392.06),(2016,'芝士披萨',9,383.09),(2017,'洋葱粉',168,379.76),(2018,'香橙牛肉',407,676.57),(2019,'花生酱饼干',235,384.54),(2020,'蓝莓酸奶',306,698.21),(2021,'蘑菇罐头',626,356.81),(2022,'香蕉牛奶',441,652.97),(2023,'蓝莓酸奶',690,895.66),(2024,'葡萄汁',754,729.29),(2025,'酸奶饮料',948,113.81);
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlog`
--

DROP TABLE IF EXISTS `orderlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL COMMENT '顾客id',
  `cashierId` int(11) NOT NULL COMMENT '收银员id',
  `goodId` varchar(255) NOT NULL COMMENT '商品ids',
  `payable` decimal(10,2) NOT NULL COMMENT '应付',
  `payment` decimal(10,2) NOT NULL COMMENT '实付',
  `goodsTag` varchar(255) DEFAULT NULL COMMENT '订单优惠标记',
  `time` timestamp NOT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`),
  KEY `index1` (`customerId`,`cashierId`,`id`,`goodId`,`payable`,`payment`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlog`
--

LOCK TABLES `orderlog` WRITE;
/*!40000 ALTER TABLE `orderlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `role` enum('admin','customer','cashier') DEFAULT NULL COMMENT '角色',
  `vip` varchar(255) DEFAULT NULL COMMENT '会员卡',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vip_pk` (`vip`),
  KEY `user_id_vip_index` (`id`,`vip`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='会员信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin','admin',NULL),(7,'admin123','admin123','admin123','admin','111'),(8,'user1','user1','user1','customer','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-20 12:06:29
