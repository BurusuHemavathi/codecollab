package com.codecollab.service;

import com.codecollab.dto.CreateSheetRequest;
import com.codecollab.dto.AddSheetItemRequest;
import com.codecollab.entity.Sheet;
import com.codecollab.entity.SheetItem;
import com.codecollab.repository.SheetRepository;
import com.codecollab.repository.SheetItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SheetServiceImpl implements SheetService {

    @Autowired
    private SheetRepository sheetRepository;

    @Autowired
    private SheetItemRepository sheetItemRepository;

    @Override
    public String createSheet(CreateSheetRequest request) {

        Sheet sheet = new Sheet();

        sheet.setSheetName(request.getSheetName());
        sheet.setCreatedBy(request.getCreatedBy());

        sheetRepository.save(sheet);

        return "Sheet Created Successfully";
    }

    @Override
    public List<Sheet> getAllSheets() {

        return sheetRepository.findAll();
    }

    @Override
    public String addItem(AddSheetItemRequest request) {

        SheetItem item = new SheetItem();

        item.setSheetId(request.getSheetId());
        item.setTitle(request.getTitle());
        item.setLink(request.getLink());
        item.setDifficulty(request.getDifficulty());

        sheetItemRepository.save(item);

        return "Item Added Successfully";
    }

    @Override
    public List<SheetItem> getItemsBySheet(Long sheetId) {

        return sheetItemRepository.findBySheetId(sheetId);
    }
}