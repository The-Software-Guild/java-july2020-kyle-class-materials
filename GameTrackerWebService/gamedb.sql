drop database if exists gamedb;

create database gamedb;

use gamedb;

create table game(
    `name` varchar(100) primary key,
    genre varchar(50),
    publisher varchar(100),
    releaseYear int);