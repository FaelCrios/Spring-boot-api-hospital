
use vollmed_api;

create table medicos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    phone varchar(20) not null,
    crm varchar(6) not null unique,
    speciality varchar(100) not null,
    state char(2) not null,
    cep varchar(9) not null,
    city varchar(100) not null,
    neighborhood varchar(100) not null,
    street varchar(100) not null,
    numero varchar(20),

    primary key(id)

);

create table pacientes (
	id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    rg varchar(20) not null,
    cpf varchar(20) not null,
    state char(2) not null,
    cep varchar(9) not null,
    city varchar(100) not null,
    neighborhood varchar(100) not null,
    street varchar(100) not null,
    numero varchar(20),
    
    primary key (id)
);