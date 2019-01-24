
-- SQL is not case sensitive
--commmon way people write out teables
-- SQL is a scripting langiuge we do not have to compu
-- 
-- can run in any order
CREATE TABLE PLAYER(
P_ID NUMBER(10),
NAME varchar2(200), 
SALARY NUMBER (10),
POINTS NUMBER(10),
TEAM VARCHAR2(200));

-- anything that chnges the data is dml
-- basketball
insert into player values (100,'Mean Mike',100000,950,'Grand Dunk Railroad');
insert into player values(77,'Michael',200000, 900,'Grand Dunk Railroad');
insert into player values (9000, 'Hal9000', 10000000, 2,'Grand Dunk Railroad');
insert into player values(48, 'Misunderstood Mike', 50000, 1200,'Grand Dunk Railroad');
insert into player values (13, 'Lisa', 100001,960,'Mutton Chop Mountaineers');
insert into player values (124, 'Peaceful Larry', 100001, 9025,'Mutton Chop Mountaineers');
insert into player values (0, 'Russell Westbrook', 150000000, 29765,'Mutton Chop Mountaineers');
INSERT INTO player VALUES (776, 'Meng Hao', 999999, 959,'Mutton Chop Mountaineers');
INSERT INTO PLAYER VALUES(500, 'Jimbob Jones', 444444, 800,'Mutton Chop Mountaineers');
insert into player values (121, 'Ryan',90000,750,'Mutton Chop Mountaineers');
insert into player values(1,'Commaless Peter', 1,900,'Mutton Chop Mountaineers');
INSERT INTO player VALUES(119, 'Shady Sam', 104550, 934,'Mutton Chop Mountaineers');


-- the drop command is ddl and removes the  table  not just the data
-- every ddl autocommits
drop table player;
-- commit will saves changes to the database
commit;
-- to grab the entire table
select * from player;

-- to remove records from a tablee you have optionns

-- delete because it is dml is only tempporaryy cann be reversed
delete player;

-- checkpoint
rollback;


-- select statements are the only statements for DQL
-- designed to return a virtual ttablee based  on critteria
select name from player;-- i have not made any specificaations  on what records I want
select p_id, points from player;

-- the where clause limits whatr records you get back not what infoormationon you get back
select * from player where name = 'Ryan';

select name from player where points <900;

-- update think of set
update player set points = 800 where name = 'Ryan';

---------------
select * from player;
select name, salary from player;

---aggregate function is going too calculate tsome  value using multiple recorrds

-- aggregate function
select avg(salary) from player;

-- group by is used with aggregate functions to break records into o groups// bucketss
select avg(salary), team from player group by team;

-- having is an extra clause we use with grouby because oracle wont let you use where
select avg(salary), team from player group by team having team like '%s';
-- like is used for regular expressions % is wild card

-- between
select name from player where points not between 700 and 1000;

-- orderby only changes to way in which the table is displayed not t what t records you pull
select name,points from player order by salary desc;

-- any select statement retuns a virtual tablee
-- you can perforce selct statements on any  table and can nest queriess

Select * from player where team = 'Mutton Chop Mountaineers';

-- nested query putting a select inside a nother slect
-- generally less efficnet that other commands and can ususally be avoided
select * from (Select * from player where team = 'Mutton Chop Mountaineers') where points >775;
