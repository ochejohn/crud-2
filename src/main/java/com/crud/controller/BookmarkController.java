package com.crud.controller;

import com.crud.dtos.BookmarkRequestDTO;
import com.crud.dtos.BookmarkResponseDTO;
import com.crud.service.BookmarkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@Validated // This ensures that validation annotations are processed for method parameters
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping
    public ResponseEntity<BookmarkResponseDTO> createBookmark(@Valid @RequestBody BookmarkRequestDTO bookmarkRequest) {
        BookmarkResponseDTO response = bookmarkService.createBookmark(bookmarkRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BookmarkResponseDTO>> getAllBookmarks() {
        List<BookmarkResponseDTO> response = bookmarkService.getAllBookmarks();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookmarkResponseDTO> getBookmarkById(@PathVariable Long id) {
        BookmarkResponseDTO response = bookmarkService.getBookmarkById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookmarkResponseDTO> updateBookmark(@PathVariable Long id, @Valid @RequestBody BookmarkRequestDTO bookmarkRequest) {
        BookmarkResponseDTO updatedResponse = bookmarkService.updateBookmark(id, bookmarkRequest);
        return ResponseEntity.ok(updatedResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) {
        bookmarkService.deleteBookmark(id);
        return ResponseEntity.noContent().build();
    }
}
