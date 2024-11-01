package com.crud.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkResponseDTO {

    private Long id;
    private String title;
    private String url;
}
