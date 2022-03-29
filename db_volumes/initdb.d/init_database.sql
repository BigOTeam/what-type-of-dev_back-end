-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bigo_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bigo_db` ;

-- -----------------------------------------------------
-- Schema bigo_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bigo_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `bigo_db` ;

-- -----------------------------------------------------
-- Table `bigo_db`.`tb_answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bigo_db`.`tb_answer` ;

CREATE TABLE IF NOT EXISTS `bigo_db`.`tb_answer` (
                                                     `answer_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                     `answer` VARCHAR(500) NOT NULL,
                                                     `answer_seq` INT NOT NULL,
                                                     PRIMARY KEY (`answer_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`tb_job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bigo_db`.`tb_job` ;

CREATE TABLE IF NOT EXISTS `bigo_db`.`tb_job` (
                                                  `job_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                  `job_name` VARCHAR(200) NOT NULL,
                                                  `job_description` VARCHAR(1000) NULL,
                                                  `job_img` VARCHAR(1000) NULL,
                                                  PRIMARY KEY (`job_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`tb_page`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bigo_db`.`tb_page` ;

CREATE TABLE IF NOT EXISTS `bigo_db`.`tb_page` (
                                                   `page_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                   `page_name` VARCHAR(200) NOT NULL,
                                                   `page_description` VARCHAR(1000) NULL,
                                                   `page_img` VARCHAR(1000) NULL,
                                                   `page_no` INT NOT NULL,
                                                   PRIMARY KEY (`page_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`tb_statistic_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bigo_db`.`tb_statistic_group` ;

CREATE TABLE IF NOT EXISTS `bigo_db`.`tb_statistic_group` (
                                                              `statistic_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                              `statistic_name` VARCHAR(500) NOT NULL,
                                                              `statistic_img` VARCHAR(1000) NULL,
                                                              PRIMARY KEY (`statistic_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`tb_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bigo_db`.`tb_question` ;

CREATE TABLE IF NOT EXISTS `bigo_db`.`tb_question` (
                                                       `question_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                       `question` VARCHAR(500) NOT NULL,
                                                       `question_initial` VARCHAR(100) NULL,
                                                       `chart_type` VARCHAR(100) NULL,
                                                       `page_id` BIGINT NOT NULL,
                                                       `statistic_id` BIGINT NULL,
                                                       PRIMARY KEY (`question_id`),
                                                       INDEX `FK_tb_page_TO_tb_question_1` (`page_id` ASC) VISIBLE,
                                                       INDEX `FK_tb_statistic_group_TO_tb_question_1` (`statistic_id` ASC) VISIBLE,
                                                       CONSTRAINT `FK_tb_page_TO_tb_question_1`
                                                           FOREIGN KEY (`page_id`)
                                                               REFERENCES `bigo_db`.`tb_page` (`page_id`),
                                                       CONSTRAINT `FK_tb_statistic_group_TO_tb_question_1`
                                                           FOREIGN KEY (`statistic_id`)
                                                               REFERENCES `bigo_db`.`tb_statistic_group` (`statistic_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`tb_survey_record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bigo_db`.`tb_survey_record` ;

CREATE TABLE IF NOT EXISTS `bigo_db`.`tb_survey_record` (
                                                            `survey_record` BIGINT NOT NULL AUTO_INCREMENT,
                                                            `aboutme_dev` INT NULL DEFAULT NULL,
                                                            `aboutme_dev_type` INT NULL DEFAULT NULL,
                                                            `aboutme_age` INT NULL DEFAULT NULL,
                                                            `aboutme_gender` INT NULL DEFAULT NULL,
                                                            `aboutme_salary` INT NULL DEFAULT NULL,
                                                            `aboutme_work` INT NULL DEFAULT NULL,
                                                            `aboutme_mobile` INT NULL DEFAULT NULL,
                                                            `dev_headphone` INT NULL DEFAULT NULL,
                                                            `dev_eat` INT NULL DEFAULT NULL,
                                                            `dev_drink` INT NULL DEFAULT NULL,
                                                            `dev_team_size` INT NULL DEFAULT NULL,
                                                            `dev_worktime` INT NULL DEFAULT NULL,
                                                            `moral_cctv` INT NULL DEFAULT NULL,
                                                            `moral_rule` INT NULL DEFAULT NULL,
                                                            `moral_help` INT NULL DEFAULT NULL,
                                                            `moral_gov_protection` INT NULL DEFAULT NULL,
                                                            `moral_manner` INT NULL DEFAULT NULL,
                                                            `moral_environment` INT NULL DEFAULT NULL,
                                                            `relation_equal` INT NULL DEFAULT NULL,
                                                            `relation_understand` INT NULL DEFAULT NULL,
                                                            `relation_humble` INT NULL DEFAULT NULL,
                                                            `relation_friends` INT NULL DEFAULT NULL,
                                                            `relation_region` INT NULL DEFAULT NULL,
                                                            `success_own_decision` INT NULL DEFAULT NULL,
                                                            `success_rich` INT NULL DEFAULT NULL,
                                                            `success_recognize` INT NULL DEFAULT NULL,
                                                            `success_admire` INT NULL DEFAULT NULL,
                                                            `success_leader` INT NULL DEFAULT NULL,
                                                            `life_good` INT NULL DEFAULT NULL,
                                                            `life_job` INT NULL DEFAULT NULL,
                                                            `life_fun` INT NULL DEFAULT NULL,
                                                            `life_safe` INT NULL DEFAULT NULL,
                                                            `life_givefun` INT NULL DEFAULT NULL,
                                                            `adventure_creative` INT NULL DEFAULT NULL,
                                                            `adventure_idea` INT NULL DEFAULT NULL,
                                                            `adventure_fun` INT NULL DEFAULT NULL,
                                                            `job_website` FLOAT NULL DEFAULT NULL,
                                                            `job_database` FLOAT NULL DEFAULT NULL,
                                                            `job_it_infrastrucutre` FLOAT NULL DEFAULT NULL,
                                                            `job_data_science` FLOAT NULL DEFAULT NULL,
                                                            `job_games` FLOAT NULL DEFAULT NULL,
                                                            `job_frinance` FLOAT NULL DEFAULT NULL,
                                                            `job_utilities` FLOAT NULL DEFAULT NULL,
                                                            `job_programming_tools` FLOAT NULL DEFAULT NULL,
                                                            `job_enetertainment` FLOAT NULL DEFAULT NULL,
                                                            `job_system_software` FLOAT NULL DEFAULT NULL,
                                                            PRIMARY KEY (`survey_record`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`tb_question_answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bigo_db`.`tb_question_answer` ;

CREATE TABLE IF NOT EXISTS `bigo_db`.`tb_question_answer` (
                                                              `question_answer_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                              `question_id` BIGINT NOT NULL,
                                                              `answer_id` BIGINT NOT NULL,
                                                              INDEX `fk_tb_question_answer_tb_question1_idx` (`question_id` ASC) VISIBLE,
                                                              INDEX `fk_tb_question_answer_tb_answer1_idx` (`answer_id` ASC) VISIBLE,
                                                              PRIMARY KEY (`question_answer_id`),
                                                              CONSTRAINT `fk_tb_question_answer_tb_question1`
                                                                  FOREIGN KEY (`question_id`)
                                                                      REFERENCES `bigo_db`.`tb_question` (`question_id`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION,
                                                              CONSTRAINT `fk_tb_question_answer_tb_answer1`
                                                                  FOREIGN KEY (`answer_id`)
                                                                      REFERENCES `bigo_db`.`tb_answer` (`answer_id`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bigo_db`.`tb_answer`
-- -----------------------------------------------------
START TRANSACTION;
USE `bigo_db`;
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('네', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('아니요', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('웹', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('금융', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('응용소프트웨어', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('시스템소프트웨어', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('게임', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('엔터테인먼트', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('인프라', 7);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('데이터/머신러닝', 8);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('DB', 9);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('프로그래밍툴', 10);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('기타', 11);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('20세 미만', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('20-24세', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('25-29세', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('30-34세', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('35-39세', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('40-44세', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('45-49세', 7);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('50세이상', 8);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('여성', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('남성', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('2000-3000', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('3000-4000', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('4000-5000', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('5000-6000', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('6000-7000', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('7000-8000', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('8000-9000', 7);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('9000-1억', 8);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('1억 이상', 9);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('재택근무', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('출근', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('난 천재라 어디서든 됨', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('노상관', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('IOS', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('Android', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('무선', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('유선', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('둘다', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('안씀', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('스스로 해먹는다', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('냉장/냉동', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('사내식당', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('외식', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('배달', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('안먹음', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('커피', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('차', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('물', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('맥주', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('에너지음료', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('청량음료', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('혼자', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('2-7', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('8-12', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('13-20', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('21-40', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('40인 이상', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('6시 이전', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('6-7', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('7-8', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('8-9', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('9-10', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('10-11', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('11-12', 7);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('12-13', 8);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('13-14', 9);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('14-15', 10);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('15-16', 11);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('16-17', 12);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('17-18', 13);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('18-19', 14);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('19-20', 15);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('20-21', 16);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우그렇다', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('그렇다', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('그렇지않다', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우그렇지않다', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('모르겠다', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우매우 만족', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우 만족', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('꽤 만족', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('만족', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('약간 만족', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('약간 불만족', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('불만족', 7);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('꽤 불만족', 8);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우 불만족', 9);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우매우 불만족', 10);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('모르겠다', 11);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('완전히 만족', 1);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우 만족', 2);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('꽤 만족', 3);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('보통', 4);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('꽤 불만족', 5);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('매우 불만족', 6);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('완전히 불만족', 7);
INSERT INTO `bigo_db`.`tb_answer` (`answer`, `answer_seq`) VALUES ('모르겠다', 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bigo_db`.`tb_job`
-- -----------------------------------------------------
START TRANSACTION;
USE `bigo_db`;
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (1, 'Websites', NULL, 'https://i.ibb.co/tLTkY32/Web.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (2, 'Utilities', NULL, 'https://i.ibb.co/vZ9p437/Util.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (3, 'Database/Data Storage', NULL, 'https://i.ibb.co/RDYFqnH/DB.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (4, 'System Software', NULL, 'https://i.ibb.co/3Y5M15k/OS.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (5, 'IT Infrastructure', NULL, 'https://i.ibb.co/JxFpn22/Infra.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (6, 'Finance', NULL, 'https://i.ibb.co/SvD3jKG/Finance.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (7, 'Business Intelligence/ Data Science / Machine Learning', NULL, 'https://i.ibb.co/FDzTCzw/Machine.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (8, 'Programming Tools', NULL, 'https://i.ibb.co/3hY46Jz/Tool.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (9, 'Entertainment', NULL, 'https://i.ibb.co/9493WGR/Ent.png');
INSERT INTO `bigo_db`.`tb_job` (`job_id`, `job_name`, `job_description`, `job_img`) VALUES (10, 'Games', NULL, 'https://i.ibb.co/n7cr5JK/Game.png');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bigo_db`.`tb_page`
-- -----------------------------------------------------
START TRANSACTION;
USE `bigo_db`;
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (1, '개발자질문', NULL, 'https://i.ibb.co/SfRGM8w/1.png', 1);
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (2, '자기소개', NULL, 'https://i.ibb.co/SfRGM8w/1.png', 2);
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (3, '개발 관련', NULL, 'https://i.ibb.co/s9vtN92/2.png', 3);
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (4, '도덕성', NULL, 'https://i.ibb.co/1r0y65T/3.png', 4);
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (5, '관계', NULL, 'https://i.ibb.co/D799vQj/4.png', 5);
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (6, '성공', NULL, 'https://i.ibb.co/3Rf5Nhd/5.png', 6);
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (7, '삶의 만족도', NULL, 'https://i.ibb.co/t8FvnSj/6.png', 7);
INSERT INTO `bigo_db`.`tb_page` (`page_id`, `page_name`, `page_description`, `page_img`, `page_no`) VALUES (8, '모험 정신', NULL, 'https://i.ibb.co/8g5ZQzG/7.png', 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bigo_db`.`tb_statistic_group`
-- -----------------------------------------------------
START TRANSACTION;
USE `bigo_db`;
INSERT INTO `bigo_db`.`tb_statistic_group` (`statistic_id`, `statistic_name`, `statistic_img`) VALUES (1, '프로필', 'https://i.ibb.co/SfRGM8w/1.png');
INSERT INTO `bigo_db`.`tb_statistic_group` (`statistic_id`, `statistic_name`, `statistic_img`) VALUES (2, '생활모습', 'https://i.ibb.co/t8FvnSj/6.png');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bigo_db`.`tb_question`
-- -----------------------------------------------------
START TRANSACTION;
USE `bigo_db`;
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('현직에서 개발일을 하고 계신가요?', 'aboutme_dev', 'doughnut', 1, 1);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('현직 개발자인 경우, 현재 일하고 있는 분야를 선택해주세요. 현직 개발자가 아닌 경우, 어느 분야에서 일하고 싶은지 선택해주세요.', 'aboutme_dev_type', 'horizontalBar', 2, 1);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('연대를 선택해주세요.', 'aboutme_age', 'verticalBar', 2, 1);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('성별을 선택해주세요.', 'aboutme_gender', 'doughnut', 2, 1);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('희망 연봉은 얼마인가요?', 'aboutme_salary', 'verticalBar', 2, 1);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('선호하는 근무형태는 무엇인가요?', 'aboutme_work', 'horizontalBar', 2, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('사용하는 모바일 운영체제는 무엇인가요?', 'aboutme_mobile', 'doughnut', 2, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('어떤 타입의 헤드셋을 사용하시나요?', 'dev_headphone', NULL, 3, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('점심은 주로 어떻게 드세요?', 'dev_eat', NULL, 3, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('일 할 때 어떤 음료를 마시나요?', 'dev_drink', 'horizontalBar', 3, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('팀 규모가 몇 명인 곳에서 일하고 싶나요?', 'dev_team_size', NULL, 3, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('주로 몇 시부터 일하나요? 또는 몇 시부터 일하고 싶나요?', 'dev_worktime', NULL, 3, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('정부가 공공장소에서 CCTV로 사람들을 감시할 권리가 있다고 생각하나요?', 'moral_cctv', NULL, 4, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('남들이 보고 있지 않을 때도 항상 규칙을 따라야 한다고 생각하나요?', 'moral_rule', NULL, 4, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('다른 사람을 돕는 것을 중요하게 생각하나요?', 'moral_help', 'horizontalBar', 4, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('정부가 강해져서 모든 위협으로부터 시민들을 보호할 수 있기를 원하나요?', 'moral_gov_protection', NULL, 4, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('항상 올바르게 행동하는 것을 중요하게 생각하나요?', 'moral_manner', 'horizontalBar', 4, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('환경 보호를 중요하게 생각하나요?', 'moral_environment', NULL, 4, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('모든 사람들이 동등하게 대우받아야 하며, 삶에서 동등한 기회를 얻어야 한다고 믿나요?', 'relation_equal', NULL, 5, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('당신은 다른 사람의 의견을 경청하고 이해하려고 노력하나요?', 'relation_understand', NULL, 5, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('당신에게는 겸손한 것이 중요하고 다른 사람들의 관심을 끌지 않으려고 노력하나요?', 'relation_humble', NULL, 5, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('친구 또는 지인들을 위해 헌신하나요?', 'relation_friends', NULL, 5, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('종교나 가족의 관습에 따르려고 노력하나요?', 'relation_region', NULL, 5, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('당신은 간섭없이 스스로 결정을 내리는 것을 중요하게 생각하나요?', 'success_own_decision', NULL, 6, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('값 비싼 것을 소유하고, 부자가 되는 것을 중요하게 생각하나요?', 'success_rich', 'horizontalBar', 6, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('자신의 능력을 인정받고, 타인으로부터 인정받기를 원하나요?', 'success_recognize', NULL, 6, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('성공하는 것이 중요하고 사람들의 당신의 업적을 인정해주기를 바라나요?', 'success_admire', NULL, 6, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('타인이 본인을 따르고 존중하는 것을 중요하게 여기나요?', 'success_leader', NULL, 6, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('모든 것을 고려했을 때, 요즘 당신의 삶은 얼마나 만족스러운가요?', 'life_good', 'horizontalBar', 7, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('당신의 직업에 얼마나 만족하나요?', 'life_job', 'horizontalBar', 7, 1);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('당신은 걱정 없이 즐겁게 사나요?', 'life_fun', NULL, 7, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('어떤 위험 요소도 없는 안전한 삶을 사는 것을 중요하게 생각하나요?', 'life_safe', 'horizontalBar', 7, 2);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('즐거움을 주는 일을 하는 것을 중요하게 생각하나요?', 'life_givefun', NULL, 7, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('당신은 새로운 아이디어에 대해서 생각하고, 나만의 방식대로 창의적이게 어떤 일을 수행하는 사람인가요?', 'adventure_creative', NULL, 8, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('새로운 일들을 찾는 것을 좋아하고, 인생에서 다른 것을 해보는 것을 중요하게 생각하나요?', 'adventure_idea', NULL, 8, NULL);
INSERT INTO `bigo_db`.`tb_question` (`question`, `question_initial`, `chart_type`, `page_id`, `statistic_id`) VALUES ('모험하는 것을 좋아하고 신나는 삶을 살고 싶나요?', 'adventure_fun', NULL, 8, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bigo_db`.`tb_question_answer`
-- -----------------------------------------------------
START TRANSACTION;
USE `bigo_db`;
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (1, 1);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (1, 2);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 3);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 4);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 5);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 6);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 7);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 8);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 9);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 10);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 11);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 12);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (2, 13);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 14);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 15);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 16);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 17);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 18);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 19);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 20);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (3, 21);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (4, 22);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (4, 23);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 24);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 25);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 26);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 27);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 28);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 29);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 30);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 31);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (5, 32);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (6, 33);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (6, 34);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (6, 35);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (6, 36);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (7, 37);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (7, 38);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (8, 39);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (8, 40);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (8, 41);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (8, 42);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (9, 43);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (9, 44);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (9, 45);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (9, 46);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (9, 47);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (9, 48);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (10, 49);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (10, 50);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (10, 51);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (10, 52);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (10, 53);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (10, 54);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (11, 55);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (11, 56);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (11, 57);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (11, 58);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (11, 59);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (11, 60);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 61);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 62);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 63);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 64);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 65);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 66);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 67);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 68);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 69);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 70);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 71);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 72);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 73);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 74);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 75);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (12, 76);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (13, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (13, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (13, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (13, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (13, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (14, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (14, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (14, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (14, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (14, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (15, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (15, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (15, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (15, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (15, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (16, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (16, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (16, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (16, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (16, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (17, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (17, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (17, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (17, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (17, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (18, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (18, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (18, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (18, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (18, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (19, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (19, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (19, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (19, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (19, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (20, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (20, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (20, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (20, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (20, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (21, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (21, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (21, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (21, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (21, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (22, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (22, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (22, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (22, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (22, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (23, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (23, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (23, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (23, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (23, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (24, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (24, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (24, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (24, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (24, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (25, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (25, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (25, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (25, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (25, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (26, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (26, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (26, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (26, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (26, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (27, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (27, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (27, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (27, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (27, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (28, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (28, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (28, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (28, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (28, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 82);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 83);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 84);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 85);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 86);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 87);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 88);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 89);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 90);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 91);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (29, 92);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 93);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 94);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 95);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 96);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 97);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 98);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 99);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (30, 100);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (31, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (31, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (31, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (31, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (31, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (32, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (32, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (32, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (32, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (32, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (33, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (33, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (33, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (33, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (33, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (34, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (34, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (34, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (34, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (34, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (35, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (35, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (35, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (35, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (35, 81);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (36, 77);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (36, 78);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (36, 79);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (36, 80);
INSERT INTO `bigo_db`.`tb_question_answer` (`question_id`, `answer_id`) VALUES (36, 81);

COMMIT;

