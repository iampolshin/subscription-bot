--liquibase formatted sql
--changeset iampolshin:create_chat_table
create table chat
(
    id bigint primary key
)