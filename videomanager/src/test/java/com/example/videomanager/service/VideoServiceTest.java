package com.example.videomanager.service;

import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.model.Video;
import com.example.videomanager.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class VideoServiceTest {

    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private VideoService videoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateVideo() {
        // Arrange
        VideoDto videoDto = new VideoDto();
        videoDto.setTitle("Test Video");
        videoDto.setDescription("Test Description");
        videoDto.setUrl("http://testurl.com");

        Video video = new Video();
        video.setId(1L);
        video.setTitle("Test Video");
        video.setDescription("Test Description");
        video.setUrl("http://testurl.com");

        when(videoRepository.save(any(Video.class))).thenReturn(video);

        // Act
        VideoDto result = videoService.createVideo(videoDto);

        // Assert
        assertEquals("Test Video", result.getTitle());
    }
}
