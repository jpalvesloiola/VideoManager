package com.example.videomanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record VideoDto(
        Long id,

        @NotBlank(message = "title must not be blank")
        @Size(max = 255)
        String title,

        @Size(max = 1000)
        String description,

        @NotBlank(message = "url must not be blank")
        @Size(max = 2000)
    @Pattern(regexp = "^(http|https)://[^ \"]+$", message = "url must be a valid URL")
        String url
) {
}
