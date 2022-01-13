package pl.codementors.springintroduction.database;

import java.util.List;

public interface CodementorsSimpleEntityRepository {
    List<SimpleEntity> findAll();

    List<SimpleEntity> findAllByName(String name);

    SimpleEntity save(SimpleEntity simpleEntity);
}
