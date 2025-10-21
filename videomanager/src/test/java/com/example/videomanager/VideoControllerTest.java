import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.videomanager.controller.VideoController;
import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.service.VideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
        // Criar um vídeo de teste no banco
        VideoDto videoDto = new VideoDto();
        videoDto.setTitle("Test Video");
        videoDto.setDescription("Test Description");
        videoDto.setUrl("http://testurl.com");
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
        mockMvc.perform(get("/videos/" + savedVideo.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Video"));
    }

    @Test
    void testUpdateVideo() throws Exception {
        mockMvc.perform(put("/videos/" + savedVideo.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Updated Video\",\"description\":\"Updated Description\",\"url\":\"http://updatedurl.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Video"));
    }

    @Test
    void testDeleteVideo() throws Exception {
        mockMvc.perform(delete("/videos/" + savedVideo.getId()))
                .andExpect(status().isNoContent());
    }
}