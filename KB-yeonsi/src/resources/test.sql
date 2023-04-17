-------------user-----------
create table users(
    user_name VARCHAR(10) primary key,
    dateNum number default 1,
    fagibility number default 0
);

select * from users;

drop table users;

insert into users values('testUser1', 1, 0);
-------like--------
create table likeability(
    user_name varchar(10) primary key references users(user_name),
    wooyeop number default 0,
    sangwoo number default 0,
    sunyeong number default 0,
    minji number default 0,
    chaelim number default 0
);

select * from likeability;

drop table likeability;

insert into likeability(user_name) values('testUser1');

------- gift & food- ----------
create table gift(
    gift_code number primary key,
    gift_name varchar(30),
    wooyeop number default 0,
    sangwoo number default 0,
    sunyeong number default 0,
    minji number default 0,
    chaelim number default 0
);
create table food(
    food_code number primary key,
    fodd_name varchar(30),
    like_character varchar(10),
    like_point number default 0,
    hate_character varchar(10),
    hate_point number default 0
);

select * from gift;
select * from food;

drop table gift;
drop table food;

create sequence gift_seq;
create sequence food_seq;

drop sequence agift_seq;
drop sequence food_seq;

insert into gift values (gift_seq.nextval, '편지', 10, 10, 20, 15, 5);
insert into food values (food_seq.nextval, '치킨', 'sangwoo', 10, 'minji', -10);

----------event---------------
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
    sel_name VARCHAR(100),
    character_name VARCHAR(10),
    like_point number,
    result_script VARCHAR(300)
);
create table talk_option(
    option_id number constraint talk_op_pk primary key,
    event_id number CONSTRAINT talk_op_fk REFERENCES talk_event(event_id),
    sel_name VARCHAR(100),
    character_name VARCHAR(10),
    like_point number,
    result_script VARCHAR(300)
);

select * from academy_event;
select * from talk_event;
select * from talk_option;
select * from academy_option;

drop table academy_event;
drop table talk_event;
drop table talk_option;
drop table academy_option;

create sequence aca_ev_seq;
create sequence aca_op_seq;

create sequence talk_ev_seq;
create sequence talk_op_seq;

drop sequence aca_ev_seq;
drop sequence aca_op_seq;
drop sequence talk_ev_seq;
drop sequence talk_op_seq;

insert into academy_event values(aca_ev_seq.nextval, '안녕하세요');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지1', '민지', 5, '대답입니다111');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지2', '우엽', 7, '대답입니다222');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지3', '상우', 8, '대답입니다331');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지4', '선영', 3, '대답입니다1441');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지5', '채림', 1, '대답입니다1551');

insert into academy_event values(aca_ev_seq.nextval, '안녕하세요안녕ㅇㄹㅇㄹ하세요안녕하세요안녕하세요');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지11', '민지', 10, '대답입니다1561');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지22', 'ㅇ우벼', 8, '대답입니다7711');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지33', '민지', 5, '대답입니다551');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지44', '상우', 5, '대답입니다1111');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '선택지55', '선영', 5, '대답입니다1001');

insert into academy_event values(aca_ev_seq.nextval, '안녕하세요안녕하세12223344요ㅇㄴㄹㄴ안녕하세요안녕하세요안녕하세요');
insert into academy_event values(aca_ev_seq.nextval, '안녕하세요안녕하세1111요안녕하세요안녕하세요안녕하세요안녕하세요');



insert into talk_event values (talk_ev_seq.nextval, '안녕하세요안녕하세1111요안녕하세요안녕하세요안녕하세요안녕하세요');
insert into talk_option values (talk_op_seq.nextval, talk_ev_seq.currval, '선택지55', '선영', 5, '대답입니다1001');

commit;
