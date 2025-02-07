-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema vinyldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `vinyldb` ;

-- -----------------------------------------------------
-- Schema vinyldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vinyldb` DEFAULT CHARACTER SET utf8 ;
USE `vinyldb` ;

-- -----------------------------------------------------
-- Table `band`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `band` ;

CREATE TABLE IF NOT EXISTS `band` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(2000) NOT NULL,
  `image_url` VARCHAR(2000) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vinyl`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vinyl` ;

CREATE TABLE IF NOT EXISTS `vinyl` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(2000) NOT NULL,
  `image_url` VARCHAR(2000) NOT NULL,
  `band_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vinyl_band_idx` (`band_id` ASC) VISIBLE,
  CONSTRAINT `fk_vinyl_band`
    FOREIGN KEY (`band_id`)
    REFERENCES `band` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS vinyls@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'vinyls'@'localhost' IDENTIFIED BY 'vinyls';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'vinyls'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `band`
-- -----------------------------------------------------
START TRANSACTION;
USE `vinyldb`;
INSERT INTO `band` (`id`, `name`, `image_url`) VALUES (1, 'Cap\'N Jazz', 'https://i.scdn.co/image/2128693a4598c64a0c14f25ba3ee0f8f2afd3ab2');
INSERT INTO `band` (`id`, `name`, `image_url`) VALUES (2, 'Callous Daoboys', 'https://i.ytimg.com/vi/GPaD8HmcRVA/maxresdefault.jpg');
INSERT INTO `band` (`id`, `name`, `image_url`) VALUES (3, 'Coheed & Cambria', 'https://guitar.com/wp-content/uploads/2022/06/Coheed-Cambria-Credit-Alexandra-Gavillet@2560x1625.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vinyl`
-- -----------------------------------------------------
START TRANSACTION;
USE `vinyldb`;
INSERT INTO `vinyl` (`id`, `title`, `image_url`, `band_id`) VALUES (1, 'Analphabetapolothology', 'https://m.media-amazon.com/images/I/61Lop-CLHXL._UF1000,1000_QL80_.jpg', 1);
INSERT INTO `vinyl` (`id`, `title`, `image_url`, `band_id`) VALUES (2, 'Celebrity Therapist', 'https://f4.bcbits.com/img/a0509988875_65', 2);
INSERT INTO `vinyl` (`id`, `title`, `image_url`, `band_id`) VALUES (3, 'Die On Mars', 'https://i.scdn.co/image/ab67616d0000b2733432f4c0648ba50db1b4749d', 2);
INSERT INTO `vinyl` (`id`, `title`, `image_url`, `band_id`) VALUES (4, 'In Keeping Secrets of Silent Earth: 3', 'https://cdn-p.smehost.net/sites/35faef12c1b64b21b3fda052d205af13/wp-content/uploads/2014/10/41Qp-SdPHxL.jpg', 3);

COMMIT;

