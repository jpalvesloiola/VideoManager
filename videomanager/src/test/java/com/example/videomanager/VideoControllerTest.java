package com.example.videomanager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.service.VideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration tests for the {@link com.example.videomanager.controller.VideoController} class.
 */
@SpringBootTest(classes = com.example.videomanager.VideoManagerApplication.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class VideoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VideoService videoService;

    private VideoDto savedVideo;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        VideoDto videoDto = new VideoDto(null, "Test Video", "Test Description", "http://testurl.com");
        savedVideo = videoService.createVideo(videoDto);
    }

    /**
     * Tests the creation of a video.
     *
     * @throws Exception if an error occurs during the test.
     */
    @Test
    void testCreateVideo() throws Exception {
        mockMvc.perform(post("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Video\",\"description\":\"New Description\",\"url\":\"http://newurl.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Video"));
    }

    /**
     * Tests the creation of a video with an invalid URL.
     *
     * @throws Exception if an error occurs during the test.
     */
    @Test
    void testCreateVideoWithInvalidUrl() throws Exception {
        mockMvc.perform(post("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Invalid URL Video\",\"description\":\"\",\"url\":\"not-a-valid-url\"}"))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests the retrieval of a video.
     *
     * @throws Exception if an error occurs during the test.
     */
    @Test
    void testGetVideo() throws Exception {
        mockMvc.perform(get("/videos/" + savedVideo.id()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Video"));
    }

    /**
     * Tests the update of a video.
     *
     * @throws Exception if an error occurs during the test.
     */
    @Test
    void testUpdateVideo() throws Exception {
        mockMvc.perform(put("/videos/" + savedVideo.id())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Updated Video\",\"description\":\"Updated Description\",\"url\":\"http://updatedurl.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Video"));
    }

    /**
     * Tests the deletion of a video.
     *
     * @throws Exception if an error occurs during the test.
     */
    @Test
    void testDeleteVideo() throws Exception {
        mockMvc.perform(delete("/videos/" + savedVideo.id()))
                .andExpect(status().isNoContent());
    }
}