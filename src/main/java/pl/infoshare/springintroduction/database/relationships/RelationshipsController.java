package pl.infoshare.springintroduction.database.relationships;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.springintroduction.database.relationships.model.*;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class RelationshipsController {

    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
        var customer = new Customer();
        customer.setName("owner");
        var savedCustomer = customerRepository.save(customer);

        var product = new Product();
        product.setName("Many to Many");
        product.setCustomer(savedCustomer);

        var product2 = new Product();
        product2.setName("Many to Many 2");
        product2.setCustomer(savedCustomer);

        var product3 = new Product();
        product3.setName("Many to Many 3");
        product3.setCustomer(savedCustomer);

        var savedProducts = productRepository.saveAll(List.of(product, product2, product3));

        var basket = new Basket();
        basket.setProducts(Set.of(savedProducts.get(0), savedProducts.get(1)));
        basketRepository.save(basket);
    }


    @GetMapping("/spring/single/{id}/get")
    public Address getOneToOne(@PathVariable Long id) {
        var customer = customerRepository.findById(id).get();
        return customer.getAddress();
    }

    @GetMapping("/spring/single-address/{id}/get")
    public Customer getOneToOneAddress(@PathVariable Long id) {
        var address = addressRepository.findById(id).get();
        return address.getCustomer();
    }

    @GetMapping("/spring/single/{id}/create")
    @Transactional
    public void addAddress(@PathVariable Long id,
                           @RequestBody Address address) {
        var savedAddress = addressRepository.save(address);
        var customer = customerRepository.findById(id).get();
        customer.setAddress(savedAddress);
//        savedAddress.setCustomer(customer);
        customer.setAddress(null);


    }

    @GetMapping("/spring/single/{id}/update")
    public void updateAddress(@PathVariable Long id,
                              @RequestBody Address address) {
    }

    @GetMapping("/spring/single/{id}/remove")
    public void removeOneToOne(@PathVariable Long id) {
    }

    // get single child
    @GetMapping("/spring/children/{id}")
    public Product getChild(@PathVariable Long id) {
        return null;
    }

    // get all children from owner, unidirectional
    @GetMapping("/spring/owners/{id}/children")
    @Transactional
    public List<Product> getChildren(@PathVariable Long id) {
        var customer = customerRepository.findById(id).get();
        var product = customer.getProducts().get(0);

        return Collections.emptyList();
    }

    @GetMapping("/spring/owners/{id}/bi-children")
    @Transactional
    public List<Product> getBiChildren(@PathVariable Long id) {
        return Collections.emptyList();
    }

    // Add new child
    @GetMapping("/spring/owners/{id}/add-child")
    @Transactional
    public List<Product> createChild(@PathVariable Long id,
                                     @RequestBody Product product) {
        var customer = customerRepository.findById(id).get();
//        product.setCustomer(customer);
//        productRepository.save(product);

        customer.addProduct(product);
        customer.getProducts().get(0).setName("Updated name");


        return Collections.emptyList();
    }

    // delete few children
    @Transactional
    @GetMapping("/spring/owners/{id}/delete-orphan")
    public void deleteOrphan(@PathVariable Long id,
                             @PathVariable Long productId) {
        var customer = customerRepository.findById(id).get();
        customer.getProducts().remove(0);
        customer.getProducts().removeIf(product -> product.getId().equals(productId));

    }

    // Add new child and update
    @GetMapping("/spring/owners/{id}/add-and-update-child")
    @Transactional
    public List<Product> createAndUpdateChild(@PathVariable Long id) {
        return Collections.emptyList();
    }

    // delete few children
    @GetMapping("/spring/owners/{id}/delete-owner")
    public void deleteChild(@PathVariable Long id) {
    }

    @Transactional
    @GetMapping("/spring/baskets/{id}/add-product/{productId}")
    public void addProductToBasket(@PathVariable Long id,
                                   @PathVariable Long productId) {
        var basket = basketRepository.findById(id).get();
        var product = productRepository.findById(productId).get();

        basket.getProducts().add(product);
    }
}
