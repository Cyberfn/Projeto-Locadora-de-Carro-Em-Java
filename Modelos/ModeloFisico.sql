-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema locacaocarros
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema locacaocarros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `locacaocarros` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `locacaocarros` ;

-- -----------------------------------------------------
-- Table `locacaocarros`.`carros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locacaocarros`.`carros` (
  `idcar` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(50) NOT NULL,
  `modelo` VARCHAR(50) NOT NULL,
  `placa` VARCHAR(50) NOT NULL,
  `cor` VARCHAR(20) NOT NULL,
  `ano` INT NOT NULL,
  `disponivel` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idcar`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `locacaocarros`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locacaocarros`.`clientes` (
  `idcli` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `dtnasc` DATE NOT NULL,
  `cpf` VARCHAR(20) NOT NULL,
  `cnh` VARCHAR(20) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idcli`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `locacaocarros`.`locacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locacaocarros`.`locacoes` (
  `id_cliente` INT NOT NULL,
  `id_carro` INT NOT NULL,
  `data_locacao` DATE NOT NULL,
  `data_devolucao` DATE NOT NULL,
  `custo` DOUBLE NOT NULL,
  PRIMARY KEY (`id_cliente`, `id_carro`),
  INDEX `id_carro` (`id_carro` ASC) VISIBLE,
  CONSTRAINT `locacoes_ibfk_1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `locacaocarros`.`clientes` (`idcli`),
  CONSTRAINT `locacoes_ibfk_2`
    FOREIGN KEY (`id_carro`)
    REFERENCES `locacaocarros`.`carros` (`idcar`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
