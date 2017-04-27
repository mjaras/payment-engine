drop table T_PAYMENT if exists;

create table T_PAYMENT (
    ID bigint not null,
    FROM_ACCOUNT varchar(50) not null,
    TO_ACCOUNT varchar(50) not null,
    AMOUNT DECIMAL(5,2) not null,
    PAYMENT_DATE DATETIME not null,
    PRIMARY KEY (ID));