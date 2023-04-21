-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.11.0-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- survey 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `survey` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `survey`;

-- 테이블 survey.surveyanswer 구조 내보내기
CREATE TABLE IF NOT EXISTS `surveyanswer` (
  `userId` varchar(50) NOT NULL,
  `answer1` longtext DEFAULT NULL,
  `answer2` longtext DEFAULT NULL,
  `answer3` longtext DEFAULT NULL,
  `answer4` longtext DEFAULT NULL,
  `answer5` longtext DEFAULT NULL,
  `answer6` longtext DEFAULT NULL,
  `answer7` longtext DEFAULT NULL,
  `answer8` longtext DEFAULT NULL,
  `answer9` longtext DEFAULT NULL,
  `answer10` longtext DEFAULT NULL,
  `answer11` longtext DEFAULT NULL,
  `answer12` longtext DEFAULT NULL,
  `answer13` longtext DEFAULT NULL,
  `answer14` longtext DEFAULT NULL,
  `answer15` longtext DEFAULT NULL,
  PRIMARY KEY (`userId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 survey.surveyanswer:~61 rows (대략적) 내보내기
DELETE FROM `surveyanswer`;
/*!40000 ALTER TABLE `surveyanswer` DISABLE KEYS */;
INSERT INTO `surveyanswer` (`userId`, `answer1`, `answer2`, `answer3`, `answer4`, `answer5`, `answer6`, `answer7`, `answer8`, `answer9`, `answer10`, `answer11`, `answer12`, `answer13`, `answer14`, `answer15`) VALUES
	('124123412', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
	('13d131r1f', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
	('aasfwed', 'asdfsd', 'fadfasd', 'fasdfas', 'dfasfasd', 'fasdf', 'asdfasdf', 'asdfasfa', 'sdfasdfas', 'dfasdfa', 'sdfasdf', 'asdfasdf', 'asdfasdf', 'asdfasdf', 'asdfasdf', 'asdfasdf'),
	('asd12d', '11', '22', '33', '44', '55', '11', '22', '33', '44', '55', '11', '22', '33', '44', '55'),
	('asdf', 'ㅇㅇㅇㅇ', 'ㅇㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇ', 'ㅇㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇ', 'ㅇㅇㅇ'),
	('asdfasdf', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
	('asdfg', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
	('tester', '테스트 답변입니다. 이러이러한 게 후회가 되었습니다.', '마음이 정말 좋지 않았습니다.', '다시 그 상황이면.. 용기를 내어 행동하고 싶습니다.', '용기를 낼 수 있는 동기, 괜찮다는 믿음', '괜찮아 질러도 돼!', '테스트 답변 2입니다.', '테스트 답변 2입니다.', '테스트 답변 2입니다.', '테스트 답변 2입니다.', '테스트 답변 2입니다.', '테스트 답변 3입니다.', '테스트 답변 3입니다.', '테스트 답변 3입니다.', '테스트 답변 3입니다.', '테스트 답변 3입니다.'),
	('tester3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
	('테스트입니다.', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
/*!40000 ALTER TABLE `surveyanswer` ENABLE KEYS */;

-- 테이블 survey.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `userId` varchar(50) NOT NULL,
  `userPw` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `sexMale` varchar(50) DEFAULT NULL,
  `sexFemale` varchar(50) DEFAULT NULL,
  `birthDate` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 survey.user:~61 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`, `userPw`, `userName`, `sexMale`, `sexFemale`, `birthDate`) VALUES
	('124123412', '', '', NULL, NULL, ''),
	('13d131r1f', '', '', NULL, NULL, ''),
	('aasfwed', '1241312', 'ddddd', '1', NULL, '2022-09-27'),
	('asd12d', 'assdfsdf', 'asdafas', '1', NULL, '2022-10-12'),
	('asdf', '1234', '이름입니다.', '1', NULL, '2022-10-13'),
	('asdfasdf', 'asdfasd', 'sadf', '1', NULL, '2022-10-04'),
	('asdfg', '1234', 'dddd', '1', NULL, '2022-09-27'),
	('tester', 'tester', '테스테입니다.', '1', NULL, '2022-10-12'),
	('tester3', 'tester', 'tester', '1', NULL, '2022-10-05'),
	('테스트입니다.', 'test', '테스터', '1', NULL, '1992-02-13');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
