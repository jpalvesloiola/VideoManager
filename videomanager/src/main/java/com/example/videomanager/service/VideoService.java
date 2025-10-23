package com.example.videomanager.service;

import com.example.videomanager.model.Video;
import com.example.videomanager.repository.VideoRepository;
import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.exception.NotFoundException;
import com.example.videomanager.mapper.VideoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing videos.
 * <p>
 * This class provides business logic for video operations, such as creating,
 * retrieving, updating, and deleting videos. It interacts with the
 * {@link VideoRepository} to perform database operations.
 * </p>
 */
@Service
public class VideoService {

    private static final String VIDEO_NOT_FOUND = "Video not found with id ";
    private final VideoRepository videoRepository;
    private final VideoMapper videoMapper;

    /**
     * Constructs a new VideoService with the given VideoRepository.
     *
     * @param videoRepository the repository to handle video data access.
     * @param videoMapper to serializer and deserializer the object.
     */
    public VideoService(VideoRepository videoRepository, VideoMapper videoMapper) {
        this.videoRepository = videoRepository;
        this.videoMapper = videoMapper;
    }

    /**
     * Retrieves all videos.
     *
     * @return a list of all videos.
     */
    public List<VideoDto> getAllVideos() {
        return videoRepository.findAll().stream().map(videoMapper::toDto).toList();
    }

    /**
     * Retrieves a video by its ID.
     *
     * @param id the ID of the video to retrieve.
     * @return the video with the specified ID.
     * @throws NotFoundException if no video is found with the given ID.
     */
    public VideoDto getVideoById(Long id) {
        Video v = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        return videoMapper.toDto(v);
    }

    /**
     * Creates a new video.
     *
     * @param videoDto the video data to create.
     * @return the created video.
     */
    public VideoDto createVideo(VideoDto videoDto) {
        Video video = videoMapper.toEntity(videoDto);
        Video saved = videoRepository.save(video);
        return videoMapper.toDto(saved);
    }

    /**
     * Updates an existing video.
     *
     * @param id       the ID of the video to update.
     * @param videoDto the new video data.
     * @return the updated video.
     * @throws NotFoundException if no video is found with the given ID.
     */
    public VideoDto updateVideo(Long id, VideoDto videoDto) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        video.setTitle(videoDto.title());
        video.setDescription(videoDto.description());
        video.setUrl(videoDto.url());
        Video saved = videoRepository.save(video);
        return videoMapper.toDto(saved);
    }

    /**
     * Deletes a video by its ID.
     *
     * @param id the ID of the video to delete.
     * @throws NotFoundException if no video is found with the given ID.
     */
    public void deleteVideo(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        videoRepository.delete(video);
    }
}
