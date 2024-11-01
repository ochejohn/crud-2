package com.crud.service;


import com.crud.dtos.BookmarkRequestDTO;
import com.crud.dtos.BookmarkResponseDTO;
import java.util.List;

public interface BookmarkService {

    BookmarkResponseDTO createBookmark(BookmarkRequestDTO bookmarkRequest);

    List<BookmarkResponseDTO> getAllBookmarks();

    BookmarkResponseDTO getBookmarkById(Long id);

    BookmarkResponseDTO updateBookmark(Long id, BookmarkRequestDTO bookmarkRequest);

    void deleteBookmark(Long id);



}
