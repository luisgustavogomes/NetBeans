/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lg
 * Created: 02/11/2017
 */
--desc carro;
select * from modelo;
--alter table proprietario modify column estado varchar(100)

--insert into marca (descricao) values ('Kia')

--insert into modelo (descricao) values ('teste');








Banco de dados
create table proprietario (
id_proprietario int primary key auto_increment,
nome varchar(100) not null, 
endereco varchar (100) not null, 
numero varchar(10) not null, 
bairro varchar(100) not null, 
cidade varchar(100) not null, 
pais varchar(100) not null,
telefone varchar (15),
email varchar(100)
);

create table marca (
id_marca int primary key auto_increment,
descricao varchar (100)
);

create table modelo (
id_modelo int primary key auto_increment,
descricao varchar (100)
);

create table carro(
id_carro int primary key auto_increment,
id_modelo int,
id_marca int,
foreign key (id_modelo) references modelo (id_modelo),
foreign key (id_marca) references marca (id_marca)
);

create table venda (
id_venda int primary key auto_increment, 
nro int not null,
data_venda date not null,
ano int(4) not null,
descricao varchar (1000),
ar_condicionado TINYINT,
toca_fita TINYINT,
roda_liga TINYINT, 
tapete TINYINT, 
alarme TINYINT, 
tipo varchar (50) not null,
estado varchar (50) not null,
km int not null,
valor decimal (10,2) not null,
numero_parcela int not null,
id_carro int ,
id_proprietario int,
foreign key (id_carro) references carro (id_carro),
foreign key (id_proprietario) references proprietario (id_proprietario)
);

create table pagamento(
id_pagamento int primary key auto_increment,
nro_pagamento varchar(10) not null,
data_vencimento date not null,
data_pagamento date,
multa decimal (10,2),
valor_liquido decimal (10,2),
liquidacao tinyint,
id_venda int, 
foreign key (id_venda) references venda (id_venda)
);
