--2024/04/16
create table member(
id varchar(100) not null,
password varchar(200) not null,
email varchar(200) not null,
age int default 0,
regdate datetime default now(),
lastlogin datetime default now(),
primary key(id));

--2024/04/16
create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(50) not null,
content text,
regdate datetime default now(),
moddate datetime default now(),
primary key(bno));