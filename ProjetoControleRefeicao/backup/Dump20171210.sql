-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: refeicao
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

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
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foto` (
  `id_foto` int(11) NOT NULL AUTO_INCREMENT,
  `image` mediumblob NOT NULL,
  PRIMARY KEY (`id_foto`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES (44,'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0	\Z\Z\Z( %!1\"%)+...383,7(-.+\n\n\n\r\Z-% &---/----------------------------------------------ÿÀ\0\0§-\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0F\0\0\0\0!1AQ\"aq2‘¡BRb±\Ñ\Òð#r‚¢Á\áâ’²\Ó\ãñ3CS$ƒ£\Â\Ãÿ\Ä\0\Z\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\'\0\0\0\0\0\0\0\0!1AQa2q\"‘Áÿ\Ú\0\0\0?\0C7—\Ã\ï¤N»¿<\é³>>ö É™÷µy\ç¢;›Êˆ±\ê=ôœž~ó÷\Ð\É\ç\ï?} ù{\Íòþ&¢GS\ï?Š´:Ÿ\â¦Šô\æjJ\Ûú¿÷R\Ê\Æÿ\0o\â£\ì\×\é~}ô\0³kê\ÝE\Ùý]<¿¥%m) ’L\Ìøµ¦áž‚\Ýxk\ÍØ§C­\Ã\ä»oºš‹b”’\ì\Ì\ä#æ¯´\çV|?\Ñ\ÜUñ)`eúL\ã©ö\n\Þðþ\r„\Ã	K`°ÿ\0¹r¾\È_eI<UÀpOŸ\Ù4\ê+ödòœ•\Æ&k\èo]_Ù¶€üXGÂ®°þŒ\àSþÂ¹\êúü\nš^ˆ\Z\Ó_Rù\Ã-»b-[DQBý‚8†\êj0¥\nv@\áºhûJnŒ\n\0^z)\Ô4ÀlƒC;g\ßOSN)„µsK–­¿\í\"Ÿ\å5GŒô3ûZkg­· {šEh˜RQVRmt`1\ß\'¬5±ˆ\ê\Ý\\§üK#\áYž\'À±v5»e‚ý5\ÓÞ»{k±\ZHb61P\ài{8ˆc\×\à(zü\ß]WŠú9…¿%\ícó\í÷\Û\Z7´V?ŠúzÜµ“\Û/AÝ¸?w\ç{*\Z6ŽX³0	\ëð}*|~\Ëƒ $‚<Á\ÔQ\à}õ,\Ð?h÷R—\Ì{©¸ðo}‡\ë|i\0\äxu!ü†ý\roö¨5¿?u\0+Nƒ\ÝD\ÇÀP\â}Âˆ\È\çðþ´JŸ*Va\áH;\ïK\ìüh@liþ´„´#oˆû\é\È?W\áøh\ÕLn?>\ÊfcFß‡ù~úkö­;óÿ\0X‘­\ßf9ò\Ð+\ãñu)­·)øŠ,¯\Ðû\Ï\ß@p4¹õu^p/F\ïbuS–\×;‡o\ÝÓ¼j\çÑ¿C¶½‹7[YŒž…õ\Û\êûúV¶õý \0\0\Ð Uª‡¶c,ž¢C\á|.\Æ~¬fx\Ö\ãj\ÇË’*UüI4‹L8¦\Ù	[\ÙC\Æx\ÑK\Ê\0R	b|j£Ç‰–\n¢L\é\ËÊ«ý5v·|ˆ2\Ä@™\Ú)þÀ-\äœC±m;ŠHQ\æF\æ¼\Î|\ß9Rlú\Ïa†8¾>‰¼;\Ý0À\í¤qZ\\¤Ü\Ã(sN›k>\Ý=Õ‘¹‡´\Û;I=~\'X£³nU\ÐW\élcM´\çYaòr\Â|`\í?ýC/<®’¥\ÕÓ¤Ç»¯*{°n•\á>•¹{Iq9€2\é©:i1Añ«\ßJ8·g•A\ï\æ\rbÇ½£\Ø+\Ü^f\Äò|ql0ü¤M¶:\ëùÚ ð\î7m\Ôqœ¼g,y“S]r\êI÷OZ\Þc5pv:Q&\'ˆ¦­Ú“p=nD\çDˆ`[o?\n¾AHx)< Šñ‚w:\Ç\ßK»p\Çtþ÷*v…C%i)\æ]7¿1\åM]p£S©÷\n)ÆŠSl•$kDV“T;!”¤©e)”€§\âü\Æ$E\ä“\É\×Kƒ\Û\Ï\È\Öz+w.?[k\é€s/\í¨\Û\Ïj\ê,”Œ±µKŠf\È\âq/\ÝøŸº€#¥t/H}\rK“sª—76ôÿ\0³ô[\Ãc\\þíœ¬\Ê\ÊU‚¤A\ÄVN-1š—B{U\æ>\Ê1|rÊ“Ù¯O¥(¯¸ÔšnçŸ¼}ô\à\ïÚ¨\×\â¥OñPÄƒbN²wð¡\í4‚ºn~4®\ïXöR{uþ·ñ}	\Ó\Öñø©Æ¶\Új\ÛøùÑ•=O\Ç\ï«3\ZXç¯µ<½\ã\ï§{3\ãñûé²;Ÿ\ß@`=‚ùi­t?E=[!o\ßPn\îˆ@\ît\'O[ì¦½ôp(›\ÒNö\Ôÿ\0œ‰:ž]+Mˆ»&µ„+l\Ã.OHF\"ñ5\á§ZšqT\Ì\âWb¸‚+\ä.ªc1g=\Õ\ÍIðª!\Ç@$£\\a\Ô\Âû@\n\ÏúO‰e\Ä\\\éÏº«ñ]2™\Ò?:W‹—6iÉ¥­ŸUƒ\ÄÃŠ—\ì\Ù:÷K—¶\Ö\â\ãó\é\r\å2\rN»\Ä\í• “1ƒ\ÙÎ¹ž+\Z3f:V8c|ö`«\'h$ƒ©ó­<ž§So¥A\ä\ËW¯f½/\Z\ÑbobHðøƒTË€vÊ­qŠÏ€Ÿ=\ÌTŒ­q\ÚN²b5\îòÓ”m\î®/À—÷Yò¹cú\ÊÉ–±LDzÀr\Ò}õx8Š‹}ù.\Ã\"2P\rHé¬˜>{U^P©°7\æ|¦¡¿;\Æ\Ý;\ÒOu\r™E—O‰‚\0\ÞFž5¹\á\ïv\ê†c\Þ\0)Ë©¦¹œ^Š\Ñ*\Þ\Æò=\ri½\â7I(„\å\Üö·¾»<o\Ç\Ë\Â^\ËZtn­Ä•\Ì\Ä\ÄÁ@\ëI·\Z(v\"75É¸\êC!\0\È,7õÐ¸\à\å\Îü\Ñ$\Æ\ÒDi^\ÑTIL~f\0\0f}±\ÌTÅ¹\á\ÏhÚ«°\à‘r‰>~Þµ*\íðˆHÀ\rLÉ·\ÛB&\â‰\ÊNYß™4wPi”O\Ç\Ú:\Ô3ŠPÀ¥³3±3\í\Ô\éRo\ÝTc7\0f«¬\âh\n\nÕ¶\0m\"Jp7œu ’ƒ¼\Òu\È\Ñañù‰\å\ïûª¹|“Bˆ¤•¡\Ú	õÁ\å\0s\éKiÕ‹¡–JA·RŠ\Ñvt¨,Œ-U/¤ÞŒ&)sh·€\î¿_ªñ¸ñ\åZuµJ6\éñµ±©4\í„kN\Ö\î®¦þ{\ê*?d:ü?­u\ïL=LZH\0^A\Ün¿U¼Â¹%\ÜF*\ÊÁ”F²öW<£Å˜\ç\ÉK@¯\çZurõ¦E…>´\î@:}C-^¿o\ÝH]½o·\î¤vk\ãñû\è‚/\ÇñQC.\Z\Ç{~S·ûTfÏÀÿ\0£O\0sW`7ÿ\0š\"‡\êü~\êvÄ†\r£\Ê= ÿ\0£ZAø\Ä\ß%\Ç\êm[~ñ\äš\Û]\ç]‡T-’\Ä\0 ’`¤\è«]€ðµ\Â\á\ÖØŒÞ³‘Í¬vCÀ\n\Óm\ì\Ë4ø­qw9\n‚\Ôõ\æÖš­\Þ\Î;I`9Ó‘Y¯”.(0ø­¡,Bhf\'RLk\Ê=´¸—\rº3(\ÉbòµÄ¼¢\âÀ*>vð=‘¸žU\Ì-#\\’¼Œvó¥¯k·	\ÌD—b	\Ó\Õ\Z\ri«˜,?h\à\ß2u\\ªBÎ²­0g`s\åYþÝž¶/3&8pO@\Ãð\Ós9pBe9÷Æ™¤\î4;MOoI\ÞÝ¡d²]\Ô\äb¤\åbdN±3\0ŽzS‰d³Ú­–ˆÊ¬F€r12œu5‹a\íe¶\è\ìY²‹“\0N“–€VŠ*¨\å\É7&\Û\Û6<?·P:žQ¨§-fœÁ\â@l\Ñ;ý\rd\ÙY\ï•\Â\Ù.¡se^‚Nb9‘H\Âq¶³s+«ªü\å \Èñ\0û+\Ï\Ë\àZ|_ø9¥‹½šLN Ü¸É™`»\Æ\ÝDŽ|\éœf$Û€\"I žöº\ë \'W3lLLÎžÊ§\ÇÞ¼\ì÷\0\"€D\êfhÁ\â´Õ­ ô\ßF\ç‚c\ÒöT	Q˜®ƒŸ˜‘>u®\á8\Ô\íÚ‰=Ó–\"|¶Ÿ*\â–8–\"Ý¥`¬³*¸A\ä@#z\×ú5{qmµ\å\\\ê\ÙH†I#40 c—M7®þ	z‚j\Ó; Å½Á\Ý:Nñ\á1µLÁ‚Á\Äuh%va\0\È?\n­\à\áUK9Y×œ0>•egŠ–\0*Ì’ \é úÔš\"Á‡Â¶r3Ê¬k¯\Ñ\ßP)»Át³¡\Ð\ÏNp)\Ð\è&A\\ñ1\Ï\Ã4R\Ó$Ø‚:ˆ-¦šŽ´†7…™\'6R@f\ÓM4G³Jk‚\ÎÁ³+‰\Ì`cùÕ†!az£Nd`Tò“­\è/\Ù\Zýì¨¤\0æ‰Ÿo3„Å¤AT\r®X\Ù\'Îœ\Äf–•Ë ©`ò¤Œ\í)\ß\ÖR\0\Ô\rÆºQ°t‚•˜Ì“\Ý\ÒF”w±¹`e\Ò~nºô™Ä©KY\\	m€;­:\rj\Zaº‡$,r\Ú|ySB.°˜°\ÌP‚n\rXª\Ö{VÛ®HŒfŸV5\'\Ä\çW¸,P¹1¸0kHÇ²\ÑE;’*¨›+X”Fs¯\é6‡}\ë\0ù\ë\×c¨û+ E%\ÖFµª.\â\ísc¶\Ûõþ\Ú2\ßX{ÿ\0¶´>œðC…¾B\én\äºWq±ø\Z\Ïyr5Zg|]«B\Ç\í|G\á¢f \ïù÷Q…>º‰ô\ÃHÔ{\àjy{>V?÷¸~*i/\Zøúÿ\0\îÓ‚\é\ëñÿ\0rfŸ\äû†µ\ÜNv‚–†m†¬t^»j}‚º]ö¬\ï\É\Ö.´#[ŒO°wG3\Ðû\êúñ\Ð\×V8\ÔN,Ò¹Ú“KŠT\Ç!\æjÌˆXü]«Kú\×+˜\0õÎ‘\Ý÷\ï^t\ÄÜ¸n¶sÝ·›¼Kw‚©q0nf+¥ü¤qF7Uð\ì·T Bm\Ã2jsO\Ås\Ç\ã\ÖõU\Ém#)\Ìv\ïKA‚LG*L\ê\Å\ZDK†\Ú\ÝSm\\’b\"d\É\ç\ì\ÐTŒOK@…\Ë$lUY¼\ËcR–\Ô\Î‡b\Ísu!U@\n¤n¬w\0{\éx\Ñu»ú>w\Ü[\Õm\ä\Ì\Ä\ï¦ÀR6þƒ‹5´\ìm»½¶Y0 0˜d 	*E¯G\âø«@žôN§}zóÛ­7\Â\Ú\å\à\áHKa@wúDrb7\ÐS¸Ë¶m\Ü“sœ’wßœg¾“V+f\ÖŠ»–f@\ZvR\'T‚|j\â…\çìœ‘l/\0²¯8“¼xÆµeˆ\ï\'z\Å\ÖYÔ•¾F\'\Ù5K\n¶Š3s©`OP4\åµ\"«T2ø¸e$/0	ø“\âj%»Ã³¸\\÷\Î\Ãj\×ÿ\0ý\\M\Ô°¶À\n6V*:\05?mQc±¶°[VØ°Àf`i¶\à	\É\ÚÝ•wñ7]\0*\ÅG\Ë\æ9\n\ÚþžjÝŸ\\¨\ínósŽžY§\ãÊ¹W³ ‰U,AðLkÊ‹z\Í\Ö$\\us«—\Ô1\ç<ÁøPÁ}»,xW¤·»`«u„°‰Ì¹G¬Hë¦žuª\ÃzEt\âm~°¢\0\r§ˆ;\×6²8µoV.0\ß]‰­\Î˜J=ÛpŽ\í\Õ\Ð\èt t>])4%Où:\æv2“\ÌeŸ\ÓÊ§»‡,Ç’€³\åÒ³ü7Œµ\è6\0uW0^\êG*›k\×n…»#™\Òk\Ë\ì¨hÀ¹±•\Ì\Ê\ì@œ¬@ž~s\çIl`d; û}†œÃ²®f\Î\ä\r’IŸ-É¤\\RÍ•Sa0vŸBc„Ç­1\0j?¥\"\æ…Í¸ñ‰ðÓ­*Á\È\Ð-ŒÁ\0Ðƒ#ž¼µ\åQq=«6bJ…={£¤þy\ÐÉ†9\ïwcP\0\'žv¦ð÷.3:\Æe˜’\0T“Ž$„\Þ\0¼òÓœó\ßj–ŽÀ÷\È^p5${>\Úb+np\Äf—¹–\î	ñ\ìjn¥­{\ÃÄ™ \Ð\Å7s\á£6û±\0\ÇAP±V¤\ç]\Ã\0c\Ê9SLL\ÖYº®%H#Â”Ee}\ÄEË€°\nvó\ê>5­­LÆˆ¢ŠpŠLS3\é\ïý#ùG\ë-÷Ó®›h‘\\R\Õ\ÉSùý\êô‰Y®\éG8|e\ë`¹³.û7x|d{+›<}^<½¬\ÞŸÞ õüÿ\0Šü\ï÷Ò”)\çöþ*ç£¨·£U÷ÿ\0»Fq9{\Ïú”£ny·ø\Ïú”}—‹\ë\×o/§VA\Úx%Ž\Ï\rez[Yó€OÆz‘–€\na«¶´y\Ïlh-1Ž\Â%\Ûoj\á„udb‚A\åRª³Ž\Ú=\Ò²}I€;¦…\0»87Åœ+Fÿ\0ii%Gw$	b*g]GZ¢\á¨-\Ü®›mžOe—;\ÚDwzû<i\ìv\ã\ÂpZw…D±3\ì8h{v\Þ\ÙB\r\ÝÝ¤£c\Ö†óPw\Ò3ˆa&/ˆP§\ã­2\Ø1y.\\7)\ÕVt\Ð|\é\ÜrExöÿ\0«c–\à\Ü\ín4\ï70\"	¥ž2\0o‘\'D\È@ò–#\ß\r¤E¼ùJZ[ƒ²:†:1Ê¤\à,á•‰v\í\è¡n$\èŠI¦ñh¶Å®\Ñ(Rªd“39ˆ:\Ù\ÛZj\Ý\ëm‰Rˆ™ˆ\ïA\Ú\0Šè•‰\ãö,*\0™;Î½w¨˜\\Nñ\Ú#µ¿ž$ƒ\àtñ)Ë¶\Ñnd0Ù”’N\êwG\ï¢KW\Ó2[‹™·6\å\ïi¸š“0\ï\ÚN®J\Û\nz\0KL\Ò\0&zTNˆK&\í²Ã¼bN£OgZk	q\êå‘¶c\Zóˆ\ÍHÃ¥«L\èm‹³ô\ÎVU\Ö‰0h7Ž»À*‘ôD=Nº{)\Þ%Am3vP2)\Õ@\ÒCDMD\Ãpw¸•u·\ëÀ(OMý¼¨øYÉ¸/]DôŽt\Ò„\ÇXaÿ\0D[oü‰›»\ÎwþU/‡{Šn½\ÐöÐœª\å`\ë\Ì\rGœ\Ô\Î/™­œ…ƒA{¤0\æ…\ÓnU›\ì^Ê­\Å`gqe?D\Îô\É\ëF\ë†z`p\èE¼\Ä\êYJ†2u‚Z#]\ÑOK¬\\RÁ\ÇhÍfh/\Ó\"“1­pœ5†»ih4i)˜Ü9V“…úF‚\í¦Ó¸DJÊ¯\Í\Ñt\Ô`Žq½K&XÔ¶Žñ‡6nKD“2	 O3PøÁ‚\n\æa\Èô>uW€ô¬\ÜQ”÷yi<©\ÛÛ…§1¬\é3Ò¥£¦X\Ú\ã£º\çRt“\Ózoyòvps%§™\å®\ÛSœG3CÀ\ÌN‡/‰\éB@_ZD‰eI1\ê\ÒffÐœ°f`M?k•^\ã\ï›,l\'U‹g\\ˆ§*\Îr\Û\0Nõ_‹¾Î¥”Q›nð×¯3LT;ˆWv-“CósLG\ÙÖ¤\Ü7{\Ú8\0’5\Z\ë¨<\êº\Ö2þç§¶§\ÙÇTD©I\Ô@25ûk\Û0M\ÚXi\Èh\rlpª,I\Ïmb±W-‡Ð°ˆ\'¨ðžbµ·Æ„\"f´‰,H¤\Å8Edˆ¹o\Ê\Ö/Úº#¼¥	ñ0\äzš\ê‘X?–<\ám°\Ýnˆ ò>–Uq5\Â\êh\å\Ùg˜÷ÿ\0m¾^ÿ\0\éQ•Hÿ\0\ì§\Õ\ämq\Ñ\Þ]—ú¿m\Ü\0Ž\ï1\ÈõýšKZ?CøÙ¦®[0V?\Â?Ñª$\ïŒt¦\r\'…\Þ\Ïb\Ó}+j}\àRÚ»‘æ‰ª¯Ip¾õ`º<÷\ÚDUµ%´×¥\0;<×À=µ\ÐsnCƒ¬‚¾«k\çP\ìð›Á­›·•d–*vã°ŽSZŸKø[\à±7fe•†°	‘\â\é5•\Äñ[om\æ\ãk&	3›]\êw5z\Þ\Äñ·‹B£hUb\ãO\Òi×ž\0¨6pZ\ã‰UYl\ÄHœjG-\Å\"ý\Â\Ö\Ò\èÔ¦Ž	\'^Dƒ§º¬ø^4°a–\ï¸$\0ñ:\È\é¥\ìˆáŠ™¶s.À\Ï3™³I\ç\á\ÄUrdºÀ\"ökšK1<†¾p\'•Lôƒ,£»g\'Bt’ûFE7\Ãlµ÷‹v\æ\ÚÁe\Õc°$N¤þb‚_cx\ÄN\Õ)c2{\Ò\ÇÝ øùÕ¥\Î>¡`“\Ð&ª:k#\ãQqƒ+\çD\Ëvr)iú }µöó^Y¶¤¼·Ôš;+ ¬\â]b\â\n4\ßa\á¥?ŒÀdW{®¤ê ’W”i´	«5ô~Ù¹&\ãˆTP\0ö¹Ö™\íÿ\0Ev·2¤\Éw¶¬Lƒ\Ý2t4\ï¡\ä\Ãa\Ö\Ø\Ém‡W\Ì\\6ž±\é¯-ª²\Þþ°©9óˆ&A`<c\ÝK[Î†m8ºXúŠ5ƒ\È\åÒ¤\àq/\Û\æu\ÈR\0õBÇ”\Ð\ÊTG\ÖHw¹5…iu\ç¯/14¾\'†»‰\ï[›„‘›\" \Æ\ä&‡»\ÞRö\ÜX\'R¼\èMM\Äq;\Ïo5›N-(\Ê\0õƒŸœ\Zþ\nŒV¸^\Ò\ä\È!’ZG¬gó\í¢\Ãa\ÆAq{Í©2v\ÈX“oNZ{¨\Ån›\Ë+L\Ì{ý”»ø+\Øv>Pñ˜J’	\Ü@\Ðy\Ó]ˆ…Ã•‘Ÿ6y@ŠéžŠq›\r®Oh\ä(cPNû\":\í\\w\ÃQr¾¨	\0†`\ÒzˆQ\ì¡Ã¸‹-Æ’\ÄL‡b6 ø@\×Â¥GÀpõ†\í.„”nu\ç\Ò*\Ð-›bUˆ\"H\Íq\Öñ>\Ò\Ê6bÐ¹Y6\ç$\ï¯?\Zµ·yˆ;\ê\Ï_%Õ«Š\Éÿ\0T\06¿Ÿ¶•fØº¬¶\Ø)VƒzpyTD¼ \Ê2•Ñ¹ƒ:\é\Ëi©¸\Þ\'óPˆC,6\Í\áöšHl‹‹\á\Ù\r¦l§Yp\"£S\×SÒ“…Â³;¨õLÁhfD\Ïô¤\á±Jn\æmT‚\'\Ýí©¶lvŒ\Ì2	‘“b\Ú\î~‰j„\Ê|f	•Ì™\å>z‘D\Õß£6Tp\Ñý+?Ž¾lw—€\ÜN¤ñÖ¬p7\î\\¸ˆˆm€d¶½\é\æO\ÝT‰f\âV\Ö\0ª\Ð\Ì(¬oÊ²ÿ\0\è[ö\íÿ\0|+gX_•÷ÿ\0\Ð\å\æ]>7CÒ£\'\ê\Ë\Çû#’C\èÿ\0öQ…\æŸwö\Óh¬z~v–-\Üðüþ\ípž‘o›\ËÜŸ}\"\å\ßþ\ÅOœH\ê\ß\ã\ÇM6 }oñ?\â ¯òwŽpH$l›f#–£bcºEh\\W3ù.\âùoÜ²sEÁ™fN«¸O/²º{Š\í\Æ\î\'‘T˜\Íª¡\ZùLºë‹¸¯%T§B±{>ú\æ¸\î‘pz½\åbž²\Ûi¯GúYè½¼m¼­£,”mˆ\ê<p\ÌU‹¬¶×´®pI\'¨†¶\Õ\ì\Å$\Õ®\'(X¡\Ì/OIß \Ð\ë±û)v°Ma”¹Y­\Ë+¡‘	®\çc4…±\ß7-–Ù™‚6\áH?:Ÿ·K\×!“B¤ ·\Ò\Z@öN´>ÁÁ½¦!‚œ°¶“\Ç\æg©¥ª¾\rU\Ô\æbL\ÓL¾d‰òª\î!Ú»öo9†Š\0’\Ý6\Þz\Ô\ì-«\Î\Ö\Ö\é\ÊTtžF k\ãLX8\Æ+9K—\å¹\Ô»\r\ÊiŽ\'Ø€\Z\Õ\Ç\Í\ÒI2jO\â@]Rª\n$\"2\Þ\Ð\ï,fj«\ÙöŠ\éI¯N´e\Æ!®­ Ý¼¸\ÝrFS\àNüµñ¦mq\Öa›3\ÓrI\çž!Nê¶ ™ ^1\Ô\Ó÷8²\ÛN\â\åW2 Uh\Þk\ï¤U\ìk\Ñ\ì\è\Â\ãvG1\"[,•€\ëMX\ÅÚ»ˆW¸¿«1R}nzý\ÔÕ¾\"Á\\2Ê±Í–@F¼ö¡c†\â.Ž\Ý-J(7\Ðt\Å2:\Ñq\Ä8\à¹yM\ÄýXõ”„c¶£bò§±œkNóO «·–š\n¥\Äñ†\ÄeKƒr3\Ó\è\Î\ÚTid‚ˆ\n«. \àŒ¥E)$.\Õ÷³w0\nH`\0\Ûû)\Î3m†S\Úf\r¨”xÀ“\ï©\\‰©\ÄyT©FR± û\èa0y/³!R\î«.p\ÓndNž1L]ô1bÀ¶Öžø¬	‹\á#Ovµg\ã\ä6|\Æ;¶\Ñr „m\í¤ñK®Î‘7\ÑÙŽ`2˜\0rô‘Q¸…\Î\Ò\âvk\Ú\\v\Í\Ý]\0FƒA±ð¤3eòv¬0Ø’À…,½œ˜ \æP:m­t.ƒ7\Ü!\Z°#M\Ó:y\×K÷-_Ek…m\n\Æ\ÓfP\ÜÎ½\Ö\é\ï­\çôº\Ú[»Ú–/™RÚ¬\ê§\Öf\ä ø\íµ#)Á·h\×_&€%~\ã\áK\áxB\ì+vz’5ƒ@-Ï•Xv–’\Ù\è\Í\ï:U^/Š\ÝkÌˆ\ÙP*\å]=V™\Ò~ú“+\Äð\âÛ°I2	€=S\ã\àg\áEoE´\0w\É#]N‡Ÿ…\×±\ïzÀwbtA%¿;\Ô[,£õ\ÄwÑ¯¬r\íóµ;øS \'\â±\n\Ò\äÍ•‰1AnºŸªÃ\Üw½«tÓ§J¬µ‚”!MdÎžu¤ôcxÄ“W$_ 1­*…\nÔ€W/ùiÆ€¶-A2\Ì\Ä:(µ«§“\\7\å\'\Ûc˜¤ZPšõ=\æù\Ã\Ã\ÝX\çul¹[W VÀ?•:o·Cð¢Ã®Ÿ3s\Óñ\Ó\ÑûŸß®6\Î\ä[·˜÷ôi\r—¨þô©y¿k\Ýþõ5r\à\ê\ÞQþõ:a`1=“¥\Ô#:6aêŽ\Ó\ÙHò5Ý¸^9/\ÚK¨e]CÏ†\ÕÀ{Bo·Býkoòe\éGý\Z\á9\\–¶H€š\ê\ÇS¸­qÊ™†hZ´t\Ö˜§H¤]G ‡\ÓZ\ã?(þŽ‹7\Å\ËAmÛ¸Ù‰Ë›+jIU‡v’*“Òž1Xvµ >²“É†\ÞTš²ñÏ‹<ç‹°ª\Ä=Õ¸·;\Ê\É\Èù|\ÓÈŠ¦\Ã\àX’\0U\ã4\êu’ \Ð\ÖÃú/uI¶\ÖN``£]I?f›\Ös‰p\á‡tebs)0`À\"GPIÒ \ì\Ó\Z7.fbM¢\Ê\ÙbI<\Îe\æ”ø\Ô;x§.„*\Û@ º\ï\æ*_Â¶\"\å¾\És; \ç7´}†—g\ä›J©	*\ZN„k\å\ÓZd\í²Go\Ö¾V@z ;•Ÿ\ãQ8þ6\Ó\ÈS s:Ÿ9¦°\\(gcq§)7žzøTþ*\Ön›V‰\ÊÙ£@!\ê`,\rO!@÷OB8Ž’\ÓY\ì 6i\ÊN’g\Û\"Šþ\åôD·óR{\ÌU@˜w™\ÐSx\Åt?£[iG!P°Ž}Oª\'m{dºÀjDƒ=6þT}‡\Ð\×\á6\\9{¬2\è¨$õ$´œˆº#YWƒ[£.±¡\Þ&³ \ç\Ä0´Tf,\Ç(\"5^rIH7’÷Eee#\Ã\Ù÷Ñ±Æˆ\ÜS\0¡C~²\ÞRD\èAÑ£¡&jc\ÞVÝ«r\îDdND™Ùº“<ª©ct…!\Ë)\Ö\ëC\r€ºFŒ\ÃQ—ôö\ÐJ\ì‹z\Ë[\':À\Æû©ø\\;\íÌ¬yÎŸóR0˜¡sõmg319B\0	\ÉùŠ­»€uÎ¥.F‚2’œlh¤LÀñ>\Ê\Í\Ä1m5:k¤\Ç:ã¬¢\ÍÀsz¬N²9/\nh9)Ú¢ \ïd`@\Ë0!‡I\ç\ãR°öZò\0ùLÙ¦{§x´\è+¡|gÚ…µm\0V\"9\Z\Ìr\Z\è»l…˜\ÞH<¦T˜\ÓM‰¨x«LŽ\n3Y h\Å@úQ¤õªg\â\n†\'¼ \ìs{\Ç]ö\ÓJC\ì\ì¼/\ÙV{‹,3dBD\rù“©ðÒ§Z\àK™ó\âI#.P£O\Î\ß6\Ú\Ï]+=i,Û·žÞ‚\Úf\"\Ùg]¤\å¬\ê\0«>\Æ\Ù\Ê\Ê\Ä\êHB\î4:\Zgw\á\ÂÍ®\×4v\Ø\Ý\r\Ðz\Ä!>Ê­\Â\ã5¶°3[!³Di–AÖ£\Ü\ãHóh‡¸\å`V9„‘\ÈÕ°bÊ¶\ÑTNùG¸{¨\rû!\î\æR`Æœ¦·œ’\Øòü\ëQ¸/T\0º‰\èu«ÁZ$C`¡Bˆš¡¾‘q5\Ã\á\î]c¢©>\îB¼òxƒ\Üfv=\æ%t\îLó¼ùZô‡;®‚\çÿ\0E\Ôõ½‚°\Ôò\áü5Åš\\™Ý‚³t\É:ú§ðÔ¡q¾ˆÿ\0ö\ÔT6Û\ÃOA\éþ_º±fÅ¡º<?ûu\Zýño\ÏeVE[\è7\Çù]¦/\Ûm;©\ç\ë\Ïÿ\0-R`\Ñ®\'Q\î\éS&\èp@ ˆ=–†j\Ö\ê8ùÿ\0\Éüž˜e¢\ßü¿Š‹[\ÐoJk+\íSG\0û˜Hü\rj®	…\ÅÞ°\â\å°\á\×i=A+­ú\éM¬uë£¬§¡ð\èy\×N<—¦q\å\Ç\Å\Ú/¨RÈ¤\Ö\Æ$#\Âl\Þõ\Ö#0\Ðÿ\0Z\ä(\'Î™ XwZ;ÀcNu\ÛhŠ ‰š²\á‘\Äòõ’¶­2·®NÃœ	\Ô{*‡†¹ª\ä *\Äy“Ó•zC‹|Ÿan6{v\Ô6\äDõ\r`ý(ù3hg[LcR©$4n4ð©¦Ž•’2Ts>…µz\Ëf\ígCš\0\0iûRz\Ó<&Í™¹nð\ï\î·3DtþµiŒ|®r\ÛK`¥•Ÿ†¤x\Ô.\Ýû\Ò\És&R4Ð–\ë\åE”\ãþ\Ê\×\âW%Il\Åe@#Hñ\ë5k\ÂB\ÝV.ŠX“›ºAÜºŒ£Ê™\ã˜uP¡Qm\é˜—$\êMU(\"\ê«4\0@\'hû%\Ü^Ëœ?¹,Ö°6$œ£øµC¥D\Ç\àŽVº\Í\Þ\î\æS¡“ü«MÝµrª(µŽ‹\çÖ³œcn\È\Ê@/:\é\à³\ìšH¶´7v\ÞEK\Ë#»\áN5·¼À­ÁÚ¶€•@\ßSG\ÃøpkÝ\Æl€f1\ÏI\0{—An\â†‘\É_\Î\Ô¶*\Ö\í…%¬‚2fDy\íÖ¦añ· ²,H6ò\ÛN´ŒFõ\ÆYžöÁº\ë\Ì\Ò\î\ãÅ“ê–¶\Ñ{\â>\ÊE*HoY/q…\ïS+\\+°f\Ø:Ç…=c„^¿\Ûö7R\Ú\Û\Ë(X! ƒ\êõ\ÔjZ„\âï—·lž\é\î\Èð\Ôûh[µv\Ñ7\'Reº{<©“Iª@\áov\Â\Ü\Ó\\ƒ¯©1\Ìó\Þb›\Ã\ám@°!\ÖfI\ë:Tö\n\æB\Ã>`\ÆH\ã§üÔ¯\Ñ\Å\Â¹\Ï Ž\émi6R½\â÷¡­ö™m\å`jºG-ON•¯\áø\æ6ŠX[L¥‚O&-¡H\ê&™À|”\â”–\Ø\Ú\å:}»V\Ã\ÑOD\îYb·’}c<…=˜\ä\àöA\á|³H	3\ï­ÿ\0\á\"\ÔuùT\Ü\r·o\Õ\Zõ©•i¶\n(U›ô\Û\ÒDÁ\Øf$=\ÔYŒ\Í\È3\à*Ïñkx{Mr\ã@Q$ÿ\0 9“Ò¸¤¼f\æ3n1…‚-¡\Í\ÝÏ»\ë\'\ËÂ±Ë’´±c\ä\íô@»}®;;™f%˜\Î\ä\ïó\éÔ\Éþúmm‘\Ì{\'ðSö\ÔõøeqÁ’%|úÿ\0}=˜u>ÿ\0\ï¦\îZ\Ó\Ö\ZFšþ\n|Zú\ãóû”PYoú_‚™¿\ÃX\îu;[\×øhP¦ô!¸s\ãø[¦†7þ\î·÷\ÑP¦*ü5\ãþˆ÷[üUQ…\Çb0Xr\×u„h}VÕ€x²…\ni‰¯Gvô\'\Òûx\ëY€*\ë\Ýu?4ù\ìEiÈ¡Bº±»GH¥*AE\n*dH[”t(M\Å}\Ãb	,°N\äF¾\Ã\\«\Ò\ï@\ïa®ÍˆkM¨\ï#¨\"Š…)$mŠrNŒŽ\n-]~\Ú\Ò=Ï­\Þ\0xr¢Æ½«d\Ýý\Ñ\r\n\ÈF‡\Äª‘\ÔP¡PuÕ”¼K»«\'¸›¦\Â~\ÚM®X <Á}¼¨P¥e8¡‹¸kˆ¤\Ì@\ÊH:ô\0xSxžE°F\ä\ëB…2x®\'¸ \ZeÊ£§—J¬\Âð|\Ân™ðš)õœ(·w0$€ 1ñ¬áž‰\ÜÅa-ù‚Oº…\n\'KG@\à\ß&Ö‘˜“Vø_D¶™rõº…\n\ÑER\É+5xk(\ØS´(U™‚…\n\0*¿ŒqD±m\î1…E,LL\çB…g’MGEA[£†zU\é\r\Üm\É`\ËmL¥½}f!µo²¨šÁºo#o\ï¡B¸n\Ù\é$’¤IKm\×\áýô\àC\Ìü\â¡B\Ãt\Óú\ÅN,uû\nu¡{?ÿ\Ù');
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instituicao`
--

DROP TABLE IF EXISTS `instituicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instituicao` (
  `id_instituicao` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `pais` varchar(100) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_instituicao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instituicao`
--

LOCK TABLES `instituicao` WRITE;
/*!40000 ALTER TABLE `instituicao` DISABLE KEYS */;
INSERT INTO `instituicao` VALUES (3,'ZÃ© da Fome','teste','2','teste','testes','ES','BR','9999999999','rnarvaesf@gmail.com'),(4,'SÃ³ pelo PF','Rua dos bobos','3','NinguÃ©m lÃ¡','NÃ£o sei','RS','BR','9999999999','rodrigo.figueira@qi.edu.br');
/*!40000 ALTER TABLE `instituicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `id_instituicao` int(11) DEFAULT NULL,
  `id_refeicao` int(11) DEFAULT NULL,
  `data_carpadio` datetime NOT NULL,
  `descricao` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id_menu`),
  KEY `id_instituicao` (`id_instituicao`),
  KEY `id_refeicao` (`id_refeicao`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id_instituicao`),
  CONSTRAINT `menu_ibfk_2` FOREIGN KEY (`id_refeicao`) REFERENCES `refeicao` (`id_refeicao`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (8,4,40,'2017-12-11 00:00:00','Foi enviado um texto para teste....'),(9,3,40,'2017-12-10 00:00:00','Vamos ver.....');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro_email`
--

DROP TABLE IF EXISTS `parametro_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro_email` (
  `id_parametro_email` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_parametro_email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro_email`
--

LOCK TABLES `parametro_email` WRITE;
/*!40000 ALTER TABLE `parametro_email` DISABLE KEYS */;
INSERT INTO `parametro_email` VALUES (2,'luisgustavobauerpedrosogomes@gmail.com');
/*!40000 ALTER TABLE `parametro_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `id_instituicao` int(11) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`),
  KEY `id_instituicao` (`id_instituicao`),
  CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id_instituicao`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (14,3,'Luis Gustavo','luis.gomes@tbsa.com.br','9999999999'),(15,3,'Karen Fagundes','karenfagundesalfaro@outlook.com','9999999999'),(17,4,'Rodrigo','rnarvaesf@gmail.com','9999999999');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refeicao`
--

DROP TABLE IF EXISTS `refeicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refeicao` (
  `id_refeicao` int(11) NOT NULL AUTO_INCREMENT,
  `id_foto` int(11) NOT NULL,
  `descricao` varchar(1000) NOT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_refeicao`),
  KEY `refeicao_ibfk_1` (`id_foto`),
  CONSTRAINT `refeicao_ibfk_1` FOREIGN KEY (`id_foto`) REFERENCES `foto` (`id_foto`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refeicao`
--

LOCK TABLES `refeicao` WRITE;
/*!40000 ALTER TABLE `refeicao` DISABLE KEYS */;
INSERT INTO `refeicao` VALUES (40,44,'Arroz e feijÃ£o','2017-12-05 00:00:00');
/*!40000 ALTER TABLE `refeicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'refeicao'
--

--
-- Dumping routines for database 'refeicao'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10 23:21:41
