package com.varun.khetiwala.repository;

import com.varun.khetiwala.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    boolean existsByEmail(String email);
    boolean existsByMobileNumber(String phone);
}
