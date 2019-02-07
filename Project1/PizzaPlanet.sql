
commit;
--Creates the table of users
create table users(
u_id number(10) Primary Key,
username varchar2(100),
password varchar2(100),
rewards number(20));