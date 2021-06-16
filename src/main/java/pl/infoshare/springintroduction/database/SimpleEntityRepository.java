package pl.infoshare.springintroduction.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long>, JpaSpecificationExecutor<SimpleEntity> {

    @Query("select e from SimpleEntity e where e.age > :age")
    List<SimpleEntity> findAllAdults(int age);

    List<SimpleEntityOverview> findAllByName(String name);

    List<SimpleEntityOverview> findAllProjectedBy();



//    Page<SimpleEntity> findAllByName(String name, Pageable pageable);

}
