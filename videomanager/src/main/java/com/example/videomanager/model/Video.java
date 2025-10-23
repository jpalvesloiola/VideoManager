package com.example.videomanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a video entity in the database.
 * <p>
 * This class is mapped to the "video" table and contains information about a video,
 * such as its title, description, URL, and metadata.
 * </p>
 */
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private String metadata;

    /**
     * Default constructor for JPA.
     */
    public Video() {
    }

    /**
     * Constructs a new Video with the specified details.
     *
     * @param id          the unique identifier of the video.
     * @param title       the title of the video.
     * @param description a brief description of the video.
     * @param url         the URL where the video is hosted.
     * @param metadata    additional metadata about the video.
     */
    public Video(Long id, String title, String description, String url, String metadata) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.metadata = metadata;
    }

    /**
     * Gets the ID of the video.
     *
     * @return the ID of the video.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the video.
     *
     * @param id the ID of the video.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title of the video.
     *
     * @return the title of the video.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the video.
     *
     * @param title the title of the video.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the video.
     *
     * @return the description of the video.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the video.
     *
     * @param description the description of the video.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the URL of the video.
     *
     * @return the URL of the video.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL of the video.
     *
     * @param url the URL of the video.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the metadata of the video.
     *
     * @return the metadata of the video.
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata of the video.
     *
     * @param metadata the metadata of the video.
     */
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}