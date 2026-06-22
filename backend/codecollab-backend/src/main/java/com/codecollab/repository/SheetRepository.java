package com.codecollab.repository;

import com.codecollab.entity.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetRepository
        extends JpaRepository<Sheet, Long> {
}