package com.example.videomanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record VideoDto(
        Long id,

        @NotBlank(message = "title must not be blank")
        @Size(max = 255)
        String title,

        @NotBlank(message = "description must not be blank")
        @Size(max = 1000)
        String description,

        @NotBlank(message = "url must not be blank")
        @URL(message = "url must be a valid URL")
        @Size(max = 2000)
        String url
) {
}