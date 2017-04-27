drop table T_ACCOUNT if exists;

create table T_ACCOUNT (
    ID bigint not null,
    USER_ID bigint not null,
    NUMBER varchar(50) not null,
    BALANCE DECIMAL(5,2) not null,
    PRIMARY KEY (ID, NUMBER));