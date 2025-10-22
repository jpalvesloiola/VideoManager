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

@SpringBootTest(classes = com.example.videomanager.VideoManagerApplication.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class VideoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VideoService videoService;

    private VideoDto savedVideo;

    @BeforeEach
    void setUp() {
        VideoDto videoDto = new VideoDto(null, "Test Video", "Test Description", "http://testurl.com");
        savedVideo = videoService.createVideo(videoDto);
    }

    @Test
    void testCreateVideo() throws Exception {
        mockMvc.perform(post("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Video\",\"description\":\"New Description\",\"url\":\"http://newurl.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Video"));
    }

    @Test
    void testGetVideo() throws Exception {
        mockMvc.perform(get("/videos/" + savedVideo.id()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Video"));
    }

    @Test
    void testUpdateVideo() throws Exception {
        mockMvc.perform(put("/videos/" + savedVideo.id())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Updated Video\",\"description\":\"Updated Description\",\"url\":\"http://updatedurl.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Video"));
    }

    @Test
    void testDeleteVideo() throws Exception {
        mockMvc.perform(delete("/videos/" + savedVideo.id()))
                .andExpect(status().isNoContent());
    }

    @Test
    void testCreateVideoWithInvalidUrl() throws Exception {
        mockMvc.perform(post("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Video\",\"description\":\"New Description\",\"url\":\"invalid-url\"}"))
                .andExpect(status().isBadRequest());
    }
}