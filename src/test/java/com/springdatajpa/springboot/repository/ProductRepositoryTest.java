package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// To load all the full application context (spring beans) from the spring boot application to be tested
// This is not a test, just to run the code for learning purposes
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create a product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("This is product 1");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");
        product.setSku("100ABC");

        // save the product to DB
        Product savedObject= productRepository.save(product);

        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateBySaveMethod() {
        // Retrieve product by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update the entity info
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        // save the updated entity
        productRepository.save(product);
    }

    @Test
    void saveAllMethod() {
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("This is product 2");
        product.setActive(true);
        product.setPrice(new BigDecimal(1000));
        product.setImageUrl("product2.png");
        product.setSku("1000ABC");

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("This is product 3");
        product3.setActive(false);
        product3.setPrice(new BigDecimal(150));
        product3.setImageUrl("product3.png");
        product3.setSku("140ABC");

        productRepository.saveAll(List.of(product, product3));
    }

    @Test
    void finAllMethod() {
        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        // deleteAll() : 2 overloaded methods

        // productRepository.deleteAll();

        Product product1 = productRepository.findById(1L).get();
        Product product2 = productRepository.findById(2L).get();
        productRepository.deleteAll(List.of(product1, product2));
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod() {
        Long id = 3L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}