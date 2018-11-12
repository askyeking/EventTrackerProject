-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mtggametracker
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mtggametracker` ;

-- -----------------------------------------------------
-- Schema mtggametracker
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mtggametracker` DEFAULT CHARACTER SET utf8 ;
USE `mtggametracker` ;

-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `opponent_name` VARCHAR(45) NOT NULL,
  `game_wins` INT NOT NULL,
  `game_losses` INT NOT NULL,
  `game_draws` INT NOT NULL DEFAULT 0,
  `deck` VARCHAR(45) NULL,
  `opponent_deck` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS planeswalker;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'planeswalker'@'localhost' IDENTIFIED BY 'planeswalker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'planeswalker';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `game`
-- -----------------------------------------------------
START TRANSACTION;
USE `mtggametracker`;
INSERT INTO `game` (`id`, `opponent_name`, `game_wins`, `game_losses`, `game_draws`, `deck`, `opponent_deck`) VALUES (1, 'Jacob Pry', 1, 2, DEFAULT, 'Fish', 'Affinity');
INSERT INTO `game` (`id`, `opponent_name`, `game_wins`, `game_losses`, `game_draws`, `deck`, `opponent_deck`) VALUES (2, 'Chris Pina', 2, 1, DEFAULT, 'Fish', 'Affinity');
INSERT INTO `game` (`id`, `opponent_name`, `game_wins`, `game_losses`, `game_draws`, `deck`, `opponent_deck`) VALUES (3, 'Alex Pina', 0, 2, DEFAULT, 'Fish', 'Ponza');
INSERT INTO `game` (`id`, `opponent_name`, `game_wins`, `game_losses`, `game_draws`, `deck`, `opponent_deck`) VALUES (4, 'Brian Kibler', 2, 0, DEFAULT, 'Mono U Tron', 'Blue Moon');
INSERT INTO `game` (`id`, `opponent_name`, `game_wins`, `game_losses`, `game_draws`, `deck`, `opponent_deck`) VALUES (5, 'Shota Yasooka', 1, 1, 1, 'Mono U Tron', 'Burn');

COMMIT;
