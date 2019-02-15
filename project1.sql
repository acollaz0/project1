select * from pizza_user;
select * from pizza_order;
select * from pizza;
delete from pizza_order where o_id = 72;
commit;
create table pizza_user(
u_id number(10) primary key,
username varchar2(200) not null,
password varchar2(200) not null,
rewards number(10),
employee number(10)
);

create table pizza_order(
o_id number(10) primary key,
u_id number(10),
total number(10),
status varchar2(200),
datetime varchar2(200),
saved number(10)
);

create table pizza(
p_id number(10) primary key,
o_id number(10),
p_size varchar2(200),
crust varchar2(200),
sauce varchar2(200)
);

create table toppings(
t_id number(10) primary key,
p_id number(10),
pepperoni number(10),
i_sausage number(10),
bacon number(10),
ham number(10),
salami number(10),
mushrooms number(10),
b_olives number(10),
b_peppers number(10),
pineapple number(10),
onions number(10),
g_peppers number(10),
feta number(10),
spinach number(10)
);

alter table pizza_order add constraint fk_order_user foreign key
(u_id) references pizza_user(u_id) on delete cascade;

alter table pizza add constraint fk_pizza_order foreign key
(o_id) references pizza_order(o_id) on delete cascade;

alter table toppings add constraint fk_toppings_pizza foreign key
(p_id) references pizza(p_id) on delete cascade;

alter table pizza_user add constraint puser_unique unique (username);

alter table pizza_user add constraint puser_nnull check (username is not null);
alter table pizza_user add constraint ppassword_nnull check (password is not null);

create sequence pid_maker
    minvalue 0
    increment by 1
    ;

create or replace procedure add_pizzauser(username varchar2, password varchar2, rewards number, employee number)
is 
begin

insert into pizza_user values(pid_maker.nextval, username, password, rewards, employee);

end;

create or replace procedure add_order(u_id number, total number, status varchar2, datetime varchar2, saved number)
is
begin

insert into pizza_order values(pid_maker.nextval, u_id, total, status, datetime, saved);

end;

create or replace procedure add_pizza(o_id number, p_size varchar2, crust varchar2, sauce varchar2)
is
begin

insert into pizza values(pid_maker.nextval, o_id, p_size, crust, sauce);

end;

create or replace procedure add_toppings(p_id number, pepperoni number, i_sausage number, bacon number, ham number, salami number, mushrooms number, b_olives number, b_peppers number, pineapple number, onions number, g_peppers number, feta number, spinach number)
is
begin

insert into toppings values(pid_maker.nextval, p_id, pepperoni, i_sausage, bacon, ham, salami, mushrooms, b_olives, b_peppers, pineapple, onions, g_peppers, feta, spinach);

end;

