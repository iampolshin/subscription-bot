--liquibase formatted sql
--changeset iampolshin:create_link_table
create table link
(
    id  bigserial primary key,
    url text not null
);