package pl.codementors.springintroduction.database;

import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RawJdbcRepository implements CodementorsSimpleEntityRepository {

    private DataSource dataSource;

    @PostConstruct
    void init() {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("admin");

        this.dataSource = new HikariDataSource(hikariConfig);
    }


    @Override
    public List<SimpleEntity> findAll() {
        try (var connection = dataSource.getConnection();
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("select id, full_name, age from simple_entity")) {

            var result = new ArrayList<SimpleEntity>();
            while(resultSet.next()) {
                var simpleEntity = new SimpleEntity();
                simpleEntity.setId(resultSet.getLong("id"));
                simpleEntity.setAge(resultSet.getInt("age"));
                simpleEntity.setName(resultSet.getString("full_name"));

                result.add(simpleEntity);
            }

            return result;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public List<SimpleEntity> findAllByName(String name) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("select id, full_name, age from simple_entity where full_name = ?")
        ) {
            statement.setString(1, name);

            try (var resultSet = statement.executeQuery()) {

                var result = new ArrayList<SimpleEntity>();
                while (resultSet.next()) {
                    var simpleEntity = new SimpleEntity();
                    simpleEntity.setId(resultSet.getLong("id"));
                    simpleEntity.setAge(resultSet.getInt("age"));
                    simpleEntity.setName(resultSet.getString("full_name"));

                    result.add(simpleEntity);
                }

                return result;
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public SimpleEntity save(SimpleEntity simpleEntity) {
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("insert into simple_entity(id, full_name, age) values (?, ?, ?)")
        ) {
            statement.setLong(1, simpleEntity.getId());
            statement.setString(2, simpleEntity.getName());
            statement.setInt(3, simpleEntity.getAge());

            statement.execute();

            return simpleEntity;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
