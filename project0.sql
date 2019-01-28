create table bankuser(
b_id number(10) primary key,
username varchar2(200) unique,
password varchar2(200),
super number(10)
);

create table bankaccount(
a_id number(10) primary key,
amount number(10),
type varchar2(200),
b_id number(10)
);

create table transaction(
t_id number(10) primary key,
change varchar2(200),
total number(10, 2),
datetime varchar2(200),
a_id number(10)
);

drop table bankaccount;

create sequence id_maker
    minvalue 0
    increment by 2
    ;

alter table bankaccount add constraint fk_account_user foreign key
(b_id) references bankuser(b_id) on delete cascade;

alter table transaction add constraint fk_transaction_account foreign key
(a_id) references bankaccount(a_id) on delete cascade;



create or replace procedure add_user(username varchar2, password varchar2, super number)
is 
begin

insert into bankuser values(id_maker.nextval, username, password, super);

end;


create or replace procedure add_account(amount number, type varchar2, b_id number)
is
begin

insert into bankaccount values(id_maker.nextval, amount, type, b_id);

end;

create or replace procedure add_transaction(change varchar2,total number, datetime varchar2, a_id number)
is
begin

insert into transaction values(id_maker.nextval, change, total, datetime, a_id);

end;

create or replace trigger account_transaction
before update on bankaccount
for each row
begin

if :new.amount < 0 then RAISE_APPLICATION_ERROR(-20000, 'Insufficient funds');
elsif :new.amount > :old.amount then add_transaction(concat('+', to_char(:new.amount - :old.amount)),:new.amount, to_char(current_timestamp, 'YYYY-MM-DD HH24:MI:SS'), :new.a_id);
elsif :new.amount < :old.amount then add_transaction(concat('-', to_char(:old.amount - :new.amount)),:new.amount, to_char(current_timestamp, 'YYYY-MM-DD HH24:MI:SS'), :new.a_id);
end if;

end;
