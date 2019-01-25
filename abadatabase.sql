select * from player;

-- truncate removes all records from a table and immediatealy auto commits
truncate table player;

drop table player;

-- constraint is a rule that helps to structure your tables and database
create table player(
p_id number(10) primary key, -- This is what makes a record un que
name varchar2(200) not null,  -- primary key is actually a mix of two other constraints
salary number(10) default 0, 
team varchar2(200));

create table stats(
p_id number(10) primary key,
points number(10),
attempts number(10),
made number(10),
shooting number(10)

);

create table team( 
name varchar2(200) primary key, 
hometown varchar2(200));

create table coach(c_id number(10) primary key, 
name varchar2(200), 
salary number(10),
team varchar2(200));

create table game(g_id number(10)primary key,
home varchar2(200), 
away varchar2(200), 
hscore number(10), 
ascore number(10));


create table game_player(g_id number(10), p_id number(10));


-- procedure is just a set of sql commands 
-- essentially a script

-- sequence is a sql object which will generate  unqiue 

create sequence id_maker
    minvalue 0
    start with 0
    -- maxvalue 999999999999999
    increment by 2
    ;
    
create or replace procedure add_player(name varchar2, salary number, team varchar2)
is
begin

insert into player values(id_maker.nextval,name,salary,team);
insert into stats values(id_maker.currval,0,0,0,0);

end;

select * from player;
select * from stats;
call add_player('Shady Sam', 900000, 'Grand Dunk Railroad');
commit;

create table retired_player(p_id number(10) primary key, name varchar2(200));

create or replace trigger retire_player
before delete on player
for each row

begin

    insert into retired_player values (:old.p_id, :old.name);
    
end;

-- a function does not change  values in a table 
-- it must have inputs and exactly one output

create or replace function shot_calculator(att number, made number) return number 
is percentage number(10);

begin
percentage := made/att*100;
return percentage;
end;


create or replace procedure update_shooting(p_idn number, attn number, maden number)
is
begin

update stats set attempts = attempts + attn, made = made + maden, 
shooting = shot_calculator(attempts+attn,made+maden)
where p_id = p_idn;

end;

select * from player;
select * from stats;

call update_shooting(40, 30, 15);


-- you can place a foreign key on a non unique column
-- but it must reference somthing  unique
-- putting a foreign key on a table makes it the child
-- the parent must exist first

alter table stats add constraint fk_stats_player foreign key
(p_id) REFERENCES player(p_id);

alter table player add constraint fk_player_team foreign key
(team) references team(name) on delete cascade;

alter table coach add constraint fk_coach_team foreign key
(team) references team(name);

alter table game_player add constraint fk_gp_player foreign key
(p_id) references player(p_id);

alter table game_player add constraint fk_gp_game foreign key
(g_id) references game(g_id);

alter table player drop constraint fk_player_team;
insert into team values ('Mutton Chomp Mountaineers', 'Morgantown');
insert into team values ('Grand Dunk Railroad', 'New York');

insert into coach values(1, 'Coachy McCoachFace',45000,'Grand Dunk Railroad');

call add_player('Mean Mike',30000,'Grand Dunk Railroad');

delete from team where name = 'Grand Dunk Railroad';


truncate table player;
truncate table stats;

select * from player;
select * from team;
select * from coach;
delete team;

insert into team values('Muttonchop Mountaineers', 'Morgantown');
insert into team values('The Groove', 'Funky Town');
insert into coach values (100, 'Coachy McCoachFace',1000000,'Muttonchop Mountaineers');
insert into coach values (101, 'Carter',300000,'The Groove');

call add_player('Nice Nick', 90000, 'Muttonchop Mountaineers');
call add_player('Jump Jackson', 90000, 'Muttonchop Mountaineers');
call add_player('Bully Baylor', 90000, 'Muttonchop Mountaineers');

call add_player('Disco Dan', 120000, 'The Groove');
call add_player('Jivin Jim', 30000, 'The Groove');
call add_player('Jammin Jerry', 200000, 'The Groove');

select * from player;

-- everything after the from statement is just a virtual table
select p_id, hometown from player left join team on player.team = team.name;

-- left and right joins
select player.name,coach.name  from player left join coach on player.team = coach.team;

--inner joins

--natural joins  shorthand for tables that share identiacl columns
select * from player natural join stats;
select * from player inner join stats on player.p_id = stats.p_id;

-- cross join returns the cartesiian of two tables
-- it multiples every record 
-- matches every record to every record
select * from player cross join coach;

-- theta joins matching records based not on equality but something else
-- there is not a single player in the league who makes more  than  a ccoach
select * from player left join coach on player.salary > coach.salary; 


-- joins will combine tables horizonatally. Unions combine tables vertically
-- we are not trying to match records
-- they require that both 'tables' have the same type and order of columns

-- union will combine two tables without duplicats
-- union all will combie two tables with  duplicates
-- intersect will only use records that are sharred
-- minus which will only use records that are not shared

select avg(salary) from
(select name,salary from player
union all
select name, salary from coach);


