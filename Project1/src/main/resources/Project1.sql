-- drop tables
drop table pizza_topping;
drop table pizza;
drop table topping;
drop table pizza_order;
drop table an_order;
drop table proj1_user;

-- drop sequences
drop sequence user_id_maker;
drop sequence order_id_maker;
drop sequence pizza_id_maker;
drop sequence topping_id_maker;

-- create tables
create table proj1_user(
    user_id number(10) primary key,
    username varchar2(200) unique,
    password varchar2(200),
    f_name varchar2(200),
    l_name varchar2(200),
    user_type varchar2(200),
    loyalty_points number(10) default 0
);

create table an_order(
    order_id number(10) primary key,
    user_id number(10),
    cost number(10,2),
    time_ordered number(10),
    status varchar2(200),
    order_type varchar2(200),
    saved number(10)
);

create table pizza(
    pizza_id number(10) primary key,
    pizza_name varchar2(200)
);

create table topping(
    topping_id number(10) primary key,
    topping_name varchar2(200)
);

create table pizza_order(
    pizza_id number(10),
    order_id number(10),
    pizza_size varchar2(200)
);

create table pizza_topping(
    pizza_id number(10),
    topping_id number(10)
);

-- add foreign keys to tables
alter table an_order add constraint fk_order_user foreign key
(user_id) references proj1_user(user_id);

alter table pizza_order add constraint fk_po_order foreign key
(order_id) references an_order(order_id);

alter table pizza_order add constraint fk_po_pizza foreign key
(pizza_id) references pizza(pizza_id);

alter table pizza_topping add constraint fk_pt_pizza foreign key
(pizza_id) references pizza(pizza_id);

alter table pizza_topping add constraint fk_pt_topping foreign key
(topping_id) references topping(topping_id);

-- create sequences
create sequence user_id_maker
    minvalue 0
    start with 0
    increment by 1;
    
create sequence order_id_maker
    minvalue 0
    start with 0
    increment by 1;
    
create sequence pizza_id_maker
    minvalue 0
    start with 0
    increment by 1;
    
create sequence topping_id_maker
    minvalue 0
    start with 0
    increment by 1;

-- create procedures
create or replace procedure add_user(username varchar2, password varchar2, f_name varchar2, l_name varchar2,
    user_type varchar2)
is
begin
insert into proj1_user values(user_id_maker.nextval, username, password, f_name, l_name, user_type, 0);
end;

create or replace procedure add_order(user_id number, cost number, time_ordered number, status varchar2,
    order_type varchar2, saved number)
is
begin
insert into an_order values(order_id_maker.nextval, user_id, cost, time_ordered, status, order_type, saved);
end;

create or replace procedure add_pizza(pizza_name varchar2)
is
begin
insert into pizza values(pizza_id_maker.nextval, pizza_name);
end;

create or replace procedure add_topping(topping_name varchar2)
is
begin
insert into topping values(topping_id_maker.nextval, topping_name);
end;

-- create toppings and standard pizzas
-- create toppings
call add_topping('Pepperoni');
call add_topping('Sausage');
call add_topping('Beef');
call add_topping('Ham');
call add_topping('Bacon');
call add_topping('Spinach');
call add_topping('Onions');
call add_topping('Tomatoes');
call add_topping('Green Peppers');
call add_topping('Mushrooms');

-- create standard pizzas
call add_pizza('Pepperoni');
call add_pizza('Sausage');
call add_pizza('Meat Lovers');
call add_pizza('Vegetarian');
call add_pizza('Supreme');
call add_pizza('Bacon Cheeseburger');
call add_pizza('Bacon Spinach');

-- fill in junction table between toppings and pizzas
insert into pizza_topping values(0, 0); -- Pepperoni
insert into pizza_topping values(1, 1); -- Sausage

insert into pizza_topping values(2, 0); -- Meat Lovers
insert into pizza_topping values(2, 1);
insert into pizza_topping values(2, 2);
insert into pizza_topping values(2, 3);
insert into pizza_topping values(2, 4);

insert into pizza_topping values(3, 5); -- Vegetarian
insert into pizza_topping values(3, 6);
insert into pizza_topping values(3, 7);
insert into pizza_topping values(3, 8);
insert into pizza_topping values(3, 9);

insert into pizza_topping values(4, 0); -- Supreme
insert into pizza_topping values(4, 1);
insert into pizza_topping values(4, 5);
insert into pizza_topping values(4, 6);
insert into pizza_topping values(4, 7);
insert into pizza_topping values(4, 8);
insert into pizza_topping values(4, 9);

insert into pizza_topping values(5, 4); -- Bacon Cheeseburger
insert into pizza_topping values(5, 2);
insert into pizza_topping values(5, 6);

insert into pizza_topping values(6, 4); -- Bacon Spinach
insert into pizza_topping values(6, 5);

commit;

-- test queries
select * from proj1_user;
select * from an_order;
select * from pizza;
select * from topping;
select * from pizza_order;
select * from pizza_topping;

-- select a pizza and all its toppings
select pizza.pizza_id, pizza_name, topping.topping_id, topping.topping_name
from pizza
inner join pizza_topping
on pizza.pizza_id = pizza_topping.pizza_id
inner join topping
on pizza_topping.topping_id = topping.topping_id
where pizza.pizza_id = 5;