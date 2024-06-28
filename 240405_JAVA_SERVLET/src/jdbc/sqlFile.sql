--테이블 생성
create table product(
pno int not null auto_increment,
pname varchar(50) not null,
pprice int not null default 0,
regdate datetime default now(),
madeby text,
primary key (pno));