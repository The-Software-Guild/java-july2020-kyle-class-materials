drop database if exists complexgamedbtest;

create database complexgamedbtest;

use complexgamedbtest;

create table publisher(
	id int primary key auto_increment,
    publisher varchar(40) not null,
    country varchar(40) null
);

create table platform(
	id int primary key auto_increment,
    platform varchar(20) not null
);

create table game(
	id int primary key auto_increment,
    `name` varchar(100) not null,
    releaseYear int,
    publisherId int,
    genre varchar(50),
    constraint foreign key (publisherId) references publisher(id)
);


CrEaTe table game_platform (
	gameId int,
    platformId int,
    primary key(gameId, platformId),
    constraint foreign key (gameId) references game(id),
    constraint foreign key (platformId) references platform(id)
);










