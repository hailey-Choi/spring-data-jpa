package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Use Lombok library annotations to replace the boilerplate code for getter, setter, constructors, ..
// More features: https://projectlombok.org/features/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
// class level annotation (not field)
@Entity
@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {
    @Id
    // GenerationType.AUTO: default, lets the persistence provider (eg. Hibernate) to choose
    // Hibernate chooses based on DB specific dialect, most DB selects GenerationType.SEQUENCE

    // GenerationType.IDENTITY: Auto-incremented DB column on each insertion
    // Highly optimized operation, efficient in DB point of view
    // Not good for JDBC batch operations

    // GenerationType.TABLE: Rarely used nowadays, prefer using SEQUENCE

    // GenerationType.SEQUENCE: Use SELECT statement to get the next value form a DB sequence
    // Good for huge application, mostly no performance impact
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    // Use Lombok library to replace the boilerplate code for getter, setter, constructors, ..
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSku() {
//        return sku;
//    }
//
//    public void setSku(String sku) {
//        this.sku = sku;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public LocalDateTime getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDateTime dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public LocalDateTime getLastUpdated() {
//        return lastUpdated;
//    }
//
//    public void setLastUpdated(LocalDateTime lastUpdated) {
//        this.lastUpdated = lastUpdated;
//    }
}
