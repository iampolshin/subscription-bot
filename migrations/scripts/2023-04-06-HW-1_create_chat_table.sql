--liquibase formatted sql
--changeset iampolshin:create_chat_table
create table if not exists chat
(
    id bigint primary key
)