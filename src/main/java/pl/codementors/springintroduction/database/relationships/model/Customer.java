package pl.codementors.springintroduction.database.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    private List<Product> products;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products.clear();
        this.products.addAll(products);
    }

    public void addProduct(Product product) {
        product.setCustomer(this);
        products.add(product);
    }
}
