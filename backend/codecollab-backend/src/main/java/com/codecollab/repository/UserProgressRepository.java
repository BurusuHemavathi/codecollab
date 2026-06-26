package com.codecollab.repository;

import com.codecollab.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProgressRepository
        extends JpaRepository<UserProgress, Long> {

    Optional<UserProgress> findByUserEmailAndItemId(
            String userEmail,
            Long itemId
    );

    List<UserProgress> findByUserEmail(
            String userEmail
    );
}