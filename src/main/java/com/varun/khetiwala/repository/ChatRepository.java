package com.varun.khetiwala.repository;

import com.varun.khetiwala.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}

