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
	privado boolean default true,
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
insert into cancion(titulo,autor,genero,duracion,portada,anho,archivo,privado,tipo,reproducciones,idUsuario)values("titulo","admin","genero","01:00","admin","2000","archivo",true,"AUDIO",1,1);
insert into listaReproduccion(nombre) values("lista1");
insert into CancionLista(pos,idCancion,idLista) values(1,1,1);