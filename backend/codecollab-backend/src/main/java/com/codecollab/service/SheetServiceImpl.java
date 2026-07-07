package com.codecollab.service;

import com.codecollab.dto.CreateSheetRequest;
import com.codecollab.dto.AddSheetItemRequest;
import com.codecollab.entity.Sheet;
import com.codecollab.entity.SheetItem;
import com.codecollab.repository.SheetRepository;
import com.codecollab.repository.SheetItemRepository;
import com.codecollab.dto.ProgressRequest;
import com.codecollab.entity.UserProgress;
import com.codecollab.repository.UserProgressRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SheetServiceImpl implements SheetService {

    @Autowired
    private UserProgressRepository userProgressRepository;

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

    @Override
    public String markComplete(ProgressRequest request) {

        Optional<UserProgress> existing =
                userProgressRepository
                        .findByUserEmailAndItemId(
                                request.getUserEmail(),
                                request.getItemId()
                        );

        UserProgress progress;

        if (existing.isPresent()) {

            progress = existing.get();

        } else {

            progress = new UserProgress();

            progress.setUserEmail(
                    request.getUserEmail());

            progress.setItemId(
                    request.getItemId());
        }

        progress.setCompleted(true);

        userProgressRepository.save(progress);

        return "Item Marked Complete";
    }

    @Override
    public String bookmarkItem(ProgressRequest request) {

        Optional<UserProgress> existing =
                userProgressRepository
                        .findByUserEmailAndItemId(
                                request.getUserEmail(),
                                request.getItemId()
                        );

        UserProgress progress;

        if (existing.isPresent()) {

            progress = existing.get();

        } else {

            progress = new UserProgress();

            progress.setUserEmail(
                    request.getUserEmail());

            progress.setItemId(
                    request.getItemId());
        }

        progress.setBookmarked(true);

        userProgressRepository.save(progress);

        return "Item Bookmarked";
    }

    @Override
    public List<UserProgress> getUserProgress(
            String userEmail) {

        return userProgressRepository
                .findByUserEmail(userEmail);
    }


    @Override
    public List<SheetItem> searchItems(
            String keyword) {

        return sheetItemRepository
                .findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public String deleteSheet(
            Long sheetId) {

        sheetRepository.deleteById(sheetId);

        return "Sheet Deleted Successfully";
    }

    @Override
    public String deleteItem(
            Long itemId) {

        sheetItemRepository
                .deleteById(itemId);

        return "Item Deleted Successfully";
    }
}