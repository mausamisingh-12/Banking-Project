create database bankmanagementsystem;
show databases;
use  bankmanagementsystem; 
create table signuptwo(formno varchar(20),religion varchar(40),category varchar(40),income varchar(40),education varchar(40),occupation varchar(60),pan varchar(30),aadhar varchar(40),seniorcitizen varchar(60),existingaccount varchar(40));
create table signupthree(formno varchar(20),accountType varchar(40),cardnumber varchar(25),pin varchar(10),facility varchar(100));
create table login(formno varchar(20),cardnumber varchar(25),pin varchar(10));
create table bank(pin varchar(10),date varchar(20),type varchar(20),amount varchar(20));
create table signup(formno varchar(20),name varchar(20),father_name varchar(30),dob varchar(20),gender varchar(20),email varchar(30),marital_status varchar(20),address varchar(40),city varchar(25),state varchar(20),pin varchar(25));
select * from login;
select * from signuptwo;
select * from signupthree;
select * from bank;
select * from signup;
drop table bank;
create table bank(pin varchar(10),date varchar(40),type varchar(30),amount varchar(40));
drop table signuptwo;
