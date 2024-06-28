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

--2024/04/17
create table product(
pnum int auto_increment,
category varchar(50) not null,
name varchar(100) not null,
price int default 0,
total_amount int default 100,
sale_amount int default 0,
regdate datetime default now(),
primary key(pnum));

create table buy(
bnum int auto_increment,
customer varchar(50),
product_name varchar(100),
price int default 0,
amount int default 0,
buydate datetime default now(),
primary key(bnum));

alter table buy add foreign key(bnum) references product(pnum);
alter table buy add foreign key(customer) references member(id);

--2024/04/20
create table comment(
cno int auto_increment,
bno int not null,
writer varchar(100) default "unknown",
content varchar(1000) not null,
regdate datetime default now(),
primary key(cno));

--2024/04/28
alter table board add imageFile varchar(100);
alter table board add readCount int default 0