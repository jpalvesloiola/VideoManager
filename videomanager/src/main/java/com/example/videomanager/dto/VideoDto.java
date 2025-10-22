package com.example.videomanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class VideoDto {
    private Long id;

    @NotBlank(message = "title must not be blank")
    @Size(max = 255)
    private String title;

    @Size(max = 1000)
    private String description;

    @NotBlank(message = "url must not be blank")
    @Size(max = 2000)
    @Pattern(regexp = "^(http|https)://[^ \"]+$", message = "url must be a valid URL")
    private String url;

    public VideoDto() {
    }

    public VideoDto(Long id, String title, String description, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
