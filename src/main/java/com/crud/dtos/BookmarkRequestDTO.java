package com.crud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkRequestDTO {

    @Size(max = 200)
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Size(max = 500)
    @NotBlank(message = "URL cannot be empty")
    private String url;
}
