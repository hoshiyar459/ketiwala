package com.varun.khetiwala.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "m_users")
@Data
@NoArgsConstructor
public class User extends AbstractPersistableCustom{

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, length = 100)
    private String email;

    @Column(unique = true, length = 15)
    private String phone;

    @Column(length = 255)
    private String password;

    @Column(name = "profile_pic", length = 255)
    private String profilePic;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "role" ,  nullable = false)
    private Integer role ;
}

