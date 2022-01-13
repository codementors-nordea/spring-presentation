package pl.codementors.springintroduction.database;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaSimpleEntityRepository implements CodementorsSimpleEntityRepository {

    private final EntityManager entityManager;

    @Override
    public List<SimpleEntity> findAll() {
        return entityManager.createQuery("select e from SimpleEntity e", SimpleEntity.class)
                .getResultList();
    }

    @Override
    public List<SimpleEntity> findAllByName(String name) {
        return entityManager.createNamedQuery("fetchEntitiesByName", SimpleEntity.class)
                .setParameter("name", name)
                .getResultList();
    }

    public SimpleEntity saveAndValidate(SimpleEntity simpleEntity) {
        return save(simpleEntity);
    }

    @Override
    @Transactional
    public SimpleEntity save(SimpleEntity simpleEntity) {
        entityManager.persist(simpleEntity);
        return simpleEntity;
    }
}
