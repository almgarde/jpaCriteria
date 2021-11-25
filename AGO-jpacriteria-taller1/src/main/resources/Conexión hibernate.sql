alter session set "_ORACLE_SCRIPT"=TRUE;

create user hibernate IDENTIFIED by hibernate
default tablespace users
temporary tablespace temp
quota 500K on users;

grant create session to hibernate;
grant create table to hibernate;
grant create sequence to hibernate;