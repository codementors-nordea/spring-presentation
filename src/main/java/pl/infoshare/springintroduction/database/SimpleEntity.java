package pl.infoshare.springintroduction.database;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.event.spi.AutoFlushEventListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQuery(name = "fetchEntitiesByName", query = "select e from SimpleEntity e where e.name = :name")
@EntityListeners(AuditingEntityListener.class)
public class SimpleEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;

    @Version
    private Long version;

    @CreatedDate
    private LocalDate createDate;
    @LastModifiedDate
    private LocalDate modificationDate;
//    @CreatedBy
//    private User createdBy;


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
