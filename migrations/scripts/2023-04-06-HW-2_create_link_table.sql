--liquibase formatted sql
--changeset iampolshin:create_link_table
CREATE TABLE link
(
    id  bigserial primary key,
    url text not null
);