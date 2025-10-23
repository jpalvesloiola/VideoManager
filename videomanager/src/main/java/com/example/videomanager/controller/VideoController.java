package com.example.videomanager.controller;

import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.service.VideoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing videos.
 * <p>
 * This controller provides endpoints for creating, retrieving, updating, and deleting videos.
 * </p>
 */
@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    /**
     * Constructs a new VideoController with the given VideoService.
     *
     * @param videoService the service to handle video operations.
     */
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    /**
     * Creates a new video.
     *
     * @param videoDto the video data to create.
     * @return a ResponseEntity containing the created video and a 201 status code.
     */
    @PostMapping
    public ResponseEntity<VideoDto> createVideo(@Valid @RequestBody VideoDto videoDto) {
        VideoDto createdVideo = videoService.createVideo(videoDto);
        return ResponseEntity.status(201).body(createdVideo);
    }

    /**
     * Retrieves all videos.
     *
     * @return a ResponseEntity containing a list of all videos and a 200 status code.
     */
    @GetMapping
    public ResponseEntity<List<VideoDto>> getAllVideos() {
        List<VideoDto> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);
    }

    /**
     * Retrieves a video by its ID.
     *
     * @param id the ID of the video to retrieve.
     * @return a ResponseEntity containing the video and a 200 status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> getVideoById(@PathVariable Long id) {
        VideoDto videoDto = videoService.getVideoById(id);
        return ResponseEntity.ok(videoDto);
    }

    /**
     * Updates an existing video.
     *
     * @param id       the ID of the video to update.
     * @param videoDto the new video data.
     * @return a ResponseEntity containing the updated video and a 200 status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VideoDto> updateVideo(@PathVariable Long id, @Valid @RequestBody VideoDto videoDto) {
        VideoDto updatedVideo = videoService.updateVideo(id, videoDto);
        return ResponseEntity.ok(updatedVideo);
    }

    /**
     * Deletes a video by its ID.
     *
     * @param id the ID of the video to delete.
     * @return a ResponseEntity with a 204 status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }
}