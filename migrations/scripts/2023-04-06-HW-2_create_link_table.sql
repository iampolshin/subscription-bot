--liquibase formatted sql
--changeset iampolshin:create_link_table
create table if not exists link
(
    id         bigserial primary key,
    url        text unique               not null,
    updated_at timestamptz default now() not null
);