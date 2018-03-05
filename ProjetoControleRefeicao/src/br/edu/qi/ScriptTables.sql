/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lg
 * Created: 11/12/2017
 */


CREATE TABLE `foto` (
  `id_foto` int(11) NOT NULL AUTO_INCREMENT,
  `image` mediumblob NOT NULL,
  PRIMARY KEY (`id_foto`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

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

CREATE TABLE `parametro_email` (
  `id_parametro_email` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_parametro_email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

CREATE TABLE `refeicao` (
  `id_refeicao` int(11) NOT NULL AUTO_INCREMENT,
  `id_foto` int(11) NOT NULL,
  `descricao` varchar(1000) NOT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  PRIMARY KEY (`id_refeicao`),
  KEY `refeicao_ibfk_1` (`id_foto`),
  CONSTRAINT `refeicao_ibfk_1` FOREIGN KEY (`id_foto`) REFERENCES `foto` (`id_foto`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

