# AnalisePropostaCartao

AnalisePropostaCartao API REST + Angular + Mysql
API REST Para manter os dados das propostas de Cartões de Crédito.

Configuração da aplicação:

	Banco Mysql está configurado para a porta 3309 (Pode ser alterado no arquivo do projeto application.properties)
	Criar uma banco de dados no Mysql com nome de propostas
	Usuário do banco: root (Pode ser alterado no arquivo do projeto application.properties)
	Senha do banco: 123456 (Pode ser alterado no arquivo do projeto application.properties)
	Executar o script contido no projeto BancoProposta.sql (Contém alguns clientes, propostas e usuários cadastrados no banco)

Created by Diego Rangel
Contact the developer

Introdução:

Descrição: Api Rest que mantém dados de propostas de cartão de crédito para aprovação por usuário auditor com interface em Angular

Principal funcionalidade: 
Login com autenticação de token 
Cadastro de Cliente
Cadastro de Propostas
Alteração dos Status das Propostas

OBSERVAÇÃO IMPORTANTE:
	Usuario admin (Usuário admin e senha 123) tem acesso a todas as funcionalidades
	Usuario auditor (Usuário admin e senha 123) tem acesso a todas as funcionalidades
	Usuario cadastros (Usuário admin e senha 123) só tem acesso a cadastro de cliente e proposta

API REST desenvolvida em Spring Boot
						 Mavem
						 Banco de dados Mysql
						 
Link do repositório no Git: https://github.com/diegorangelsoares/AnalisePropostaCartao


Link para acesso aos andpoints pelo swagger
localhost:8080/swagger-ui.html

Link para acessar a interface Angular
http://localhost:8080/#/


SQL do BancoProposta.sql

/*
SQLyog Ultimate v9.01 
MySQL - 5.1.46-community : Database - propostas
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`propostas` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `propostas`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

LOCK TABLES `hibernate_sequence` WRITE;

insert  into `hibernate_sequence`(`next_val`) values (57),(57);

UNLOCK TABLES;

/*Table structure for table `tab_cliente` */

DROP TABLE IF EXISTS `tab_cliente`;

CREATE TABLE `tab_cliente` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `tab_cliente` */

LOCK TABLES `tab_cliente` WRITE;

insert  into `tab_cliente`(`id`,`cpf`,`email`,`nome`) values (1,'048.509.434-70','diegorangeljpa@gmail.com','Diego Rangel'),(2,'511.013.828-13','pedro@gmail.com','Pedro Antonio'),(3,'453.189.479-05','junior@gmail.com','Junior Ramalho'),(5,'123.123.123-23','a@a.com','Diego Rangel Diego'),(4,'123.123.123-23','a@a.com','Julia Da Silva'),(6,'048.509.434-71','a@a.com','Diego Rangel Diego');

UNLOCK TABLES;

/*Table structure for table `tab_proposta` */

DROP TABLE IF EXISTS `tab_proposta`;

CREATE TABLE `tab_proposta` (
  `id` bigint(20) NOT NULL,
  `data` varchar(255) DEFAULT NULL,
  `status_documentos` varchar(255) DEFAULT NULL,
  `status_proposta` varchar(255) DEFAULT NULL,
  `statusspc` varchar(255) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgeculiujk1v83ik6dm8ppo03i` (`cliente_id`),
  KEY `FKqv8nhe3l3k5amuv2ss8lr1p9m` (`usuario_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `tab_proposta` */

LOCK TABLES `tab_proposta` WRITE;

insert  into `tab_proposta`(`id`,`data`,`status_documentos`,`status_proposta`,`statusspc`,`cliente_id`,`usuario_id`) values (30,'02/08/2019','autorizada','autorizada','autorizada',1,1),(0,'02/08/2019','pendente','pendente','pendente',2,1),(8,'02/08/2019','pendente','pendente','pendente',3,1),(1,'02/08/2019','pendente','pendente','pendente',4,1),(2,'02/08/2019','pendente','pendente','pendente',1,1),(3,'02/08/2019','pendente','pendente','pendente',2,1),(4,'02/08/2019','pendente','pendente','pendente',1,1),(5,'02/08/2019','pendente','pendente','pendente',4,1),(6,'02/08/2019','pendente','pendente','pendente',2,1);

UNLOCK TABLES;

/*Table structure for table `tab_usuario` */

DROP TABLE IF EXISTS `tab_usuario`;

CREATE TABLE `tab_usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `permissao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `tab_usuario` */

LOCK TABLES `tab_usuario` WRITE;

insert  into `tab_usuario`(`id`,`nome`,`senha`,`permissao`) values (1,'admin','123','auditor');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
