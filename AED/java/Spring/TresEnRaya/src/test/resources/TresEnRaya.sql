SET MODE MYSQL;

DROP TABLE IF EXISTS partidas;

create table partidas(
	id INT AUTO_INCREMENT,
	simbJ1 char,
	simbJ2 char,
	nickJ1 varchar(14),
	nickJ2 varchar(14),
	turno int,
	winner varchar(14),
	escenario varchar(9),
	estado varchar(15),
	CONSTRAINT pk_partidas PRIMARY KEY(id)
);