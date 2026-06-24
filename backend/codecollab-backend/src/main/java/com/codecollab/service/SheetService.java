package com.codecollab.service;

import com.codecollab.dto.CreateSheetRequest;
import com.codecollab.dto.AddSheetItemRequest;
import com.codecollab.entity.Sheet;
import com.codecollab.entity.SheetItem;

import java.util.List;

public interface SheetService {

    String createSheet(CreateSheetRequest request);

    List<Sheet> getAllSheets();
    String addItem(AddSheetItemRequest request);

    List<SheetItem> getItemsBySheet(Long sheetId);
}