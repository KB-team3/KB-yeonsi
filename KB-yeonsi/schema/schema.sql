-- Create Tables
create table users (
    user_name varchar2(20) primary key,
    game_date Number default 1
);

create table Likeability (
    user_name varchar2(20) primary key,
    wooyeop Number default 0,
    sangwoo Number default 0,
    sunyeong Number default 0,
    minji Number default 0,
    chaelim Number default 0,
    constraint user_fk foreign key (user_name) references users(user_name) on delete cascade
);

create table food (
    food_code Number,
    food_name varchar2(20),
    wooyeop Number,
    sangwoo Number,
    sunyeong Number,
    minji Number,
    chaelim Number
);

create table gift (
    gift_code Number,
    gift_name varchar2(20),
    wooyeop Number,
    sangwoo Number,
    sunyeong Number,
    minji Number,
    chaelim Number
);

create table academy_event(
    event_id number constraint aca_ev_pk primary key,
    script VARCHAR2(1000)
);

create table talk_event(
    event_id number constraint talk_ev_pk primary key,
    script VARCHAR2(1000)
);
create table academy_option(
    option_id number constraint op_pk primary key,
    event_id number CONSTRAINT op_fk REFERENCES academy_event(event_id),
    sel_name VARCHAR(300),
    character_name VARCHAR(10),
    like_point number,
    result_script VARCHAR(500)
);
create table talk_option(
    option_id number constraint talk_op_pk primary key,
    event_id number CONSTRAINT talk_op_fk REFERENCES talk_event(event_id),
    sel_name VARCHAR(300),
    character_name VARCHAR(10),
    like_point number,
    result_script VARCHAR(500)
);

-- Create Sequences
create sequence aca_ev_seq;
create sequence aca_op_seq;
create sequence talk_ev_seq;
create sequence talk_op_seq;

delete from likeability where user_name ='dd';
delete from users where user_name ='dd';

commit;

-- test user
insert into users values ('test', 1, 0);

-- test likeability
insert into likeability values ('test', 0, 0, 0, 0, 0);

-- gift insert
insert into gift values (1, 'perfume', -10, 20, -15, 30, -15);
insert into gift values (2, 'tv', 0, 10, 20, 10, -5);
insert into gift values (3, 'shoes',-20, -5, 0, -20, -10);
insert into gift values (4, 'cake', 30, -25, -15, -20, 30);

-- food
insert into food values (1, 'dbe', 15, -25, -15, -10, 20);
insert into food values (2, 'pizza', 25, 40, 0, 25, -15);
insert into food values (3, 'curry', -40, 0, -20, 15, 20);
insert into food values (4, 'chicken', 0, -15, 35, 20, -25);

select * from users;
select * from likeability;
select * from gift;
select * from food;

select * from academy_event;
select * from talk_event;
select * from academy_option;
select * from talk_option;


commit;