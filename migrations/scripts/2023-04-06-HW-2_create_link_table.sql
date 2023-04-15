--liquibase formatted sql
--changeset iampolshin:create_link_table
create table if not exists link
(
    id              bigserial primary key,
    url             text not null,
    updated_at      timestamptz,
    checked_at timestamptz not null default now()
);