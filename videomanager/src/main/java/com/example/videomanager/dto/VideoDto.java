package com.example.videomanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * A Data Transfer Object (DTO) for video data.
 * <p>
 * This record is used to transfer video information between the client and the server.
 * </p>
 *
 * @param id          the unique identifier of the video.
 * @param title       the title of the video.
 * @param description a brief description of the video.
 * @param url         the URL where the video is hosted.
 */
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
