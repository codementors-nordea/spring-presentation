package pl.codementors.springintroduction.database;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Primary
@RequiredArgsConstructor
public class JdbcTemplateRepository implements CodementorsSimpleEntityRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<SimpleEntity> findAll() {
        return jdbcTemplate.query(
                "select id, full_name, age from simple_entity",
                this::mapSimpleEntity
        );
    }

    @Override
    public List<SimpleEntity> findAllByName(String name) {
        return jdbcTemplate.query(
                "select id, full_name, age from simple_entity where full_name = ?",
                this::mapSimpleEntity,
                name
        );
    }

    @Override
    public SimpleEntity save(SimpleEntity simpleEntity) {
        jdbcTemplate.update(
                "insert into simple_entity(id, full_name, age) values (?, ?, ?)",
                simpleEntity.getId(),
                simpleEntity.getName(),
                simpleEntity.getAge()
        );

        return simpleEntity;
    }

    private SimpleEntity mapSimpleEntity(ResultSet resultSet, int rowNum) throws SQLException {
        var simpleEntity = new SimpleEntity();
        simpleEntity.setId(resultSet.getLong("id"));
        simpleEntity.setAge(resultSet.getInt("age"));
        simpleEntity.setName(resultSet.getString("full_name"));

        return simpleEntity;
    }
}
