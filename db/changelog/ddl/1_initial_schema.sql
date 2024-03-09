--liquibase formatted sql

--changeset author:a.sulyz failOnError:true labels:TASK-1
create sequence agreement_seq;

create table agreement (
    id     serial CONSTRAINT id PRIMARY KEY,
    status varchar
);

-----

-- rollback drop sequence agreement_seq;
-- rollback drop table agreement;