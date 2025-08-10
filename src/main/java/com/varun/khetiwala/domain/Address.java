package com.varun.khetiwala.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "m_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractPersistableCustom {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String name;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String postalCode;

}

