package com.example.videomanager.service;

import com.example.videomanager.model.Video;
import com.example.videomanager.repository.VideoRepository;
import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.exception.NotFoundException;
import com.example.videomanager.mapper.VideoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private static final String VIDEO_NOT_FOUND = "Video not found with id ";
    private final VideoRepository videoRepository;
    private final VideoMapper videoMapper;

    public VideoService(VideoRepository videoRepository, VideoMapper videoMapper) {
        this.videoRepository = videoRepository;
        this.videoMapper = videoMapper;
    }

    public List<VideoDto> getAllVideos() {
        return videoRepository.findAll().stream().map(videoMapper::toDto).toList();
    }

    public VideoDto getVideoById(Long id) {
        Video v = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        return videoMapper.toDto(v);
    }

    public VideoDto createVideo(VideoDto videoDto) {
        Video video = videoMapper.toEntity(videoDto);
        Video saved = videoRepository.save(video);
        return videoMapper.toDto(saved);
    }

    public VideoDto updateVideo(Long id, VideoDto videoDto) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        video.setTitle(videoDto.title());
        video.setDescription(videoDto.description());
        video.setUrl(videoDto.url());
        Video saved = videoRepository.save(video);
        return videoMapper.toDto(saved);
    }

    public void deleteVideo(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        videoRepository.delete(video);
    }
}
