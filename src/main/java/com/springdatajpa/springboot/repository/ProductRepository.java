package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// No need for @Repository annotation as SimpleJpaRepository class already has it
// No need for implementation of methods since SimpleJpaRepository already implements JpaRepository interface
public class ProductRepository extends JpaRepository<Product, Long> {
}
