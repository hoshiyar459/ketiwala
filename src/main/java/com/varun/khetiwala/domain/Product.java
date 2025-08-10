package com.varun.khetiwala.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractPersistableCustom {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String title;
    @Column(length = 2000)
    private String description;

    private BigDecimal pricePerDay;
    private BigDecimal priceSell;

    private Boolean isAvailable = true;
    private String category;
    private String imageUrl;

    private LocalDateTime createdAt = LocalDateTime.now();
}

