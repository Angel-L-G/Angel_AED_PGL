CREATE DATABASE  TresEnRaya;
USE  TresEnRaya;

CREATE TABLE `partidas`(
	id int AUTO_INCREMENT,
	estado VARCHAR(40),
	nickJ1 VARCHAR(255),
	nickJ2 VARCHAR(255),
	simbJ1 VARCHAR(1),
	simbJ2 VARCHAR(1),
	turno int,
	escenario VARCHAR(255),
	winner VARCHAR(255),
	CONSTRAINT pk_partidas PRIMARY KEY(id)
);

CREATE TABLE `usuarios` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nombre` varchar(45) NOT NULL,
	`password` varchar(200) NOT NULL,
	`rol` varchar(45) NOT NULL,
	`email` varchar (45),
	`active` int default 0,
	`hash` varchar(255),
	constraint pk_usuarios PRIMARY KEY(id),
	constraint uk_nombre UNIQUE KEY(nombre)
);
