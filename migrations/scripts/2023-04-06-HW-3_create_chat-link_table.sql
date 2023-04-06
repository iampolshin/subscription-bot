--liquibase formatted sql
--changeset iampolshin:create_chat-link_table
CREATE TABLE chat_link
(
    chat_id bigint,
    link_id bigint,
    primary key (chat_id, link_id),
    constraint fk_chat foreign key (chat_id) references chat (id),
    constraint fk_link foreign key (link_id) references link (id)
);