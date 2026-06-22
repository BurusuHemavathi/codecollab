package com.codecollab.service;

import com.codecollab.dto.CreateSheetRequest;
import com.codecollab.entity.Sheet;
import com.codecollab.repository.SheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SheetServiceImpl
        implements SheetService {

    @Autowired
    private SheetRepository sheetRepository;

    @Override
    public String createSheet(
            CreateSheetRequest request) {

        Sheet sheet = new Sheet();

        sheet.setSheetName(
                request.getSheetName());

        sheet.setCreatedBy(
                request.getCreatedBy());

        sheetRepository.save(sheet);

        return "Sheet Created Successfully";
    }

    @Override
    public List<Sheet> getAllSheets() {

        return sheetRepository.findAll();
    }
}