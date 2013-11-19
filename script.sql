drop database if exists jee;
create database jee;

use jee;

create table wallet (
	id integer not null primary key auto_increment
);

create table transaction (
	id integer not null primary key auto_increment
);

create table admin (
	id integer not null primary key auto_increment,
	name varchar(80),
	lastName varchar(80)
);

create table action (
	id integer not null primary key auto_increment,
	idWallet integer,
	foreign key (idWallet) references wallet(id) on delete cascade
);

create table account (
	id integer not null primary key auto_increment,
	amount float,
	idWallet integer,
	foreign key (idWallet) references wallet(id)
);

create table client (
	id integer not null primary key auto_increment,
	name varchar(80),
	firsName varchar(80),
	idAccount integer,
	foreign key (idAccount) references account(id)
);
