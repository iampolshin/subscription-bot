package ru.tinkoff.edu.java.scrapper.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.java.scrapper.dto.entity.Chat;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcChatRepository {
    private static final String SAVE_SQL = """
            insert into chat (id)
            values (?)
            """;
    private static final String REMOVE_BY_ID_SQL = """
            delete from chat
            where id = ?
            """;
    private static final String FIND_ALL_SQL = """
            select id
            from chat
            """;
    private static final RowMapper<Chat> ROW_MAPPER = new DataClassRowMapper<>(Chat.class);


    private final JdbcTemplate template;

    public void save(Chat chat) {
        template.update(SAVE_SQL, chat.getId());
    }

    public int removeById(long id) {
        return template.update(REMOVE_BY_ID_SQL, id);
    }

    public List<Chat> findAll() {
        return template.query(FIND_ALL_SQL, ROW_MAPPER);
    }
}
