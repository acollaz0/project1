create table pizza_user(
u_id number(10) primary key,
username varchar2(200),
password varchar2(200),
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
t_id number(10),
p_size varchar2(200),
crust varchar2(200),
sauce varchar2(200)
);

create table toppings(
t_id number(10) primary key,
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

alter table pizza add constraint fk_pizza_toppings foreign key
(t_id) references toppings(t_id) on delete cascade;

create sequence pid_maker
    minvalue 0
    increment by 1
    ;

create or replace procedure add_pizzauser(username varchar2, password varchar2, rewards number, employee number)
is 
begin

insert into pizza_user values(pid_maker.nextval, username, password, rewards, employee);

end;

