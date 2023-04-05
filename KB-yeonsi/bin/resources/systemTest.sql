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

insert into academy_event values(aca_ev_seq.nextval, '�ȳ��ϼ���');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������1', '����', 5, '����Դϴ�111');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������2', '�쿱', 7, '����Դϴ�222');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������3', '���', 8, '����Դϴ�331');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������4', '����', 3, '����Դϴ�1441');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������5', 'ä��', 1, '����Դϴ�1551');

insert into academy_event values(aca_ev_seq.nextval, '�ȳ��ϼ���ȳ礷�������ϼ���ȳ��ϼ���ȳ��ϼ���');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������11', '����', 10, '����Դϴ�1561');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������22', '���캭', 8, '����Դϴ�7711');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������33', '����', 5, '����Դϴ�551');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������44', '���', 5, '����Դϴ�1111');
insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, '������55', '����', 5, '����Դϴ�1001');

insert into academy_event values(aca_ev_seq.nextval, '�ȳ��ϼ���ȳ��ϼ�12223344�䤷�������ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���');
insert into academy_event values(aca_ev_seq.nextval, '�ȳ��ϼ���ȳ��ϼ�1111��ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���');



insert into talk_event values (talk_ev_seq.nextval, '�ȳ��ϼ���ȳ��ϼ�1111��ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���ȳ��ϼ���');
insert into talk_option values (talk_op_seq.nextval, talk_ev_seq.currval, '������55', '����', 5, '����Դϴ�1001');

commit;