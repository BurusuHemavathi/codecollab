package com.codecollab.repository;

import com.codecollab.entity.SheetItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SheetItemRepository
        extends JpaRepository<SheetItem, Long> {

    List<SheetItem> findBySheetId(Long sheetId);
}