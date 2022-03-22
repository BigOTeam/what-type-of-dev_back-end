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

-- -----------------------------------------------------
-- Schema bigo_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bigo_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `bigo_db` ;

-- -----------------------------------------------------
-- Table `bigo_db`.`job`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bigo_db`.`job` (
                                               `job_id` BIGINT NOT NULL,
                                               `job_name` VARCHAR(200) NOT NULL,
                                               `job_description` VARCHAR(1000) NULL DEFAULT NULL,
                                               `job_img_url` VARCHAR(1000) NULL DEFAULT NULL,
                                               PRIMARY KEY (`job_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`page`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bigo_db`.`page` (
                                                `page_id` BIGINT NOT NULL,
                                                `page_name` VARCHAR(200) NOT NULL,
                                                `page_description` VARCHAR(1000) NULL DEFAULT NULL,
                                                `page_img_url` VARCHAR(1000) NULL DEFAULT NULL,
                                                `page_no` INT NOT NULL,
                                                PRIMARY KEY (`page_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`statistic_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bigo_db`.`statistic_group` (
                                                           `statistic_id` BIGINT NOT NULL,
                                                           `statistics_name` VARCHAR(500) NOT NULL,
                                                           `statistics_image` VARCHAR(1000) NULL DEFAULT NULL,
                                                           PRIMARY KEY (`statistic_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bigo_db`.`question` (
                                                    `question_id` BIGINT NOT NULL,
                                                    `question` VARCHAR(500) NOT NULL,
                                                    `question_initial` VARCHAR(100) NULL DEFAULT NULL,
                                                    `chart_type` VARCHAR(100) NULL DEFAULT NULL,
                                                    `page_id` BIGINT NOT NULL,
                                                    `statistic_id` BIGINT NOT NULL,
                                                    PRIMARY KEY (`question_id`),
                                                    INDEX `FK_page_TO_question_1` (`page_id` ASC) VISIBLE,
                                                    INDEX `FK_statistic_group_TO_question_1` (`statistic_id` ASC) VISIBLE,
                                                    CONSTRAINT `FK_page_TO_question_1`
                                                        FOREIGN KEY (`page_id`)
                                                            REFERENCES `bigo_db`.`page` (`page_id`),
                                                    CONSTRAINT `FK_statistic_group_TO_question_1`
                                                        FOREIGN KEY (`statistic_id`)
                                                            REFERENCES `bigo_db`.`statistic_group` (`statistic_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`survey_answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bigo_db`.`survey_answer` (
                                                         `survey_answer_id` BIGINT NOT NULL,
                                                         `answer` VARCHAR(500) NOT NULL,
                                                         `answer_seq` INT NOT NULL,
                                                         `question_id` BIGINT NOT NULL,
                                                         PRIMARY KEY (`survey_answer_id`),
                                                         INDEX `FK_question_TO_survey_answer_1` (`question_id` ASC) VISIBLE,
                                                         CONSTRAINT `FK_question_TO_survey_answer_1`
                                                             FOREIGN KEY (`question_id`)
                                                                 REFERENCES `bigo_db`.`question` (`question_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `bigo_db`.`survey_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bigo_db`.`survey_record` (
                                                         `survey_record` BIGINT NOT NULL,
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
