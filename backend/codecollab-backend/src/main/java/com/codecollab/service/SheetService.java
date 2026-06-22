package com.codecollab.service;

import com.codecollab.dto.CreateSheetRequest;
import com.codecollab.entity.Sheet;

import java.util.List;

public interface SheetService {

    String createSheet(CreateSheetRequest request);

    List<Sheet> getAllSheets();
}