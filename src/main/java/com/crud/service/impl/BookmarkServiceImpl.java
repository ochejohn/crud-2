package com.crud.service.impl;

import com.crud.dtos.BookmarkRequestDTO;
import com.crud.dtos.BookmarkResponseDTO;
import com.crud.entity.Bookmark;
import com.crud.repository.BookmarkRepository;
import com.crud.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public BookmarkResponseDTO createBookmark(BookmarkRequestDTO bookmarkRequest) {
        Bookmark bookmark = new Bookmark();
        bookmark.setTitle(bookmarkRequest.getTitle());
        bookmark.setUrl(bookmarkRequest.getUrl());
        Bookmark savedBookmark = bookmarkRepository.save(bookmark);
        return convertToResponse(savedBookmark);
    }

    @Override
    public List<BookmarkResponseDTO> getAllBookmarks() {
        List<Bookmark> bookmarks = bookmarkRepository.findAll();
        return bookmarks.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookmarkResponseDTO getBookmarkById(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookmark not found"));
        return convertToResponse(bookmark);
    }

    @Override
    public BookmarkResponseDTO updateBookmark(Long id, BookmarkRequestDTO bookmarkRequest) {
        Bookmark bookmark = bookmarkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookmark not found"));
        bookmark.setTitle(bookmarkRequest.getTitle());
        bookmark.setUrl(bookmarkRequest.getUrl());
        Bookmark updatedBookmark = bookmarkRepository.save(bookmark);
        return convertToResponse(updatedBookmark);
    }

    @Override
    public void deleteBookmark(Long id) {
        if (!bookmarkRepository.existsById(id)) {
            throw new RuntimeException("Bookmark not found");
        }
        bookmarkRepository.deleteById(id);
    }

    // Utility method to convert Bookmark entity to DTO
    private BookmarkResponseDTO convertToResponse(Bookmark bookmark) {
        BookmarkResponseDTO dto = new BookmarkResponseDTO();
        dto.setId(bookmark.getId());
        dto.setTitle(bookmark.getTitle());
        dto.setUrl(bookmark.getUrl());
        return dto;
    }
}
