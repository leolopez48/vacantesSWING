create table usuario
(
id_usuario int not null,
nombre_usuario varchar(100) not null,
prioridad int not null,
contra varchar(6) not null,
foto_usuario varchar(100) not null,
estado int not null
);

create table profesional
(
id_profesional int not null,
edad int not null,
nombre_profesional varchar(100) not null,
apellido_profesional varchar(100) not null,
profesion varchar(100) not null,
correo varchar(100) not null,
id_usuario int not null,
id_genero int not null
);

create table habilidad 
(
id_habilidad int not null,
descripcion varchar(80) not null,
id_profesional int not null
);

create table idioma 
(
id_idioma int not null AUTO_INCREMENT,
idioma varchar(50) null,
id_habilidad int not null
);

create table titulo
(
id_titulo int not null,
profesion varchar(80) not null,
id_habilidad int not null
);

create table curso
(
id_curso int not null,
curso varchar(50) null,
id_habilidad int not null
);

create table ultimos_trabajos
(
id_trabajos int not null,
trabajo varchar(50) not null,
id_habilidad int not null
);

create table años_expeciencia
(
id_añosExp int not null,
años_experincia int not null,
id_habilidad int not null
);

create table genero 
(
id_genero int not null,
genero varchar(20) not null
);

create table empresa 
(
id_empresa int not null,
nombre_empresa varchar(100) not null,
descripcion varchar(200) not null,
id_usuario int not null
);


alter table usuario add constraint pk_id_usuario primary key (id_usuario);
alter table profesional add constraint pk_id_profesional primary key (id_profesional);
alter table habilidad add constraint pk_id_habilidad primary key (id_habilidad);
alter table idioma add constraint pk_id_idioma primary key (id_idioma);
alter table titulo add constraint pk_id_titulo primary key(id_titulo);
alter table curso add constraint pk_id_curso primary key (id_curso);
alter table ultimos_trabajos add constraint pk_id_trabajos primary key (id_trabajos);
alter table años_expeciencia add constraint pk_id_añosExp primary key (id_añosExp);
alter table genero  add constraint pk_id_genero primary key (id_genero);
alter table empresa add constraint pk_id_empresa primary key (id_empresa);


alter table profesional add constraint fk_id_usuario foreign key (id_usuario) references usuario(id_usuario);
alter table empresa add constraint fk_id_usuar foreign key (id_usuario) references usuario(id_usuario);
alter table habilidad add constraint fk_profesion foreign key (id_profesional) references profesional(id_profesional);
alter table idioma add constraint fk_id_habilidad foreign key (id_habilidad) references habilidad(id_habilidad);
alter table titulo add constraint fk_id_habilida foreign key (id_habilidad) references habilidad(id_habilidad);
alter table curso add constraint fk_id_habilid foreign key (id_habilidad) references habilidad(id_habilidad);
alter table ultimos_trabajos add constraint id_habili foreign key (id_habilidad) references habilidad(id_habilidad);
alter table años_expeciencia add constraint id_habil foreign key (id_habilidad) references habilidad(id_habilidad);
alter table profesional add constraint fk_genero foreign key (id_genero) references genero(id_genero);

INSERT INTO `genero` (`id_genero`, `genero`) VALUES ('1', 'Masculino');
INSERT INTO `genero` (`id_genero`, `genero`) VALUES ('2', 'Femenino');
INSERT INTO `genero` (`id_genero`, `genero`) VALUES ('3', 'Otro');
insert into usuario (id_usuario, nombre_usuario, prioridad, contra, foto_usuario, estado) values(1,"leolopez",1,"12345","C:\Users\Roberto\Pictures\proyecto\1.jpg", 1);
insert into profesional (id_profesional, edad, nombre_profesional, apellido_profesional,profesion, correo, id_usuario, id_genero) values(1,34,"Leonel","Lopez","Programador", "elprogramador@gmail.com", 1, 1); 
insert into usuario (id_usuario, nombre_usuario, prioridad, contra, foto_usuario, estado) values(2,"rob",1,"123","C:\Users\Roberto\Pictures\proyecto\2.png", 1);
insert into profesional (id_profesional, edad, nombre_profesional, apellido_profesional,profesion, correo, id_usuario, id_genero) values(2,34,"Roberto","Armijo","Programador", "elprogramador@gmail.com", 2, 1); 

insert into empresa(id_empresa,nombre_empresa,descripcion,id_usuario) values (1,"DELL","Buena Empresa de Tecnologia",1);
insert into empresa(id_empresa,nombre_empresa,descripcion,id_usuario) values (2,"IBM","Tecnologia y mas, Empresa dedicada a la comunidad y a otras cosas",1);
INSERT INTO `habilidad` (`id_habilidad`, `descripcion`, `id_profesional`) VALUES ('1', 'Idioma', '1'), ('2', 'Curso', '1');

INSERT INTO `idioma` (`id_idioma`, `idioma`, `id_habilidad`) VALUES ('1', 'Español', '1'), ('2', 'Ingles', '1');

INSERT INTO `curso` (`id_curso`, `curso`, `id_habilidad`) VALUES ('1', 'Master en JAVA', '2'), ('2', 'Master en Javascript', '2');
 

