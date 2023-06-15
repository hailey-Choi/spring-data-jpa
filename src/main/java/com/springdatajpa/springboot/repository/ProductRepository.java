package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// No need for @Repository annotation as SimpleJpaRepository class already has it
// No need for implementation of methods since SimpleJpaRepository already implements JpaRepository interface
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Returns the found product entry by using its name as search criteria.
     * If no product entry is found, this method returns null.
     */
    Product findByName(String name);

    /**
     * Returns an Optional which contains the found product entry by using its id as search criteria.
     * If no product entry is found, this method returns an empty Optional.
     */
    Optional<Product> findById(Long id);

    /**
     * Returns the found list of product entries whose name or description is given as method parameter.
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByNameOrDescription(String name, String description);

    /**
     * Returns the found list of product entries whose name and description are given as method parameter.
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Returns the found distinct product entry by using its name as search criteria.
     * If no product entry is found, this method returns null.
     */
    Product findDistinctByName(String name);

    /**
     * Returns the found list of product entries whose price is greater than the given price as method parameter.
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Returns the found list of product entries whose price is less than the given price as method parameter.
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Returns the filtered list of product entries that match the given text.
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByNameContaining(String name);

    /**
     * Return the filtered list of product entire based on SQL like condition
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByNameLike(String name);

    /**
     * Returns the list of product entries whose price is between startPrice and endPrice
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     * Returns the list of product entries whose date created is between startDate and endDate
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Returns the list of product entries whose name is in the list names
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findByNameIn(List<String> names);

    /**
     * Returns the list of the first 2 product entries whose names are in ascending order.
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findFirst2ByOrderByNameAsc();


    /**
     * Returns the list of the first 2 product entries whose prices are in descending order.
     * If no product entry is found, this method returns an empty list.
     */
    List<Product> findTop2ByOrderByPriceDesc();

}
