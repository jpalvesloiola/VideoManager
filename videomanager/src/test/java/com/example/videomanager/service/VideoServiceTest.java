package com.example.videomanager.service;

import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.mapper.VideoMapper;
import com.example.videomanager.model.Video;
import com.example.videomanager.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the {@link VideoService} class.
 */
class VideoServiceTest {

    @Mock
    private VideoRepository videoRepository;

    @Mock
    private VideoMapper videoMapper;

    private VideoService videoService;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        videoService = new VideoService(videoRepository, videoMapper);
    }

    /**
     * Tests the creation of a video.
     */
    @Test
    void testCreateVideo() {
        // Arrange
        VideoDto videoDto = new VideoDto(null, "Test Video", "Test Description", "http://testurl.com");

        Video video = new Video();
        video.setId(1L);
        video.setTitle("Test Video");
        video.setDescription("Test Description");
        video.setUrl("http://testurl.com");

        VideoDto videoDtoSaved = new VideoDto(1L,"Test Video", "Test Description", "http://testurl.com");

        when(videoMapper.toEntity(any(VideoDto.class))).thenReturn(video);
        when(videoRepository.save(any(Video.class))).thenReturn(video);
        when(videoMapper.toDto(any(Video.class))).thenReturn(videoDtoSaved);


        // Act
        VideoDto result = videoService.createVideo(videoDto);

        // Assert
        assertEquals("Test Video", result.title());
    }
}
