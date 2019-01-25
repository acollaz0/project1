
--SQL is not case sensitive
--common way people write out tables
--SQL is a scripting language
--we dont have to compile anything and can run in any order

CREATE TABLE PLAYER(P_ID NUMBER(10),
NAME varchar2(200),
SALARY NUMBER(10),
POINTS NUMBER(10),
TEAM VARCHAR2(200));

CREATE TABLE BANKUSER(U_ID NUMBER(10),
USERNAME varchar2(200),
PASSWORD varchar2(200),
ADMIN BOOLEAN);

CREATE TABLE BANKACCOUNT(A_ID NUMBER(10),
AMOUNT NUMBER(10),
TYPE varchar2(200));

--performing any command which will change the data in the database is DML

INSERT into PLAYER values(100, 'Mean Mike', 100000, 950, 'Grand Dunk Railroad');
insert into player values(77,'Michael',200000, 900, 'Grand Dunk Railroad');
insert into player values (9000, 'Hal9000', 10000000, 2, 'Grand Dunk Railroad');
insert into player values(48, 'Misunderstood Mike', 50000, 1200, 'Grand Dunk Railroad');
insert into player values (13, 'Lisa', 100001,960, 'Mutton Chop Mountaineers');
insert into player values (124, 'Peaceful Larry', 100001, 9025, 'Mutton Chop Mountaineers');
insert into player values (0, 'Russell Westbrook', 150000000, 29765, 'Mutton Chop Mountaineers');
INSERT INTO player VALUES (776, 'Meng Hao', 999999, 959, 'Mutton Chop Mountaineers');
INSERT INTO PLAYER VALUES(500, 'Jimbob Jones', 444444, 800, 'Mutton Chop Mountaineers');
insert into player values (121, 'Ryan',90000,750, 'Mutton Chop Mountaineers');
insert into player values(1,'Peter', 1,900, 'Mutton Chop Mountaineers');
INSERT INTO player VALUES(119, 'Shady Sam', 104550, 934, 'Mutton Chop Mountaineers');


--drop command is ddl and removes the table not just the data
--every ddl autocommits
drop table player;

--commit will save changes to the database
commit;
--to grab the entire table
SELECT * FROM PLAYER;

--if i want to remove records from a table you have options

--delete because it is dml it is only temporary can be reversed
delete PLAYER;
--checkpoint
rollback;

--select statements are the only statements for DQL
--designed to return a virtual table based on criteria

select name from player; --i have not made any specifications n what records i want
select p_id, points from player;

--where clause limits what records you get back not what information you get back
select * from player where name = 'Peter';
select name from player where points < 900;

--update think of set
update player set points = 800 where name = 'Ryan';

--aggregate function is going to calculate some value using multiple records

--aggregate function
select avg(salary) from player;

--group by is used with aggregate functions to break records into groups/buckets
select avg(salary), team from player group by team;

--having is an extra clause we use with group by because oracle wont let you use where

select avg(salary), team from player group by team having team like '%s';
--like is used for regualr expressions % is wild card

--between
select name from player where points between 700 and 1000;

--order by only changes the way in which the table is displayed not what records you pull
select name, points from player order by salary desc;

--any select statement returns a virtual table
--you can perform select statements on any table and can nest queries
select * from player where team = 'Mutton Chop Mountaineers';
--nested query putting a select inside another select
--generall less efficient than other commands and can usually be avoided
select * from (select * from player where team = 'Mutton Chop Mountaineers') where points > 775;

--truncate removes all records from a table and immediately auto commits
truncate table player;

--constraint is a rule that helps to structure your tables and database
create table player(
p_id number(10) primary key, --this is what makes a record unique
name varchar2(200) not null, --primary key is actually a mix of two other constraints
salary number(10) default 0,
team varchar2(200));

drop table player;
--procedure is just a set of sql commands
--essentially a script


--sequence is a sql object will generate unique numerbers
create sequence id_maker
    minvalue 0
    increment by 2
    ;

create or replace procedure add_player(name varchar2, salary number, team varchar2)
is 
begin

insert into player values(id_maker.nextval, name, salary, team);
insert into stats values(id_maker.currval, 0, 0, 0, 0);

end;

select * from player;

call add_player('Misunderstood Mike', 9000, 'Grand Dunk Railroad');

create table retired_player(
p_id number(10) primary key,
name varchar2(200));

create or replace trigger retire_player
before delete on player
for each row

begin

    insert into retired_player values(:old.p_id, :old.name);

end;

delete from player where p_id = 0;

select * from retired_player;

--does not change values in a table
--must have inputs and exactly one output

create or replace function shot_calculator(att number, made number) return number 
is percentage number(10);

begin
percentage := made/att*100;
end;

select * from stats;

create table stats(
p_id number(10) primary key,
points number(10),
attempts number(10),
made number(10),
shooting number(10)
);

create table team(
name varchar2(200) primary key,
hometown varchar2(200)
);

create table coach(
c_id number(10) primary key,
name varchar2(200),
salary number(10),
team varchar2(200)
);

create table game(
g_id number(10)primary key,
home varchar2(200),
away varchar2(200),
hscore number(10),
ascore number(10)
);

create table game_player(
g_id number(10),
p_id number(10)
);

create or replace procedure update_shooting(p_idn number, attn number, maden number)
is
begin
update stats set attempts = attempts + attn, made = made + maden, 
shooting = shot_calculator(attempts+attn, made+maden)
where p_id = p_idn;

end;

call update_shooting(40, 30, 15);
--you can place a foreign key on a non unique column
--but it must reference something unique
--putting a foreign key on a table makes it the child
--the parent must exist first

truncate table player;
truncate table stats;

alter table stats add constraint fk_stats_player foreign key
(p_id) references player(p_id);

alter table player add constraint fk_player_team foreign key
(team) references team(name);

alter table coach add constraint fk_coach_team foreign key
(team) references team(name);

alter table game_player add constraint fk_gp_player foreign key
(p_id) references player(p_id);

alter table game_player add constraint fk_gp_game foreign key
(g_id) references game(g_id);


select * from player;
select * from team;
select * from coach;
select * from stats;

insert into team values('Muttonchop Mountaineers', 'Morgantown');
insert into team values('The Groove', 'Funky Town');
insert into coach values(100, 'Coachy McCoachFace', 10000000, 'Muttonchop Mountaineers');
insert into coach values(101, 'Coach Carter', 300000, 'The Groove');

call add_player('Nice Nick', 90000, 'Muttonchop Mountaineers');
call add_player('Jump Jackson', 90000, 'Muttonchop Mountaineers');
call add_player('Bully Baylor', 90000, 'Muttonchop Mountaineers');

call add_player('Disco Dan', 120000, 'The Groove');
call add_player('Jivin Jim', 30000, 'The Groove');
call add_player('Jammin Jerry', 200000, 'The Groove');

commit;

-- everything after from is a virtual table
select * from player left join team on player.team = team.name;

--left and right joins
select player.name, coach.name from player left join coach on player.team = coach.team;

--inner joins

--natural joines shorthand for tables that share identical columns

select * from player natural join stats;
select * from player inner join stats on player.p_id = stats.p_id;

--cross join returns the cartesiian of two tables
--it multiplies every record
--matches every record to every record
select * from player cross join coach;

--theta joins matching records based not on equality but something else
--there is not a single player in the league who makes more than a coach
select * from player left join coach on player.salary > coach.salary;

--joins will combine tables horizontally. Unions cmbine tables vertically
--we are not trying to match records
--require that both 'tables' have the same type and order of columns

--union will combine two tables without duplicates 
--union all will combine two tables with duplicates
--intersect will only use records that are shared
--minus which will only use records that are not shared


select avg(salary) from
(select name, salary from player
union all
select name, salary from coach);





