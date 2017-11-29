create database tb_user;
use tb_user;
create table t_user(
	id int primary key identity(1,1),
	uname varchar(20) not null,
	upwd varchar(20) not null,
	educact varchar(20) not null,
	sex int not null
	)