drop database if exists casette;
create database casette;
use casette;

create table usuario(
	idUsuario int auto_increment,
	nombreUsuario varchar(30) not null unique,
	clave varchar(20) not null,
	email varchar(40),
	fechaNacimiento date,
	deBaja boolean default false,
	constraint PK_USUARIO primary key (idUsuario) 
);

create table cancion(
	idCancion int auto_increment,
	titulo varchar(30) not null,
	autor varchar(30),
	genero varchar(20),
	duracion time not null,
	portada varchar(225),
	anho year,
	archivo varchar(225) not null,
	privada boolean default true,
	tipo enum('AUDIO', 'VIDEO'),
	reproducciones int, 
	idUsuario int,
	constraint PK_CANCION primary key (idCancion),
	constraint FK_CANCION_USUARIO foreign key (idUsuario) references usuario(idUsuario)
		on delete set null
	    on update cascade
);

create table listaReproduccion(
	idLista int auto_increment,
	nombre varchar(30) not null,
	idUsuario int,
	constraint PK_LISTAREPRODUCCION primary key (idLista),
	constraint FK_LISTA_USUARIO foreign key (idUsuario) references usuario(idUsuario)
		on delete set null
		on update cascade
);

create table CancionLista (
	idCancionLista int auto_increment,
	pos int not null,
	idCancion int, 
	idLista int, 
	constraint PK_POS primary key (idCancionLista),
	constraint FK_POS_CANCION foreign key (idCancion) references cancion(idCancion)
	on delete set null
	on update cascade,
	constraint FK_POS_LISTA foreign key (idLista) references listaReproduccion(idLista)
	on delete set null
	on update cascade
);


insert into usuario(nombreUsuario, clave, email, fechaNacimiento, deBaja) values("admin","abc123...","admin@gmail.com","2001-03-17", false);

insert into cancion(titulo,autor,genero,duracion,portada,anho,archivo,privada,tipo,reproducciones,idUsuario)values("titulo1","autor1","genero1","01:00","portada1.png","2024","musica1.mp3",true,"AUDIO",0,1);
insert into cancion(titulo,autor,genero,duracion,portada,anho,archivo,privada,tipo,reproducciones,idUsuario)values("titulo2","autor2","genero2","01:00","portada2.jpg","2015","musica2.mp3",false,"AUDIO",0,1);
insert into cancion(titulo,autor,genero,duracion,portada,anho,archivo,privada,tipo,reproducciones,idUsuario)values("titulo3","autor3","genero3","01:00","portada3.png","2023","musica3.mp3",false,"AUDIO",0,1);
insert into cancion(titulo,autor,genero,duracion,portada,anho,archivo,privada,tipo,reproducciones,idUsuario)values("titulo4","autor4","genero4","01:00","portada4.jpg","2018","musica4.mp3",true,"AUDIO",0,1);

insert into listaReproduccion(nombre, idUsuario) values("lista1", 1);

insert into CancionLista(pos,idCancion,idLista) values(1,1,1);
insert into CancionLista(pos,idCancion,idLista) values(2,2,1);
insert into CancionLista(pos,idCancion,idLista) values(3,3,1);
insert into CancionLista(pos,idCancion,idLista) values(4,4,1);

-- select * from listaReproduccion LR join cancionLista CL on LR.idLista = CL.idLista where LR.idLista = 1 and idUsuario = 1;
-- SELECT * FROM cancionLista CL JOIN cancion C ON CL.idCancion = C.idCancion WHERE idLista = 1 ORDER BY pos;