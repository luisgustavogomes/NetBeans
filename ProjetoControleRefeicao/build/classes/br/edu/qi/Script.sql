/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lg
 * Created: 26/11/2017
 */

create table instituicao (
	 id_instituicao int not null primary key auto_increment 
	,nome varchar(100) not null
    ,endereco varchar(100) NOT NULL
    ,numero varchar(10) NOT NULL
    ,bairro varchar(100) NOT NULL
    ,cidade varchar(100) NOT NULL
    ,estado varchar(100) NOT NULL
    ,pais varchar(100) NOT NULL
    ,telefone varchar(15) DEFAULT NULL
    ,email varchar(100) DEFAULT NULL
);

create table pessoa (
	id_pessoa int not null primary key auto_increment
    ,id_instituicao int
    ,nome varchar(100) not null
    ,email varchar(100) not null
    ,telefone varchar (15) default null
	,FOREIGN KEY (id_instituicao) references instituicao (id_instituicao)
);



create table foto (
	id_foto int not null primary key auto_increment
    , image Blob	
);


create table refeicao(
	id_refeicao int not null primary key auto_increment
    ,id_foto int
    ,descricao varchar (1000) not null
    , data_cadastro datetime not null
    , foreign key (id_foto) references foto (id_foto)
);

create table menu( 
	id_menu int not null primary key auto_increment
    , id_instituicao int
	, id_refeicao int
    , data_carpadio datetime not null
    , descricao varchar(1000)
    , foreign key (id_instituicao) references instituicao (id_instituicao)
    , foreign key (id_refeicao) references refeicao (id_refeicao)
);

create table parametro_email (
	id_parametro_email int not null primary key auto_increment
    , email varchar(100) 
);

