package com.codecollab.controller;

import com.codecollab.dto.CreateSheetRequest;
import com.codecollab.entity.Sheet;
import com.codecollab.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codecollab.dto.AddSheetItemRequest;
import com.codecollab.entity.SheetItem;
import com.codecollab.dto.ProgressRequest;
import com.codecollab.entity.UserProgress;

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

    @PostMapping("/complete")
    public String markComplete(
            @RequestBody ProgressRequest request) {

        return sheetService
                .markComplete(request);
    }

    @PostMapping("/bookmark")
    public String bookmarkItem(
            @RequestBody ProgressRequest request) {

        return sheetService
                .bookmarkItem(request);
    }

    @GetMapping("/progress/{email}")
    public List<UserProgress> getProgress(
            @PathVariable String email) {

        return sheetService
                .getUserProgress(email);
    }

    @GetMapping("/search")
    public List<SheetItem> searchItems(
            @RequestParam String keyword) {

        return sheetService.searchItems(keyword);
    }
}