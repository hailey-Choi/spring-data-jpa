package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        // get() method to get the value from the Optional
        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("product 2", "This is product 2");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("product 2", "This is product 2");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(1000));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("%product%");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(50), new BigDecimal(200));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod() {
        LocalDateTime startDate = LocalDateTime.of(2023,06,14,16,41,43);
        LocalDateTime endDate = LocalDateTime.of(2023,07,14,16,41,43);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findByNameInMethod() {
        List<Product> products = productRepository.findByNameIn(List.of("product 2", "product 3"));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findTop2ByOrderByPriceDescMethod() {
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }
}
