create database hotelmanagementsystem;
show databases;
use hotelmanagementsystem;

create table login(username varchar(25), password varchar(25));
insert into login values('admin', '12345');
select * from login;

create table room(roomnumber varchar(20), availability varchar(20), cleaning_status varchar(20), price varchar(20), bed_type varchar(20));
select * from room;

create table employee(name varchar(20), age varchar(20), gender varchar(20), job varchar(20), salary varchar(20), phone varchar(20), email varchar(40), aadhar varchar(20));
select * from employee;

create table driver(name varchar(20), age varchar(20),gender varchar(20), company varchar(20), carname varchar(20), available varchar(20), location varchar(20));
select * from driver;

create table login2(user_name varchar(20), password varchar(20));
select * from login2;
insert into login2 values('Saurav', '123456');

create table department(department varchar(80), budget varchar(50));
select * from department;

insert into department values ('office','50000');
insert into department values ('HouseKeeping','40000');
insert into department values ('Food','80000');
insert into department values ('Kitchen','20000');
insert into department values ('Security','60000');

create table customer(document varchar(20), number varchar(30), name varchar(30), gender varchar(15), country varchar(20), room varchar(10), checkintime varchar(80),deposit varchar(20));
select * from customer;

create table history( name varchar(30),id_number varchar(20), room varchar(10),checkin varchar(50),checkout varchar(50),amount varchar(20));
select * from history;













