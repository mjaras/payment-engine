drop table T_USER if exists;

create table T_USER (
    ID  bigint not null,
    PERSONAL_ID bigint not null,
    FIRST_NAME varchar(50) not null,
    LAST_NAME varchar(50) not null,
    PHONE_NUMBER varchar(30) not null,
    EMAIL_ADDRESS varchar(30) not null,
    PRIMARY KEY (ID, PERSONAL_ID));
