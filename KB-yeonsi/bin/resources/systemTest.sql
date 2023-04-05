-- create
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