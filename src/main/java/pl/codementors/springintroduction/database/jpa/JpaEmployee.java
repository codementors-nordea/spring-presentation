package pl.codementors.springintroduction.database.jpa;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class JpaEmployee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "full_name", columnDefinition = "text")
    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private JpaContractType contractType;

    @AttributeOverride(name = "street", column = @Column(name = "address_street"))
    private JpaEmbeddableAddress address;

    @Transient
    private UUID toBeIgnored = UUID.randomUUID();

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
        return age  + 20;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public JpaEmbeddableAddress getAddress() {
        return address;
    }

    public void setAddress(JpaEmbeddableAddress address) {
        this.address = address;
    }

    public JpaContractType getContractType() {
        return contractType;
    }

    public void setContractType(JpaContractType contractType) {
        this.contractType = contractType;
    }

    public UUID getToBeIgnored() {
        return toBeIgnored;
    }

    public void setToBeIgnored(UUID toBeIgnored) {
        this.toBeIgnored = toBeIgnored;
    }
}
