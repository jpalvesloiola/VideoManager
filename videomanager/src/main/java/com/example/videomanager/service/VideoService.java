package com.example.videomanager.service;

import com.example.videomanager.model.Video;
import com.example.videomanager.repository.VideoRepository;
import com.example.videomanager.dto.VideoDto;
import com.example.videomanager.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private static final String VIDEO_NOT_FOUND = "Video not found with id ";
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    private VideoDto toDto(Video v) {
        return new VideoDto(v.getId(), v.getTitle(), v.getDescription(), v.getUrl());
    }

    private Video toEntity(VideoDto dto) {
        return new Video(dto.id(), dto.title(), dto.description(), dto.url(), null);
    }

    public List<VideoDto> getAllVideos() {
        return videoRepository.findAll().stream().map(this::toDto).toList();
    }

    public VideoDto getVideoById(Long id) {
        Video v = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        return toDto(v);
    }

    public VideoDto createVideo(VideoDto videoDto) {
        Video video = toEntity(videoDto);
        Video saved = videoRepository.save(video);
        return toDto(saved);
    }

    public VideoDto updateVideo(Long id, VideoDto videoDto) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        video.setTitle(videoDto.title());
        video.setDescription(videoDto.description());
        video.setUrl(videoDto.url());
        Video saved = videoRepository.save(video);
        return toDto(saved);
    }

    public void deleteVideo(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(VIDEO_NOT_FOUND + id));
        videoRepository.delete(video);
    }
}