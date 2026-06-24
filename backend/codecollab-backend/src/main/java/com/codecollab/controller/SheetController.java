package com.codecollab.controller;

import com.codecollab.dto.CreateSheetRequest;
import com.codecollab.entity.Sheet;
import com.codecollab.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codecollab.dto.AddSheetItemRequest;
import com.codecollab.entity.SheetItem;

import java.util.List;

@RestController
@RequestMapping("/api/sheets")
public class SheetController {

    @Autowired
    private SheetService sheetService;

    @PostMapping("/create")
    public String createSheet(
            @RequestBody CreateSheetRequest request) {

        return sheetService.createSheet(request);
    }

    @GetMapping
    public List<Sheet> getAllSheets() {

        return sheetService.getAllSheets();
    }

    @PostMapping("/item")
    public String addItem(
            @RequestBody AddSheetItemRequest request) {

        return sheetService.addItem(request);
    }

    @GetMapping("/{sheetId}/items")
    public List<SheetItem> getItems(
            @PathVariable Long sheetId) {

        return sheetService.getItemsBySheet(sheetId);
    }
}