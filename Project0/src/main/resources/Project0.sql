-- drop tables
drop table transaction;
drop table bank_account;
drop table a_user;

-- drop sequences
drop sequence user_id_maker;
drop sequence bank_account_id_maker;
drop sequence transaction_id_maker;

-- create tables
create table a_user(
    user_id number(10) primary key,
    username varchar2(200) unique,
    password varchar2(200),
    f_name varchar2(200),
    l_name varchar2(200),
    user_type varchar2(200)
);

create table bank_account(
    bank_account_id number(10) primary key,
    user_id number(10),
    balance number(10,2),
    account_type varchar2(200)
);

create table transaction(
    transaction_id number(10) primary key,
    bank_account_id number(10),
    balance_before number(10,2),
    balance_after number(10,2)
);

-- add foreign keys to tables
alter table bank_account add constraint fk_bank_account_user foreign key
(user_id) references a_user(user_id) on delete cascade;

alter table transaction add constraint fk_transaction_bank_account foreign key
(bank_account_id) references bank_account(bank_account_id) on delete cascade;

-- create sequences
create sequence user_id_maker
    minvalue 0
    start with 0
    increment by 1;
    
create sequence bank_account_id_maker
    minvalue 0
    start with 0
    increment by 1;
    
create sequence transaction_id_maker
    minvalue 0
    start with 0
    increment by 1;

-- create procedures
create or replace procedure add_user(username varchar2, password varchar2, f_name varchar2, l_name varchar2, user_type varchar2)
is
begin
insert into a_user values(user_id_maker.nextval, username, password, f_name, l_name, user_type);
end;

create or replace procedure add_bank_account(user_id number, balance number, account_type varchar2)
is
begin
insert into bank_account values(bank_account_id_maker.nextval, user_id, balance, account_type);
end;

create or replace procedure add_transaction(bank_account_id number, balance_before number, balance_after number)
is
begin
insert into transaction values(transaction_id_maker.nextval, bank_account_id, balance_before, balance_after);
end;

-- test queries
insert into a_user values(2, 'salatomic', 'hello', 'Michael', 'Salato', 'user');
--insert into a_user values(3, 'salatomic', 'hello', 'user'); -- will not work because it violates unique constraints
insert into bank_account values(1, 2, 50, 'savings');
insert into bank_account values(2, 2, 2.25, 'checking');
insert into transaction values(5, 1, 20, 32);
insert into transaction values(6, 1, 9, 3);
insert into transaction values(9, 2, 23, 2);
commit;

select * from a_user;
select * from bank_account;
select * from transaction;

delete from a_user where user_id >= 0;
delete from bank_account where bank_account_id >= 0;
delete from transaction where transaction_id >= 0;
commit;

update a_user set f_name = 'Tester' where user_id = 5534532;

delete from a_user where user_id = 2;
delete from bank_account where user_id = 2;
delete from bank_account where bank_account_id = 1;
commit;