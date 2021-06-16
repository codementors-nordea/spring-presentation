package pl.infoshare.springintroduction.database;

import java.util.List;

public interface InfoshareSimpleEntityRepository {
    List<SimpleEntity> findAll();

    List<SimpleEntity> findAllByName(String name);

    SimpleEntity save(SimpleEntity simpleEntity);
}
